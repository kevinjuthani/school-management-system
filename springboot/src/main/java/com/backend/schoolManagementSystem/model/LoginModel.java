package com.backend.schoolManagementSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginModel {
	@Id
	String id;
	String email;
	String password;
	String role;
	String otl;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getOtl() {
		return otl;
	}
	public void setOtl(String otl) {
		this.otl = otl;
	}
	
}
