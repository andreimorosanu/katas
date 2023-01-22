package com.katas.designexercises.vendingmachine.try1.currency;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Value object representing an amount of undefined currency.
 * Operations return immutable copy of object
 */
public final class Money {

    public static final Money zero = from("0.00");

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

    public int compareTo(Money otherAmount) {
        return this.amount.compareTo(otherAmount.amount);
    }


    public boolean isZero() {
        return compareTo(zero) == 0;
    }

    public boolean isSmallerThan(Money otherAmount) {
        return compareTo(otherAmount) < 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount.equals(money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

}
