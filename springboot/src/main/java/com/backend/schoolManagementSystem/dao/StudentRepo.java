package com.backend.schoolManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.schoolManagementSystem.model.StudentModel;

public interface StudentRepo extends JpaRepository<StudentModel, String> {
	@Query("select name from StudentModel where id=?1")
	String findName(String id);
}
