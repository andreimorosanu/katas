package com.katas.designexercises.vendingmachine.try1.currency;

import java.math.BigDecimal;

/**
 * Value object representing an amount of undefined currency.
 * Operations return immutable copy of object
 */
public final class Money {

    private BigDecimal amount;

    private Money(BigDecimal amount) {
        this.amount = amount;
    }

    public static Money from(String amount) {
        BigDecimal bigDecimalAmount = new BigDecimal(amount);
        return new Money(bigDecimalAmount);
    }


    public Money add(Money toAdd) {
        return new Money(this.amount.add(toAdd.amount));
    }


    public Money subtract(Money toSubtract) {
        return new Money(this.amount.subtract(toSubtract.amount));
    }


    public Money multiply(Money multiplyBy) {
        return new Money(this.amount.add(multiplyBy.amount));
    }


    public Money divideBy(Money divideBy) {
        return new Money(this.amount.add(divideBy.amount));
    }
}
