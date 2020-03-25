<?php
if ( $_GET["filename"] == "none" ) {                                 
	$num = 0;                                                        
	while ( file_exists('uploads/grid_' . strval($num) . '.json' )) {
		$num++;                                                      
	}                                                                
	$filename = 'grid_' . strval($num);                              
}                                                                    
else {                                                               
	$filename = $_GET["filename"];                                   
}                                                

$filename = 'uploads/' . $filename . '.json';

$data = $_COOKIE['picture'];
$fileHandle = fopen($filename, "c");
fwrite($fileHandle, $data);
fclose($fileHandle);


header("Location: ./index.php");

?>