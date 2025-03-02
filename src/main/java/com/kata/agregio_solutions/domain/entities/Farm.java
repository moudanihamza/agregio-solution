package com.kata.agregio_solutions.domain.entities;

import com.kata.agregio_solutions.domain.EnergyType;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
public class Farm {

    private UUID id;

    private EnergyType energyType;

    private BigDecimal energyMW;

    @Singular(ignoreNullCollections = true)
    private List<TimeBlock> timeBlocks;
}
