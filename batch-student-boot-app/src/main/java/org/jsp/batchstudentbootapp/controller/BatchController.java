package org.jsp.batchstudentbootapp.controller;

import java.util.List;

import org.jsp.batchstudentbootapp.dto.Batch;
import org.jsp.batchstudentbootapp.service.BatchService;
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
@RequestMapping("/batches")
public class BatchController {
	@Autowired
	private BatchService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<Batch>> saveBatch(@RequestBody Batch batch) {
		return service.saveBatch(batch);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Batch>> updateBatch(@RequestBody Batch batch) {
		return service.updateBatch(batch);
	}

	@GetMapping("/{studentId}")
	public ResponseEntity<ResponseStructure<List<Batch>>> findByStudentId(@PathVariable int studentId) {
		return service.findByStudentId(studentId);
	}

	@GetMapping("/phone/{phone}")
	public ResponseEntity<ResponseStructure<List<Batch>>> findByStudentPhone(@PathVariable long phone) {
		return service.findByStudentPhone(phone);
	}
	
	@PostMapping("/{batchId}/addStudent/{studentId}")
    public ResponseEntity<ResponseStructure<String>> addStudentToBatch(@PathVariable int batchId, @PathVariable int studentId) {
        return service.addStudentToBatch(batchId, studentId);
    }

}
