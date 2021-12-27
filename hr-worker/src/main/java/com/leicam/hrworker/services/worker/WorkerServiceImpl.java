package com.leicam.hrworker.services.worker;

import com.leicam.hrworker.entities.Worker;
import com.leicam.hrworker.models.WorkerModel;
import com.leicam.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService{

    @Autowired
    private WorkerRepository repository;

    @Override
    public List<WorkerModel> findAll() {
        List<WorkerModel> list = new ArrayList<WorkerModel>();
        repository.findAll().forEach(item -> list.add(new WorkerModel(item.getId(), item.getName(), item.getDailyIncome())));

        return list;
    }

    @Override
    public WorkerModel findById(Long id) {
        Worker worker;

        try {
            var object = repository.findById(id);
            if (object.isPresent())
                worker = object.get();
            else
                throw new RuntimeException("Worker not found");
        } catch (RuntimeException re){
            throw new RuntimeException(re.getMessage());
        }

        return new WorkerModel(worker.getId(), worker.getName(), worker.getDailyIncome());
    }
}
