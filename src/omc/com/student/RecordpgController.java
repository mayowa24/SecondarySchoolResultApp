/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omc.com.student;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import java.io.FileOutputStream;
import java.io.IOException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class RecordpgController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    private JFXComboBox<String> combsearch;

    @FXML
    private TableColumn<RecordModel, String> colname;

     @FXML
    private TableColumn<RecordModel, String> colstudentid;

    @FXML
    private TableColumn<RecordModel, String> colcategory;

    @FXML
    private TableColumn<RecordModel, String> colclass;
//    @FXML
//    private JFXCheckBox checkmale;
//
//    @FXML
//    private JFXCheckBox checkfemale;
    
    ObservableList<RecordModel>rec;
    
      @FXML
    private TableView<RecordModel> studentrec;

    @FXML
    private TableColumn<RecordModel, String> colparent;
    Stage stage;

    @FXML
    void Search(ActionEvent event) {
        rec = FXCollections.observableArrayList();
        
          try {
              Class.forName("com.mysql.jdbc.Driver");
              Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/excellencedb","root","");
              String sql = "SELECT * FROM studenttb WHERE category = '"+combsearch.getValue()+"'";
              PreparedStatement prepare = conn.prepareStatement(sql);
              ResultSet rs = prepare.executeQuery();
              while (rs.next()){
                  rec.add(new RecordModel(rs.getString("sname"), rs.getString("studentid"), rs.getString("category"), rs.getString("sclass")));
                 
                 colname.setCellValueFactory(new PropertyValueFactory<>("sname"));
                 colstudentid.setCellValueFactory(new PropertyValueFactory<>("studentid"));
                 colcategory.setCellValueFactory(new PropertyValueFactory<>("category"));
                 colclass.setCellValueFactory(new PropertyValueFactory<>("sclass"));
                 
                 
                 studentrec.setItems(rec);
              }
              
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(RecordpgController.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(RecordpgController.class.getName()).log(Level.SEVERE, null, ex);
          }
          if(combsearch.getValue().equals("All")){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/excellencedb","root","");
                String sql = "SELECT * FROM studenttb ";
                PreparedStatement prepare = conn.prepareStatement(sql);
                ResultSet rs = prepare.executeQuery();
                while (rs.next()){
                    rec.add(new RecordModel(rs.getString("sname"), rs.getString("studentid"), rs.getString("category"), rs.getString("sclass")));
                 
                 colname.setCellValueFactory(new PropertyValueFactory<>("sname"));
                 colstudentid.setCellValueFactory(new PropertyValueFactory<>("studentid"));
                 colcategory.setCellValueFactory(new PropertyValueFactory<>("category"));
                 colclass.setCellValueFactory(new PropertyValueFactory<>("sclass"));
                 
                 
                 studentrec.setItems(rec);
                    
                    
                }   } catch (ClassNotFoundException ex) {
                Logger.getLogger(RecordpgController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(RecordpgController.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
    }
    
    @FXML
    void Print(ActionEvent event) throws BadElementException, IOException, DocumentException {
        String name,regno,sclass;
        Document document = new Document(PageSize.A4);
        PdfWriter output = PdfWriter.getInstance(document,new FileOutputStream("Student List\\"+combsearch.getValue()+".pdf"));
        document.open();
        Image image = Image.getInstance("image\\"+"excel.jpg");
        document.add(image);
        document.add(new Paragraph("."));
        document.add(new Phrase("List of "+combsearch.getValue()+" Students",FontFactory.getFont(FontFactory.TIMES_BOLD,14)));
        PdfPTable table = new PdfPTable(3);
        table.addCell(new Phrase("Name",FontFactory.getFont(FontFactory.TIMES_BOLD,14)));
        table.addCell(new Phrase("Student RegNO",FontFactory.getFont(FontFactory.TIMES_BOLD,14)));
//        table.addCell("Category");
        table.addCell(new Phrase("Class",FontFactory.getFont(FontFactory.TIMES_BOLD,14)));
          try {
              Class.forName("com.mysql.jdbc.Driver");
              Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/excellencedb","root","");
               String sql = "SELECT * FROM studenttb where category = '"+combsearch.getValue()+"'";
                PreparedStatement prepare = conn.prepareStatement(sql);
                ResultSet rs = prepare.executeQuery();
                while(rs.next()){
                    name = rs.getString("sname");
                    regno = rs.getString("studentid");
//                    category = rs.getString("category");
                    sclass=rs.getString("sclass");
                    
                  table.addCell(name);
                  table.addCell(regno);
//                  table.addCell(category);
                  table.addCell(sclass);
                    
                    
                }
                float[] tcol = new float[]{50f,50f,20f};
                table.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.setWidths(tcol);
                document.add(table);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Operation Successful");
                alert.setContentText("Pdf generated successfully");
                alert.showAndWait();
                
                combsearch.setItems(null);
                studentrec.setItems(null);
                
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(RecordpgController.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(RecordpgController.class.getName()).log(Level.SEVERE, null, ex);
          } 
                
            if(combsearch.getValue().equals("All")){    
                try {
              Class.forName("com.mysql.jdbc.Driver");
              Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/excellencedb","root","");
               String sql = "SELECT * FROM studenttb";
                PreparedStatement prepare = conn.prepareStatement(sql);
                ResultSet rs = prepare.executeQuery();
                while(rs.next()){
                    name = rs.getString("sname");
                    regno = rs.getString("studentid");
//                    category = rs.getString("category");
                    sclass=rs.getString("sclass");
                    
                  table.addCell(name);
                  table.addCell(regno);
//                  table.addCell(category);
                  table.addCell(sclass);
                    
                    
                }
                float[] tcol = new float[]{50f,50f,20f};
                table.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.setWidths(tcol);
                document.add(table);
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Operation Successful");
                alert.setContentText("Pdf generated successfully");
                alert.showAndWait();
                
                combsearch.setItems(null);
                studentrec.setItems(null);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(RecordpgController.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(RecordpgController.class.getName()).log(Level.SEVERE, null, ex);
          } 
            }
        
        document.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        ObservableList<String> level = FXCollections.observableArrayList();
        level.add("Kindergarten");
        level.add("Primary");
        level.add("Junior Secondary School");
        level.add("Senior Secondary School");
        level.add("All");
        combsearch.setItems(level);
        
        
    }    
    public Stage getStage(){
        return stage;
    }
    public void setStage(Stage stage){
        this.stage=stage;
    }
    
}
