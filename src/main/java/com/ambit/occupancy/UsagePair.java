package com.ambit.occupancy;

import lombok.Data;

@Data
public class UsagePair {
    private long premiumSum;
    private long economySum;

    public UsagePair(long premiumSum, long economySum) {

        this.premiumSum = premiumSum;
        this.economySum = economySum;
    }
}
