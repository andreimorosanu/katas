package com.katas.designexercises.vendingmachine.try1.machine;

public class VendingOperationException extends RuntimeException {

    private Reason reason;

    public Reason getReason() {
        return reason;
    }

    public VendingOperationException(Reason reason) {

        this.reason = reason;
    }

    public enum Reason {
        NO_PURCHASE_IN_PROGRESS, CANNOT_STOCK_WHILE_PURCHASE_IN_PROGRESS, PURCHASE_ALREADY_IN_PROGRESS

    }
}
