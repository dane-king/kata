package org.daneking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {


    private final Expression fiveDollars= Money.dollar(5);

    private final Expression fiveFrancs= Money.franc(5);
    private Bank bank;
    private Expression tenFrancs = Money.franc(10);

    @BeforeEach
    void setUp() {
        bank=new Bank();
    }

    @Test
    void multiple5time2is10And5times3is15() {
        assertEquals(Money.dollar(10),fiveDollars.times(2));
        assertEquals(Money.dollar(15), fiveDollars.times(3));
    }
    @Test
    void multiple5time2is10And5times3is15Francs() {
        assertEquals(Money.franc(10), fiveFrancs.times(2));
        assertEquals(Money.franc(15), fiveFrancs.times(3));
    }

    @Test
    void moneyShouldBeEqual() {
        assertEquals(fiveDollars, Money.dollar(5));
        assertNotEquals(fiveDollars, Money.dollar(6));
        assertNotEquals(fiveFrancs,Money.dollar(5));

    }

    @Test
    void moneyShouldHaveCurrencyType() {
        assertEquals(Money.DOLLAR, Money.dollar(1).currency());
        assertEquals(Money.FRANC, Money.franc(1).currency());
    }

    @Test
    void reduceSumUSDShouldResultInMoney() {
        Expression sum=new Sum(Money.dollar(3), Money.dollar(5));
        assertEquals(Money.dollar(8), bank.reduce(sum,Money.DOLLAR ));
    }

    @Test
    void reduceMoneyWithBank() {
        Money result=bank.reduce(Money.dollar(1),Money.DOLLAR );
        assertEquals(Money.dollar(1),result);
    }

    @Test
    void reduceMoneyOfDifferentCurrency() {
        setFrancDollarConversionRate(2);
        bank.rate(Money.FRANC,Money.DOLLAR);
        Money result=bank.reduce(Money.franc(2),Money.DOLLAR);
        assertEquals(Money.dollar(1),result);
    }

    private void setFrancDollarConversionRate(int rate) {
        bank.addRate(Money.FRANC, Money.DOLLAR,rate);
    }

    @Test
    void mixedAddition() {
        setFrancDollarConversionRate(2);
        Money result=bank.reduce(fiveDollars.plus(tenFrancs), Money.DOLLAR);
        assertEquals(Money.dollar(10),result);

    }

    @Test
    void testIdentityRate() {
        assertEquals(1, bank.rate(Money.DOLLAR, Money.DOLLAR));
    }

    @Test
    void sumPlus() {
        setFrancDollarConversionRate(2);
        Expression sum=new Sum(fiveDollars,tenFrancs).plus(fiveDollars);
        Money result=bank.reduce(sum, Money.DOLLAR);
        assertEquals(Money.dollar(15), result);
    }
    @Test
    void sumTimes() {
        setFrancDollarConversionRate(2);
        Expression sum=new Sum(fiveDollars,tenFrancs).times(2);
        Money result=bank.reduce(sum, Money.DOLLAR);
        assertEquals(Money.dollar(20), result);
    }

}