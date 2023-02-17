package com.example.demo.controllers;

import com.example.demo.ApiExceptionHandler.ResourceAlreadyPresentException;
import com.example.demo.ApiExceptionHandler.ResourceNotFoundException;
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
    public ResponseEntity<Student> getStudent(@PathVariable int rollNo){
        try{
            return new ResponseEntity(service.getStudentByRollNo(rollNo), HttpStatus.OK);
        }catch(ResourceNotFoundException e){

            return new ResponseEntity(e.getMessage()+""+e.getId(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student st){
        try{
            return new ResponseEntity(service.addStudent(st), HttpStatus.CREATED);
        }catch (ResourceAlreadyPresentException e){
            return new ResponseEntity(e.getMessage()+""+e.getId(), HttpStatus.CONFLICT);
        }

    }

    @PutMapping("/updateStudent/{rollNo}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student st,@PathVariable int rollNo){
       try {
           return new ResponseEntity(service.updateStudent(st,rollNo), HttpStatus.OK);
       }catch(Exception e){
           return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }

    }
    @DeleteMapping("deleteStudent/{rollNo}")
   public ResponseEntity<AddResponse> deleteStudent(@PathVariable int rollNo){
        try{
            return new ResponseEntity(service.deleteStudent(rollNo),HttpStatus.OK);

        }catch(ResourceNotFoundException e){
            return new ResponseEntity(e.getMessage()+""+e.getId(),HttpStatus.NOT_FOUND);
        }
    }
}
