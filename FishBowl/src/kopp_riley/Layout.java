package kopp_riley;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class Layout {

    // Link to Controller
    Controller controller;

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

    // Tank View
    private TankView tank;



    public Scene init(){
        Scene scene;

        BorderPane borderPane = new BorderPane();
        borderPane.setMinSize(700, 600);
        borderPane.setBottom(setupInfoBar());
        borderPane.setLeft(setupActionBar());
        borderPane.setCenter(setupTank());

        scene = new Scene(borderPane);
        return scene;
    }

    Layout(Controller controllerIn){
        controller = controllerIn;
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

        actionSelection.setMaxWidth(Double.MAX_VALUE);

        // Spacing between selection and the feeding options
        Region spacing  = new Region();
        VBox.setVgrow(spacing, Priority.ALWAYS);

        // Give the combo box a default value
        actionSelection.setOnAction(controller.getComboBoxEvent());
        actionSelection.getSelectionModel().selectFirst();

        // TODO add events

        list.add(actionSelection);
        list.add(spacing);
        list.add(new Text("Feed Amount"));
        list.add(feedAmount);
        list.add(feed);




        return side;
    }

    private BorderPane setupInfoBar(){
        BorderPane info = new BorderPane();


        // Init Items
        newDayButton = new Button("New Day");
        bowlInfo     = new Text("Day: 0\nFilled: 0\nDied: 0");
        small        = new Button("3x3");
        medium       = new Button("4x5");
        large        = new Button("6x8");


        // TODO add events

        // Prettify the Formatting
        HBox resizeOptions = new HBox();
        resizeOptions.setAlignment(Pos.CENTER_LEFT);
        resizeOptions.getChildren().addAll(small, medium, large);
        BorderPane.setAlignment(bowlInfo, Pos.CENTER);
        BorderPane.setAlignment(newDayButton, Pos.CENTER_LEFT);

        // Add items to the correct sides of the pane.
        info.setLeft(newDayButton);
        info.setCenter(bowlInfo);
        info.setRight(resizeOptions);


        return info;
    }

    private TankView setupTank(){
        tank = new TankView(controller);

        return tank;
    }
}
