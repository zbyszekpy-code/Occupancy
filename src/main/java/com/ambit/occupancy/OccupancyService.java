package com.ambit.occupancy;


import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.summarizingInt;

@Service
public class OccupancyService {

    public UsagePair calculateUsage(long premiumCount, long economyCount, List<Integer> customers) {

        var premiumStatistics = customers.stream()
                                         .filter(this::isPremium)
                                         .sorted(Comparator.reverseOrder())
                                         .limit(premiumCount)
                                         .collect(summarizingInt(x -> x));

        var freePremium = premiumCount - premiumStatistics.getCount();

        var economy = customers.stream()
                .filter(x -> !isPremium(x))
                .sorted(Comparator.reverseOrder())
                .limit(freePremium + economyCount)
                .mapToInt(v -> v)
                .toArray();

        var usePremium = economy.length <= economyCount ? 0 : economy.length - economyCount;

        var premiumSum = premiumStatistics.getSum() + Arrays.stream(economy).limit(usePremium).sum();

        var economySum = Arrays.stream(economy).skip(usePremium).sum();

        return new UsagePair(premiumSum, economySum);
    }

    private boolean isPremium(Integer x) {
        return x >= AppParams.ECONOMY_LIMIT;
    }
}
