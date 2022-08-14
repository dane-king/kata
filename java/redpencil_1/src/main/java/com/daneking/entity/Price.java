package com.daneking.entity;

import java.math.BigDecimal;

public class Price {

    private final BigDecimal originalPrice;
    private BigDecimal currentPrice;

    public Price(double originalPrice) {
        this.originalPrice = BigDecimal.valueOf(originalPrice);
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = BigDecimal.valueOf(currentPrice);
    }

    public BigDecimal getCurrentPrice() {
        return this.currentPrice;
    }

    public BigDecimal getOriginalPrice(){
        return this.originalPrice;
    }
}
