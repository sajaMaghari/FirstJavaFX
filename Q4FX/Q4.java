/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q4fx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.DatatypeConverter;
import sun.security.util.Password;

/**
 *
 * @author khatib
 */
public class Q4 extends Application {

    Button signin;
    Button Exit;
    PasswordField Passwords;
    TextField User;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Login Page");
        Label label = new Label(" Welcome ");
        label.setFont(new Font("Cambria", 32));
        
        Label UserName = new Label("User Name : ");
        Label Password = new Label("Password  : ");

        User = new TextField();
        Passwords = new PasswordField();

        HBox hBoxUser = new HBox(UserName, User);
        HBox hBoxPass = new HBox(Password, Passwords);

        signin = new Button("sign in");
        signin.setStyle("-fx-background-color:DarkCyan");
        Exit = new Button("Exit");
        Exit.setStyle("-fx-background-color:DarkCyan");

        EventHandler<ActionEvent> EventHandlerl = null;
        signin.setOnAction(EventHandlerl);

        HBox hBox = new HBox(signin, Exit);
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-background-color:Gray  ");

        VBox vBox = new VBox(label, hBoxUser, hBoxPass, hBox);
        vBox.setAlignment(Pos.CENTER);
label.setContentDisplay(ContentDisplay.LEFT);      
label.setAlignment(Pos.CENTER_LEFT);
        vBox.setStyle("-fx-background-color:Gray  ");

        Scene scene1 = new Scene(vBox, 300, 250);
        Stage Stage1 = new Stage();
        Stage1.setTitle("Login Page");
        Stage1.setScene(scene1);
        Stage1.show();

        String password = Passwords.getText();
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest);

        signin.setOnAction(event -> {
//             if (!UserName.getText().isEmpty() && !Password.getText().isEmpty()) {


                  PrintWriter PW = null;
            try {
                String file = "src/Q4FX/Q4.txt";
                PW = new PrintWriter(new FileOutputStream(file, true));
                User us = new User(User.getText(), myHash);
                PW.print(us);
                User.clear();
                Passwords.clear();
                PW.flush();
                PW.close();
                Button Add = new Button("Add Student");
                Add.setStyle("-fx-background-color:DarkCyan");

                Button View = new Button("View Student");
                View.setStyle("-fx-background-color:DarkCyan");

                VBox vBox1 = new VBox(Add, View);
                vBox1.setStyle("-fx-background-color:Gray  ");

                vBox1.setAlignment(Pos.CENTER);
                Scene scene2 = new Scene(vBox1, 300, 250);
                Stage Stage2 = new Stage();
                Stage2.setTitle("Optione Page");
                Stage2.setScene(scene2);
                Stage2.show();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Q4.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                PW.close();
            }
            
            
            
//            } else if (UserName.getText().isEmpty() && Password.getText().isEmpty()) {
//                Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
//                alertInformation.setTitle("Error window");
//                alertInformation.setHeaderText("warning");
//                alertInformation.setContentText("You must specify a color or several colors");
//                alertInformation.showAndWait();
            //}
       
          
        });
Exit.setOnAction(event -> {
    System.exit(0);
});
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
