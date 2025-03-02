package com.kata.agregio_solutions.infrastructure;

import com.kata.agregio_solutions.domain.entities.Farm;
import com.kata.agregio_solutions.domain.repositories.FarmRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryFarmRepository implements FarmRepository {

    private final List<Farm> farms = new ArrayList<>();

    @Override
    public void save(Farm farm) {
        farms.add(farm);
    }
}
