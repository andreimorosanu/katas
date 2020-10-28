package com.katas.designexercises.vendingmachine.try1.machine.shelves;

import java.util.List;

public class ShelvesStokerImpl implements ShelvesStoker {


    private List<Shelf> shelves;

    public ShelvesStokerImpl(List<Shelf> shelves) {

        this.shelves = shelves;
    }

    public void addItem(String item) {

    }
}
