package com.katas.designexercises.vendingmachine.try1.machine;


import com.katas.designexercises.vendingmachine.try1.machine.shelves.BasicShelf;
import com.katas.designexercises.vendingmachine.try1.machine.shelves.Shelf;
import com.katas.designexercises.vendingmachine.try1.machine.shelves.ShelvesStoker;

import java.util.ArrayList;
import java.util.List;

public class BasicVendingMachine implements VendingMachine {

    private final List<Shelf> shelves;
    private final ShelvesStoker shelvesStoker;
    private final PricingManager pricingManager;

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

    }

    @Override
    public void stockChange(String changeAmount) {

    }

    @Override
    public void cancelPurchase() {

    }

    @Override
    public void startPurchase() {

    }

    @Override
    public void addMoney(String amount) {

    }

    @Override
    public void selectItem(String item) {

    }
}
