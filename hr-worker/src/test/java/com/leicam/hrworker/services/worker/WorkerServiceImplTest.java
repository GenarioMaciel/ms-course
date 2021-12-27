package com.leicam.hrworker.services.worker;

import com.leicam.hrworker.entities.Worker;
import com.leicam.hrworker.models.WorkerModel;
import com.leicam.hrworker.repositories.WorkerRepository;
import org.hibernate.jdbc.Work;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WorkerServiceImplTest {

    @Mock
    private WorkerRepository repository;

    @InjectMocks
    private WorkerServiceImpl service;

    @Test
    public void test_find_worker_by_id() {

        var expected = createWorkerModel();

        when(repository.findById(1L)).thenReturn(createWorker());

        var actual = service.findById(1L);

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getDailyIncome(), actual.getDailyIncome());
    }

    @Test(expected = RuntimeException.class)
    public void test_find_worker_by_id_not_found_RuntimeException() {

        var expected = createWorkerModel();

        doThrow(new RuntimeException()).when(repository).findById(10L);

        var actual = service.findById(10L);

    }

    @Test
    public void test_find_worker_all() {

        var expected = createListWorkerModel();

        when(repository.findAll()).thenReturn(createListWorker());

        var actual = service.findAll();

        verify(repository, times(1)).findAll();
        assertEquals(1, actual.size());
    }

    private Optional<Worker> createWorker() {
        return Optional.of(new Worker(1L, "Test", 2d));
    }

    private WorkerModel createWorkerModel() {
        return new WorkerModel(1L, "Test", 2d);
    }

    private List<Worker> createListWorker() {
        List<Worker> list = new ArrayList<Worker>();
        list.add(createWorker().get());

        return list;
    }

    private List<WorkerModel> createListWorkerModel() {
        List<WorkerModel> list = new ArrayList<WorkerModel>();
        list.add(createWorkerModel());

        return list;
    }
}
