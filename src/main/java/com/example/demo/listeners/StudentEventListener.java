package com.example.demo.listeners;

import com.example.demo.events.StudentEvent;
import com.example.demo.repositorys.AuditReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StudentEventListener {
    @Autowired
    AuditReportRepository repo;

    @EventListener
    public void handleStudentEvent(StudentEvent studentEvent){
        repo.save(studentEvent.getAuditReport());

    }

}
