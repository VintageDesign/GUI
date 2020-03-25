<!DOCTYPE html>
<html>
<header>

</header>


<?php
    if(isset($_GET["filename"])) {
        $filename = './uploads/' . $_GET["filename"];
        $fileHandle = fopen($filename, 'r') or die("Could Not Open File: ". $filename);
        
        $data = fread($fileHandle, filesize($filename));

        setcookie("picture", $data);
    }
?>


<head>
    <link rel="stylesheet" href="style.css">
    <script src="picture.js" charset="utf-8"></script>
    <script src="undoer.js" charset="utf-8"></script>
    <script src="scripts.js" charset="utf-8"></script>

    Main
    <a href="file_mgmt.php">Files</a>
    <a href="help.php">Help</a>
</head>

<body>
    <div>
        <button id="w" class="color-button">W</button>
        <button id="g" class="color-button">G</button>
        <button id="b" class="color-button">B</button>
        <div>Selected Color:<div id="ind"></div>
        </div>
        <div>
        Size:
        <input id="sizer" type="number" value="5" min="2" max="75" class="size"> </input>
        <br>
        </div>
        <input id="filename" type="text" placeholder="filename (w/o extension)"> 
        <button id="save" class="base-button">Save</button>
        <br>
        <button id="undo" class="base-button">Undo</button>
        <button id="redo" class="base-button">Redo</button>
    </div>
    <div id="frame">
        <div id="picture">
        </div>
    </div>
</body>

</html>