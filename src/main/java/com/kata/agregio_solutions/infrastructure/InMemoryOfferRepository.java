package com.kata.agregio_solutions.infrastructure;

import com.kata.agregio_solutions.domain.MarketType;
import com.kata.agregio_solutions.domain.entities.Farm;
import com.kata.agregio_solutions.domain.entities.Offer;
import com.kata.agregio_solutions.domain.entities.TimeBlock;
import com.kata.agregio_solutions.domain.repositories.OfferRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class InMemoryOfferRepository implements OfferRepository {

    private final List<Offer> offers = new ArrayList<>();

    @Override
    public void save(Offer offer) {
        offers.add(offer);
    }

    @Override
    public List<Offer> getOffersByMarketType(MarketType marketType) {
        return offers.stream().filter(offer -> Objects.equals(offer.getMarketType(), marketType)).toList();
    }

    @Override
    public List<Farm> getFarmsByMarketType(MarketType marketType) {
        return offers.stream()
                .filter(offer -> Objects.equals(offer.getMarketType(), marketType))
                .flatMap(offer -> offer.getTimeBlocks().stream())
                .map(TimeBlock::getFarm)
                .toList();
    }
}
