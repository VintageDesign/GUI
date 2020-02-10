package kopp_riley;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.management.modelmbean.ModelMBean;
import java.beans.PropertyChangeSupport;

public class Main extends Application {
    private Layout layout;
    private Controller controller;
    private Aquarium model;
    @Override
    public void start(Stage stage) throws Exception {
        model = new Aquarium();
        controller = new Controller(model);
        layout = new Layout(controller);

        Scene scene = layout.init();

        stage.setScene(scene);
        stage.show();
    }
}
