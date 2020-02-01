package kopp_riley;

import javafx.scene.control.Button;

public class TileView extends Button {
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
}
