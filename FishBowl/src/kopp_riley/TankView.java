package kopp_riley;

import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.util.ArrayList;

public class TankView extends GridPane {
    Integer rows;
    Integer cols;

    ArrayList<TileView> fishList;
    TankView(Controller controller){
        TileView tempFish;
        fishList = new ArrayList<TileView>();

        setAlignment(Pos.CENTER);
        rows = 3;
        cols = 3;



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

    void setMode(Aquarium newModel){

    }

    void resize(Integer cols, Integer rows){

    }
}
