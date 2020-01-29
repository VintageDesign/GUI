package kopp_riley;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Layout {


    // Action Bar Items
    private String    actionsList[] = { "GoldFish", "AngelFish", "Remove"};
    private ComboBox  actionSelection;
    private TextField feedAmount;
    private Button    feed;

    // Info Bar Items
    private Button newDayButton;
    private Text   bowlInfo;
    private Button small;
    private Button medium;
    private Button large;

    public Scene init(){
        Scene scene;

        BorderPane borderPane = new BorderPane();
        borderPane.setMinSize(700, 600);
        borderPane.setBottom(setupInfoBar());
        borderPane.setLeft(setupActionBar());

        scene = new Scene(borderPane);
        return scene;
    }

    private VBox setupActionBar(){
        VBox side = new VBox();
        side.setAlignment(Pos.CENTER);
        ObservableList list = side.getChildren();

        ObservableList<String> actions = FXCollections.observableArrayList(actionsList);

        // Init Items
        actionSelection = new ComboBox(actions);
        feedAmount      = new TextField();
        feed            = new Button("Feed");

        // TODO add events

        list.add(actionSelection);
        // TODO add R object here (See notes)
        list.add(new Text("Feed Amount"));
        list.add(feedAmount);
        list.add(feed);



        return side;
    }

    private BorderPane setupInfoBar(){
        BorderPane info = new BorderPane();


        // Init Items
        newDayButton = new Button("New Day");
        bowlInfo     = new Text("TMP\nTMP\nTMP");
        small        = new Button("3x3");
        medium       = new Button("4x5");
        large        = new Button("6x8");

        HBox resizeOptions = new HBox();
        resizeOptions.setAlignment(Pos.CENTER_LEFT);
        resizeOptions.getChildren().addAll(small, medium, large);

        BorderPane.setAlignment(bowlInfo, Pos.CENTER);
        BorderPane.setAlignment(newDayButton, Pos.CENTER_LEFT);
        //BorderPane.setAlignment(resizeOptions, Pos.CENTER_RIGHT);
        info.setLeft(newDayButton);
        info.setCenter(bowlInfo);
        info.setRight(resizeOptions);


        return info;
    }
}
