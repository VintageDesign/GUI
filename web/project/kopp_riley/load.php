<?php
    if(isset($_GET["filename"])) {
        $filename = './uploads/' . $_GET["filename"];
        $fileHandle = fopen($filename, 'r') or die("Could Not Open File: ". $filename);
        
        $data = fread($fileHandle, filesize($filename));

        echo json_encode($data);
    }
?>