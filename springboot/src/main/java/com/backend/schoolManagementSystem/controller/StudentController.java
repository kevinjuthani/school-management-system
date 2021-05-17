package com.backend.schoolManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import com.backend.schoolManagementSystem.model.Student;
import com.backend.schoolManagementSystem.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        try{
          Student addedStudent = this.studentService.createStudent(student);
            return ResponseEntity.of(Optional.of(addedStudent));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> allStudents = this.studentService.getAllStudents();
        if(allStudents.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(allStudents));
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long id){
        Student reqStudent = this.studentService.getStudentById(id);
        if(reqStudent == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(reqStudent));
    
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") long id){
        Student updatedStudent = null;
        try{
            updatedStudent = this.studentService.updateStudent(student, id);
            return ResponseEntity.of(Optional.of(updatedStudent));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") long id){
        Student deletedStudent = null;
        try{
            deletedStudent = this.studentService.deleteStudent(id);
            return ResponseEntity.of(Optional.of(deletedStudent));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/students")
    public ResponseEntity<Student> deleteAllStudents(){
        try{
            this.studentService.deleteAllStudents();
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
