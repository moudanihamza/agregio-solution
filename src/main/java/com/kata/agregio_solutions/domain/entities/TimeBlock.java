package com.kata.agregio_solutions.domain.entities;


import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.UUID;

@Builder
@Getter
public class TimeBlock {

    private UUID id;

    private LocalTime start;

    private LocalTime end;

    private Farm farm;

    private Offer offer;

    private BigDecimal floorPrice;
}
