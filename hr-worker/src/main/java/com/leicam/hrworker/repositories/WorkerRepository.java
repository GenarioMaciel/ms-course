package com.leicam.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leicam.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
