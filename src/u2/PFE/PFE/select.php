<?php
    $con = mysqli_connect("localhost","root","","pfe_scann");
// Check connection
if (mysqli_connect_errno())
{
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}else{  
   // echo var_dump($_POST);

  $code_qr=$_POST['code_qr'];  
  // json_decode($code_qr);
                      
   // $code_qr=mysqli_real_escape_string($_POST['code_qr']);                  
    //$code_qr=$_GET['code_qr'];                     
    //$code_qr=$_GET['code_qr'];  

                         
    /*  
    SELECT O.oeuvre_name, O.oeuvre_description, (SELECT url FROM media WHERE oeuvre_id=O.oeuvre_id AND media_type='youtube') youtube,(SELECT url FROM media WHERE oeuvre_id=O.oeuvre_id AND media_type='image') image, (SELECT url FROM media WHERE oeuvre_id=O.oeuvre_id AND media_type='mp3') audio, (SELECT url FROM media WHERE oeuvre_id=O.oeuvre_id AND media_type='map') map  FROM oeuvre O WHERE O.code_qr="code001";
    
    "SELECT O.oeuvre_name, O.oeuvre_description, (SELECT url FROM media WHERE oeuvre_id=O.oeuvre_id AND media_type='youtube') youtube,(SELECT url FROM media WHERE oeuvre_id=O.oeuvre_id AND media_type='image') image, (SELECT url FROM media WHERE oeuvre_id=O.oeuvre_id AND media_type='mp3') audio, (SELECT url FROM media WHERE oeuvre_id=O.oeuvre_id AND media_type='map') map  FROM oeuvre O WHERE O.code_qr='".$code_qr."';";
    */
   // $obj = json_decode($HTTP_RAW_POST_DATA); $code_qr =$obj->{'code_qr'};
    //$sql = "select oeuvre_id, code_qr, oeuvre_name, oeuvre_description, musee_id, type_id from oeuvre where code_qr='".$code_qr."';";
    $sql = "SELECT o.code_qr,o.oeuvre_name ,o.oeuvre_description , m.imgUrl, m.videoUrl, m.mp3Url, m.mapUrl, a.artiste_name  FROM oeuvre o, media m , artiste a  WHERE o.oeuvre_id=m.oeuvre_id AND o.artiste_id=a.artiste_id and o.code_qr='".$code_qr."'";
    mysqli_set_charset($con,"utf8");
    //mysqli_query('SET CHARACTER SET utf8');
    $result = $con->query($sql);
    if ($result->num_rows > 0){
while($row = $result->fetch_assoc()) $output[]=$row;    
        print(json_encode($output));        
     
    //print(json_encode($flag));
    //mysqli_close($con);    
//echo var_dump($_POST); 
    $con->close();      
    }else{
        echo 'no data found yoshyosh!!!';
        $con->close();      
    } 
}

?>