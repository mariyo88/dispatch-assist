package com.firstcode.dispatchassist.service;

import com.firstcode.dispatchassist.model.Load;
import com.firstcode.dispatchassist.repository.LoadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadServiceImpl implements LoadService {

    private final LoadRepository repository;

    public LoadServiceImpl(LoadRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Load> findAll() {
        return repository.findAll();
    }

    @Override
    public Load findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Load save(Load load) {
        return repository.save(load);
    }
}
