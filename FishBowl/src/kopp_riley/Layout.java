package kopp_riley;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;

public class Layout {
    public Scene init(){
        Scene scene;

        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(new Label("Test"));
        borderPane.setLeft(new Label("Side"));

        scene = new Scene(borderPane);
        return scene;
    }
}
