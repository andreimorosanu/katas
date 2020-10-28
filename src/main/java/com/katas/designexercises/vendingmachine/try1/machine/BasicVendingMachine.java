package com.katas.designexercises.vendingmachine.try1.machine;


import com.katas.designexercises.vendingmachine.try1.machine.shelves.BasicShelf;
import com.katas.designexercises.vendingmachine.try1.machine.shelves.Shelf;
import com.katas.designexercises.vendingmachine.try1.machine.shelves.ShelvesStoker;
import com.katas.designexercises.vendingmachine.try1.machine.shelves.ShelvesStokerImpl;

import java.util.ArrayList;
import java.util.List;

public class BasicVendingMachine implements VendingMachine {

    private final List<Shelf> shelves;
    private final ShelvesStoker shelvesStoker;
    private final PricingManager pricingManager;

    public BasicVendingMachine() {

        shelves = new ArrayList<>();
        shelves.add(new BasicShelf());
        shelves.add(new BasicShelf());
        shelves.add(new BasicShelf());
        shelves.add(new BasicShelf());
        shelves.add(new BasicShelf());

        shelvesStoker = new ShelvesStokerImpl(shelves);
        pricingManager = new PricingManagerImpl();
    }

    @Override
    public void stockItem(String item, String amount, String shelf) {

    }

    @Override
    public void stockItem(String item, String amount) {

    }

    @Override
    public void stockChange(String amount) {

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
    public void buy(String item) {

    }
}
