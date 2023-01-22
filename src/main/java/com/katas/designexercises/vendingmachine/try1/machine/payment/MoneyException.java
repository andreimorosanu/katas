package com.katas.designexercises.vendingmachine.try1.machine.payment;

public class MoneyException extends RuntimeException {


    private Reason reason;

    public Reason getReason() {
        return reason;
    }

    public MoneyException(Reason reason) {

        this.reason = reason;
    }

    public enum Reason {
        UNEXPECTED_COIN_DENOMINATION,
        NOT_ENOUGH_CHANGE,
        NOT_ENOUGH_MONEY_PAID,
    }
}
