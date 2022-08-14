package com.daneking.actions;

import com.daneking.repository.CoinRepository;

public class DepositCoins {
    public DepositCoins(CoinRepository coinRepository) {
        this.coinRepository = coinRepository;
    }

    private CoinRepository coinRepository;


    public void handle(DepositRequest coinRequest) {
        coinRepository.save(coinRequest.getCoins());
    }
}
