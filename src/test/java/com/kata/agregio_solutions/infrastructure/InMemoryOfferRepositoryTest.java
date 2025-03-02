package com.kata.agregio_solutions.infrastructure;

import com.kata.agregio_solutions.domain.EnergyType;
import com.kata.agregio_solutions.domain.MarketType;
import com.kata.agregio_solutions.domain.entities.Farm;
import com.kata.agregio_solutions.domain.entities.Offer;
import com.kata.agregio_solutions.domain.entities.TimeBlock;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.UUID;

class InMemoryOfferRepositoryTest {

    private final InMemoryOfferRepository offerRepository = new InMemoryOfferRepository();

    @Test
    void should_save_offer() {
        //GIVEN
        var offer = Offer.builder().id(UUID.randomUUID()).build();

        //WHEN
        offerRepository.save(offer);

        //THEN
        var offers = (List<Offer>) ReflectionTestUtils.getField(offerRepository, "offers");
        assert offers != null;
        Assertions.assertThat(offers.size()).isEqualTo(1);
        Assertions.assertThat(offers).containsExactly(offer);
    }


    @Test
    void should_get_offers_by_market_type() {
        //GIVEN
        var offer1 = Offer.builder().id(UUID.randomUUID()).marketType(MarketType.PRIMARY).build();
        var offer2 = Offer.builder().id(UUID.randomUUID()).marketType(MarketType.SECONDARY).build();
        offerRepository.save(offer1);
        offerRepository.save(offer2);

        //WHEN
        List<Offer> actual = offerRepository.getOffersByMarketType(MarketType.PRIMARY);

        //THEN
        Assertions.assertThat(actual).containsExactly(offer1);
    }

    @Test
    void should_get_farm_by_market_type() {
        //GIVEN
        Farm expected = Farm.builder().id(UUID.randomUUID()).energyType(EnergyType.SOLAR).build();
        Farm farm = Farm.builder().energyType(EnergyType.HYDRO_POWER).build();
        var offer1 = Offer.builder().id(UUID.randomUUID())
                .marketType(MarketType.PRIMARY)
                .timeBlock(TimeBlock.builder().farm(expected).build())
                .build();
        var offer2 = Offer.builder().id(UUID.randomUUID())
                .timeBlock(TimeBlock.builder().id(UUID.randomUUID()).farm(farm).build())
                .marketType(MarketType.SECONDARY)
                .build();
        offerRepository.save(offer1);
        offerRepository.save(offer2);

        //WHEN
        List<Farm> actual = offerRepository.getFarmsByMarketType(MarketType.PRIMARY);

        //THEN
        Assertions.assertThat(actual).containsExactly(expected);
    }

}