package com.rest.service;

import java.util.List;

import com.rest.model.Student;

public interface StudentService {

	public void saveData(Student s);
	
	public List<Student> getAllData();
	
	public Student getByRollNo(Integer rollno);
	
}
