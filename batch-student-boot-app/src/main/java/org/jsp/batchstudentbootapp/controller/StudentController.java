package org.jsp.batchstudentbootapp.controller;

import java.util.List;

import org.jsp.batchstudentbootapp.dto.Student;
import org.jsp.batchstudentbootapp.service.StudentService;
import org.jsp.merchantbootapp.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<Student>> addStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);
	}

	@GetMapping("/{student_id}")
	public ResponseEntity<ResponseStructure<Student>> findById(@PathVariable int student_id) {
		return service.findById(student_id);
	}

	@GetMapping("/batch/{batch_id}")
	public ResponseEntity<ResponseStructure<List<Student>>> findByBatchId(@PathVariable int batch_id) {
		return service.findByBatchId(batch_id);
	}

	@GetMapping("/batchCode/{batchCode}")
	public ResponseEntity<ResponseStructure<List<Student>>> findByBatchCode(@PathVariable String batchCode) {
		return service.findByBatchCode(batchCode);
	}

	@GetMapping("/subject/{subject}")
	public ResponseEntity<ResponseStructure<List<Student>>> findBySubject(@PathVariable String subject) {
		return service.findBySubject(subject);
	}

	@GetMapping("/trainer/{trainer}")
	public ResponseEntity<ResponseStructure<List<Student>>> findByTrainer(@PathVariable String trainer) {
		return service.findByTrainer(trainer);
	}

}
