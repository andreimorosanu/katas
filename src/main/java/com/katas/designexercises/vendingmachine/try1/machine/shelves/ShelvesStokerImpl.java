package com.katas.designexercises.vendingmachine.try1.machine.shelves;

import com.katas.designexercises.vendingmachine.try1.inventory.Item;

import java.util.List;

public class ShelvesStokerImpl implements ShelvesStoker {

    private List<Shelf> shelves;

    public void addItem(String item) {

    }

    @Override
    public void setShelves(List<Shelf> shelves) {
        this.shelves = List.copyOf(shelves);
    }

    @Override
    public ItemAvailability availability(Item desiredItem) {
        // TODO: 11/2/2020 this code seems to procedural, perhaps if there are no availble items i can return a different item?
        for (Shelf shelf : shelves) {
            ItemAvailability itemOnShelf = shelf.getAvailability(desiredItem.getName());
            if (itemOnShelf.isAvailable()) {
                return itemOnShelf;
            }
        }

        ItemAvailability itemAvailability = new ItemAvailability();
        itemAvailability.setAvailable(false);
        return itemAvailability;
    }
}
