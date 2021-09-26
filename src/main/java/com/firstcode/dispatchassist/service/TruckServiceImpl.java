package com.firstcode.dispatchassist.service;

import com.firstcode.dispatchassist.model.Truck;
import com.firstcode.dispatchassist.repository.TruckRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruckServiceImpl implements TruckService {

    private final TruckRepository repository;

    public TruckServiceImpl(TruckRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Truck> findAll() {
        return repository.findAll();
    }
}
