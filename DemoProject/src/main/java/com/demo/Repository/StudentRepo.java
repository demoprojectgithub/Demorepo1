package com.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.Model.Student;



@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	
	Optional<Student> findByStudentId(int studentId);
	
	//finding student by id
	Optional<Student> findByStudentName(int studentName);
}
