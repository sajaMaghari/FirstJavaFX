/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3FX;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JTextArea;

/**
 *
 * @author khatib
 */
public class Q3 extends Application {
    //Q3

    TextArea textAreaFileContent;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Working with menus");
        MenuBar MB = new MenuBar();

        Menu menuFile = new Menu("_File");

        MenuItem MIopen = new MenuItem("_open");
        MenuItem MIclose = new MenuItem("_close");
        MenuItem MIExit = new MenuItem("_Exit");

        menuFile.getItems().addAll(MIopen, MIclose, MIExit);

        Menu menuEdit = new Menu("_Edit");

        MenuItem menuItemFont = new MenuItem("_Font");
        MenuItem menuItemColor = new MenuItem("_Color");
        menuEdit.getItems().addAll(menuItemFont, menuItemColor);
        MB.getMenus().addAll(menuFile, menuEdit);

        textAreaFileContent = new TextArea("Initial Text");

        EventHandlerl ev1 = new EventHandlerl();
        MIopen.setOnAction((EventHandler<ActionEvent>) ev1);
        MIclose.setOnAction(ev1);
        MIExit.setOnAction(ev1);
        menuItemColor.setOnAction(ev1);
        menuItemFont.setOnAction(ev1);

        VBox vBox = new VBox(MB, textAreaFileContent);
        Scene scene = new Scene(vBox, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private class EventHandlerl implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            String menuItem = ((MenuItem) event.getSource()).getText();
            switch (menuItem) {
                case "_open":
                    FileChooser fc = new FileChooser();
                    fc.setTitle("File selection");
                    fc.setInitialDirectory(new File("."));
                    File file = fc.showOpenDialog(null);
                     {
                        try {
                            Scanner scanner = new Scanner(file);
                            while (scanner.hasNext()) {
                                textAreaFileContent.appendText(scanner.nextLine());
                            }

                            scanner.close();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Q3.class.getName());
                        }
                    }
                    break;
                case "_close":
                    textAreaFileContent.setText("");

                    break;
                case "_Exit":
                    System.exit(0);
                    break;
                case "_Font":
                    Dialog<String> dialogFont = new ChoiceDialog<>("23", FXCollections
                            .observableArrayList("11", "32", "13", "14"));
                    dialogFont.setTitle("Font Selection");
                    dialogFont.setHeaderText("Select Font");
                    String Font = dialogFont.showAndWait().get();
                    textAreaFileContent.setStyle("-fx-text-fill:" + Font);

                    break;
                case "_Color":
                    Dialog<String> dialogColor = new ChoiceDialog<>("Blue", FXCollections
                            .observableArrayList("Red", "Blue", "Gray"));
                    dialogColor.setTitle("Color Selection");
                    dialogColor.setHeaderText("Select color");
                    String color = dialogColor.showAndWait().get();
                    textAreaFileContent.setStyle("-fx-text-fill:" + color);
                    break;

            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
