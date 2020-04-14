/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omc.com.result;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class ResultProController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField txtstudentid;

    @FXML
    private JFXTextField txtname;

    @FXML
    private JFXTextField txtclass;

    @FXML
    private ImageView imgpassport;

    @FXML
    private JFXComboBox<String> combsession;

    @FXML
    private JFXComboBox<String> combterm;

    @FXML
    private JFXTextField txtattendance;

    @FXML
    private JFXTextField txtweight;

    @FXML
    private JFXTextField txtgender;

    @FXML
    private JFXTextField txtage;

    @FXML
    private JFXComboBox<String> combsubject;

    @FXML
    private JFXTextField txttest1;

    @FXML
    private JFXTextField txttest2;

    @FXML
    private JFXTextField txtexam;

    @FXML
    private JFXTextField txttotal;
    @FXML
    private JFXTextField txtgrade;

    @FXML
    private JFXButton txtsubmit;
     @FXML
    private JFXTextField txtcategory;


    @FXML
    private JFXComboBox<String> combcategory;
    Stage stage;
    
      @FXML
    void Search(ActionEvent event) throws SQLException {
        if(txtstudentid.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Empty Field");
            alert.setContentText("You have not entered the student id");
            alert.showAndWait();
        }else
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/excellencedb","root","");
             String sqll = "SELECT * FROM studenttb WHERE studentid='"+txtstudentid.getText()+"'";
             PreparedStatement pre = con.prepareStatement(sqll);
             ResultSet rs = pre.executeQuery();
            if(rs.next()){
                txtname.setText(rs.getString("sname"));
                txtclass.setText(rs.getString("sclass"));
                txtweight.setText(rs.getString("weight"));
                txtage.setText(rs.getString("age"));
                txtgender.setText(rs.getString("gender"));
                txtcategory.setText(rs.getString("category"));
                
                
             }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("No Record Found");
                alert.setContentText("No Record found for this studentID");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ResultProController.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }

    @FXML
    void LoadSubject(ActionEvent event) {
        ObservableList<String>primary = FXCollections.observableArrayList();
        primary.add("MATHEMATICS");
        primary.add("ENGLISH");
        primary.add("SOCIAL STUDIES");
        primary.add("BASIC SCIENCE");
        primary.add("HOME-ECONOMICS");
        primary.add("C.R.S");
        primary.add("COMPUTER STUDIES");
        primary.add("CIVIL EDUCATION");
        primary.add("CULTURAL AND CREATIVE ARTS");
        primary.add("AGRICULTURAL SCIENCE");
        primary.add("VOCATIONAL STUDIES");
        primary.add("QUANTITATIVE REASONING");
        primary.add("VERBAL REASONING");
        primary.add("HAND WRITING");
        primary.add("EDO LANGUAGE");
        
         ObservableList<String>kind = FXCollections.observableArrayList();
         kind.add("NUMBERS");
         kind.add("PHONICS");
         kind.add("HEALTH HABITS");
         kind.add("NATURE STUDY");
         kind.add("SOCIAL HABITS");
         kind.add("C.R.S");
         kind.add("HANDWRITING");
         kind.add("CREATIVE ARTS");
         kind.add("RHYMES");
         kind.add("STORIES");
         
         ObservableList<String>junior = FXCollections.observableArrayList();
         junior.add("MATHEMATICS");
         junior.add("ENGLISH LANGUAGE");
         junior.add("PRE-VOCATIONAL STUDIES");
         junior.add("RELIGION AND NATIONAL VALUES");
         junior.add("BASIC SCIENCE AND TECHNOLOGY");
         junior.add("ENGLISH-LITERATURE");
         junior.add("CREATIVE AND CULTURAL ARTS");
         junior.add("BUSINESS STUDIES");
         junior.add("COMPUTER STUDIES");
         junior.add("EDO LANGUAGE");
         
         ObservableList<String>senior = FXCollections.observableArrayList();
         senior.add("MATHEMATICS");
         senior.add("ENGLISH LANGUAGE");
         senior.add("MARKETING");
         senior.add("CIVIC EDUCATION");
         senior.add("BIOLOGY");
         senior.add("PHYSICS");
         senior.add("CHEMISTRY");
         senior.add("AGRICULTURAL SCIENCE");
         senior.add("ECONOMICS");
         senior.add("GOVERNMENT");
         senior.add("ENGLISH-LITERATURE");
         senior.add("C.R.S");
         senior.add("COMPUTER");
         senior.add("GEOGRAPHY");
         senior.add("COMMERCE");
         senior.add("EDO LANGUAGE");
         if(txtcategory.getText().equalsIgnoreCase("kindergarten")){
             combsubject.setItems(kind);
         }else if(txtcategory.getText().equalsIgnoreCase("Primary")){
             combsubject.setItems(primary);
         }else if (txtcategory.getText().equalsIgnoreCase("Junior Secondary School")){
             combsubject.setItems(junior);
         }else if(txtcategory.getText().equalsIgnoreCase("Senior Secondary School")){
             combsubject.setItems(senior);
         }else if(txtcategory.getText().equals("")){
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Studentid");
            alert.setContentText("you cannot load subject until you search studentid");
            alert.showAndWait();
         }
         
         
    }
    
    @FXML
    void Calculate(ActionEvent event) {
        double test1,test2,exam,total;
        test1 = Double.parseDouble(txttest1.getText());
        test2 = Double.parseDouble(txttest2.getText());
        exam = Double.parseDouble(txtexam.getText());
        total = test1+test2+exam;
        txttotal.setText(total+"");
        if(txttest1.getText().equals("")||txttest2.getText().equals("")||txtexam.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Empty Field(s)");
            alert.setContentText("Nothing to calculate");
            alert.showAndWait();
        }
        
        else
        if(total<=39){
            txtgrade.setText("F");
        }
        else if(total>39 && total<=49){
            txtgrade.setText("E");
        }
        else if(total>49 && total<=59){
            txtgrade.setText("D");
        }
         else if(total>59 && total<=69){
            txtgrade.setText("C");
        }
         else if(total>69 && total<=79){
            txtgrade.setText("B");
        }else if(total>100){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Overflow Error");
            alert.setContentText("The total score is greater than 100");
            alert.showAndWait();
        }
        else{
             txtgrade.setText("A");
         }
    }
     @FXML
    void SubmitScore(ActionEvent event) {
        if (txtname.getText().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Student ID");
                alert.setContentText("Empty field(s) detected");
                alert.showAndWait();
        }else
        try {
            
            
                Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/excellencedb","root","");
            String sqll = "SELECT subject FROM resulttb WHERE studentid='"+txtstudentid.getText()+"'AND section='"+combsession.getValue()+"'AND term='"+combterm.getValue()+"'AND subject='"+combsubject.getValue()+"'";
            PreparedStatement pre = con.prepareStatement(sqll);
            ResultSet rs = pre.executeQuery();
            if (rs.next()){
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Redundancy");
                alert1.setContentText("you have already submitted score of "+combsubject.getValue()+" for this student");
                alert1.showAndWait();
                
                combsubject.setValue("");
                txttest1.setText("");
                txttest2.setText("");
                txtexam.setText("");
                txttotal.setText("");
                txtgrade.setText("");
                
            }else
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/excellencedb","root","");
                String sql = "INSERT INTO resulttb(studentid,sname,category,section,term,subject,test1,test2,exam,total,grade)VALUES('"+txtstudentid.getText()+"','"+txtname.getText()+"','"+
                        txtcategory.getText()+"','"+combsession.getValue()+"','"+combterm.getValue()+"','"+combsubject.getValue()+"','"+Double.parseDouble(txttest1.getText())+"','"+Double.parseDouble(txttest2.getText())+"','"+Double.parseDouble(txtexam.getText())+"','"+Double.parseDouble(txttotal.getText())+"','"+txtgrade.getText()+"')";
                PreparedStatement prepare = conn.prepareStatement(sql);
                prepare.execute();
                
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Registration Number");
                alert2.setContentText("You have submitted score for "+combsubject.getValue());
                alert2.showAndWait();
                
//                txtstudentid.setText("");
//                txtname.setText("");
//                txtcategory.setText("");
//                txtgender.setText("");
//                txtage.setText("");
//                txtclass.setText("");
//                txtweight.setText("");
//                combsession.setValue("");
//                combsession.setValue("");
                combsubject.setValue("");
                txttest1.setText("");
                txttest2.setText("");
                txtexam.setText("");
                txttotal.setText("");
                txtgrade.setText("");
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ResultProController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ResultProController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ResultProController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ResultProController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String>term = FXCollections.observableArrayList();
        term.add("First Term");
        term.add("Second Term");
        term.add("Third Term");
        combterm.setItems(term);
        
        ObservableList<String>session = FXCollections.observableArrayList();
        session.add("2019/2020");
        session.add("2020/2021");
        session.add("2021/2022");
        session.add("2022/2023");
        session.add("2023/2024");
        combsession.setItems(session);
//        category.add("Kindergarten");
//         category.add("Nursery");
//        category.add("Primary");
//        category.add("Junior Secondary School");
//        category.add("Senior Secondary School");
//        combcategory.setItems(category);
    }    
    public Stage getStage(){
        return stage;
    }
    public void setStage(Stage stage){
        this.stage=stage;
    }
}
