package com.backend.schoolManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.schoolManagementSystem.model.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, String> {
	@Query("select name from Teacher where id=?1")
	String findName(String id);
}