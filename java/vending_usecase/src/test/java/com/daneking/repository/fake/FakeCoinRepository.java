package com.daneking.repository.fake;

import com.daneking.actions.domain.Coin;
import com.daneking.repository.CoinRepository;

import java.math.BigDecimal;
import java.util.List;

public class FakeCoinRepository implements CoinRepository {
    private List<Coin> coins;


    @Override
    public BigDecimal getBalance() {
        BigDecimal returnVal = calculateCoins(coins);
        return returnVal;
    }

    private BigDecimal calculateCoins(List<Coin> coins) {
        int amount= coins.stream().mapToInt(Coin::getAmount).sum();
        return new BigDecimal(amount * .01);
    }


    @Override
    public void save(List<Coin> coins) {
        this.coins=coins;
    }
}
