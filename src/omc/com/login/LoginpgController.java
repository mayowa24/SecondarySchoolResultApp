/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omc.com.login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class LoginpgController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField txtusername;

    @FXML
    private JFXPasswordField jpassword;
    Stage stage;

    @FXML
    void login(ActionEvent event) throws IOException {
        if(txtusername.getText().equals("")&jpassword.getText().equals("")){
            Stage stage = new Stage(StageStyle.UNDECORATED);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/omc/com/home/homepg.fxml"));
        BorderPane load = (BorderPane) loader.load();
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
        
        txtusername.setText("");
        jpassword.setText("");
        }
        else if(txtusername.getText().equals("")||jpassword.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Empty Field");
            alert.setContentText("You must enter the username and password");
            alert.showAndWait();
        }
            
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Access Denied");
            alert.setContentText("Incorrect Username or password");
            alert.showAndWait();
        }
            
        

    }
    
     @FXML
    void Exit(ActionEvent event) {
        System.exit(0);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public Stage getStage(){
        return stage;
    }
    public void setStage(Stage stage){
        this.stage=stage;
    }
    
}
