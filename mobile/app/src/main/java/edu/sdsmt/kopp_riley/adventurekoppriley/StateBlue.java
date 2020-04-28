package edu.sdsmt.kopp_riley.adventurekoppriley;

import android.graphics.Color;

public class StateBlue extends State {


    public StateBlue(){
        this.color = Color.BLUE;
    }

    @Override
    public State doTask(Edge direction) {
        State retval = null;

        if(direction == Edge.Left){
            retval = this;
        }
        else{
            retval =  new StateGrey();
        }
        return retval;
    }
}
