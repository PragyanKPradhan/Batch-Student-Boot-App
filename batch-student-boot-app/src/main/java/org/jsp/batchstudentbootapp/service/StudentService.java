package org.jsp.batchstudentbootapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.batchstudentbootapp.dao.StudentDao;
import org.jsp.batchstudentbootapp.dto.Student;
import org.jsp.merchantbootapp.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;

	public ResponseEntity<ResponseStructure<Student>> addStudent(Student student) {
		ResponseStructure<Student> structure = new ResponseStructure<>();
		student = studentDao.addStudent(student);
		structure.setData(student);
		structure.setMessage("Student added successfully with ID: " + student.getId());
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Student>> updateStudent(Student student) {
		ResponseStructure<Student> structure = new ResponseStructure<>();
		student = studentDao.updateStudent(student);
		structure.setData(student);
		structure.setMessage("Student updated successfully");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> findByBatchId(int batchId) {
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		List<Student> students = studentDao.findByBatchId(batchId);

		if (!students.isEmpty()) {
			structure.setData(students);
			structure.setMessage("Students found for batch ID: " + batchId);
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.OK);
		} else {
			structure.setData(null);
			structure.setMessage("No students found for batch ID: " + batchId);
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Student>> findById(int studentId) {
		ResponseStructure<Student> structure = new ResponseStructure<>();
		Optional<Student> student = studentDao.findById(studentId);

		if (student.isPresent()) {
			structure.setData(student.get());
			structure.setMessage("Student found with ID: " + studentId);
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		} else {
			structure.setData(null);
			structure.setMessage("No student found with ID: " + studentId);
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<List<Student>>> findByBatchCode(String batchCode) {
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		List<Student> students = studentDao.findByBatchCode(batchCode);

		if (!students.isEmpty()) {
			structure.setData(students);
			structure.setMessage("Students found for batch code: " + batchCode);
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.OK);
		} else {
			structure.setData(null);
			structure.setMessage("No students found for batch code: " + batchCode);
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<List<Student>>> findBySubject(String subject) {
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		List<Student> students = studentDao.findBySubject(subject);

		if (!students.isEmpty()) {
			structure.setData(students);
			structure.setMessage("Students found for subject: " + subject);
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.OK);
		} else {
			structure.setData(null);
			structure.setMessage("No students found for subject: " + subject);
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<List<Student>>> findByTrainer(String trainer) {
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		List<Student> students = studentDao.findByTrainer(trainer);

		if (!students.isEmpty()) {
			structure.setData(students);
			structure.setMessage("Students found for trainer: " + trainer);
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.OK);
		} else {
			structure.setData(null);
			structure.setMessage("No students found for trainer: " + trainer);
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.NOT_FOUND);
		}
	}

}
