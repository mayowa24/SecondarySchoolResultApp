/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omc.com.login;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class RegisterpgController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField txtname;

    @FXML
    private JFXComboBox<?> combposition;

    @FXML
    private JFXComboBox<?> combgender;

    @FXML
    private JFXTextField txtusername;

    @FXML
    private JFXPasswordField jpassword;

    @FXML
    private JFXPasswordField jconfirm;

    @FXML
    void register(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
