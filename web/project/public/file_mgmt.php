<!DOCTYPE html>
<html>
<header>

</header>

<head>
    <link rel="stylesheet" href="style.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">

    <script src="scripts.js" charset="utf-8"></script>

    <div id="menu">
        <div class="page">
            <a href="./index.php">Files</a>
        </div>
        <div class="page currentPage">
            Files
        </div>
        <div class="page">
            <a href="./help.php">Help</a>
        </div>
    </div>
</head>

<body>

    <form class="options" action="file_mgmt.php" method="post" enctype="multipart/form-data">
        
        <div class="option"> Upload:</div>
        <input class="option" type="file" name="fileToUpload" id="fileToUpload">
        <input class="option base-button" type="submit" value="Upload" name="submit">
    </form>

    <?php

    // Stolen from W3Schools
    $target_dir = "uploads/";
    $target_file = $target_dir . basename($_FILES["fileToUpload"]["name"]);
    $uploadOk = 1;
    $imageFileType = strtolower(pathinfo($target_file, PATHINFO_EXTENSION));
    // Check if image file is a actual image or fake image
    if (isset($_POST["submit"])) {
        if (move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $target_file)) {
        echo "The file ". basename( $_FILES["fileToUpload"]["name"]). " has been uploaded.";
    } else {
        echo "Sorry, there was an error uploading your file.";
    }
    }

    $myFiles = scandir('./uploads/');
    foreach ($myFiles as $f) {
        if ($f[0] != '.') {
            echo '<p>' . $f . ' ';
            echo '<a href=' . './uploads/' . $f . ' download><button class="base-button">Download</button></a>';
            echo '<button class="base-button" onclick=loadFromServer("' . $f . '")>Load</button></p>';
        }
    }

    ?>




</body>

</html>