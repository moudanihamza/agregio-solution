package com.kata.agregio_solutions.infrastructure;

import com.kata.agregio_solutions.domain.entities.Farm;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.UUID;

class InMemoryFarmRepositoryTest {

    private final InMemoryFarmRepository farmRepository = new InMemoryFarmRepository();

    @Test
    void should_save_farm() {
        //GIVEN
        var farm = Farm.builder().id(UUID.randomUUID()).build();

        //WHEN
        farmRepository.save(farm);

        //THEN
        var farms = (List<Farm>) ReflectionTestUtils.getField(farmRepository, "farms");
        assert farms != null;
        Assertions.assertThat(farms.size()).isEqualTo(1);
        Assertions.assertThat(farms).containsExactly(farm);
    }

}