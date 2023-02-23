package com.example.demo.controllers;

import com.example.demo.beans.AuditReport;
import com.example.demo.services.AuditReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auditReport")
public class AuditReportController {
    @Autowired
    AuditReportService service;

    @GetMapping
    public List<AuditReport> getAuditReport(){
        return service.getAuditReport();
    }

//    @GetMapping(path = "/{rollNo}")
//    public List<AuditReport> getAuditReportByRollNo(@PathVariable int rollNo){
//        return service.getAuditReportByRollNo(rollNo);
//    }

    @GetMapping(path = "/{rollNo}")
    public List<AuditReport> getAuditReportByRollNoSorted(@PathVariable int rollNo, @RequestParam(name="page") int pageNo, @RequestParam(name="limit") int limit){
            return  service.getAuditReportByRollNo(rollNo,pageNo,limit);
    }
}
