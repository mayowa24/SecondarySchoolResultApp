/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omc.com.login;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class WelcomepgController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    private ProgressBar jprogress1;
    Stage stage;
    @FXML
    private Label wait;
    private int maxTimeTaken;

    private Service<Void> progressUpdate;

    private List<String> msg;

    private int max;
//      @FXML
            
//    void Continue(ActionEvent event) throws IOException {
//        Stage stage = new Stage();
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("/omc/com/login/loginpg.fxml"));
//        BorderPane load = (BorderPane) loader.load();
//        Scene scene = new Scene(load);
//        stage.setScene(scene);
//        stage.show();
//
//    }
    
    @FXML
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        maxTimeTaken = 100000000;
         msg = new LinkedList<>();
         msg.add("wait while O.S checking the system requirements...");
         msg.add("Preparing the environment...");
         msg.add("checking system configuration pls wait...");
         
         maxTimeTaken = 100000000;
         
         max=7;
         
          progressFun();

        msgFun();
    }    
    public void progressFun() {
        progressUpdate = new Service<Void>() {

            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {

                    @Override
                    protected Void call() throws Exception {
                        for (int i = 0; i < maxTimeTaken; i++) {
                            updateProgress(i, maxTimeTaken);
                        }
                        return null;
                    }

                    @Override
                    protected void succeeded() {
                        try {
                            LoadLogin();
                        } catch (IOException ex) {
                            Logger.getLogger(WelcomepgController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                };
            }
        };
        jprogress1.progressProperty().bind(progressUpdate.progressProperty());
        progressUpdate.restart();
    }

    public void msgFun() {
        progressUpdate = new Service<Void>() {

            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {

                    @Override
                    protected Void call() throws Exception {
                        for (int i = 0; i < max; i++) {
                            updateMessage(msg.get(i));
                            Thread.sleep(1000);
                        }
                        return null;
                    }

                    @Override
                    protected void succeeded() {
                        wait.setText("Completed.");
                    }

                };
            }
        };
        wait.textProperty().bind(progressUpdate.messageProperty());
        progressUpdate.restart();
    }
    
     void LoadLogin() throws IOException {
        Stage stage = new Stage(StageStyle.UNDECORATED);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/omc/com/login/loginpg.fxml"));
        BorderPane load = (BorderPane) loader.load();
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
    }
    public Stage getStage(){
        return stage;
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }
}
