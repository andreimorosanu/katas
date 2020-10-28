package com.katas.designexercises.vendingmachine.try1.machine.shelves;

import java.util.List;

public class ShelvesStokerImpl implements ShelvesStoker {

    private List<Shelf> shelves;

    public void addItem(String item) {

    }

    @Override
    public void setShelves(List<Shelf> shelves) {
        this.shelves = List.copyOf(shelves);
    }
}
