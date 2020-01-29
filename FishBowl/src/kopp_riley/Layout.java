package kopp_riley;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Layout {


    // Action Bar Items
    private String actionsList[] = { "GoldFish", "AngelFish", "Remove"};
    private ComboBox  actionSelection;
    private TextField feedAmount;
    private Button feed;


    public Scene init(){
        Scene scene;

        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(new Label("Bottom"));
        borderPane.setLeft(setupActionBar());

        scene = new Scene(borderPane);
        return scene;
    }

    private VBox setupActionBar(){
        VBox side = new VBox();
        ObservableList list = side.getChildren();

        ObservableList<String> actions = FXCollections.observableArrayList(actionsList);

        // Init Items
        actionSelection = new ComboBox(actions);
        feedAmount      = new TextField();
        feed            = new Button("Feed");

        // TODO add events

        list.add(actionSelection);
        // TODO add R object here (See notes)
        list.add(feedAmount);
        list.add(feed);



        return side;
    }
}
