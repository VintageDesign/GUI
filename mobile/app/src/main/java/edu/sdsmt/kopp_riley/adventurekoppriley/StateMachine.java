package edu.sdsmt.kopp_riley.adventurekoppriley;

import android.graphics.Color;

public class StateMachine {
    private Boolean beenToBlue;
    private Boolean win;
    private State   currentState;
    private State   previousState;

    public StateMachine(){
        beenToBlue = false;
        win = false;
        currentState = new StateGrey();
        previousState = null;
    }

    public State setState(Edge direction){
        previousState = currentState;
        currentState = currentState.doTask(direction);
        if(beenToBlue == false && currentState.getColor() == Color.BLUE)
        {
            beenToBlue = true;
        }

        //GRADING: GUARD
        else if (beenToBlue == true
                && currentState.getColor() == Color.RED
                && previousState.getColor() == Color.RED)
        {
            this.win = true;

        }
        return currentState;
    }

    public Boolean checkWin(){
        return win;
    }
    public Boolean getBlue(){ return beenToBlue;}
    public void setBlue(Boolean blue){
        beenToBlue = blue;
    }
    public State  getState(){return currentState;}
    public void setCurrentState(State newState){
        currentState = newState;
    }

}
