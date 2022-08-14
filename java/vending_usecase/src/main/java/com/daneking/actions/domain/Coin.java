package com.daneking.actions.domain;

public enum Coin {
    NICKEL(5), DIME(10), QUARTER(25);

    private final int amount;

    Coin(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
