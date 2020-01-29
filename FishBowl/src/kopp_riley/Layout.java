package kopp_riley;

import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Layout {




    public Scene init(){
        Scene scene;

        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(setupActionBar());
        borderPane.setLeft(new Label("Side"));

        scene = new Scene(borderPane);
        return scene;
    }

    private VBox setupActionBar(){
        VBox side = new VBox();

        return side;
    }
}
