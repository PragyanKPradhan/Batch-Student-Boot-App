package org.jsp.batchstudentbootapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.batchstudentbootapp.dao.BatchDao;
import org.jsp.batchstudentbootapp.dao.StudentDao;
import org.jsp.batchstudentbootapp.dto.Batch;
import org.jsp.batchstudentbootapp.dto.Student;
import org.jsp.merchantbootapp.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BatchService {
	@Autowired
	private BatchDao batchDao;
	@Autowired
	private StudentDao studentDao;

	public ResponseEntity<ResponseStructure<Batch>> saveBatch(Batch batch) {
		ResponseStructure<Batch> structure = new ResponseStructure<>();
		batch = batchDao.saveBatch(batch);
		structure.setData(batch);
		structure.setMessage("Batch saved successfully " + batch.getId());
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Batch>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Batch>> updateBatch(Batch batch) {
		ResponseStructure<Batch> structure = new ResponseStructure<>();
		batch = batchDao.updateBatch(batch);
		structure.setData(batch);
		structure.setMessage("Batch updated successfully ");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Batch>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<List<Batch>>> findByStudentId(int student_id) {
		ResponseStructure<List<Batch>> structure = new ResponseStructure<>();
		Optional<Student> recStudent = studentDao.findById(student_id);
		if (recStudent.isPresent()) {
			structure.setData(batchDao.findByStudentId(student_id));
			structure.setMessage("Batch found!");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Batch>>>(structure, HttpStatus.ACCEPTED);
		}
		structure.setData(null);
		structure.setMessage("Invalid Student Id");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Batch>>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<List<Batch>>> findByStudentPhone(long phone) {
		ResponseStructure<List<Batch>> structure = new ResponseStructure<>();
		List<Batch> batches = batchDao.findByStudentPhone(phone);

		if (!batches.isEmpty()) {
			structure.setData(batches);
			structure.setMessage("Batches found for student phone: " + phone);
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Batch>>>(structure, HttpStatus.OK);
		} else {
			structure.setData(null);
			structure.setMessage("No batches found for student phone: " + phone);
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Batch>>>(structure, HttpStatus.NOT_FOUND);
		}
	}

    public ResponseEntity<ResponseStructure<String>> addStudentToBatch(int batchId, int studentId) {
        ResponseStructure<String> structure = new ResponseStructure<>();

        // Step 1: Fetch Batch and Student entities
        Optional<Batch> recBatch = batchDao.findById(batchId);
        Optional<Student> recStudent = studentDao.findById(studentId);

        // Step 2: Check if both Batch and Student entities exist
        if (recBatch.isPresent() && recStudent.isPresent()) {
            Batch batch = recBatch.get();
            Student student = recStudent.get();

            // Step 3: Update the Batch entity's list of students
            batch.getStudents().add(student);

            // Step 4: Update the Student entity's list of batches
            student.getBatches().add(batch);

            // Step 5: Save changes to both entities using the update/ save method
            batchDao.updateBatch(batch);
            studentDao.updateStudent(student);

            structure.setData("Student added to Batch successfully: Batch ID " + batchId + ", Student ID " + studentId);
            structure.setMessage("Student added to Batch successfully");
            structure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
        } else {
            structure.setData(null);
            structure.setMessage("Batch or Student not found");
            structure.setStatusCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
        }
    }

}
