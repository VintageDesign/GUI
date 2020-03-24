var selectedColor = 'white';
var pic, undoer;


window.onload = () => {
    pic = new Picture(5);
    //undoer = new undoer();

    //pic.addUndo(undoer);

    updateInd();

    document.getElementById('save').addEventListener('click', (e) => {
       // TODO 
    });

    /*
    document.getElementById('undo').addEventListener('click', (e) =>{
        undoer.undo();
    });

    document.getElementById('redo').addEventListener('click', (e) =>{
        undoer.redo();
    });
    */

    document.getElementById('w').addEventListener('click', (e) =>{
        selectedColor = 'white';
        updateInd();
    });
    
    document.getElementById('g').addEventListener('click', (e) =>{
        selectedColor = 'green';
        updateInd();
    });

    document.getElementById('b').addEventListener('click', (e) =>{
        selectedColor = 'black';
        updateInd();
    });

    document.getElementById('sizer').addEventListener('change', (e)=>
    {
        pic.setGrid(e.target.value);
    });
}


function updateInd() {
    document.getElementById('selected_color').style.backgroundColor = selectedColor;
}