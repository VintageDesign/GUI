package kopp_riley;

import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.util.ArrayList;

/***************************************************************************************************
 * @author Riley Kopp
 * The tank view
 **************************************************************************************************/
public class TankView extends GridPane {
    Integer rows;
    Integer cols;
    Integer deathCount;

    Controller controller;

    /***************************************************************************************************
     * The default constructor for the display
     **************************************************************************************************/
    ArrayList<TileView> fishList;
    TankView(Controller controllerIn){
        controller = controllerIn;
        setAlignment(Pos.CENTER);
        rows = 3;
        cols = 3;
        createBowl();
    }

    /***************************************************************************************************
     * Resizes the display and grid pane size
     **************************************************************************************************/
    void resize(Integer rowsIn, Integer colsIn){
        getChildren().clear();
        getRowConstraints().clear();
        getColumnConstraints().clear();

        cols = colsIn;
        rows = rowsIn;

        createBowl();
    }

    /***************************************************************************************************
     * Creates the new bowl and all the tiles within it
     **************************************************************************************************/
    private void createBowl(){
        TileView tempFish;
        fishList = new ArrayList<TileView>();

        deathCount = 0;

        //System.out.println(rows.toString());

        for( int i = 0; i < rows; i++){
            for (int j = 0; j< cols; j++){
                tempFish = new TileView(i, j);

                setVgrow(tempFish, Priority.ALWAYS);
                setHgrow(tempFish, Priority.ALWAYS);
                tempFish.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
                tempFish.addEventHandler(MouseEvent.MOUSE_CLICKED, controller.getFishButtonEvent());
                fishList.add(tempFish);
                add(tempFish, j, i);
            }
        }
    }

    /***************************************************************************************************
     * Getter for the tile view
     **************************************************************************************************/
    public TileView getTileView(Integer row, Integer col){
        return fishList.get(row*cols + col);
    }
}
