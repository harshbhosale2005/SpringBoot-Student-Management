package com.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.model.Student;
import com.rest.repository.StudentRepository;

@Service
public class StudentServiceimpl implements StudentService{
	
	StudentRepository sr;
	
	public StudentServiceimpl(StudentRepository sr) {
		
		this.sr=sr;
	}

	@Override
	public void saveData(Student s) {

		sr.save(s);		
	}

	@Override
	public List<Student> getAllData() {

		List<Student> all = (List<Student>)  sr.findAll();
		
		return all;
	}

	@Override
	public Student getByRollNo(Integer rollno) {

		Student student = sr.findById(rollno).get();
		
		return student;
	}

	@Override
	public void deleteByRollNo(Integer rollno) {

		sr.deleteById(rollno);
		
	}

	@Override
	public void update(int rollno, Student s) {

		Student st = sr.findById(rollno).get();
		
		st.setName(s.getName());
		st.setEmail(s.getEmail());
		st.setContact(s.getContact());
		st.setAddress(s.getAddress());
		st.setUsername(s.getUsername());
		st.setPassword(s.getPassword());
		
		sr.save(st);
		
	}

}
