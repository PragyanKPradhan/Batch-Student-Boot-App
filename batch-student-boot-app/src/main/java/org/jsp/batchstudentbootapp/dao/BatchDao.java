package org.jsp.batchstudentbootapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.batchstudentbootapp.dto.Batch;
import org.jsp.batchstudentbootapp.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BatchDao {
	@Autowired
	private BatchRepository bRepository;

	public Batch saveBatch(Batch batch) {
		return bRepository.save(batch);
	}

	public Batch updateBatch(Batch batch) {
		return bRepository.save(batch);
	}
	
	public Optional<Batch> findById(int id){
		return bRepository.findById(id);
	}

	public List<Batch> findByStudentId(int student_id) {
		return bRepository.findByStudentId(student_id);
	}

	public List<Batch> findByStudentPhone(long phone) {
		return bRepository.findByStudentPhone(phone);
	}

}
