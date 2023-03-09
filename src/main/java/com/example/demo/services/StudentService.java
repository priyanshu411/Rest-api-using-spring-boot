package com.example.demo.services;

import com.example.demo.ApiExceptionHandler.ResourceAlreadyPresentException;
import com.example.demo.ApiExceptionHandler.ResourceNotFoundException;
import com.example.demo.beans.AuditReport;
import com.example.demo.beans.Student;
import com.example.demo.controllers.AddResponse;
import com.example.demo.events.StudentEvent;
import com.example.demo.repositorys.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Component
@Service
public class StudentService {

    @Autowired
    private ApplicationEventPublisher publisher;
    @Autowired
    StudentRepository stRepo;

    //    get all student details
    public List<Student> getAllStudents(){
        return stRepo.findAll();
    }

    //    get specific student details
    public Student getStudentByRollNo(int rollNo) throws ResourceNotFoundException {
        if(! stRepo.findById(rollNo).isPresent()){
            throw new ResourceNotFoundException(rollNo,"Resource not found of Roll No :");
        }else{
            return stRepo.findById(rollNo).get();
        }

    }

//    add new student
    public Student addStudent(Student st) throws ResourceAlreadyPresentException {
       if(!stRepo.findById(st.getRollNo()).isPresent()){
           stRepo.save(st);

           //event
           AuditReport auditReport=new AuditReport();
           auditReport.setOldData("");
           auditReport.setCurrentData("name :"+st.getStudentName()+" ,course :"+st.getCourse());
           auditReport.setRollNo(st.getRollNo());
           auditReport.setOperation("insert");
           auditReport.setDateTime(new Timestamp(System.currentTimeMillis()));

           StudentEvent studentEvent=new StudentEvent(this,auditReport);
           publisher.publishEvent(studentEvent);

           return st;
       }else{
           throw new ResourceAlreadyPresentException(st.getRollNo(),"Resource already present of Roll no :");
       }
    }

//    update specific student
    public Student updateStudent(Student st,int rollNo) throws ResourceNotFoundException {
        Student exSt=stRepo.findById(rollNo).get(); //get old data
        //event
        AuditReport auditReport=new AuditReport();
        auditReport.setOldData("name :"+exSt.getStudentName()+" ,course :"+exSt.getCourse());
        auditReport.setCurrentData("name :"+st.getStudentName()+" ,course :"+st.getCourse());
        auditReport.setRollNo(exSt.getRollNo());
        auditReport.setOperation("update");
        auditReport.setDateTime(new Timestamp(System.currentTimeMillis()));

        exSt.setStudentName(st.getStudentName());
        exSt.setCourse(st.getCourse());
        Student temp=stRepo.save(exSt);
        StudentEvent studentEvent=new StudentEvent(this,auditReport);
        publisher.publishEvent(studentEvent);
        return temp;
    }

    //delete specific student
    public AddResponse deleteStudent(int rollNo) throws ResourceNotFoundException {
        if(stRepo.findById(rollNo).isPresent()){
            Student exSt=stRepo.findById(rollNo).get(); //get old data
            //event
            AuditReport auditReport=new AuditReport();
            auditReport.setOldData("name :"+exSt.getStudentName()+" ,course :"+exSt.getCourse());
            auditReport.setCurrentData("");
            auditReport.setRollNo(exSt.getRollNo());
            auditReport.setOperation("delete");
            auditReport.setDateTime(new Timestamp(System.currentTimeMillis()));

            stRepo.deleteById(rollNo);
            StudentEvent studentEvent=new StudentEvent(this,auditReport);
            publisher.publishEvent(studentEvent);
            return new AddResponse(rollNo,"Resource deleted successfully");
        }else{
            throw new ResourceNotFoundException(rollNo,"Resource not found of Roll No :");
        }
    }

}

