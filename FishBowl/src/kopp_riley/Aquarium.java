package kopp_riley;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.util.Random;

public class Aquarium {
    private final Integer KILL = 3;
    private TankView tankView;
    private Integer rows;
    private PropertyChangeSupport[][] subject;
    private Integer cols;

    private Integer dayCount;
    private Integer deathCount;

    private Integer action; // 0: Add GoldFish, 1: Add AngelFish, 2: Remove

    private Tile[][] tank;

    private Integer feedAmount;
    private Integer numFish;

    Aquarium(){
        feedAmount = 0;
        numFish    = 0;
        action     = 0;

    }


    public void setAction(ComboBox e) {
        action = e.getSelectionModel().getSelectedIndex();
    }

    public void doAction(Integer row, Integer col, MouseEvent e){
        //System.out.println("Doing action " + action.toString() + " on " + row.toString() + ", " + col.toString());
        Boolean newfish = false;
        if(tank[row][col].getFish()== null){
           newfish = true;
        }
        tank[row][col].newFish(action);
        if (action < 3 && newfish) {
            numFish++;
        }
        else if (action == 3){
            numFish--;
        }
        // GRADING: TRIGGER
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
        numFish = 0;

        for(int rowIdx = 0; rowIdx < rows; rowIdx++){
            for(int colIdx = 0; colIdx < cols; colIdx++){
                tank[rowIdx][colIdx]    = new Tile();
                subject[rowIdx][colIdx] = new PropertyChangeSupport(this);
                // GRADING: SUBJECT
                subject[rowIdx][colIdx].addPropertyChangeListener(tankView.getTileView(rowIdx, colIdx));
            }
        }

    }

    public void setDisplay(TankView tankIn) {
        tankView = tankIn;
    }

    public void feedFish() {
        Integer individualFeedAmount = feedAmount / numFish;

        for(int rowIdx = 0; rowIdx < rows; rowIdx++){
            for(int colIdx = 0; colIdx < cols; colIdx++){
                Fish temp = tank[rowIdx][colIdx].getFish();
                if(temp != null)
                {
                    temp.feedFish(individualFeedAmount);
                    subject[rowIdx][colIdx].firePropertyChange("Update", 0, tank[rowIdx][colIdx].getFish());
                }
            }
        }

    }

    public void setFeedAmount(TextField source) {
        try {
            feedAmount = Integer.parseInt(source.getText());
        }
        catch (java.lang.NumberFormatException e ){

        }
    }

    public void newDay() {
        Random rand = new Random();
        dayCount++;
        Integer newColIdx = 0;
        Integer newRowIdx = 0;


        for(Integer rowIdx = 0; rowIdx < rows; rowIdx++){
            for(Integer colIdx = 0; colIdx < cols; colIdx++){
                Fish temp = tank[rowIdx][colIdx].getFish();
                if(temp != null)
                {
                    if (!temp.isVisited()) {
                        temp.setVisited(true);
                        if (temp.getType() == "Betta"){
                            newColIdx = rand.nextInt(cols);
                            newRowIdx = rand.nextInt(rows);
                         
                        }
                        else{

                            newColIdx = colIdx;
                            newRowIdx = rowIdx;
                        }

                        if (temp.newDay() == 0) {
                            tank[rowIdx][colIdx].newFish(KILL);
                            deathCount++;
                            numFish--;
                        }
                        else if (temp.getType() == "Betta" && (newColIdx != colIdx || newRowIdx != rowIdx)) {
                            if (tank[newRowIdx][newColIdx].getFish() != null) {
                                tank[newRowIdx][newColIdx].newFish(KILL);
                                deathCount++;
                                numFish--;
                            }
                            tank[newRowIdx][newColIdx].setFish(tank[rowIdx][colIdx].getFish());
                            tank[rowIdx][colIdx].newFish(KILL);
                        }
                        subject[newRowIdx][newColIdx].firePropertyChange("Update", 0, tank[newRowIdx][newColIdx].getFish());
                        subject[rowIdx][colIdx].firePropertyChange("Update", 0, tank[rowIdx][colIdx].getFish());

                    }
                }
            }
        }

        for(int rowIdx = 0; rowIdx < rows; rowIdx++){
            for(int colIdx = 0; colIdx < cols; colIdx++){
                Fish temp = tank[rowIdx][colIdx].getFish();
                if(temp != null)
                {
                    temp.setVisited(false);
                }
            }
        }
    }

    public Integer getDay() {
        return dayCount;
    }

    public Integer getDead(){
        return deathCount;
    }

    public Integer getFilled(){
        return numFish;
    }
}
