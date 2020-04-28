package edu.sdsmt.kopp_riley.adventurekoppriley;

import android.graphics.Color;

public class StateRed extends State {


    public StateRed(){
        this.color = Color.RED;
    }

    @Override
    public State doTask(Edge direction) {
        State retval = null;

        if(direction == Edge.Left){
            retval = new StateGrey();
        }
        else{
            retval =  this;
        }
        return retval;
    }
}
