package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/create")
    public Student crateStudentData(@RequestBody Student student){
        return service.createStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getStudentData(){
        return service.getAllStudent();
    }
    
}
