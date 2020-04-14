/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omc.com.staff;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class StaffUpdatepgController implements Initializable {

    /**
     * Initializes the controller class.
     */
     
    Stage stage;

    
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