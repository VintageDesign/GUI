package kopp_riley;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Controller {
    Aquarium model;
    Layout layout;
    Controller(){
    }


    private class AddFishEvent implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {
            TileView button  = (TileView) mouseEvent.getSource();

            model.doAction(button.getRow(), button.getCol(), mouseEvent);

        }
    }

    private class FeedFishEvent implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {

            model.feedFish();

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
            layout.getTank().resize(rows, cols);
            model.setBowlSize(rows, cols);

        }
    }

    // Updates the current selected action in the combo box.
    private class UpdateActionSelection implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e)
        {
            model.setAction((ComboBox) e.getSource());
        }
    }

    private class UpdateFeedAmount implements EventHandler<KeyEvent>{

        public void handle(KeyEvent e)
        {
            model.setFeedAmount((TextField) e.getSource());
        }
    }
    public void setLayout(Layout layoutIn){
        layout = layoutIn;
    }

    public void setModel(Aquarium modelIn){
        model = modelIn;
        model.setDisplay(layout.getTank());
        model.setBowlSize(3,3);
    }


    public ResizeBowl getResizeBowl(Integer rowsIn, Integer colsIn){ return new ResizeBowl(rowsIn, colsIn);}

    public UpdateActionSelection getComboBoxEvent(){
        return new UpdateActionSelection();
    }

    public AddFishEvent getFishButtonEvent(){
        return new AddFishEvent();
    }

    public UpdateFeedAmount getFeedAmountEvent(){return new UpdateFeedAmount();}
    public FeedFishEvent getFeedFishEvent(){return new FeedFishEvent();}
}
