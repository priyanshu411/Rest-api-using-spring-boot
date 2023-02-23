package com.example.demo.repositorys;

import com.example.demo.beans.AuditReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AuditReportRepository extends JpaRepository<AuditReport,Integer> {

    Page<AuditReport> findByRollNo(int rollNo, Pageable pg);
}
