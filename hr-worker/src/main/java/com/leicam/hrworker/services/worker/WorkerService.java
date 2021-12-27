package com.leicam.hrworker.services.worker;

import com.leicam.hrworker.models.WorkerModel;

import java.util.List;

public interface WorkerService {
    List<WorkerModel> findAll();

    WorkerModel findById(Long id);
}
