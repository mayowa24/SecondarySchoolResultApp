/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omc.com.result;

/**
 *
 * @author HP-PC
 */
public class ResultTableModel {
    String subject,test1,test2,exam,total,grade;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public ResultTableModel(String subject, String test1, String test2, String exam, String total, String grade) {
        this.subject = subject;
        this.test1 = test1;
        this.test2 = test2;
        this.exam = exam;
        this.total = total;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ResultTableModel{" + "subject=" + subject + ", test1=" + test1 + ", test2=" + test2 + ", exam=" + exam + ", total=" + total + ", grade=" + grade + '}';
    }
    
    
}
