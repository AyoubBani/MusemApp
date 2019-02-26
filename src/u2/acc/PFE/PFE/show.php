<?php 

  $mysqli = new mysqli('localhost','root','','pfe_scann');
    $myArray = array();
if ($result = 

    $mysqli->query("SELECT o.code_qr,o.oeuvre_name , m.imgUrl, a.artiste_name  FROM oeuvre o, media m , artiste a  WHERE o.oeuvre_id=m.oeuvre_id AND o.artiste_id=a.artiste_id  "))

     {


        $tempArray = array();
        while($row = $result->fetch_object()) {
                $tempArray = $row;
                array_push($myArray, $tempArray);
            }
        echo json_encode($myArray);
    }

   
//
 ?>