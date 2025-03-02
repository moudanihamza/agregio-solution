package com.kata.agregio_solutions.domain.repositories;

import com.kata.agregio_solutions.domain.entities.Farm;
import com.kata.agregio_solutions.domain.MarketType;
import com.kata.agregio_solutions.domain.entities.Offer;

import java.util.List;

public interface OfferRepository {

    void save(Offer offer);

    List<Offer> getOffersByMarketType(MarketType marketType);

    List<Farm> getFarmsByMarketType(MarketType marketType);
}
