package com.backend.schoolManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "teacher_id")
	Long id;
	String name;
	String email;
	String dob;
	@Column(name = "contact_no")
	String contactNo;
	String address;

	public Teacher(String name, String email, String dob, String contactNo, String address) {
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.contactNo = contactNo;
		this.address = address;
	}

	public Teacher() {
	}

	public String getName() {
		return name;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Teacher [address=" + address + ", contactNo=" + contactNo + ", dob=" + dob + ", email=" + email
				+ ", id=" + id + ", name=" + name + "]";
	}
    
	

}
