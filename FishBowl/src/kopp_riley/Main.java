package kopp_riley;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.management.modelmbean.ModelMBean;
import java.beans.PropertyChangeSupport;

/***********************************************************************************************
 * @author  Riley Kopp
 * Descripton:
 * The entry point of the Aquarium program. For more information see the assignment on D2L for
 * a full description of the program.
 *
 * Last Tier Completed: 3
 * Extensions Completed:
 * +5 Resize buttons are all the same size
 * +10 Pirrana moves randomly and kills fish it lands on.
 *      - NOTE: The Pirrana was implemented as a Betta fish, as they both kill other fish in
 *              life and because it is more likely that our users would own a betta rather than
 *              a Pirrana. Plus I like making your life more difficult Yoyslin
 *
 * Known Bugs:
 * None... I cleaned this tank thouroughly
 **********************************************************************************************/
public class Main extends Application {
    private Layout layout;
    private Controller controller;
    private Aquarium model;
    @Override
    public void start(Stage stage) throws Exception {
        controller = new Controller();
        layout = new Layout(controller);

        Scene scene = layout.init();

        model = new Aquarium();
        controller.setModel(model);


        stage.setScene(scene);
        stage.show();
    }
}
