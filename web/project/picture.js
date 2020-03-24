class Picture {
    constructor(size_in){
        this.grid = [];
        this.setGrid(size_in);
    }

    setGrid(size_in){
        // TODO add undoer stuff here
        this.colors = []

        let picture = document.getElementById('picture');

        picture.innerHTML = "";

        
        for(var i = 0; i < size_in*size_in; i++)
        {
            let pixel = document.createElement('div');

            pixel.id = "pixel_" + i.toString();
            
            pixel.className = "Pixel";

            pixel.addEventListener('click', (e) => {
                this.changeColorWithUndo(e.target, selectedColor);
            });

            pixel.style.backgroundColor = 'black';

            pixel.style.width = "25px"
            pixel.style.height = "25px"

            this.colors.push('white');

            picture.appendChild(pixel);
        }

        this.size = size_in;

        let templateSize = '1fr '.repeat(this.size);


        picture.style.gridTemplateRows = templateSize;
        picture.style.gridTemplateColumns = templateSize;

        // TODO add undoer stuff here
    }

    changeColor(item, newColor){
        let element = document.getElementById(item.id)
        element.style.backgroundColor = newColor;
        this.colors[item.id.replace('/pixel_/', '')] = newColor;
    }

    changeColorWithUndo(element, newColor) {

        // TODO add undo stuff

        this.changeColor(element, newColor);

    }



    stringifyWrapper() {
        let replace = (key, value) => {
            if(key == 'undoer') return undefined;
            else return value;
        }


        return JSON.stringify(this. replacer);
    }

    
}