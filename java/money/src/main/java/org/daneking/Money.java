package org.daneking;

import java.util.Objects;

public class Money implements Expression {
    protected int amount;
    private String currency;
    public static final String DOLLAR = "USD";
    public static final String FRANC = "CHF";

    Money(int amount, String currency) {
        this.amount=amount;
        this.currency=currency;
    }

    static Money franc(int amount){
        return new Money(amount, FRANC);
    }

    static Money dollar(int amount){
        return new Money(amount, DOLLAR);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Money money = (Money) o;
        return amount == money.amount &&
                currency==money.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }


    public String currency() {
        return this.currency;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    @Override
    public Expression times(int multiplier) {
        return new Money(this.amount * multiplier, this.currency);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int rate= bank.rate(this.currency,to);
        return new Money(amount/rate,to);
    }
}
