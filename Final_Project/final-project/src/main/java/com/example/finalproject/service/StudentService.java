package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
    // here we are using Spring IoC Concept and Dependency Injection
    @Autowired
    private StudentRepository repository;

    // Spring IoC (Inversion of Control) Container is the core 
    // of the Spring Framework. It creates and manages objects 
    // (beans), injects dependencies and manages their 
    // life cycles. It uses Dependency Injection (DI),
    //  based on configurations from XML files, 
    //  Java-based configuration, annotations or POJOs. 
    //  Since the container, not the developer, controls 
    //  object creating and wiring, 
    // it's called Inversion of Control (IoC).
   
    // from here we can start creating CRUD Services


    //service for inserting data into table
    public List<Student> getAllStudent(){
    return repository.findAll();
}

public Optional<Student> getStudentById(Long id){
    return repository.findById(id);
}

public Student createStudent(Student student){
    return repository.save(student);
}

// you have to create service for Delete and update operation



public Student updateStudentData(Long id, Student updatedData) {

        Student existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student Not Found with ID: " + id));

        // Update fields
        existingStudent.setName(updatedData.getName());
        existingStudent.setEmail(updatedData.getEmail());
        existingStudent.setSection(updatedData.getSection());
        existingStudent.setCourse(updatedData.getCourse());

        return repository.save(existingStudent); // saves updated student
    }

    public void deleteStudentData(Long id) {

    Student student = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student Not Found with ID: " + id));

    repository.delete(student);
}
    
}
