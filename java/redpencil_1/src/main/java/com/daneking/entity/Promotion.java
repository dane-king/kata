package com.daneking.entity;

public class Promotion {
    public static final double MIN_CHANGE = -.05;
    public static final double MAX_CHANGE = -.30;

    public boolean isStarted(Price price) {
        if(price==null) throw new IllegalArgumentException("price should not be null");
        return PriceCalculation.changeIsBetween(MIN_CHANGE, MAX_CHANGE, price);
    }

}
