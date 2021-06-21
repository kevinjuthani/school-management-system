package com.backend.schoolManagementSystem.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.backend.schoolManagementSystem.model.Login;
import com.backend.schoolManagementSystem.model.Student;
import com.backend.schoolManagementSystem.service.LoginService;
import com.backend.schoolManagementSystem.service.StudentService;
import com.backend.schoolManagementSystem.util.MailSender;

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
    @Autowired
    private LoginService loginService;
    @PostMapping("/students")//@RequestBody 
    public ResponseEntity<Student> createStudent(Student student){
    	System.out.println("Creating account of: "+student.getName());
        try{
          Student addedStudent = this.studentService.createStudent(student);
          Login user=new Login();
          user.setId(addedStudent.getId());
          user.setOtl("1");
          Random rnd = new Random();
		  int number = rnd.nextInt(999999);
		  String pass=String.format("%06d", number);
	      user.setPassword(pass);
          user.setEmail(addedStudent.getEmail());
          user.setRole("1");
          this.loginService.createStudentCred(user);
          MailSender.send(addedStudent.getEmail(),"Account Creation","Dear "+addedStudent.getName()+",<br>Provided below is the password "
					+ "for your newly created account.<br>Kindly login with your emailID and the password given below: <h1>"
					+ pass
					+"</h1><br>You would be prompted to set a new password after this.<br>Thank you.");
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
