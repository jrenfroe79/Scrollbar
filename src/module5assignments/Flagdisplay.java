package module5assignments;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Flagdisplay extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        String[] imagePaths = {
            "file:///C:/Users/jrenf/Downloads/14-1 Images/Images/flag1.gif",
            "file:///C:/Users/jrenf/Downloads/14-1 Images/Images/flag2.gif",
            "file:///C:/Users/jrenf/Downloads/14-1 Images/Images/flag6.gif",
            "file:///C:/Users/jrenf/Downloads/14-1 Images/Images/flag7.gif"
        };

        for (int i = 0; i < imagePaths.length; i++) {
            Image image = new Image(imagePaths[i]);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(200);
            imageView.setFitHeight(200);
            gridPane.add(imageView, i % 2, i / 2);
        }

        Scene scene = new Scene(gridPane, 420, 420);
        primaryStage.setTitle("Image Grid Pane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
