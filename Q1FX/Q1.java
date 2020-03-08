/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1FX;

import Q3FX.Q3;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author khatib
 */
public class Q1 extends Application {

    ListView<String> listV;
    
    Button Copy;
    ListView TextCopy;
    Label label_result ;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Multiple Selection Lists");

        listV = new ListView<String>();
       // listV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ObservableList<String> items = FXCollections.observableArrayList("red", "blue",
                "green", "yellow", "orange", "brown", "pink", "purple", "gray", "black", "white");
        listV.setItems(items);
        listV.setPrefSize(130, 150);

        listV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Copy = new Button("Copy >>> ");
        TextCopy = new ListView();
        TextCopy.setPrefSize(100, 190);

        Copy.setOnAction((ActionEvent e) -> {
       if(!listV.getSelectionModel().getSelectedItems().isEmpty()){
            TextCopy.getItems().addAll(listV.getSelectionModel().getSelectedItems());
 
       }else if(listV.getSelectionModel().getSelectedItems().isEmpty()){
            Alert alertInformation = new Alert(AlertType.INFORMATION);
            alertInformation.setTitle("Error window");
            alertInformation.setHeaderText("warning");
            alertInformation.setContentText("You must specify a color or several colors");
            alertInformation.showAndWait();

       }
       
            listV.getSelectionModel().clearSelection();

        });



        HBox hBox = new HBox(listV, Copy, TextCopy);
        hBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(hBox, 300, 250);
        primaryStage.setTitle("Multiple Selection Lists");
        primaryStage.setScene(scene);
        primaryStage.show();

}

    public static void main(String[] args) {
        launch(args);
    }
}
