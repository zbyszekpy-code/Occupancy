package com.ambit.occupancy;

import lombok.Data;

@Data
public class UsagePair {
    private int premiumSum;
    private int economySum;

    public UsagePair(int premiumSum, int economySum) {

        this.premiumSum = premiumSum;
        this.economySum = economySum;
    }
}
