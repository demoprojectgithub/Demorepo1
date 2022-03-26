package com.demo.Service;

	import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Model.Student;
import com.demo.Repository.StudentRepo;
	@Service
	@Transactional
	public class StudentService {
	    @Autowired
	    StudentRepo repo;
	    public Student addStudent(Student s) {
	        return repo.save(s);
	    }
	    public Optional<Student> findByStudentId(int studentId) {
	        return repo.findByStudentId(studentId);
	    }
	  


}
