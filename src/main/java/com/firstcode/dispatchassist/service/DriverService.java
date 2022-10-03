package com.firstcode.dispatchassist.service;

import com.firstcode.dispatchassist.model.Driver;
import com.firstcode.dispatchassist.model.Paged;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DriverService {

    List<Driver> findAll();

    Driver findById(Long id);

    Page<Driver> findPaginated(Pageable pageable);

    Paged<Driver> findPage(int pageNumber, int size);

    void save(Driver driver);
}
