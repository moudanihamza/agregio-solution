package com.kata.agregio_solutions.application;

import com.kata.agregio_solutions.domain.MarketType;
import com.kata.agregio_solutions.domain.entities.Farm;
import com.kata.agregio_solutions.domain.entities.Offer;
import com.kata.agregio_solutions.domain.repositories.OfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;

    public void save(Offer offer) {
        offerRepository.save(offer);
    }

    public List<Offer> getOffersByMarketType(MarketType marketType){
       return offerRepository.getOffersByMarketType(marketType);
    }

    public List<Farm> getFarmsByMarketType(MarketType marketType){
        return offerRepository.getFarmsByMarketType(marketType);
    }
}
