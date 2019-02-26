<?php 

  $mysqli = new mysqli('localhost','root','','pfe_scann');
    $myArray = array();
if ($result = 

    $mysqli->query("SELECT o.oeuvre_name , m.url, a.artiste_name  FROM oeuvre o, media m , artiste a  WHERE o.oeuvre_id=m.oeuvre_id AND o.artiste_id=a.artiste_id  AND   m.media_type='image'"))

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