package kopp_riley;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


/**************************************************************************************************
 * @author Riley Kopp
 * Description:
 *      Class of event handlers for passing actions from the Layout back to the Model
 */
public class Controller {
    Aquarium model;
    Layout layout;
    Controller(){
    }


    /**********************************************************************************************
     * Handles click events in the tank view to add/remove fish.
     * @param mouseEvent : MouseEvent triggered on MouseClick
     *********************************************************************************************/
    private class AddFishEvent implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {
            TileView button  = (TileView) mouseEvent.getSource();

            model.doAction(button.getRow(), button.getCol(), mouseEvent);
            layout.update(model.getDay(), model.getFilled(), model.getDead());

        }
    }

    /**********************************************************************************************
     * Handles click events on the Feed Button
     * @param mouseEvent : MouseEvent triggered on MouseClick
     *********************************************************************************************/
    private class FeedFishEvent implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {

            model.feedFish();

        }
    }

    /**********************************************************************************************
     * Handles click events on the New Day Button
     * @param mouseEvent : MouseEvent triggered on MouseClick
     *********************************************************************************************/
    private class NewDayEvent implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {

            model.newDay();
            layout.update(model.getDay(), model.getFilled(), model.getDead());

        }
    }

    /**********************************************************************************************
     * Handles click events on the resize buttons
     * @param mouseEvent : MouseEvent triggered on MouseClick
     *********************************************************************************************/
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
            layout.update(model.getDay(), model.getFilled(), model.getDead());
        }
    }

    // Updates the current selected action in the combo box.
    /**********************************************************************************************
     * Updates the current selected action in the combo box.
     * 0) GoldFish
     * 1) AngelFish
     * 2) Betta
     * 3) Remove Fish
     * @param mouseEvent : MouseEvent triggered on MouseClick
     *********************************************************************************************/
    private class UpdateActionSelection implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e)
        {
            model.setAction((ComboBox) e.getSource());
        }
    }

    /**********************************************************************************************
     * Updates the Feed amount value in the model
     * @param EventHandler: KeyPress
     *********************************************************************************************/
    private class UpdateFeedAmount implements EventHandler<KeyEvent>{

        public void handle(KeyEvent e)
        {
            model.setFeedAmount((TextField) e.getSource());
        }
    }

    /**********************************************************************************************
     * Gives the controller a copy of the layout object
     * @param Layout layoutIn the current instance of the Layout
     *********************************************************************************************/
    public void setLayout(Layout layoutIn){
        layout = layoutIn;
    }

    /**********************************************************************************************
     * Gives the controller a copy of the model object
     * @param Aquarium: modelIn the current instance of the Model
     *********************************************************************************************/
    public void setModel(Aquarium modelIn){
        model = modelIn;
        model.setDisplay(layout.getTank());
        model.setBowlSize(3,3);
    }


    /**********************************************************************************************
     * Getter for resize bowl events
     *********************************************************************************************/
    public ResizeBowl getResizeBowl(Integer rowsIn, Integer colsIn){ return new ResizeBowl(rowsIn, colsIn);}

    /**********************************************************************************************
     * Getter for combo box events
     *********************************************************************************************/
    public UpdateActionSelection getComboBoxEvent(){
        return new UpdateActionSelection();
    }

    /**********************************************************************************************
     * Getter for Add Fish events
     *********************************************************************************************/
    public AddFishEvent getFishButtonEvent(){
        return new AddFishEvent();
    }

    /**********************************************************************************************
     * Getter for Update Feed Amount events
     *********************************************************************************************/
    public UpdateFeedAmount getFeedAmountEvent(){return new UpdateFeedAmount();}

    /**********************************************************************************************
     * Getter for FeedFish events
     *********************************************************************************************/
    public FeedFishEvent getFeedFishEvent(){return new FeedFishEvent();}

    /**********************************************************************************************
     * Getter for NewDay events
     *********************************************************************************************/
    public NewDayEvent getNewDayEvent(){return new NewDayEvent();}
}
