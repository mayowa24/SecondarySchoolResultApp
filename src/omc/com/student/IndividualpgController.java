/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omc.com.student;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
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
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
//import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import omc.com.imageUtil;
import omc.com.result.ViewResultController;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class IndividualpgController implements Initializable {

    /**
     * Initializes the controller class.
     */
       @FXML
    private JFXTextField txtfileno;

    @FXML
    private JFXTextField txtname;

    @FXML
    private JFXTextField txtgender;

    @FXML
    private JFXTextField txtclass;

    @FXML
    private JFXTextField txtparent;

    @FXML
    private JFXTextField txtaddress;

    @FXML
    private JFXTextField txtphoneno;

    @FXML
    private JFXTextField txtdob;

    @FXML
    private JFXTextField txtage;

     @FXML
    private JFXTextField txtweight;

    @FXML
    private JFXTextField txtcategory;

//    private Image image;
    private File file;
    Stage stage;
    
    @FXML
    private ImageView imgpassport;
    String imagepath;
    @FXML
    void AttachPassport(ActionEvent event) {
         FileChooser filechooser = new FileChooser();
        file = filechooser.showOpenDialog(null);
        
        
            BufferedImage bufferimage;
        try {
            bufferimage = ImageIO.read(file);
//            System.out.print(bufferimage.getPropertyNames());
            
            WritableImage toFXImage = SwingFXUtils.toFXImage(bufferimage, null);
            imgpassport.setImage(toFXImage);
            imagepath = file.getPath();
            System.out.print(imagepath);
        } catch (IOException ex) {
            Logger.getLogger(ViewResultController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    @FXML
    void print(ActionEvent event) throws FileNotFoundException {
            Document document = new Document();
            
            
            String studentid = txtfileno.getText();
            String studentname = txtname.getText();
            String gender = txtgender.getText();
          if(txtfileno.getText().equals("")){
              Alert alert = new Alert(Alert.AlertType.ERROR);
              alert.setTitle("Empty Files");
              alert.setContentText("No Record to Print ");
              alert.showAndWait();
          }
          else
          try {
              
              PdfWriter output = PdfWriter.getInstance(document,new FileOutputStream("RegForm\\"+"RegForm"+txtname.getText()+".pdf"));
              
              document.open();
              document.add(new Paragraph(new Date().toString()+"RegForm/ExcellenceSchools/"+studentid,FontFactory.getFont(FontFactory.TIMES_ITALIC,8)));
              Image image =Image.getInstance("image\\"+"excel.jpg");
              Image img = Image.getInstance(imagepath);
//              document.add(new Paragraph("Image"));
              document.add(image);
              document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------"));
              
              
              document.add(new Paragraph("." ,FontFactory.getFont(FontFactory.TIMES_BOLD,11,BaseColor.WHITE)));
              document.add(new Paragraph("STUDENT BIODATA",FontFactory.getFont(FontFactory.TIMES_BOLD,16,Font.UNDERLINE)));
              document.add(new Paragraph("." ,FontFactory.getFont(FontFactory.TIMES_BOLD,11,BaseColor.WHITE)));
//              document.add(new Paragraph("." ,FontFactory.getFont(FontFactory.TIMES_BOLD,11,BaseColor.WHITE)));
              PdfPTable table = new PdfPTable(3);
              PdfPCell c1 = new PdfPCell();
              c1.addElement(new Phrase("REGISTRATION NO:"));
              c1.addElement(new Phrase("NAME:"));
              c1.addElement(new Phrase("GENDER:"));
              c1.addElement(new Phrase("Age:"));
              c1.addElement(new Phrase("Weight:"));
              c1.addElement(new Phrase("Class:"));
              c1.setBorder(Rectangle.NO_BORDER);
              PdfPCell c2 = new PdfPCell();
              c2.addElement(new Phrase(studentid));
              c2.addElement(new Phrase(studentname));
              c2.addElement(new Phrase(gender));
              c2.addElement(new Phrase(txtage.getText()));
              c2.addElement(new Phrase(txtweight.getText()));
              c2.addElement(new Phrase(txtclass.getText()));
              c2.setBorder(Rectangle.NO_BORDER);
              float[] col = new float[]{30f,50f,15f};
              table.setWidths(col);
              table.addCell(c1);
              table.addCell(c2);
              table.addCell(img);
              table.setHorizontalAlignment(Element.ALIGN_LEFT);
             table.setWidthPercentage(90f);
              document.add(table);
//              document.add(new Paragraph("STUDENT REGISTRATION NO::  "+studentid));
//              document.add(new Paragraph("STUDENT'S NAME:  "+studentname));
//              document.add(new Paragraph("GENDER:  "+gender));
//              document.add(new Paragraph("Age:  "+ txtage.getText()));
//              document.add(new Paragraph("Category:  "+ txtcategory.getText()));
//              document.add(new Paragraph("Date of Birth:  "+ txtdob.getText()));
              document.add(new Paragraph("." ,FontFactory.getFont(FontFactory.TIMES_BOLD,11,BaseColor.WHITE)));
              document.add(new Paragraph("PARENT/GUARDIAN INFORMATION",FontFactory.getFont(FontFactory.TIMES_BOLD,16,Font.UNDERLINE)));
              document.add(new Paragraph("." ,FontFactory.getFont(FontFactory.TIMES_BOLD,11,BaseColor.WHITE)));
              PdfPTable ptable = new PdfPTable(2);
              PdfPCell p1 = new PdfPCell();
              p1.addElement(new Phrase("Name:"));
              p1.addElement(new Phrase("Addess:"));
              p1.addElement(new Phrase("Phone Number:"));
              p1.setBorder(Rectangle.NO_BORDER);
              PdfPCell p2 = new PdfPCell();
              p2.addElement(new Phrase(txtparent.getText()));
              p2.addElement(new Phrase(txtaddress.getText()));
              p2.addElement(new Phrase(txtphoneno.getText()));
              p2.setBorder(Rectangle.NO_BORDER);
              
              float[] csize = new float[]{25f,60f};
              ptable.setWidths(csize);
              ptable.addCell(p1);
              ptable.addCell(p2);
              ptable.setHorizontalAlignment(Element.ALIGN_LEFT);
              document.add(ptable);
//              document.add(new Paragraph("Name:  "+ txtparent.getText()));
//              document.add(new Paragraph("Addess:  "+ txtaddress.getText()));
//              document.add(new Paragraph("Phone Number:  "+ txtphoneno.getText()));
              document.add(new Paragraph("." ,FontFactory.getFont(FontFactory.TIMES_BOLD,11,BaseColor.WHITE)));
              document.add(new Paragraph(".",FontFactory.getFont(FontFactory.TIMES_BOLD,11,BaseColor.WHITE)));
              document.add(new Paragraph(".",FontFactory.getFont(FontFactory.TIMES_BOLD,11,BaseColor.WHITE)));
              document.add(new Paragraph("---------------------------                                                   "+"-------------------------------------"));
              document.add(new Paragraph("Student's Signature                                                   "+"Parent/Guardian Signature"));
              document.add(new Paragraph(".",FontFactory.getFont(FontFactory.TIMES_BOLD,11,BaseColor.WHITE)));
              document.add(new Paragraph(".",FontFactory.getFont(FontFactory.TIMES_BOLD,11,BaseColor.WHITE)));
              document.add(new Paragraph(".",FontFactory.getFont(FontFactory.TIMES_BOLD,11,BaseColor.WHITE)));
              document.add(new Paragraph(".",FontFactory.getFont(FontFactory.TIMES_BOLD,11,BaseColor.WHITE)));
              document.add(new Paragraph("------------------------------------------------                   "));
              document.add(new Paragraph("   Principal's Signature & Date                         "));
              document.close();
              
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Report");
              alert.setContentText("the Document as been saved as pdf file successfully");
              alert.showAndWait();
              
              txtname.setText("");
              txtfileno.setText("");
              txtgender.setText("");
              txtcategory.setText("");
              txtage.setText("");
//              txtdob.setText("");
              txtparent.setText("");
              txtaddress.setText("");
              txtphoneno.setText("");
          } catch (DocumentException ex) {
              Logger.getLogger(IndividualpgController.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(IndividualpgController.class.getName()).log(Level.SEVERE, null, ex);
          }
         
        

    }

    @FXML
    void search(ActionEvent event) {
        
        if(txtfileno.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Empty Field");
            alert.setContentText("Student Id is required");
            alert.showAndWait();
        }
        else
          try {
              Class.forName("com.mysql.jdbc.Driver");
              Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/excellencedb","root","");
              String sql = "SELECT * FROM studenttb WHERE studentid='"+txtfileno.getText()+"'";
              PreparedStatement prepare = conn.prepareStatement(sql);
              ResultSet rs = prepare.executeQuery();
              if(rs.next()){
                    
                  txtname.setText(rs.getString("sname"));
                  txtgender.setText(rs.getString("gender"));
                  txtclass.setText(rs.getString("sclass"));
                  txtage.setText(rs.getString("age"));
                  txtcategory.setText(rs.getString("category"));
                  txtparent.setText(rs.getString("parent"));
                  txtaddress.setText(rs.getString("address"));
                  txtweight.setText(rs.getString("weight"));
                  txtphoneno.setText(rs.getString("phone"));
//                  txtorigin.setText(rs.getString("state"));
//                    java.awt.Image scaledImage = imageUtil.getScaledImage(rs.getBytes("passport"),null);
//                imgpasport.setImage(scaledImage);

                            
                           
                 
//                  OutputStream os = new FileOutputStream(new File("img"));
//                  byte [] content = new byte[2048];
//                  int size=0;
//                  while ((size=is.read(content))!=-1){
//                      os.write(content,0,size);
//                  }
//                  os.close();
//                  is.close();

//                  javafx.scene.image.Image passport = new Image("file:img",imgpasport.getFitWidth(),imgpasport.getFitHeight(),true,true);
//                  imgpasport.setImage(passport);
//                  imgpasport.setPreserveRatio(true);
                  
                 
                  
                  
                
//                  BufferedImage bi = null;
//                  bi =ImageIO.read(is);
//                  WritableImage toFXImage = SwingFXUtils.toFXImage(bi, null);
//                    imgpasport.setImage(toFXImage);
//                  javafx.scene.image.Image passport = new Image("file:img",img pasport.getFitWidth(),imgpasport.getFitHeight(),true,true);
                  

                  
              }
              else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Data Not Found");
            alert.setContentText("No Record Found for this ID");
            alert.showAndWait();    
            
            txtfileno.setText("");
                      }
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(IndividualpgController.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(IndividualpgController.class.getName()).log(Level.SEVERE, null, ex);
//          } catch (FileNotFoundException ex) {
//              Logger.getLogger(IndividualpgController.class.getName()).log(Level.SEVERE, null, ex);
//          } catch (IOException ex) {
//              Logger.getLogger(IndividualpgController.class.getName()).log(Level.SEVERE, null, ex);
//          }

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
