<?php
	$con = mysqli_connect("localhost","root","","pfe1");
// Check connection
if (mysqli_connect_errno())
{
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}else{  
	
	//$code_qr=$_REQUEST['code_qr'];	 	  	 	 	 
	$code_qr=$_POST['code_qr'];	 	  	 	 	 
	//$code_qr=$_GET['code_qr'];	 	  	 	 	 
	//$code_qr=$_GET['code_qr'];	 	  	 	 	 		
	$sql = "select oeuvre_id, code_qr, oeuvre_name, oeuvre_description, musee_id, type_id from oeuvre where code_qr='".$code_qr."';";
	$result = $con->query($sql);
	if ($result->num_rows > 0){
while($row = $result->fetch_assoc()) $output[]=$row;	
		print(json_encode($output));		
	 
	//print(json_encode($flag));
	//mysqli_close($con);    
	$con->close();		
	}else{
		echo 'no data found yoshyosh!!!';
		$con->close();		
	} 
}
?>