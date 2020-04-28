package edu.sdsmt.kopp_riley.adventurekoppriley;

import android.graphics.Color;
import android.util.Log;

public class StateGrey extends State {

    public StateGrey(){
        this.color = Color.GRAY;
    }

    @Override
    public State doTask(Edge direction) {
        State retval = null;

        if(direction == Edge.Left){
            retval = new StateBlue();
            Log.i("SateGrey", "Went Blue");
            Log.i("StateGrey", "New Color: " + retval.getColor());
        }
        else{
            retval =  new StateRed();
        }
        return retval;
    }


}
