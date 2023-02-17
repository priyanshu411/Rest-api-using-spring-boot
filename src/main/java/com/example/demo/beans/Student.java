package com.example.demo.beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="student")
@Entity
public class Student {
    @Id
    @Column(name="rollNo")
    private int rollNo;
    @Column(name="name")
    private String studentName;
    @Column(name="course")
    private String course;

    public Student(){

    }
    public Student(int rollNo, String studentName, String course) {
        this.rollNo = rollNo;
        this.studentName = studentName;
        this.course = course;
    }

    public int getRollNo() {
        return rollNo;
    }
    public String getStudentName() {
        return studentName;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

}
