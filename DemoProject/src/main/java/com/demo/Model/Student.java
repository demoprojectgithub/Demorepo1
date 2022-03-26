package com.demo.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="students")
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int studentId;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "student")
	//@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	//@JoinColumn(name = "address_id")
	@JsonManagedReference
	private Address address;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", address=" + address + "]";
	}
	
	
	

}