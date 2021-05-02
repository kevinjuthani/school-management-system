package com.backend.schoolManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.schoolManagementSystem.model.LoginModel;

public interface LoginRepo extends JpaRepository<LoginModel, String> {
	@Query("select id from LoginModel where email=?1 and password=?2")
	String findPassword(String email,String password);
	@Query("select role from LoginModel where id=?1")
	String findRole(String id);
}