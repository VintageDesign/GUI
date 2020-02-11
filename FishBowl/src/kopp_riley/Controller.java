package kopp_riley;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    Aquarium model;
    Layout layout;
    Controller(Aquarium modelIn){
        model = modelIn;
    }


    private class AddFishEvent implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {
            TileView button  = (TileView) mouseEvent.getSource();

            model.doAction(button.getRow(), button.getCol(), mouseEvent);

        }
    }

    private class ResizeBowl implements EventHandler<MouseEvent> {
        private Integer rows;
        private Integer cols;

        ResizeBowl(Integer rowsIn, Integer colsIn){
            rows = rowsIn;
            cols = colsIn;
        }

        @Override
        public void handle(MouseEvent mouseEvent) {
            model.setBowlSize(rows, cols);
            layout.getTank().resize(rows, cols);

        }
    }

    // Updates the current selected action in the combo box.
    private class UpdateActionSelection implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e)
        {
            model.setAction((ComboBox) e.getSource());
        }
    }

    public void setLayout(Layout layoutIn){layout = layoutIn;}

    public ResizeBowl getResizeBowl(Integer rowsIn, Integer colsIn){ return new ResizeBowl(rowsIn, colsIn);}

    public UpdateActionSelection getComboBoxEvent(){
        return new UpdateActionSelection();
    }

    public AddFishEvent getFishButtonEvent(){
        return new AddFishEvent();
    }
}
