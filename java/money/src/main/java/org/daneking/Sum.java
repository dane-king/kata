package org.daneking;

public class Sum implements Expression {
    private final Expression augend;
    private final Expression addend;

    public Sum(Expression augend,
               Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amt=addend.reduce(bank,to).amount + augend.reduce(bank,to).amount;
        return new Money(amt, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(this.augend.times(multiplier), this.addend.times(multiplier));
    }
}
