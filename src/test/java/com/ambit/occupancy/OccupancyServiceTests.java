package com.ambit.occupancy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class OccupancyServiceTests {

    List<Integer> testCustomers = asList(23, 45, 155, 374, 22, 99, 100, 101, 115, 209);

    @Test
    void acceptanceTest1() {

        var result = new OccupancyService().calculateUsage(3, 3, testCustomers);

        assertThat(result.getPremiumSum()).isEqualTo(738);
        assertThat(result.getEconomySum()).isEqualTo(167);
    }

    @Test
    void acceptanceTest2() {

        var result = new OccupancyService().calculateUsage(7, 5, testCustomers);

        assertThat(result.getPremiumSum()).isEqualTo(1054);
        assertThat(result.getEconomySum()).isEqualTo(189);
    }

    @Test
    void acceptanceTest3() {

        var result = new OccupancyService().calculateUsage(2, 7, testCustomers);

        assertThat(result.getPremiumSum()).isEqualTo(583);
        assertThat(result.getEconomySum()).isEqualTo(189);
    }

    @Test
    void acceptanceTest4() {

        var result = new OccupancyService().calculateUsage(7, 1, testCustomers);

        assertThat(result.getPremiumSum()).isEqualTo(1153);
        assertThat(result.getEconomySum()).isEqualTo(45);
    }

}
