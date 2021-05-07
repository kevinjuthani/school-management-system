package com.backend.schoolManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import com.backend.schoolManagementSystem.model.Teacher;
import com.backend.schoolManagementSystem.service.TeacherService;

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
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/teachers")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher){
        try{
            Teacher addedTeacher = this.teacherService.createTeacher(teacher);
            return ResponseEntity.of(Optional.of(addedTeacher));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/teachers")
    public ResponseEntity<List<Teacher>> getAllTeachers(){
        List<Teacher> allTeachers = this.teacherService.getAllTeachers();
        if(allTeachers.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(allTeachers));
    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") long id){
        Teacher reqTeacher = this.teacherService.getTeacherById(id);
        if(reqTeacher == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(reqTeacher));
    
    }

    @PutMapping("/teachers/{id}")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher,@PathVariable("id") long id){
        Teacher updatedTeacher = null;
        try{
            updatedTeacher = this.teacherService.updateTeacher(teacher, id);
            return ResponseEntity.of(Optional.of(updatedTeacher));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/teachers/{id}")
    public ResponseEntity<Teacher> deleteTeacher(@PathVariable("id") long id){
        Teacher deletedTeacher = null;
        try{
            deletedTeacher = this.teacherService.deleteTeacher(id);
            return ResponseEntity.of(Optional.of(deletedTeacher));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/teachers")
    public ResponseEntity<Teacher> deleteAllTeachers(){
        try{
            this.teacherService.deleteAllTeachers();
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
