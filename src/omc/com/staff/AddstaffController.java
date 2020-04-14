/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omc.com.staff;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class AddstaffController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField txtname;

    @FXML
    private JFXComboBox<String> combgender;

    @FXML
    private JFXTextField txtlevel;

    @FXML
    private JFXComboBox<String> combstatus;

    @FXML
    private JFXComboBox<String> combpost;

    @FXML
    private JFXTextField txtaddress;

    @FXML
    private JFXTextField txtemail;

    @FXML
    private JFXTextField txtphone1;

    @FXML
    private JFXTextField txtphone2;

    @FXML
    private DatePicker jdate;

    @FXML
    private JFXComboBox<String> combmarital;

    @FXML
    private ImageView imgpassport;

    @FXML
    private JFXTextField txtkinname;

    @FXML
    private JFXTextField txtkinaddress;

    @FXML
    private JFXTextField txtkinphone;

    @FXML
    private JFXComboBox<String> combrelationship;
    
    Stage stage;
     @FXML
    private JFXTextField txtstaffid;

    @FXML
    void SaveRecord(ActionEvent event) {
        
//        Random random = new Random();
//        int nextInt = random.nextInt(99);
//        String key = "NESS/STF/"+nextInt;
        
        if(txtname.getText().equals("")||txtaddress.getText().equals("")||txtemail.getText().equals("")||txtkinname.getText().equals("")||txtkinphone.getText().equals("")||combstatus.getValue().equals(null)||txtstaffid.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Empty Field(s)");
            alert.setContentText("Some Important field(s) are not filled");
            alert.showAndWait();
        }
//        else if(imgpassport.getImage().equals(null)){
//             Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Passport Required");
//            alert.setContentText("You must upload your ");
//            alert.showAndWait();
//            }
        
else
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newera","root","");
            String sqll = "SELECT staffid FROM stafftb WHERE staffid='"+txtstaffid.getText()+"'";
             PreparedStatement pre = con.prepareStatement(sqll);
             ResultSet rs = pre.executeQuery();
             if (rs.next()){
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setTitle("Staff ID Exist");
                alert.setContentText("This Staff ID already exist in our database");
                alert.showAndWait();
                
                txtstaffid.setText("");
//                txtstaffid.setFocusColor("#ffffff");
                
             }
             else
             
             try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newera","root","");
            String sql = "INSERT INTO stafftb(staffid,sname,address,gender,email,phone1,phone2,date,mstatus,post,level,status,kinname,kinaddress,kinphone,kinrelationship)VALUES('"+txtstaffid.getText()+"','"+txtname.getText()+"','"+
                    txtaddress.getText()+"','"+combgender.getValue()+"','"+txtemail.getText()+"','"+txtphone1.getText()+"','"+txtphone2.getText()+"','"+jdate.getValue()+"','"+combmarital.getValue()+"','"+combpost.getValue()+"','"+txtlevel.getText()+"','"+
                    combstatus.getValue()+"','"+txtkinname.getText()+"','"+txtkinaddress.getText()+"','"+txtkinphone.getText()+"','"+combrelationship.getValue()+"')";
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.execute();
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Staff ID");
//            alert.setResult(ButtonType.YES);
//            alert.setResult(ButtonType.NO);
            
            alert.setContentText("Are you sure the infomations are correct? ");
                Optional<ButtonType> response = alert.showAndWait();
            if(response.get()==ButtonType.OK){
            
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Registration");
            alert1.setContentText("Data saved successfully");
            alert1.showAndWait();
            
            
                    txtname.setText("");
                    txtaddress.setText("");
                    combgender.setValue(null);
                    txtemail.setText("");
                    txtphone1.setText("");
                    txtphone2.setText("");
                    jdate.setValue(null);
                    combmarital.setValue("");
                    combpost.setValue(null);
                    txtlevel.setText("");
                    combstatus.setValue(null);
                    txtkinname.setText("");
                    txtkinaddress.setText("");
                    txtkinphone.setText("");
                    combrelationship.setValue(null);
//                    imgpassport.setImage(null);
                    txtstaffid.setText("");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddstaffController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddstaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddstaffController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddstaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

    }
    
    @FXML
    void UploadPassport(ActionEvent event) {
//        FileChooser filechooser = new FileChooser();
//        File file = filechooser.showOpenDialog(null);
//        
//        try {
//            BufferedImage bi = ImageIO.read(file);
//            WritableImage toFXImage = SwingFXUtils.toFXImage(bi, null);
//            imgpassport.setImage(toFXImage);
//        } catch (IOException ex) {
//            Logger.getLogger(AddstaffController.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> gender = FXCollections.observableArrayList();
        gender.add("Male");
        gender.add("Female");
        combgender.setItems(gender);
        
        ObservableList<String> status = FXCollections.observableArrayList();
        status.add("PTA Teacher");
        status.add("Parmernent Teacher");
        status.add("N-Power Teaher");
        combstatus.setItems(status);
        
        
        ObservableList<String> post = FXCollections.observableArrayList();
        post.add("Principal");
        post.add("Vice Principal");
        post.add("Busar");
        post.add("Secretary");
        post.add("Librarian");
        post.add("None");
        combpost.setItems(post);
        
        ObservableList<String> relationship = FXCollections.observableArrayList();
        relationship.add("Brother");
        relationship.add("Sister");
        relationship.add("Husband");
        relationship.add("Wife");
        relationship.add("Others");
        combrelationship.setItems(relationship);
        
        ObservableList<String> stat = FXCollections.observableArrayList();
        stat.add("Single");
        stat.add("Married");
        stat.add("Divorced");
        stat.add("Widow");
        stat.add("Widower");
        stat.add("Complicated");
        combmarital.setItems(stat);
    }    
    public Stage getStage(){
        return stage;
    }
    public void setStage(Stage stage){
        this.stage=stage;
    }
}
