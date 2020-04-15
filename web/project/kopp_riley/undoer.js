// GRADING: MANAGE
// GRADING: COMMAND
class Undoer {
    constructor(){
        this.steps = [];
        this.index = 0;
    }

    newAction(call, func, undoArg, redoArg) {
        // If we are behind in the Undo stack we need to clear the stop of the stack
        if( this.index < this.steps.length){
            this.steps.splice(this.index, this.steps.length - this.index);
        }

        this.steps.push({call, func, undoArg, redoArg});

        this.index += 1;
    }

    undo() {
        if(this.index > 0){
            let action = this.steps[this.index-1];
            action.func.call(action.call, ...action.undoArg);
            this.index -= 1;
        }
    }

    redo() {
        if(this.index <= this.steps.length){
            let action = this.steps[this.index];
            action.func.call(action.call, ...action.redoArg);
            this.index += 1;
        }
    }


    clear() {
        this.steps = [];
        this.index = 0;
    }
}