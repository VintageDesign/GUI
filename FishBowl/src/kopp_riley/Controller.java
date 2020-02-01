package kopp_riley;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    Aquarium model;
    Controller(Aquarium modelIn){
        model = modelIn;
    }

    private class AddFishEvent implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {
            TileView button  = (TileView) mouseEvent.getSource();

            model.doAction(button.getRow(), button.getCol());

        }
    }

    // Updates the current selected action in the combo box.
    private class UpdateActionSelection implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e)
        {
            model.setAction((ComboBox) e.getSource());
        }
    }

    public UpdateActionSelection getComboBoxEvent(){
        return new UpdateActionSelection();
    }

    public AddFishEvent getFishButtonEvent(){
        return new AddFishEvent();
    }
}
