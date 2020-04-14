/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omc.com.student;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.awt.Image;
import java.awt.event.MouseEvent;
//import omc.com.imageUtil;
////import com.mysql.jdbc.Connection;
//import java.awt.image.BufferedImage;
//
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Objects;
import java.util.Optional;
//import java.sql.DriverManager;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
//import javafx.scene.image.ImageView;
//import javafx.scene.image.WritableImage;
//import javafx.stage.FileChooser;
import javafx.stage.Stage;
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JFileChooser;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */

public class EnrollmentpgController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private JFXTextField txtstudentname;

    @FXML
    private JFXComboBox<String> combgender;

     @FXML
    private DatePicker dateaddmitted;


//    @FXML
//    private ImageView imgpassport;

//    @FXML
//    private JFXTextField txtlga;

    @FXML
    private JFXTextField txtorigin;

//    @FXML
//    private DatePicker dob;

//    @FXML
//    private JFXTextField txtformal;

    @FXML
    private JFXComboBox<String> combclass;

    @FXML
    private JFXTextField txtparent;

    @FXML
    private JFXTextField txtaddress;

    @FXML
    private JFXTextField txtphone;
    
//     @FXML
//    private JFXComboBox<String> combday;
       @FXML
    private JFXComboBox<String> combcategory;

//    @FXML
//    private JFXComboBox<String> combmonth;

//    @FXML
//    private JFXComboBox<String> combyear;
    
    @FXML
    private JFXTextField txtothernames;
     @FXML
    private JFXTextField txtage;
     @FXML
    private JFXTextField txtweight;
    
//    private File file;
//    private BufferedImage image;
//    private String category;
//    private FileInputStream fis;
//    private static BufferedImage passportBuffer;
//    private static byte[] passportArry;
    
    Stage stage;
    int id = 0;
    int studentid=1;

    @FXML
    void cancel(ActionEvent event) {

    }
//     @FXML
//    void UploadPassport(ActionEvent event) throws IOException {
////        JFileChooser fileChooser = new JFileChooser();
//
//        int option = fileChooser.showOpenDialog(null);
//
//        if (option == 0) {
//            File selectedFile = fileChooser.getSelectedFile();
//            
//                passportBuffer = ImageIO.read(selectedFile);
//                passportArry = imageUtil.imageToByteArray(passportBuffer);
////                 BufferedImage bufferimage = ImageIO.read(file);
//                   FileChooser filechooser = new FileChooser();
//                   file = filechooser.showOpenDialog(null);
//                   BufferedImage bufferimage = ImageIO.read(file);
//                    WritableImage toFXImage = SwingFXUtils.toFXImage(bufferimage, null);
//                   
////                WritableImage toFXImage = SwingFXUtils.toFXImage(passportBuffer, null);
//                imgpassport.setImage(toFXImage);
//                
//                Image image = passportBuffer.getScaledInstance(imgpassport.getWidth(), imgpassport.getHeight(), BufferedImage.SCALE_DEFAULT);
//                passportJLabel.setIcon(new ImageIcon(image));
            

        
        
       
        
//    }
      @FXML
    void LoadClass(ActionEvent event) {
        ObservableList<String> junior = FXCollections.observableArrayList();
        junior.add("JSS 1");
        junior.add("JSS 2");
        junior.add("JSS 3");
        
        ObservableList<String>senior = FXCollections.observableArrayList();
        senior.add("SS 1");
        senior.add("SS 2");
        senior.add("SS 3");
        
        
        ObservableList<String>primary = FXCollections.observableArrayList();
        primary.add("Primary 1");
        primary.add("Primary 2");
        primary.add("Primary 3");
        primary.add("Primary 4");
        primary.add("Primary 5");
        primary.add("Primary 6");
        
        ObservableList<String>kg = FXCollections.observableArrayList();
        kg.add("Kg 1");
        kg.add("Kg 2");
        kg.add("Kg 3");
        
        
        
         if(combcategory.getValue().equalsIgnoreCase("kindergarten")){
       
        
            combclass.setItems(kg);
        }
        else if(combcategory.getValue().equals("Primary")){
            combclass.setItems(primary);
        }
         else if(combcategory.getValue().equals("Junior Secondary School")){
            combclass.setItems(junior);
        }
         else if(combcategory.getValue().equals("Senior Secondary School")){
            combclass.setItems(senior);
        }
//         else if(combcategory.getValue().equals("Nursery")){
//            combclass.setItems(nursery);
//        }
    }
//@FXML
//    void LoadClass(MouseEvent event) {
//        
//    }
    

    @FXML
    void register(ActionEvent event) {
        id = studentid+1;
        Random random = new Random();
        int nextInt = random.nextInt(999);
        String key = "EXCEL/"+nextInt;
//            String key = "EXCEL/"+id;
        
//        String admissiondate = combday.getValue()+" "+combmonth.getValue();
        String studentname = txtstudentname.getText()+" "+txtothernames.getText();
//        System.out.println(key);
           
        
        
        if(txtstudentname.getText().equals("")||txtorigin.getText().equals("")||txtage.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Empty Field");
            alert.setContentText("you must fill all fields");
            alert.showAndWait();
        }else{
        
         
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation ");
        alert.setHeaderText("Are You Sure");
        alert.setContentText("Are You sure, you want to submit?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {

            
          
         try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/excellencedb","root","");
             String sqll = "SELECT studentid FROM studenttb WHERE studentid='"+key+"'";
             PreparedStatement pre = con.prepareStatement(sqll);
             ResultSet rs = pre.executeQuery();
             while (rs.next()){
                nextInt = random.nextInt(999);
                key = "EXCEL/"+nextInt;
                
                
             } 
            try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/excellencedb","root","");
            String sql = "INSERT INTO studenttb(studentid,sname,gender,weight,age,state,category,sclass,adate,parent,address,phone)VALUES('"+key+"','"+studentname+"','"+
                    combgender.getValue()+"','"+Double.parseDouble(txtweight.getText())+"','"+Integer.parseInt(txtage.getText())+"','"+txtorigin.getText()+"','"+combcategory.getValue()+"','"+combclass.getValue()+"','"+dateaddmitted.getValue()+"','"+txtparent.getText()+"','"+txtaddress.getText()+"','"+txtphone.getText()+"')";
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.execute();
            
            
//            fis = new FileInputStream(file);
            
            
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setTitle("Registration Number");
            alert2.setContentText("this student Reg. Number is "+key);
            alert2.showAndWait();
            
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Registration");
            alert1.setContentText("this student has been registered successfully");
            alert1.showAndWait();
            
            txtstudentname.setText("");
            txtothernames.setText("");
            combgender.setValue(null);
            txtage.setText("");
            txtweight.setText("");
            combcategory.setValue(null);
            dateaddmitted.setValue(null);
            txtorigin.setText("");

            combclass.setValue(null);
            txtparent.setText("");
            txtaddress.setText("");
            txtphone.setText("");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EnrollmentpgController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentpgController.class.getName()).log(Level.SEVERE, null, ex);
        }    
//            catch (FileNotFoundException ex) {
//                 Logger.getLogger(EnrollmentpgController.class.getName()).log(Level.SEVERE, null, ex);
//             }
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(EnrollmentpgController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(EnrollmentpgController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
                }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> gender = FXCollections.observableArrayList();
        gender.add("Male");
        gender.add("Female");
        combgender.setItems(gender);
        
        ObservableList<String>category = FXCollections.observableArrayList();
        category.add("Kindergarten");
//         category.add("Nursery");
        category.add("Primary");
        category.add("Junior Secondary School");
        category.add("Senior Secondary School");
        combcategory.setItems(category);
//        
        
        
    }    
    public Stage getStage(){
        return stage;
    }
    public void setStage(Stage stage){
        this.stage=stage;
    }
}
