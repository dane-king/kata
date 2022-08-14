package com.daneking.actions;

import com.daneking.actions.domain.Coin;

import java.util.Collections;
import java.util.List;

public class DepositRequest {
    private final List<Coin> coins;

    public DepositRequest(List<Coin> coins) {
        this.coins = coins;
    }

    public List<Coin> getCoins() {
        return Collections.unmodifiableList(coins);
    }
}
