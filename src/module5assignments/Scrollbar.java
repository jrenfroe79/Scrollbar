package module5assignments;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;

public class Scrollbar extends Application {

    private Label textLabel;

    @Override
    public void start(Stage primaryStage) {
        textLabel = new Label("Colors!");
        textLabel.setFont(new Font("Arial", 24));

        Slider redSlider = createColorSlider("Red");
        Slider greenSlider = createColorSlider("Green");
        Slider blueSlider = createColorSlider("Blue");
        Slider opacitySlider = createOpacitySlider();

        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor());
        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor());
        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor());
        opacitySlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor());

        VBox root = new VBox(10);
        root.getChildren().addAll(textLabel, redSlider, greenSlider, blueSlider, opacitySlider);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Color Selector");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Slider createColorSlider(String colorName) {
        Slider slider = new Slider(0, 255, 0);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(50);
        slider.setBlockIncrement(10);
        slider.setPrefWidth(200);

        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double value) {
                return String.format("%.0f", value);
            }

            @Override
            public Double fromString(String string) {
                return Double.valueOf(string);
            }
        });

        return slider;
    }

    private Slider createOpacitySlider() {
        Slider slider = new Slider(0, 1, 1);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(0.2);
        slider.setBlockIncrement(0.1);
        slider.setPrefWidth(200);

        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double value) {
                return String.format("%.2f", value);
            }

            @Override
            public Double fromString(String string) {
                return Double.valueOf(string);
            }
        });

        return slider;
    }

    private void updateColor() {
        double red = ((Slider) ((VBox) textLabel.getParent()).getChildren().get(1)).getValue();
        double green = ((Slider) ((VBox) textLabel.getParent()).getChildren().get(2)).getValue();
        double blue = ((Slider) ((VBox) textLabel.getParent()).getChildren().get(3)).getValue();
        double opacity = ((Slider) ((VBox) textLabel.getParent()).getChildren().get(4)).getValue();

        Color color = Color.rgb((int) red, (int) green, (int) blue, opacity);
        textLabel.setTextFill(color);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
