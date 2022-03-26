package com.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Model.Student;
import com.demo.Service.StudentService;



@RestController
@RequestMapping("/Student")
public class StudentRestController {

	@Autowired
	StudentService service;

	@PostMapping("/addStudent")

	public ResponseEntity<Student> addStudent(@Validated @RequestBody Student student) {
		Student s = service.addStudent(student);

		return new ResponseEntity<Student>(s, HttpStatus.OK);
	}

	@GetMapping("/fetchByStudentId/{studentId}")

	public ResponseEntity<Optional<Student>> fetchByStudentId(@PathVariable int studentId) {
		System.out.println(studentId);
		Optional<Student> obj = service.findByStudentId(studentId);
		System.out.println(obj);
		return new ResponseEntity<Optional<Student>>(obj, HttpStatus.OK);
	}
	
	
	

	@PutMapping("/updateStudentId")
	public ResponseEntity<String> updateByStudentId(@RequestBody Student s) {
		String status = null;
		System.out.println(s.getStudentId());
		Optional<Student> obj = service.findByStudentId(s.getStudentId());

		if (obj.isPresent()) {
			service.updateByStudentId(s);
			status = "Successfully updated";
		}

		else {
			status = "Id not available";
		}
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

}