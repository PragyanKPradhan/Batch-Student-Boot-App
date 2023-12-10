package org.jsp.batchstudentbootapp.repository;

import java.util.List;

import org.jsp.batchstudentbootapp.dto.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BatchRepository extends JpaRepository<Batch, Integer> {
	@Query("select distinct b from Batch b join b.students s where s.id = ?1")
	public List<Batch> findByStudentId(int student_id);

	// distinct is optional ( If a student can be associated with multiple batches
	// (or vice versa), using DISTINCT helps ensure that you receive unique entities
	// in the result set.}

	@Query("select distinct b from Batch b join b.students s where s.phone = ?1")
	public List<Batch> findByStudentPhone(long phone);

}
