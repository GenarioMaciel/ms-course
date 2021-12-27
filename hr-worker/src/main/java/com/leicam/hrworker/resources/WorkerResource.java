package com.leicam.hrworker.resources;

import com.leicam.hrworker.entities.Worker;
import com.leicam.hrworker.models.WorkerModel;
import com.leicam.hrworker.services.worker.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	@Autowired
	private WorkerService service;
	
	@GetMapping
	public ResponseEntity<List<WorkerModel>> findAll() {
		var list = service.findAll();
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<WorkerModel> findById(@PathVariable Long id) {
		var worker = service.findById(id);
		
		return ResponseEntity.ok(worker);
	}
}
