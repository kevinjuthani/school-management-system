package com.backend.schoolManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.schoolManagementSystem.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	public Student findById(long id);

	@Query("select name from Student where id=?1")
	String findName(String id);
}
