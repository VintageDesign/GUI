package kopp_riley;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Layout layout;
    @Override
    public void start(Stage stage) throws Exception {
        layout = new Layout();
        Scene scene = layout.init();

        stage.setScene(scene);
        stage.show();
    }
}
