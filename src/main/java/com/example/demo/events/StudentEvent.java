package com.example.demo.events;

import com.example.demo.beans.AuditReport;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class StudentEvent extends ApplicationEvent {
    private  AuditReport auditReport;

    public StudentEvent(Object source, AuditReport auditReport) {
        super(source);
        this.auditReport = auditReport;
    }

    public AuditReport getAuditReport() {
        return auditReport;
    }

    public void setAuditReport(AuditReport auditReport) {
        this.auditReport = auditReport;
    }
}
