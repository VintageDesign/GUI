package kopp_riley;

import javafx.scene.control.ComboBox;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;

public class Aquarium {

    private Integer rows;
    private Integer cols;

    private Integer dayCount;
    private Integer deathCount;

    private Integer action; // 0: Add GoldFish, 1: Add AngelFish, 2: Remove

    private Tile[][] tank;

    Aquarium(){
        rows = 3;
        cols = 3;

        createNewTank();

        dayCount = 0;
        deathCount = 0;
        action = 0;
    }


    public void setAction(ComboBox e) {
        action = e.getSelectionModel().getSelectedIndex();
    }

    public void doAction(Integer row, Integer col){
        System.out.println("Doing action " + action.toString() + " on " + row.toString() + ", " + col.toString());
        tank[row][col].newFish(action);
    }

    private void createNewTank(){
        tank = new Tile[rows][cols];

        for(int rowIdx = 0; rowIdx < rows; rowIdx++){
            for(int colIdx = 0; colIdx < cols; colIdx++){
                tank[rowIdx][colIdx] = new Tile();
            }
        }

    }
}
