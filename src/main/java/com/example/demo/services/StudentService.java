package com.example.demo.services;

import com.example.demo.ApiExceptionHandler.ResourceAlreadyPresentException;
import com.example.demo.ApiExceptionHandler.ResourceNotFoundException;
import com.example.demo.beans.Student;
import com.example.demo.controllers.AddResponse;
import com.example.demo.repositorys.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

@Component
@Service
public class StudentService {
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
           return st;
       }else{
           throw new ResourceAlreadyPresentException(st.getRollNo(),"Resource already present of Roll no :");
       }
    }

//    update specific student
    public Student updateStudent(Student st,int rollNo) throws ResourceNotFoundException {

            Student exSt=stRepo.findById(rollNo).get(); //get old data
            exSt.setStudentName(st.getStudentName());
            exSt.setCourse(st.getCourse());
            return stRepo.save(exSt);
    }

    //delete specific student
    public AddResponse deleteStudent(int rollNo) throws ResourceNotFoundException {
        if(stRepo.findById(rollNo).isPresent()){
            stRepo.deleteById(rollNo);
            return new AddResponse(rollNo,"Resource deleted successfully");
        }else{
            throw new ResourceNotFoundException(rollNo,"Resource not found of Roll No :");
        }
    }

}

