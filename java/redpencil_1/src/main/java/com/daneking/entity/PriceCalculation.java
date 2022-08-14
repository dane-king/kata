package com.daneking.entity;

import java.math.BigDecimal;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static java.math.RoundingMode.CEILING;

public class PriceCalculation {
    public static final int FOUR_DECIMALS = 10000;

    private static double hasChangedBy(Price price) {
        BigDecimal currentPrice = price.getCurrentPrice();
        BigDecimal originalPrice = price.getOriginalPrice();
        return currentPrice.subtract(originalPrice).divide(originalPrice, CEILING).doubleValue();
    }

    public static boolean changeIsBetween(double minChange, double maxChange, Price price) {
        double priceChangePercentage = truncate(hasChangedBy(price));
        return priceChangePercentage <= minChange && priceChangePercentage >= maxChange;

    }

    private static double truncate(double priceChangePercent) {
        return Math.floor(priceChangePercent * FOUR_DECIMALS) / FOUR_DECIMALS;
    }

}
