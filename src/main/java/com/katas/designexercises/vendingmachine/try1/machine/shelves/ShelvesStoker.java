package com.katas.designexercises.vendingmachine.try1.machine.shelves;

import com.katas.designexercises.vendingmachine.try1.inventory.Item;

import java.util.List;

public interface ShelvesStoker {
    void setShelves(List<Shelf> shelves);

    ItemAvailability availability(Item desiredItem);
}
