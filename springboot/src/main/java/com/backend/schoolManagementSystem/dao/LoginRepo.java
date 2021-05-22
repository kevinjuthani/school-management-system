package com.backend.schoolManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.schoolManagementSystem.model.Login;

public interface LoginRepo extends JpaRepository<Login, Long> {
	@Query("select id from Login where email=?1 and password=?2")
	String findPassword(String email,String password);
	
	@Query("select role from Login where id=?1")
	String findRole(long id);
	
	@Query("select id from Login where email=?1")
	String findEmail(String email);
}