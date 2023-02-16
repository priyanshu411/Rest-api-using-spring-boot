package com.example.demo.services;

import com.example.demo.ApiExceptionHandler.StudentNotFoundException;
import com.example.demo.beans.Student;
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
    public Student getStudentByRollNo(int rollNo) throws StudentNotFoundException{
        if(! stRepo.findById(rollNo).isPresent()){
            throw new StudentNotFoundException("student not found");
        }else{
            return stRepo.findById(rollNo).get();
        }

    }
}

