var selectedColor = 'white';
var pic, undoer;


window.onload = () => {
    pic = new Picture(5);
    cookie = getCookie("picture");
    if (cookie !== undefined && cookie != "") {
        pic.load(cookie)
    }
    undoer = new Undoer();

    pic.addUndoer(undoer);

    updateInd('white');

    document.getElementById('save').addEventListener('click', (e) => {
        let filename = document.getElementById('filename').value;
        let jsonData = pic.stringifyWrapper();

        if(filename == "") {
            filename = "none";
        }

        setCookie('picture', jsonData, 1);

        document.location.href = "save.php?filename="+filename;

    });

    document.getElementById('undo').addEventListener('click', (e) =>{
        undoer.undo();
    });

    document.getElementById('redo').addEventListener('click', (e) =>{
        undoer.redo();
    });

    document.getElementById('w').addEventListener('click', (e) =>{
        updateInd('white');
    });
    
    document.getElementById('g').addEventListener('click', (e) =>{
        updateInd('green');
    });

    document.getElementById('b').addEventListener('click', (e) =>{
        updateInd('black');
    });

    document.getElementById('sizer').addEventListener('change', (e)=>
    {

        updateInd('white', true);
        pic.setGrid(e.target.value);
    });
}


function updateInd(new_color, undoing = false) {
    if(!undoing){
        undoer.newAction(null, updateInd, [selectedColor, true], [new_color, true])        
    }

    selectedColor = new_color;

    document.getElementById('ind').style.backgroundColor = selectedColor;
}


/* Stolen from W3 Schools */

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function deleteCookie(name) {
	document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;';
};


function loadFromServer(filename) {
    fetch('./load.php?filename=' + filename, {
        method: 'get',
    })
        .then((response) => response.json())
        .then((jsonData) => setCookie("picture", jsonData, 1))
        .then(() => {window.location.href="./index.php"})
        .catch((err) => console.log(err));
};