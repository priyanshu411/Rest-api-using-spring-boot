package com.example.demo.controllers;

import com.example.demo.ApiExceptionHandler.StudentNotFoundException;
import com.example.demo.beans.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping
    public List getStudents(){
        return service.getAllStudents();
    }


    @GetMapping(path="/{rollNo}")
    public ResponseEntity getStudent(@PathVariable int rollNo){
        try{
            return new ResponseEntity(service.getStudentByRollNo(rollNo), HttpStatus.OK);
        }catch(StudentNotFoundException e){

            return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
    }


}
