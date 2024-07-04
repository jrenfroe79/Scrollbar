package module5assignments;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Changecolor extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 400, 400);

        Circle circle = new Circle(200, 200, 50, Color.WHITE);
        circle.setStroke(Color.BLACK);

        circle.setOnMousePressed(event -> {
            circle.setFill(Color.BLACK);
        });

        circle.setOnMouseReleased(event -> {
            circle.setFill(Color.WHITE);
        });

        root.getChildren().add(circle);

        primaryStage.setTitle("Change Color");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

