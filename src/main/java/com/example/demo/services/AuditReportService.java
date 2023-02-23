package com.example.demo.services;
import com.example.demo.beans.AuditReport;
import com.example.demo.repositorys.AuditReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Component
@Service
public class AuditReportService {
    @Autowired
    AuditReportRepository repo;

    public List<AuditReport> getAuditReport(){
        return repo.findAll();
    }

    public List<AuditReport> getAuditReportByRollNo(int rollNo,int pageNo,int limit){
        Pageable pageable=PageRequest.of(pageNo,limit,Sort.by("dateTime").ascending());
        Page<AuditReport> page=repo.findByRollNo(rollNo,pageable);
        return page.getContent();
    }

}
