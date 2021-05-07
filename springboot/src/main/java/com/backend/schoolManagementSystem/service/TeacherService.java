package com.backend.schoolManagementSystem.service;

import java.util.List;

import com.backend.schoolManagementSystem.dao.TeacherRepository;
import com.backend.schoolManagementSystem.model.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher createTeacher(Teacher teacher){
      return this.teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeachers(){
        return this.teacherRepository.findAll();
    }
    
    public Teacher getTeacherById(long id){
      return this.teacherRepository.findById(id);
    }

    public Teacher updateTeacher(Teacher teacher, long id){
      teacher.setId(id);
      return this.teacherRepository.save(teacher);
    }

    public Teacher deleteTeacher(long id){
      Teacher deletedTeacher = this.teacherRepository.findById(id);
      this.teacherRepository.deleteById(id);
      return deletedTeacher;
    }

    public void deleteAllTeachers(){
      this.teacherRepository.deleteAll();
    }
}
