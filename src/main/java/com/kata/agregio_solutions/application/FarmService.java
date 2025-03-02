package com.kata.agregio_solutions.application;

import com.kata.agregio_solutions.domain.entities.Farm;
import com.kata.agregio_solutions.domain.repositories.FarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FarmService {

    private final FarmRepository farmRepository;

    public void save(Farm farm) {
        farmRepository.save(farm);
    }

}
