package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Button btn1 = new Button("Component 1");
        Button btn5 = new Button("Component 5");
        GridPane example = new GridPane();
        example.add(btn1, 0, 0, 1, 3);
        example.add(new Button("Component 2"), 1, 0, 1, 1);
        example.add(new Button("Component 3"), 1, 1, 1, 1);
        example.add(new Button("Component 4"), 1, 2, 1, 1);
        example.add(btn5, 3, 0, 1, 3);

        example.setAlignment(Pos.CENTER);

        btn1.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        btn5.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        example.setVgrow(btn1, Priority.ALWAYS);
        example.setVgrow(btn5, Priority.ALWAYS);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(example, 300, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
