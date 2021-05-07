package com.backend.schoolManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	Long id;
	String name;
	String email;
	String dob;
	@Column(name = "contact_no")
	String contactNo;
	String address;
	@Column(name = "guardian_name")
	String guardianName;
	@Column(name = "roll_no")
	String rollNo;
	@Column(name = "class")
	String classNo;
	String stream;
	
	public Student() {
	}

	public Student(String name, String email, String dob, String contactNo, String address, String guardianName,
			String rollNo, String classNo, String stream) {
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.contactNo = contactNo;
		this.address = address;
		this.guardianName = guardianName;
		this.rollNo = rollNo;
		this.classNo = classNo;
		this.stream = stream;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
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

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	@Override
	public String toString() {
		return "Student [address=" + address + ", classNo=" + classNo + ", contactNo=" + contactNo + ", dob=" + dob
				+ ", email=" + email + ", guardianName=" + guardianName + ", id=" + id + ", name=" + name + ", rollNo="
				+ rollNo + ", stream=" + stream + "]";
	}

}
