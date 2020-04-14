/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omc.com.result;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
public class ViewResultController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField txtstudentid;

    @FXML
    private JFXTextField txtname;

    @FXML
    private JFXTextField txtgender;

    @FXML
    private JFXTextField txtclass;

    @FXML
    private JFXTextField txtweight;

    @FXML
    private JFXTextField txtage;

    @FXML
    private JFXTextField txtattendance;

    @FXML
    private ImageView imgpassport;

    @FXML
    private JFXComboBox<String> combsession;

    @FXML
    private JFXComboBox<String> combterm;

    @FXML
    private TableColumn<ResultTableModel, String> colsubject;

    @FXML
    private TableColumn<ResultTableModel, String> coltest1;

    @FXML
    private TableColumn<ResultTableModel, String> coltest2;

    @FXML
    private TableColumn<ResultTableModel, String> colexam;
    
    @FXML
    private TableColumn<ResultTableModel, String> coltotal;

    @FXML
    private TableColumn<ResultTableModel, String> colgrade;

    @FXML
    private JFXTextField txtteacher;

    @FXML
    private JFXTextField txtremark;

    @FXML
    private JFXTextField txtprincipal;
    @FXML
    private JFXTextField txtcategory;
    @FXML
    private JFXTextField txtrecommend;
     @FXML
    private TableView<ResultTableModel> tableResult;
     @FXML
    private JFXComboBox<String> combpuntual;

    @FXML
    private JFXComboBox<String> combattentive;

    @FXML
    private JFXComboBox<String> combstaff;

    @FXML
    private JFXComboBox<String> combpupil;

    @FXML
    private JFXComboBox<String> combneat;

    @FXML
    private JFXComboBox<String> combpolite;

    @FXML
    private JFXComboBox<String> comborganize;

    @FXML
    private JFXComboBox<String> combinitiate;

    @FXML
    private JFXComboBox<String> combattendance;

    @FXML
    private JFXComboBox<String> combself;

    @FXML
    private JFXComboBox<String> combart;

    @FXML
    private JFXComboBox<String> combsport;

    @FXML
    private JFXComboBox<String> combclub;

    @FXML
    private JFXComboBox<String> comblanguage;

    @FXML
    private JFXComboBox<String> combtools;
    @FXML
    private ImageView imgpass;
    
    String imagepath;

    
    Stage stage;
    ObservableList<ResultTableModel>rec;
    int count = 0;
    int Gtotal;
    int sum = 0;
    int totalscore;
    double average;
    int totals=0;
    int totalsubject;
    String Ograde="";
    
    BufferedImage bufferimage;
    File file;
    
    public static PdfPCell createImageCell(byte[] path) throws BadElementException, IOException{
        Image img = Image.getInstance(path);
        PdfPCell cell = new PdfPCell(img,true);
        return cell;
    }
    @FXML
    void Print(ActionEvent event) throws IOException {
        String subject, test1,test2,exam,total,grade;
        Document document = new Document(PageSize.A4,35f,3f,3f,3f);
        
        Font font = FontFactory.getFont(FontFactory.COURIER);
            Font size = FontFactory.getFont(FontFactory.COURIER,10f);
//            if(imgpass.equals(null)){
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("Passport Missing");
//                alert.setContentText("You need to attach passport");
//                alert.showAndWait();
//                
//            }else
//            if(imagepath.isEmpty()){
//                
//            }else
//            float fontsize;
//            float lineSpacine;
//            lineSpacine = 9f;
//           BufferedImage bi = SwingFXUtils.fromFXImage(imgpass.getImage(),null);
//            ByteArrayOutputStream s = new ByteArrayOutputStream();
//            ImageIO.write(bi, "png", s);
//            byte[] res = s.toByteArray();
////            
////            fontsize=9f;
////            Paragraph p = new Paragraph(new Phrase(FontFactory.getFont(font, fontsize)));
//            if(res ==null){
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("No Image");
//                alert.setContentText("No Image found");
//                alert.showAndWait();
//                
//            }
//        for(int i = 0; i<res.length;i++){
//    Image image = Image.getInstance(imgpass.getImage());
        try {
            
            
            PdfWriter output = PdfWriter.getInstance(document,new FileOutputStream("result\\"+txtname.getText()+".pdf"));
            document.open();
//            Paragraph para = new Paragraph();
//            para.setLeading(15, 0);
//            Font font = FontFactory.getFont(FontFactory.COURIER);
//            Font size = FontFactory.getFont(FontFactory.COURIER,10f);
                Font font1 = new Font(FontFamily.TIMES_ROMAN,11,Font.NORMAL);
                Font fontkey = new Font(FontFamily.TIMES_ROMAN,9,Font.NORMAL);
                Font font2 = new Font(FontFamily.TIMES_ROMAN,12,Font.BOLD);
                Font font0 = new Font(FontFamily.TIMES_ROMAN,2,Font.BOLD);
//            document.setMargins(0f, 0f, 0f, 0f);
            Image image =Image.getInstance("image\\"+"excel.jpg");
            Image imagekey = Image.getInstance("image\\"+"key.png");
            Image rating = Image.getInstance("image\\"+"rating.png");
            Image image1 = Image.getInstance(imagepath);
            image.setAlignment(Element.ALIGN_CENTER);
//            image1.scaleAbsoluteHeight(50);
//            image1.scaleAbsoluteWidth(50);
            document.add(new Paragraph(new Date().toString()+"/Excellence/Schools/Result",FontFactory.getFont(FontFactory.COURIER,9)));
            document.add(image);
            
            Font f = new Font(FontFactory.getFont(FontFactory.TIMES_BOLD,16,Font.BOLD,BaseColor.WHITE));
            Chunk ch = new Chunk("                "+txtcategory.getText()+"                ",f);
            ch.setBackground(BaseColor.BLUE);
            Paragraph cat = new Paragraph(ch);
            cat.setAlignment(Element.ALIGN_CENTER);
            document.add(cat);
//            document.add(new Paragraph(txtcategory.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,16,Font.BOLD)));
            document.add(new Paragraph("",font0));
            PdfPTable bio = new PdfPTable(5);
            PdfPCell cell11 = new PdfPCell();
            cell11.addElement(new Phrase("NAME: ",font2));
            cell11.addElement(new Phrase("AGE: ",font2));
            cell11.addElement(new Phrase("Gender: ",font2));
            cell11.addElement(new Phrase("Class: ",font2));
            cell11.setBorder(Rectangle.NO_BORDER);
            PdfPCell cell01 = new PdfPCell();
            cell01.addElement(new Phrase(txtname.getText(),font2));
            cell01.addElement(new Phrase(txtage.getText(),font2));
            cell01.addElement(new Phrase(txtgender.getText(),font2));
            cell01.addElement(new Phrase(txtclass.getText(),font2));
            cell01.setBorder(Rectangle.NO_BORDER);
            PdfPCell cell12 = new PdfPCell();
            cell12.addElement(new Phrase("SESSION: ",font2));
            cell12.addElement(new Phrase("Term: ",font2));
            cell12.addElement(new Phrase("Attendance: ",font2));
            cell12.addElement(new Phrase("Weight:",font2));
//            cell12.getImage(imgpass.getImage());
            cell12.setBorder(Rectangle.NO_BORDER);
            PdfPCell cell02 = new PdfPCell();
            cell02.addElement(new Phrase(combsession.getValue(),font2));
            cell02.addElement(new Phrase(combterm.getValue(),font2));
            cell02.addElement(new Phrase(txtattendance.getText(),font2));
            cell02.addElement(new Phrase(txtweight.getText(),font2));
            cell02.setBorder(Rectangle.NO_BORDER);
            
            PdfPCell cellimg = new PdfPCell();
            cellimg.addElement(new Phrase(imagepath));
            cellimg.setBorder(Rectangle.NO_BORDER);
//            bio.addCell(createImageCell(res));
//            PdfPCell cell13 = new PdfPCell(new Phrase("AGE:        "+txtage.getText(),font2));
//            cell13.setBorder(Rectangle.NO_BORDER);
//            PdfPCell cell14 = new PdfPCell(new Phrase("Term:  "+combterm.getValue(),font2));
//            cell14.setBorder(Rectangle.NO_BORDER);
//            PdfPCell cell15 = new PdfPCell(new Phrase("Gender:     "+txtgender.getText(),font2));
//            cell15.setBorder(Rectangle.NO_BORDER);
//            PdfPCell cell16 = new PdfPCell(new Phrase("Attendance: "+ txtattendance.getText(),font2));
//            cell16.setBorder(Rectangle.NO_BORDER);
//            PdfPCell cell17 = new PdfPCell(new Phrase("Class:     "+txtclass.getText(),font2));
//            cell17.setBorder(Rectangle.NO_BORDER);
//            PdfPCell cell18 = new PdfPCell(new Phrase("Weight:    "+ txtweight.getText(),font2));
//            cell18.setBorder(Rectangle.NO_BORDER);
            bio.addCell(cell11);
            bio.addCell(cell01);
            bio.addCell(cell12);
            bio.addCell(cell02);
            bio.addCell(image1);
//            bio.addCell(cell13);
//            bio.addCell(cell14);
//            bio.addCell(cell15);
//            bio.addCell(cell16);
//            bio.addCell(cell17);
//            bio.addCell(cell18);
//             bio.addCell(new PdfPCell(new Phrase("NAME:  "+txtname.getText(),font2)));
//             
//             bio.addCell(new PdfPCell(new Phrase("SESSION: "+combsession.getValue(),font2)));
//             bio.addCell(new PdfPCell(new Phrase("AGE:        "+txtage.getText(),font2)));
//             bio.addCell(new PdfPCell(new Phrase("Term:  "+combterm.getValue(),font2)));
//             bio.addCell(new PdfPCell(new Phrase("Gender:     "+txtgender.getText(),font2)));
//             bio.addCell(new PdfPCell(new Phrase("Attendance: "+ txtattendance.getText(),font2)));
//             bio.addCell(new PdfPCell(new Phrase("Class:     "+txtclass.getText(),font2)));
//             bio.addCell(new PdfPCell(new Phrase("Weight:    "+ txtweight.getText(),font2)));
             float[] c1 = new float[]{15f,50f,20f,25f,20f};
             bio.getDefaultCell().setBorderWidth(0f);
            bio.setWidths(c1);
            
             document.add(bio);
             
//            document.add(new Paragraph(txtcategory.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,16,Font.BOLD)));
//            document.add(new Paragraph("Name:       "+txtname.getText() + "                                       Session:     "+ combsession.getValue()));
//            document.add(new Paragraph("Age:         "+txtage.getText() + "                                                         Term:        "+ combterm.getValue()));
//            document.add(new Paragraph("Gender:     "+txtgender.getText() + "                                                   Attendance:     "+ txtattendance.getText()));
//            document.add(new Paragraph("Class:       "+txtclass.getText() + "                                                   Weight:     "+ txtweight.getText()));
            
            document.add(new Paragraph("A. ACADEMIC REPORT",FontFactory.getFont(FontFactory.TIMES_BOLD,12,Font.BOLD,BaseColor.BLUE)));
            document.add(new Paragraph(".",font0));
            
            
            PdfPTable Subject = new PdfPTable(6);
            PdfPCell cell = new PdfPCell(new Paragraph("SUBJECT",font2));
//            cell.setBorder(Rectangle.NO_BORDER);
            cell.setBackgroundColor(BaseColor.WHITE);
//            cell.setColspan();
//            cell.setColspan(4);
            Subject.addCell(cell);
            PdfPCell cell1 = new PdfPCell(new Paragraph("1st Test",font2));
//            cell1.setBorder(Rectangle.NO_BORDER);
            cell1.setBackgroundColor(BaseColor.WHITE);
//            cell1.setColspan(4);
            Subject.addCell(cell1);
            PdfPCell cell2 = new PdfPCell(new Paragraph("2nd Test",font2));
//            cell2.setBorder(Rectangle.NO_BORDER);
            cell2.setBackgroundColor(BaseColor.WHITE);
//            cell2.setColspan(4);
            Subject.addCell(cell2);
            PdfPCell cell3 = new PdfPCell(new Paragraph("EXAM",font2));
//            cell3.setBorder(Rectangle.NO_BORDER);
            cell3.setBackgroundColor(BaseColor.WHITE);
//            cell3.setColspan(4);
            Subject.addCell(cell3);
            PdfPCell cell4 = new PdfPCell(new Paragraph("TOTAL",font2));
//            cell4.setBorder(Rectangle.NO_BORDER);
            cell4.setBackgroundColor(BaseColor.WHITE);
//            cell4.setColspan(4);
            Subject.addCell(cell4);
            PdfPCell cell5 = new PdfPCell(new Paragraph("GRADE",font2));
//            cell5.setBorder(Rectangle.NO_BORDER);
            cell5.setBackgroundColor(BaseColor.WHITE);
//            cell5.setColspan(4);
            Subject.addCell(cell5);
             
            float[] columnWidths = new float[]{35f,9f,12f,10f,9f,10f};
            Subject.setWidths(columnWidths);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/excellencedb","root","");
            String sqll = "SELECT * FROM resulttb WHERE studentid='"+txtstudentid.getText()+"'AND section ='"+combsession.getValue()+"'AND term ='"+combterm.getValue()+"'";
            PreparedStatement pre = con.prepareStatement(sqll);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                 subject = rs.getString("subject");
                 test1 = rs.getString("test1");
                 test2 = rs.getString("test2");
                 exam = rs.getString("exam");
                 total = rs.getString("total");
                 grade = rs.getString("grade");
                 
                 
                 PdfPCell cellsub = new PdfPCell(new Phrase(subject,font1));
//                 cellsub.setBorder(Rectangle.NO_BORDER);
                 cellsub.setBackgroundColor(BaseColor.WHITE);
                 PdfPCell cellt1 = new PdfPCell(new Phrase(test1,font1));
//                 cellt1.setBorder(Rectangle.NO_BORDER);
                 cellt1.setBackgroundColor(BaseColor.WHITE);
                 PdfPCell cellt2 = new PdfPCell(new Phrase(test2,font1));
//                 cellt2.setBorder(Rectangle.NO_BORDER);
                 cellt2.setBackgroundColor(BaseColor.WHITE);
                 PdfPCell celle = new PdfPCell(new Phrase(exam,font1));
//                 celle.setBorder(Rectangle.NO_BORDER);
                 celle.setBackgroundColor(BaseColor.WHITE);
                 PdfPCell cellto = new PdfPCell(new Phrase(total,font1));
//                 cellto.setBorder(Rectangle.NO_BORDER);
                 cellto.setBackgroundColor(BaseColor.WHITE);
                 PdfPCell cellg = new PdfPCell(new Phrase(grade,font1));
//                 cellg.setBorder(Rectangle.NO_BORDER);
                 cellg.setBackgroundColor(BaseColor.WHITE);
                 
                 
                 Subject.addCell(cellsub);
                 Subject.addCell(cellt1);
                 Subject.addCell(cellt2);
                 Subject.addCell(celle);
                 Subject.addCell(cellto);
                 Subject.addCell(cellg);
//                 Subject.addCell(test1);
//                 Subject.addCell(test2);
//                 Subject.addCell(exam);
//                 Subject.addCell(total);
//                 Subject.addCell(grade);
                
                totalsubject = Integer.parseInt(total);
                 totals+=totalsubject;
//             Paragraph para =  new Paragraph(rs.getString("subject")+" " +rs.getString("test1")+" " +rs.getString("test2")+" " +rs.getString("exam")+" " + rs.getString("total")+" " +rs.getString("grade"));
//                 document.add(para);
                 count+=1;
                 Gtotal = count*100;
                 average = (double)totals/count;
//                 document.add(new Paragraph(""));
                
                
                
                
            }
            
//            System.out.println("Number of Subject: "+count);
//            System.out.println("Total Score: "+totals);
//            System.out.println("Grand Total: "+Gtotal);
//            System.out.println("Average: " +average);
//            System.out.println("Overall Grade: " +Ograde);
            
             if(average<40){
                 Ograde="FAIL";
             }else if(average>=40 && average<50){
                 Ograde="PASSED";
             }else if(average>=50 && average<70){
                 Ograde = "MERIT";
             }else if (average>=70 && average<90){
                 Ograde = "CREDIT";
             }else{
                 Ograde = "DISTINCTION";
             }
//             System.out.println(count);
             Subject.setHorizontalAlignment(Element.ALIGN_LEFT);
             Subject.setWidthPercentage(90f);
             document.add(Subject);
             
             document.add(new Paragraph(".",fontkey));
//             document.add(imagekey);
             PdfPTable tbkey = new PdfPTable(4);
            PdfPCell summ = new PdfPCell();
            summ.addElement(new Phrase("SUMMARY ",fontkey));
            summ.addElement(new Phrase("GRAND TOTAL: ",fontkey));
            summ.addElement(new Phrase("TOTAL SCORE: ",fontkey));
            summ.addElement(new Phrase("AVERAGE: ",fontkey));
            summ.addElement(new Phrase("OVERALL GRADE: ",fontkey));
            summ.setBorder(Rectangle.NO_BORDER);
            PdfPCell value = new PdfPCell();
            value.addElement(new Phrase(". ",fontkey));
            value.addElement(new Phrase(""+Gtotal,fontkey));
            value.addElement(new Phrase(""+totals,fontkey));
            value.addElement(new Phrase(""+average,fontkey));
            value.addElement(new Phrase(""+Ograde,fontkey));
            value.setBorder(Rectangle.NO_BORDER);
            
            tbkey.addCell(summ);
            tbkey.addCell(value);
            tbkey.addCell(imagekey);
            tbkey.addCell(rating);
            tbkey.setHorizontalAlignment(Element.ALIGN_LEFT);
            tbkey.setWidthPercentage(90f);
            float[] col1 =  new float[]{10f,10f,15f,20f};
            tbkey.setWidths(col1);
            
            document.add(tbkey);
//             document.add(new Paragraph("SUMMARY:                                                                     "+"                                     KEY",FontFactory.getFont(FontFactory.TIMES_BOLD,11,Font.BOLD)));
//             document.add(new Paragraph("GRAND TOTAL:   "+Gtotal+"                                        LETTER GRADE RATING"+"        ",FontFactory.getFont(FontFactory.COURIER,9)));                                                                                 
//             document.add(new Paragraph("TOTAL SCORE:   "+totals+"                              80 and above = A |"+" 70 - 79 = B |"+ " 60 - 69 = C |",FontFactory.getFont(FontFactory.COURIER,9)));
//             document.add(new Paragraph("AVERAGE:        "+average+ "                            50 - 59 = D |"+" 40 - 49 = E, | 0 - 39 = F",FontFactory.getFont(FontFactory.COURIER,9)));                                                           
//             document.add(new Paragraph("OVERALL GRADE:   "+Ograde,FontFactory.getFont(FontFactory.COURIER,9)));
            document.add(new Paragraph("B. BEHAVIOURAL ASSESMENT",FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLUE)));
            document.add(new Paragraph("I. AFFECTIVE DOMAIN",FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLUE)));
           document.add(new Paragraph(".",font0));
             PdfPTable behavior = new PdfPTable(5);
             behavior.addCell(new PdfPCell(new Phrase("Punctuality:  " + combpuntual.getValue(),font1)));
//             behavior.addCell("Punctuality:  " + combpuntual.getValue());
//             behavior.addCell(combpuntual.getValue());
                behavior.addCell(new PdfPCell(new Phrase("Attentiveness:  " + combattentive.getValue(),font1)));
                behavior.addCell(new PdfPCell(new Phrase("Relationship with Staff:  "+combstaff.getValue(),font1)));
                behavior.addCell(new PdfPCell(new Phrase("Neatness:  "+combneat.getValue(),font1)));
                behavior.addCell(new PdfPCell(new Phrase("Politeness:  "+combpolite.getValue(),font1)));
                behavior.addCell(new PdfPCell(new Phrase("Attendance:  "+combattendance.getValue(),font1)));
                behavior.addCell(new PdfPCell(new Phrase("Initiative:  " +combinitiate.getValue(),font1)));
                behavior.addCell(new PdfPCell(new Phrase("Relationship with Pulpils:  "+combpupil.getValue(),font1)));
                behavior.addCell(new PdfPCell(new Phrase("Self Control:  " +combself.getValue(),font1)));
                behavior.addCell(new PdfPCell(new Phrase("Organizational Ability:  " +comborganize.getValue(),font1)));
                
//                behavior.addCell(new PdfPCell(new Phrase("Attentiveness:  " + combattentive.getValue(),font1)));
//                behavior.addCell(new PdfPCell(new Phrase("Attentiveness:  " + combattentive.getValue(),font1)));
//                behavior.addCell(new PdfPCell(new Phrase("Attentiveness:  " + combattentive.getValue(),font1)));
//             behavior.addCell("Attentiveness:  " + combattentive.getValue());
//             behavior.addCell(combattentive.getValue());
//             behavior.addCell("Relationship with Staff:  "+combstaff.getValue());
////             behavior.addCell(combstaff.getValue());
//             behavior.addCell("Neatness:  "+combneat.getValue());
////             behavior.addCell(combneat.getValue());
//             behavior.addCell("Politeness:  "+combpolite.getValue());
////             behavior.addCell(combpolite.getValue());
//             behavior.addCell("Attendance:  "+combattendance.getValue());
////             behavior.addCell(combattendance.getValue());
//             behavior.addCell("Relationship with Pulpils:  "+combpupil.getValue());
////             behavior.addCell(combpupil.getValue());
//             behavior.addCell("Self Control:  " +combself.getValue());
//             behavior.addCell("Initiative:  " +combinitiate.getValue());
//             behavior.addCell("  " );
//             behavior.addCell("Organizational Ability:  " +comborganize.getValue());
//             behavior.addCell("  " );
//             behavior.addCell(combself.getValue());
             float[] column = new float[]{20f,22f,35f,20f,32f};
             behavior.setHorizontalAlignment(Element.ALIGN_LEFT);
                behavior.setWidths(column);
                behavior.setWidthPercentage(90f);
             document.add(behavior);
             
             document.add(new Paragraph("II. PSYCOMOTOR DOMAIN",FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLUE)));
             document.add(new Paragraph(".",font0));
             PdfPTable motor = new PdfPTable(4);
             motor.addCell(new PdfPCell(new Phrase("Art & Craft:  "+combart.getValue(),font1)));
             motor.addCell(new PdfPCell(new Phrase("Aerobics & Sports: " + combsport.getValue(),font1)));
             motor.addCell(new PdfPCell(new Phrase("Club Participation: " + combclub.getValue(),font1)));
             motor.addCell(new PdfPCell(new Phrase("Language Skills: "+comblanguage.getValue(),font1)));
//             motor.addCell(new PdfPCell(new Phrase("Art & Craft:  "+combart.getValue(),font1)));
//             motor.addCell("Art & Craft:  "+combart.getValue());
//             motor.addCell("Aerobics & Sports: " + combsport.getValue());
//             behavior.addCell(combpuntual.getValue());
//             motor.addCell("Club Participation: " + combclub.getValue());
////             behavior.addCell(combattentive.getValue());
//             motor.addCell("Language Skills: "+comblanguage.getValue());
//             behavior.addCell(combstaff.getValue());
             float[] col = new float[]{19f,28f,28f,25f};
                motor.setWidths(col);
                motor.setHorizontalAlignment(Element.ALIGN_LEFT);
                document.add(motor);
//             document.add(new Paragraph("KEY",FontFactory.getFont(FontFactory.TIMES_BOLD,11,Font.BOLD)));
//             document.add(new Paragraph("5. Excellent | 4. High  |  3. Acceptable   |   4. Fair/Minimal   |   1. Poor",FontFactory.getFont(FontFactory.COURIER,9)));
            document.add(new Paragraph(".",font0));
             PdfPTable recommend = new PdfPTable(2);
             recommend.addCell(new PdfPCell(new Phrase("CLASS TEACHER: "+txtteacher.getText(),font1)));
             recommend.addCell(new PdfPCell(new Phrase("PRINCIPAL: "+txtprincipal.getText(),font1)));
             recommend.addCell(new PdfPCell(new Phrase("REMARKS: "+txtremark.getText(),font1)));
             recommend.addCell(new PdfPCell(new Phrase(txtrecommend.getText(),font1)));
             recommend.addCell(new PdfPCell(new Phrase("Signature:___________________",font1)));
             recommend.addCell(new PdfPCell(new Phrase("Signature & Stamp:______________ ",font1)));
//             recommend.addCell("CLASS TEACHER: "+txtteacher.getText());
//             recommend.addCell("PRINCIPAL: "+txtprincipal.getText());
//             recommend.addCell("REMARKS: "+txtremark.getText());
//             recommend.addCell(txtrecommend.getText());
//             recommend.addCell("Signature:___________________");
//             recommend.addCell("Signature & Stamp:______________ ");
             float[] c = new float[]{50f,50f};
                recommend.setWidths(c);
                recommend.setHorizontalAlignment(Element.ALIGN_LEFT);
                recommend.setWidthPercentage(90f);
                document.add(recommend);
             
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Output");
                alert.setContentText("Report of "+txtname.getText()+" has been generated successfully");
                alert.showAndWait();
//             s.close();
                txtstudentid.setText("");
                txtname.setText("");
                txtgender.setText("");
                txtclass.setText("");
                txtweight.setText("");
                txtage.setText("");
                txtcategory.setText("");
                txtattendance.setText("");
                imgpass.setImage(null);
                combsession.setValue("");
                combterm.setValue("");
                txtteacher.setText("");
                txtprincipal.setText("");
                txtrecommend.setText("");
                txtremark.setText("");
                tableResult.setItems(null);
                combpuntual.setItems(null);
                combattentive.setItems(null);
                combstaff.setItems(null);
                combpupil.setItems(null);
                combneat.setItems(null);
                combpolite.setItems(null);
                comborganize.setItems(null);
                combself.setItems(null);
                combinitiate.setItems(null);
                combattendance.setItems(null);
                combart.setItems(null);
                combsport.setItems(null);
                combtools.setItems(null);
                combclub.setItems(null);
                comblanguage.setItems(null);
            document.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewResultController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ViewResultController.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException ex) {
            Logger.getLogger(ViewResultController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewResultController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewResultController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    @FXML
    void AttachPassport(ActionEvent event) {
        FileChooser filechooser = new FileChooser();
        file = filechooser.showOpenDialog(null);
        
        
//            BufferedImage bufferimage;
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
    void ViewResult(ActionEvent event) {
        rec = FXCollections.observableArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/excellencedb","root","");
            String sqll = "SELECT * FROM resulttb WHERE studentid='"+txtstudentid.getText()+"'AND section ='"+combsession.getValue()+"'AND term ='"+combterm.getValue()+"'";
            PreparedStatement pre = con.prepareStatement(sqll);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
              rec.add(new ResultTableModel(rs.getString("subject"), rs.getString("test1"),rs.getString("test2"),rs.getString("exam"), rs.getString("total"),rs.getString("grade")));
                 
                 colsubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
                 coltest1.setCellValueFactory(new PropertyValueFactory<>("test1"));
                 coltest2.setCellValueFactory(new PropertyValueFactory<>("test2"));
                 colexam.setCellValueFactory(new PropertyValueFactory<>("exam"));
                 coltotal.setCellValueFactory(new PropertyValueFactory<>("total"));
                 colgrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
                 
                 tableResult.setItems(rec);  
                
                
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewResultController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewResultController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void search(ActionEvent event) {
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
        } catch (SQLException ex) {
            Logger.getLogger(ViewResultController.class.getName()).log(Level.SEVERE, null, ex);
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
        
         ObservableList<String>key = FXCollections.observableArrayList();
        key.add("1");
        key.add("2");
        key.add("3");
        key.add("4");
        key.add("5");
        
        combpuntual.setItems(key);
        combattentive.setItems(key);
        combstaff.setItems(key);
        combtools.setItems(key);
        combart.setItems(key);
        combpolite.setItems(key);
        combneat.setItems(key);
        combsport.setItems(key);
        comborganize.setItems(key);
        combpupil.setItems(key);
        combself.setItems(key);
        combinitiate.setItems(key);
        comblanguage.setItems(key);
        combclub.setItems(key);
        combattendance.setItems(key);
    }    
    public Stage getStage(){
        return stage;
    }
    public void setStage(Stage stage){
        this.stage=stage;
    }
}
