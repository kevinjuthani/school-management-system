package com.backend.schoolManagementSystem.service;

import java.util.List;

import com.backend.schoolManagementSystem.dao.StudentRepository;
import com.backend.schoolManagementSystem.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student){
      return this.studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return this.studentRepository.findAll();
    }
    
    public Student getStudentById(long id){
      return this.studentRepository.findById(id);
    }

    public Student updateStudent(Student student, long id){
      student.setId(id);
      return this.studentRepository.save(student);
    }

    public Student deleteStudent(long id){
      Student deletedStudent = this.studentRepository.findById(id);
      this.studentRepository.deleteById(id);
      return deletedStudent;
    }

    public void deleteAllStudents(){
      this.studentRepository.deleteAll();
    }
    
    public String findName(long id) {
    	return this.studentRepository.findName(id);
    }
}
