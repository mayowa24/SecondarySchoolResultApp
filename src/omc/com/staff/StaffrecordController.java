/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omc.com.staff;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import omc.com.student.RecordModel;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class StaffrecordController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private JFXComboBox<String> txtsearch;

    @FXML
    private TableView<StaffModel> tablestaff;

    @FXML
    private TableColumn<StaffModel, String> colname;

    @FXML
    private TableColumn<StaffModel, String> colpost;

    @FXML
    private TableColumn<StaffModel, String> colphone;

    @FXML
    private TableColumn<StaffModel, String> colkinname;
    
    @FXML
    private TableColumn<StaffModel, String> colstaffid;

    @FXML
    private TableColumn<StaffModel, String> colkinphone;
    
    ObservableList<StaffModel> rec;
    Stage stage;

    @FXML
    void Print(ActionEvent event) {
         try {
             Document document = new Document(PageSize.A4);
             document.add(new Paragraph(""));
             
         } catch (DocumentException ex) {
             Logger.getLogger(StaffrecordController.class.getName()).log(Level.SEVERE, null, ex);
         }

    }

    @FXML
    void Search(ActionEvent event) {
        rec = FXCollections.observableArrayList();
        
         try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/newera","root","");
             String sql = "SELECT * FROM stafftb WHERE status = '"+txtsearch.getValue()+"'";
             PreparedStatement prepare = conn.prepareStatement(sql);
             ResultSet rs = prepare.executeQuery();
             
             while (rs.next()){
                  rec.add(new StaffModel(rs.getString("sname"), rs.getString("staffid"), rs.getString("post"), rs.getString("phone1"), rs.getString("kinname"), rs.getString("kinphone")));
                 
                 colname.setCellValueFactory(new PropertyValueFactory<>("sname"));
                 colstaffid.setCellValueFactory(new PropertyValueFactory<>("staffid"));
                 colpost.setCellValueFactory(new PropertyValueFactory<>("post"));
                 colphone.setCellValueFactory(new PropertyValueFactory<>("phone1"));
                 colkinname.setCellValueFactory(new PropertyValueFactory<>("kinname"));
                 colkinphone.setCellValueFactory(new PropertyValueFactory<>("kinphone"));
                 
                 tablestaff.setItems(rec);
             }
             
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(StaffrecordController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(StaffrecordController.class.getName()).log(Level.SEVERE, null, ex);
         }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> search = FXCollections.observableArrayList();
        search.add("N-Power Teacher");
        search.add("Parmernent Teacher");
        search.add("PTA Teacher");
        search.add("Female");
        search.add("Male");
        search.add("All");
        txtsearch.setItems(search);
    }    
    public Stage getStage(){
        return stage;
    }
    public void setStage(Stage stage){
        this.stage=stage;
    }
}
