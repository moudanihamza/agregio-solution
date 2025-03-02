package com.kata.agregio_solutions.application;

import com.kata.agregio_solutions.domain.entities.Farm;
import com.kata.agregio_solutions.domain.repositories.FarmRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class FarmServiceTest {

    @InjectMocks
    private FarmService farmService;

    @Spy
    private FarmRepository farmRepository;

    @Test
    void should_call_save_method(){
        //GIVEN
        var farm = Farm.builder().id(UUID.randomUUID()).build();
        Mockito.doNothing().when(farmRepository).save(farm);

        //WHEN
        farmService.save(farm);

        //THEN
        Mockito.verify(farmRepository).save(farm);
    }

}