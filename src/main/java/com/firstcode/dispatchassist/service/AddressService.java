package com.firstcode.dispatchassist.service;

import com.firstcode.dispatchassist.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAll();

    void save(Address address);
}
