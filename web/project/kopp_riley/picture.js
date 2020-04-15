class Picture {
    constructor(size_in){
        this.grid = [];
        this.setGrid(size_in);
    }

    addUndoer(undoer_in){
        this.undoer = undoer_in;
    }

    setGrid(size_in, undoing = false){

        if(this.undoer !== undefined && !undoing){
            var old = this.stringifyWrapper();
        }


        this.grid = []

        let picture = document.getElementById('picture');

        document.getElementById('sizer').value = size_in;

        picture.innerHTML = "";

        
        for(var i = 0; i < size_in*size_in; i++)
        {
            let pixel = document.createElement('div');

            pixel.id = "pixel_" + i.toString();
            
            pixel.className = "Pixel";

            pixel.addEventListener('click', (e) => {
                this.changeColorWithUndo(e.target, selectedColor);
            });

            pixel.style.backgroundColor = 'white';
            pixel.style.border = "black"
            pixel.style.borderStyle = "solid"
            pixel.style.width = "25px"
            pixel.style.height = "25px"

            this.grid.push('white');

            picture.appendChild(pixel);
        }

        this.size = size_in;

        let templateSize = '1fr '.repeat(this.size);


        picture.style.gridTemplateRows = templateSize;
        picture.style.gridTemplateColumns = templateSize;

        if(this.undoer !== undefined && !undoing) {
            // GRADING: ACTION
            let newState = this.stringifyWrapper();
            this.undoer.newAction(this, this.load, [old, true], [newState, true]);
        }
    }

    changeColor(item, newColor){
        let element = document.getElementById(item)
        element.style.backgroundColor = newColor;
        this.grid[element.id.replace('pixel_', '')] = newColor;
    }

    changeColorWithUndo(element, newColor) {

        let old = element.style.backgroundColor;

        // GRADING: ACTION

        this.undoer.newAction(this, this.changeColor, [element.id, old], [element.id, newColor]);
        this.changeColor(element.id, newColor);

    }



    stringifyWrapper() {
        let replace = (key, value) => {
            if(key == 'undoer') return undefined;
            else return value;
        }


        return JSON.stringify(this, replace);
    }

    load(json, undoing = false) {
        let image = JSON.parse(json);
        this.setGrid(image.size, undoing);
        this.grid = image.grid;
        this.updateColors();
    }

    updateColors(){
        for( var color in this.grid){
            document.getElementById("pixel_"+color).style.backgroundColor = this.grid[color];
        }
    }
}