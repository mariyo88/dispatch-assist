package com.firstcode.dispatchassist.service;

import com.firstcode.dispatchassist.model.Load;

import java.util.List;

public interface LoadService {

    List<Load> findAll();

    Load findById(Long id);

    void deleteById(Long id);

    Load save(Load load);
}
