/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omc.com.home;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class HomepgController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private BorderPane borderpane;
    Stage stage;
      @FXML
    void About(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/omc/com/about/about.fxml"));
        BorderPane load = (BorderPane) loader.load();
        borderpane.setCenter(load);
    }

    @FXML
    void AddStaff(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/omc/com/staff/addstaff.fxml"));
        BorderPane load = (BorderPane) loader.load();
        borderpane.setCenter(load);
    }

    @FXML
    void Enroll(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/omc/com/student/enrollmentpg.fxml"));
        BorderPane load = (BorderPane) loader.load();
        borderpane.setCenter(load);
    }

    @FXML
    void Exit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Exit App");
            alert.setContentText("Are you sure you want to exit?");
         Optional<ButtonType> response = alert.showAndWait();
         if(response.get()==ButtonType.OK){
            
        System.exit(0);

    }
    }

    @FXML
    void StaffRecords(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/omc/com/staff/staffrecord.fxml"));
        BorderPane load = (BorderPane) loader.load();
        borderpane.setCenter(load);
    }

    @FXML
    void Staffdetails(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/omc/com/staff/staffdetails.fxml"));
        BorderPane load = (BorderPane) loader.load();
        borderpane.setCenter(load);
    }

    @FXML
    void StudentRecord(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/omc/com/student/recordpg.fxml"));
        BorderPane load = (BorderPane) loader.load();
        borderpane.setCenter(load);

    }

    @FXML
    void Studentdetails(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/omc/com/student/individualpg.fxml"));
        BorderPane load = (BorderPane) loader.load();
        borderpane.setCenter(load);

    }
    
     @FXML
    void UpdateStaff(ActionEvent event) throws IOException {
       
    }
     @FXML
    void ProcessResult(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/omc/com/result/ResultPro.fxml"));
        BorderPane load = (BorderPane) loader.load();
        borderpane.setCenter(load);
    }
    
        @FXML
    void ViewResult(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/omc/com/result/ViewResult.fxml"));
        BorderPane load = (BorderPane) loader.load();
        borderpane.setCenter(load);
    }
    @FXML
    void UpdateStudent(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/omc/com/student/Updatepg.fxml"));
        BorderPane load = (BorderPane) loader.load();
        borderpane.setCenter(load);
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
