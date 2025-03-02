package com.kata.agregio_solutions.domain.entities;

import com.kata.agregio_solutions.domain.MarketType;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
public class Offer {

    private UUID id;

    private MarketType marketType;

    @Singular(ignoreNullCollections = true)
    private List<TimeBlock> timeBlocks;
}
