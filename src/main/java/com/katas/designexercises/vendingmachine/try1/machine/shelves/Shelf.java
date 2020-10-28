package com.katas.designexercises.vendingmachine.try1.machine.shelves;

import com.katas.designexercises.vendingmachine.try1.inventory.Item;

public interface Shelf {

    /**
     * Add a specific item to the shelf inventory
     */
    void stockItem(String name);


    ItemAvailability getAvailability(String desiredItemName);

    /**
     * A shelf can only return the first item on it
     *
     * @return
     */
    Item retrieveItem();

}
