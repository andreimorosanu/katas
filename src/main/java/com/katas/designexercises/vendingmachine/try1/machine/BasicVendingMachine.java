package com.katas.designexercises.vendingmachine.try1.machine;


import com.katas.designexercises.vendingmachine.try1.machine.pricing.PricingManager;
import com.katas.designexercises.vendingmachine.try1.machine.shelves.BasicShelf;
import com.katas.designexercises.vendingmachine.try1.machine.shelves.Shelf;
import com.katas.designexercises.vendingmachine.try1.machine.shelves.ShelvesStoker;

import java.util.ArrayList;
import java.util.List;

public class BasicVendingMachine implements VendingMachine {

    private final List<Shelf> shelves;
    private final ShelvesStoker shelvesStoker;
    private final PricingManager pricingManager;

    // TODO: 10/28/2020 can refactor this so that there are 2 actual object implementation
    boolean purchaseInProgress = false;

    public BasicVendingMachine(ShelvesStoker shelvesStoker, PricingManager pricingManager) {

        this.shelvesStoker = shelvesStoker;
        this.pricingManager = pricingManager;

        shelves = new ArrayList<>();
        shelves.add(new BasicShelf());
        shelves.add(new BasicShelf());
        shelves.add(new BasicShelf());
        shelves.add(new BasicShelf());
        shelves.add(new BasicShelf());

        shelvesStoker.setShelves(shelves);
    }

    @Override
    public void stockItem(String item, String price) {
        if (purchaseInProgress) {
            throw new VendingOperationException(VendingOperationException.Reason.CANNOT_STOCK_WHILE_PURCHASE_IN_PROGRESS);
        }
    }

    @Override
    public void stockChange(String changeAmount) {
        if (purchaseInProgress) {
            throw new VendingOperationException(VendingOperationException.Reason.CANNOT_STOCK_WHILE_PURCHASE_IN_PROGRESS);
        }
    }

    @Override
    public void cancelPurchase() {

    }

    @Override
    public void startPurchase() {

        if (purchaseInProgress) {
            throw new VendingOperationException(VendingOperationException.Reason.PURCHASE_ALREADY_IN_PROGRESS);
        }

        purchaseInProgress = true;
    }

    @Override
    public void addMoney(String amount) {
        if (!purchaseInProgress) {
            throw new VendingOperationException(VendingOperationException.Reason.NO_PURCHASE_IN_PROGRESS);
        }
    }

    @Override
    public void selectItem(String item) {
        if (!purchaseInProgress) {
            throw new VendingOperationException(VendingOperationException.Reason.NO_PURCHASE_IN_PROGRESS);
        }

    }
}
