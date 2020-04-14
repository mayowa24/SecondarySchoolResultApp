/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omc.com.staff;

/**
 *
 * @author HP-PC
 */
public class StaffModel {
    String sname, staffid, post, phone1,kinname,kinphone;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getKinname() {
        return kinname;
    }

    public void setKinname(String kinname) {
        this.kinname = kinname;
    }

    public String getKinphone() {
        return kinphone;
    }

    public void setKinphone(String kinphone) {
        this.kinphone = kinphone;
    }

    public StaffModel(String sname, String staffid, String post, String phone1, String kinname, String kinphone) {
        this.sname = sname;
        this.staffid = staffid;
        this.post = post;
        this.phone1 = phone1;
        this.kinname = kinname;
        this.kinphone = kinphone;
    }

    @Override
    public String toString() {
        return "StaffModel{" + "sname=" + sname + ", staffid=" + staffid + ", post=" + post + ", phone1=" + phone1 + ", kinname=" + kinname + ", kinphone=" + kinphone + '}';
    }
    
    
    
    
}
