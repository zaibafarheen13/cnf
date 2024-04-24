package com.zaiba.lab7;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	int usn;
	String name;
	
	public Student() {
		
	}
	
	public Student(int usn, String name) {
		super();
		this.usn = usn;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getUsn() {
		return usn;
	}
	public void setUsn(int usn) {
		this.usn = usn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", usn=" + usn + ", name=" + name + "]";
	}
	
	

}
