package com.zaiba.lab7;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository sr;
	
	
	public void addStudent(int usn,String name) {
		Student s=new Student(usn,name);
		sr.save(s);	
	}
	
	public void getAllStudents() {
		List<Student> students=sr.findAll();
		
		if(!students.isEmpty()) {
			for(Student s:students) {
				System.out.println(s.getUsn());
				System.out.println(s.getName());
			}
		}
	}
	
	public void updateStudent(Long id,int usn,String name) {
		Student s=sr.findById(id).orElse(null);
		
		if(s!=null) {
			s.setUsn(usn);
			s.setName(name);
			sr.save(s);
		}
	}
	
	
	public void deleteStudent(Long id) {
		sr.deleteById(id);
	}

}
