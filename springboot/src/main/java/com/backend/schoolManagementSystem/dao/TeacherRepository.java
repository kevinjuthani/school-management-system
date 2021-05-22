package com.backend.schoolManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.schoolManagementSystem.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	public Teacher findById(long id);

	@Query("select name from Teacher where id=?1")
	String findName(long id);

	
}