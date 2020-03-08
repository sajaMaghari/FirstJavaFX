/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2FX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author khatib
 */
public class Q2 extends Application {

    TextField text;
    Label label;
    RadioButton Fahrenheit;
    RadioButton Kelvin;
    Label NewTemperatureInIs;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Temperature converter");

        final double MIN = 0.0, MAX = 100.0, INITIAL = 0.0;
        final double MAJOR_TICK_UNIT = 20.0;
        final int MINOR_TICK_COUNT = 5;
        final double SLIDER_WIDTH = 300.0;

        label = new Label("Enter Celsius timperature: ");
        text = new TextField();

        Fahrenheit = new RadioButton("Fahrenheit");
        Kelvin = new RadioButton("Kelvin");
//        Fahrenheit.setSelected(true);

        ToggleGroup radioGroup = new ToggleGroup();
        Fahrenheit.setToggleGroup(radioGroup);
        Kelvin.setToggleGroup(radioGroup);

        Label NewTemperatureInIs = new Label(" ");
        NewTemperatureInIs.setAlignment(Pos.CENTER);

        HBox hBox = new HBox(Fahrenheit, Kelvin);
        hBox.setAlignment(Pos.CENTER);
        VBox vBox = new VBox(label, text, hBox, NewTemperatureInIs);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox, 300, 250);
        primaryStage.setTitle("Temperature converter");
        primaryStage.setScene(scene);
        primaryStage.show();

        Slider slider = new Slider(MIN, MAX, INITIAL);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(MAJOR_TICK_UNIT);
        slider.setMinorTickCount(MINOR_TICK_COUNT);
        slider.setShowTickLabels(true);
        slider.setSnapToTicks(true);
        slider.setPrefWidth(SLIDER_WIDTH);

        double celsius = slider.getValue();
        Fahrenheit.setOnAction(event -> {
            if (!text.getText().isEmpty()) {
                double fahrenheit = (9.0 / 5.0) * celsius + 32;
                NewTemperatureInIs.setText(String.format("New temperature in is :" + fahrenheit));
            } else if (text.getText().isEmpty()) {
                Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
                alertInformation.setTitle("Error window");
                alertInformation.setHeaderText("warning");
                alertInformation.setContentText("You must specify a color or several colors");
                alertInformation.showAndWait();
            }

        });

        Kelvin.setOnAction(event -> {
            if (!text.getText().isEmpty()) {
                double kelvin = celsius + 273.15;
                NewTemperatureInIs.setText(String.format("New temperature in is :" + kelvin));
            } else if (text.getText().isEmpty()) {
                Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
                alertInformation.setTitle("Error window");
                alertInformation.setHeaderText("warning");
                alertInformation.setContentText("You must specify a color or several colors");
                alertInformation.showAndWait();

            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
