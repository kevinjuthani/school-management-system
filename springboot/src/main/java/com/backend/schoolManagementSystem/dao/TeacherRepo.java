package com.backend.schoolManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.schoolManagementSystem.model.TeacherModel;

public interface TeacherRepo extends JpaRepository<TeacherModel, String> {
	@Query("select name from TeacherModel where id=?1")
	String findName(String id);
}