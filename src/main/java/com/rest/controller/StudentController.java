package com.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Student;
import com.rest.service.StudentService;

@RestController
public class StudentController {

	StudentService si;
	
	public StudentController(StudentService si) {
		this.si=si;
	}
	
	@PostMapping("/save")
	public Student saveData(@RequestBody Student s) {
		si.saveData(s);
		
		return s;
	}
	
	@GetMapping("/showData")
	public List<Student> getAllData(){
		List<Student> all=si.getAllData();
		
		return all;
	}
	
	@GetMapping("/getSingleData/{rollno}")
	public Student getSingleData(@PathVariable Integer rollno) {
		
		Student st=si.getByRollNo(rollno);
		
		return st;
		
	}
		
	@DeleteMapping("/deleteByRollno/{rollno}")
	public String deleteData(@PathVariable  Integer rollno) {
		
		si.deleteByRollNo(rollno);
		
		return "record deleted.."+rollno;
				
	}
	
	@PutMapping("/update/{rollno}")
	public Student updateData(@PathVariable int rollno, @RequestBody Student s) {
		
		si.update(rollno, s);
		
		return s;
	}
	
	@GetMapping("/logincheck/{username}/{password}")
	public Student loginCheck(@PathVariable String username,@PathVariable String password) {
		
		Student loginCheck = si.loginCheck(username, password);
		
		return loginCheck;
	}
		
}
