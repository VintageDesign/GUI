package kopp_riley;

import javafx.scene.control.Button;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TileView extends Button implements PropertyChangeListener{
    private Integer row;
    private Integer col;

    TileView(Integer rowIn, Integer colIn) {
        row = rowIn;
        col = colIn;
        setText("None");
    }


    public Integer getCol() {
        return col;
    }

    public Integer getRow() {
        return row;
    }

    // GRADING: OBSERVE
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        Fish newFish = (Fish) propertyChangeEvent.getNewValue();
        if(newFish !=  null) {
            setText(newFish.getType()
                    + "\nHealth: " + newFish.getHealth().toString()
                    + "\nHunger: " + newFish.getHunger().toString());
        }
        else{
            setText("None");
        }

    }
}
