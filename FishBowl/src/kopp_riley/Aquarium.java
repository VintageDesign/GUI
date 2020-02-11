package kopp_riley;

import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;


import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;

public class Aquarium {
    private TankView tankView;
    private Integer rows;
    private PropertyChangeSupport[][] subject;
    private Integer cols;

    private Integer dayCount;
    private Integer deathCount;

    private Integer action; // 0: Add GoldFish, 1: Add AngelFish, 2: Remove

    private Tile[][] tank;

    Aquarium(){

    }


    public void setAction(ComboBox e) {
        action = e.getSelectionModel().getSelectedIndex();
    }

    public void doAction(Integer row, Integer col, MouseEvent e){
        System.out.println("Doing action " + action.toString() + " on " + row.toString() + ", " + col.toString());
        tank[row][col].newFish(action);
        subject[row][col].firePropertyChange("Update", 0, tank[row][col].getFish());
    }

    public void setBowlSize(Integer rowsIn, Integer colsIn){
        rows = rowsIn;
        cols = colsIn;

        createNewTank();
    }
    private void createNewTank(){
        tank = new Tile[rows][cols];
        subject = new PropertyChangeSupport[rows][cols];
        dayCount = 0;
        deathCount = 0;
        action = 0;

        for(int rowIdx = 0; rowIdx < rows; rowIdx++){
            for(int colIdx = 0; colIdx < cols; colIdx++){
                tank[rowIdx][colIdx]    = new Tile();
                subject[rowIdx][colIdx] = new PropertyChangeSupport(this);
                subject[rowIdx][colIdx].addPropertyChangeListener(tankView.getTileView(rowIdx, colIdx));
            }
        }

    }

    public void setDisplay(TankView tankIn) {
        tankView = tankIn;
    }
}
