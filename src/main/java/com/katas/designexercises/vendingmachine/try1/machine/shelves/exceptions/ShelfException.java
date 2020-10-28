package com.katas.designexercises.vendingmachine.try1.machine.shelves.exceptions;

public class ShelfException extends RuntimeException {


    private Reason reason;

    public ShelfException(Reason reason) {
        this.reason = reason;
    }

    public Reason getReason() {
        return reason;
    }


    public enum Reason {

        SHELF_IS_EMPTY, SHELF_CAPACITY_EXCEEDED
    }

}
