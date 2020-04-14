/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omc.com.staff;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class StaffdetailsController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private JFXTextField txtstaffid;

    @FXML
    private JFXTextField txtname;

    @FXML
    private JFXTextField txtgender;

    @FXML
    private JFXTextField txtaddress;

    @FXML
    private JFXTextField txtlevel;

    @FXML
    private JFXTextField txtphone;

    @FXML
    private JFXTextField txtpost;

    @FXML
    private JFXTextField txtkinname;

    @FXML
    private JFXTextField txtkinnumber;

    @FXML
    private JFXTextField txtrelationship;

    @FXML
    private ImageView imgpassport;
    Stage stage;
    Image image;

    @FXML
    void Search(ActionEvent event) {
        if(txtstaffid.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Empty Field");
            alert.setContentText("Staff Id is required");
            alert.showAndWait();
        }
        else
         try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newera","root","");
             String sql = "SELECT * FROM stafftb WHERE staffid ='"+txtstaffid.getText()+"'";
             PreparedStatement prepare = conn.prepareStatement(sql);
             ResultSet rs = prepare.executeQuery();
             if(rs.next()){
                 txtname.setText(rs.getString("sname"));
                 txtaddress.setText(rs.getString("address"));
                 txtgender.setText(rs.getString("gender"));
                 txtlevel.setText(rs.getString("level"));
                 txtphone.setText(rs.getString("phone1"));
                 txtpost.setText(rs.getString("post"));
                 txtkinname.setText(rs.getString("kinname"));
                 txtkinnumber.setText(rs.getString("kinphone"));
                 txtrelationship.setText(rs.getString("kinrelationship"));
                 
//                 InputStream is = rs.getBinaryStream("passport");
//                 OutputStream os = new FileOutputStream(new File("photo.jpg"));
//                 byte [] contents = new byte[1024];
//                 int size = 0;
//                 while((size= is.read(contents))!=-1){
//                     os.write(contents, 0, size);
//                     
//                 }
//                 image = new Image("photo.jpg",imgpassport.getFitWidth(),imgpassport.getFitHeight(),true,true);
//                 imgpassport.setImage(image);
             }
             else{
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("Data Not Found");
                 alert.setContentText("Sorry! No Record found for this ID");
                 alert.showAndWait();
                 
                 txtstaffid.setText("");
             }
                 
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(StaffdetailsController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(StaffdetailsController.class.getName()).log(Level.SEVERE, null, ex);
         } 
//         catch (FileNotFoundException ex) {
//             Logger.getLogger(StaffdetailsController.class.getName()).log(Level.SEVERE, null, ex);
//         } 
//         catch (IOException ex) {
//             Logger.getLogger(StaffdetailsController.class.getName()).log(Level.SEVERE, null, ex);
//         }
        
    }
    @FXML
    void Print(ActionEvent event) {
        
        if(txtstaffid.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Empty Field");
            alert.setContentText("No Record to Print");
            alert.showAndWait();
        }
        else
         try {
             Document document = new Document(PageSize.A4);
             PdfWriter output = PdfWriter.getInstance(document, new FileOutputStream(txtname.getText()+".pdf"));
             document.open();
             document.add(new Paragraph(new Date().toString()));
             com.itextpdf.text.Image image =com.itextpdf.text.Image.getInstance("era.jpg");
//              document.add(new Paragraph("Image"));
              document.add(image);
              document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------"));
              document.add(new Paragraph("." ,FontFactory.getFont(FontFactory.TIMES_BOLD,11,BaseColor.WHITE)));
              document.add(new Paragraph("Teachers' Details Form ",FontFactory.getFont(FontFactory.TIMES_BOLD, 16,Font.UNDERLINE)));
             document.add(new Paragraph("Teacher's Computer Code: "+ txtstaffid.getText()));
             document.add(new Paragraph("Fullname: "+ txtname.getText()));
             document.add(new Paragraph("Address: "+ txtaddress.getText()));
             document.add(new Paragraph("gender: "+ txtgender.getText()));
             document.add(new Paragraph("Level: "+ txtlevel.getText()));
             document.add(new Paragraph("Post: "+ txtpost.getText()));
             document.add(new Paragraph("Phone Number: "+ txtphone.getText()));
             document.add(new Paragraph("." ,FontFactory.getFont(FontFactory.TIMES_BOLD,11,BaseColor.WHITE)));
             document.add(new Paragraph("Next of Kins Details ",FontFactory.getFont(FontFactory.TIMES_BOLD, 16,Font.UNDERLINE)));
             document.add(new Paragraph("Next of Kin's Name: "+ txtkinname.getText()));
             document.add(new Paragraph("Phone Number: "+ txtkinnumber.getText()));
             document.add(new Paragraph("Relationship: "+ txtrelationship.getText()));
                document.add(new Paragraph("." ,FontFactory.getFont(FontFactory.TIMES_BOLD,11,BaseColor.WHITE)));
              document.add(new Paragraph(".",FontFactory.getFont(FontFactory.TIMES_BOLD,11,BaseColor.WHITE)));
              document.add(new Paragraph(".",FontFactory.getFont(FontFactory.TIMES_BOLD,11,BaseColor.WHITE)));
              document.add(new Paragraph("---------------------------                                                   "+"-------------------------------------"));
              document.add(new Paragraph("Teacher's Signature                                                   "+"Next of Kin's Signature"));
              document.add(new Paragraph(".",FontFactory.getFont(FontFactory.TIMES_BOLD,11,BaseColor.WHITE)));
              document.add(new Paragraph(".",FontFactory.getFont(FontFactory.TIMES_BOLD,11,BaseColor.WHITE)));
              document.add(new Paragraph(".",FontFactory.getFont(FontFactory.TIMES_BOLD,11,BaseColor.WHITE)));
              document.add(new Paragraph(".",FontFactory.getFont(FontFactory.TIMES_BOLD,11,BaseColor.WHITE)));
              document.add(new Paragraph("------------------------------------------------                   "));
              document.add(new Paragraph("   Principal's Signature & Date                         "));
             document.close();
             
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("File Output");
             alert.setContentText("the File as been Saved as pdf successfully");
             alert.showAndWait();
             
             
             txtname.setText("");
             txtaddress.setText("");
             txtlevel.setText("");
             txtpost.setText("");
             txtphone.setText("");
             txtgender.setText("");
             txtstaffid.setText("");
             txtkinname.setText("");
             txtkinnumber.setText("");
             txtrelationship.setText("");
         } catch (FileNotFoundException ex) {
             Logger.getLogger(StaffdetailsController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (DocumentException ex) {
             Logger.getLogger(StaffdetailsController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(StaffdetailsController.class.getName()).log(Level.SEVERE, null, ex);
         }
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
