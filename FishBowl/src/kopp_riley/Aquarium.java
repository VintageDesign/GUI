package kopp_riley;

import javafx.scene.control.ComboBox;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;

public class Aquarium {

    private Integer rows;
    private Integer cols;

    private Integer dayCount;
    private Integer deathCount;

    private Integer action; // 0: Add GoldFish, 1: Add AngelFish, 2: Remove

    Aquarium(){
        rows = 3;
        cols = 3;

        dayCount = 0;
        deathCount = 0;
        action = 0;
    }


    public void setAction(ComboBox e) {
        action = e.getSelectionModel().getSelectedIndex();
    }

    public void doAction(Integer row, Integer col){
        System.out.println("Doing action " + action.toString() + " on " + row.toString() + ", " + col.toString());
    }
}
