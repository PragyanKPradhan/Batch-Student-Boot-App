package org.jsp.batchstudentbootapp.repository;

import java.util.List;

import org.jsp.batchstudentbootapp.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query("select s from Student s join s.batches b where b.id = ?1")
	public List<Student> findByBatchId(int batch_id);

	@Query("select s from Student s join s.batches b where b.batchcode = ?1")
	public List<Student> findByBatchCode(String Batch_code);

	@Query("select distinct s from Student s join s.batches b where b.subject = ?1")
	public List<Student> findBySubject(String subject);

	@Query("select distinct s from Student s join s.batches b where b.trainer = ?1")
	public List<Student> findByTrainer(String trainer);
}
