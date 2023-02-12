package com.example.demo.controllers;

import com.example.demo.beans.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Student getStudent(@PathVariable int rollNo){
       return service.getStudentByRollNo(rollNo);
    }


}
