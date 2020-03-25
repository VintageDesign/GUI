<!DOCTYPE html>
<html>
<header>

</header>


<?php
if (isset($_GET["filename"])) {
    $filename = './uploads/' . $_GET["filename"];
    $fileHandle = fopen($filename, 'r') or die("Could Not Open File: " . $filename);

    $data = fread($fileHandle, filesize($filename));

    setcookie("picture", $data);
}
?>


<head>
    <link rel="stylesheet" href="style.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
    <script src="picture.js" charset="utf-8"></script>
    <script src="undoer.js" charset="utf-8"></script>
    <script src="scripts.js" charset="utf-8"></script>

    <div id="menu">
        <div class="page currentPage">
            Main
        </div>
        <div class="page">
            <a href="./file_mgmt.php">Files</a>
        </div>
        <div class="page">
            <a href="./help.php">Help</a>
        </div>
    </div>
</head>

<body>
    <div class="options">
        <button id="w" class="option base-button">W</button>
        <button id="g" class="option base-button">G</button>
        <button id="b" class="option base-button">B</button>
        <div class="option"> Selected Color:</div>
        <div class="option" id="ind" ></div>
        <div class="option"> Size:</div>
        <input id="sizer" type="number" value="5" min="2" max="75" class="option size"> </input>
        <div class="option">Save File:</div>
        <input id="filename" type="text" placeholder="filename (w/o extension)">
        <button id="save" class="option base-button">Save</button>
        <button id="undo" class="option base-button">Undo</button>
        <button id="redo" class="option base-button">Redo</button>
    </div>
    <div id="frame">
        <div id="picture">
        </div>
    </div>
</body>

</html>