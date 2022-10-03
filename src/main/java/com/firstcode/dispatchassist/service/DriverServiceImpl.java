package com.firstcode.dispatchassist.service;

import com.firstcode.dispatchassist.model.Driver;
import com.firstcode.dispatchassist.model.Paged;
import com.firstcode.dispatchassist.model.Paging;
import com.firstcode.dispatchassist.repository.DriverRepository;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository repository;

    public DriverServiceImpl(DriverRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Driver> findAll() {
        return repository.findAll();
    }

    @Override
    public Driver findById(Long id) {
        Optional<Driver> optionalDriver = repository.findById(id);

        if (optionalDriver.isEmpty()) {
            throw new RuntimeException();
        }

        return optionalDriver.get();
    }

    @Override
    public Page<Driver> findPaginated(Pageable pageable) {
        List<Driver> drivers = repository.findAll();

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();

        int startItem = currentPage * pageSize;
        List<Driver> list;

        if (drivers.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, drivers.size());
            list = drivers.subList(startItem, toIndex);
        }

        return new PageImpl<>(list, PageRequest.of(currentPage, pageSize), drivers.size());
    }

    @Override
    public Paged<Driver> findPage(int pageNumber, int size) {
        PageRequest request = PageRequest.of(pageNumber - 1, size, Sort.by(Sort.Direction.DESC, "modified"));
        Page<Driver> postPage = repository.findAll(request);
        return new Paged<>(postPage, Paging.of(postPage.getTotalPages(), pageNumber, size));
    }

    @Override
    public void save(Driver driver) {
        repository.save(driver);
    }
}
