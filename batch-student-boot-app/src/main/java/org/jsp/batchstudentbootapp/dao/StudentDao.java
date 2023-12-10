package org.jsp.batchstudentbootapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.batchstudentbootapp.dto.Student;
import org.jsp.batchstudentbootapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
	@Autowired
	private StudentRepository sRepository;

	public Student addStudent(Student student) {
		return sRepository.save(student);
	}

	public Student updateStudent(Student student) {
		return sRepository.save(student);
	}

	public Optional<Student> findById(int id) {
		return sRepository.findById(id);
	}

	public List<Student> findByBatchId(int batch_id) {
		return sRepository.findByBatchId(batch_id);
	}

	public List<Student> findByBatchCode(String batch_code) {
		return sRepository.findByBatchCode(batch_code);
	}

	public List<Student> findBySubject(String subject) {
		return sRepository.findBySubject(subject);
	}

	public List<Student> findByTrainer(String trainer) {
		return sRepository.findByTrainer(trainer);
	}

}
