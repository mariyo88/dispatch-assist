package com.firstcode.dispatchassist.service;

import com.firstcode.dispatchassist.model.Address;
import com.firstcode.dispatchassist.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository repository;

    public AddressServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Address> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Address address) {
        repository.save(address);
    }
}
