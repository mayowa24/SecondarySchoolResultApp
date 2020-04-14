/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omc.com.student;

/**
 *
 * @author HP-PC
 */
public class RecordModel {
   String sname, studentid, category,sclass;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public RecordModel(String sname, String studentid, String category, String sclass) {
        this.sname = sname;
        this.studentid = studentid;
        this.category = category;
        this.sclass = sclass;
    }

    @Override
    public String toString() {
        return "RecordModel{" + "sname=" + sname + ", studentid=" + studentid + ", category=" + category + ", sclass=" + sclass + '}';
    }
    
    
    
    
}
