package com.example.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
@Table(name="audit_report")
@Entity
public class AuditReport {
    @Column(name="roll_no")
    private int rollNo;
    @Column(name="old_data")
    private String oldData;
    @Column(name="current_data")
    private String currentData;
    @Column(name="date_time")
    private Timestamp dateTime;
    @Column(name="operation")
    private String operation;
    @Id
    @Column(name="id")
    private int id;

    //constructor
    public AuditReport(int id, String oldData, String currentData, Timestamp dateTime, int rollNo, String operation) {
        this.id = id;
        this.oldData = oldData;
        this.currentData = currentData;
        this.dateTime = dateTime;
        this.rollNo = rollNo;
        this.operation = operation;
    }

    public AuditReport() {
    }

    //    getter
    public int getId() {
        return id;
    }

    public String getOldData() {
        return oldData;
    }

    public String getCurrentData() {
        return currentData;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getOperation() {
        return operation;
    }

    //setter

    public void setId(int id) {
        this.id = id;
    }

    public void setOldData(String oldData) {
        this.oldData = oldData;
    }

    public void setCurrentData(String currentData) {
        this.currentData = currentData;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
