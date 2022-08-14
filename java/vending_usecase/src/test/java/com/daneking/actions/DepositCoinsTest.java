package com.daneking.actions;

import com.daneking.actions.domain.Coin;
import com.daneking.repository.CoinRepository;
import com.daneking.repository.fake.FakeCoinRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepositCoinsTest {
    private DepositCoins depositCoins;
    private CoinRepository coinRepository;

    @BeforeEach
    void setUp() {
        coinRepository=new FakeCoinRepository();
        depositCoins=new DepositCoins(coinRepository);
    }

    @Test
    void should_deposit_coins() {
        List<Coin> coins=List.of(Coin.NICKEL,Coin.DIME,Coin.QUARTER);
        //deposit
        DepositRequest coinRequest=new DepositRequest(coins);
        depositCoins.handle(coinRequest);
        //verify repository
        BigDecimal fortyCents=new BigDecimal(".4").setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(fortyCents, coinRepository.getBalance());
    }

}