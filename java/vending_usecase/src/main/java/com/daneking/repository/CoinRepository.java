package com.daneking.repository;

import com.daneking.actions.domain.Coin;

import java.math.BigDecimal;
import java.util.List;

public interface CoinRepository {
    BigDecimal getBalance();

    void save(List<Coin> coins);
}
