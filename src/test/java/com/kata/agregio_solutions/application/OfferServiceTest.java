package com.kata.agregio_solutions.application;

import com.kata.agregio_solutions.domain.MarketType;
import com.kata.agregio_solutions.domain.entities.Offer;
import com.kata.agregio_solutions.domain.repositories.OfferRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class OfferServiceTest {

    @InjectMocks
    private OfferService offerService;

    @Spy
    private OfferRepository offerRepository;

    @Test
    void should_call_save_method(){
        //GIVEN
        var offer = Offer.builder().id(UUID.randomUUID()).build();
        Mockito.doNothing().when(offerRepository).save(offer);

        //WHEN
        offerService.save(offer);

        //THEN
        Mockito.verify(offerRepository).save(offer);
    }

    @Test
    void should_call_find_offers_by_market_type(){
        //GIVEN
        Mockito.doReturn(Lists.newArrayList()).when(offerRepository).getOffersByMarketType(any());

        //WHEN
        offerService.getOffersByMarketType(MarketType.SECONDARY);

        //THEN
        Mockito.verify(offerRepository).getOffersByMarketType(MarketType.SECONDARY);
    }


    @Test
    void should_call_find_farms_by_market_type(){
        //GIVEN
        Mockito.doReturn(Lists.newArrayList()).when(offerRepository).getFarmsByMarketType(any());

        //WHEN
        offerService.getFarmsByMarketType(MarketType.SECONDARY);

        //THEN
        Mockito.verify(offerRepository).getFarmsByMarketType(MarketType.SECONDARY);
    }

}