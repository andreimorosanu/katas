package com.katas.designexercises.vendingmachine.try1.machine.shelves;

import com.katas.designexercises.vendingmachine.try1.inventory.Item;
import com.katas.designexercises.vendingmachine.try1.machine.shelves.exceptions.ShelfException;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicShelf implements Shelf {

    protected static final int maxCapacity = 10;
    private Deque<Item> items = new ArrayDeque();

    @Override
    public void stockItem(String name) {

        validateShelfFull();
        items.push(new Item(name));
    }


    @Override
    public ItemAvailability getAvailability(String desiredItemName) {
        ItemAvailability availability = new ItemAvailability();
        Item peek = items.peek();

        if (peek == null) {
            availability.setAvailable(false);
        }

        if (peek.getName().equals(desiredItemName)) {
            availability.setAvailable(true);
        }

        return availability;
    }

    @Override
    public Item retrieveItem() {
        validateShelfNotEmpty();
        return items.pop();
    }

    private void validateShelfNotEmpty() {
        if (items.size() == 0) {
            throw new ShelfException(ShelfException.Reason.SHELF_IS_EMPTY);
        }
    }

    private void validateShelfFull() {
        if (maxCapacity < items.size() + 1) {
            throw new ShelfException(ShelfException.Reason.SHELF_CAPACITY_EXCEEDED);
        }
    }

}
