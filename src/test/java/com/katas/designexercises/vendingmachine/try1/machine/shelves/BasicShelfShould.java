package com.katas.designexercises.vendingmachine.try1.machine.shelves;

import com.katas.designexercises.vendingmachine.try1.inventory.Item;
import com.katas.designexercises.vendingmachine.try1.machine.shelves.exceptions.ShelfException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BasicShelfShould {

    private static final String ITEM_COLA = "COLA";
    private static final String ITEM_SNICKERS = "SNICKERS";

    @Test
    public void allowItemToBeAddedIfBelowCapacity() {

        //setup
        BasicShelf shelf = new BasicShelf();

        //execute
        shelf.stockItem(ITEM_COLA);

        //verify
        Item item = shelf.retrieveItem();
        assertEquals(ITEM_COLA, item.getName());

    }

    @Test
    public void retrieveTheLastItemStocked() {

        //setup
        BasicShelf shelf = new BasicShelf();
        List<String> itemNames = Arrays.asList("COKE", "PEPSI", "SNICKERS", "COKE");

        for (String itemName : itemNames) {
            shelf.stockItem(itemName);
        }

        // execute & verify
        for (int i = itemNames.size() - 1; i >= 0; i--) {
            assertEquals(itemNames.get(i), shelf.retrieveItem().getName());
        }

    }

    @Test
    public void notAllowItemsQuantityToExceedCapacity() {
        //setup
        BasicShelf shelf = new BasicShelf();
        for (int i = 0; i < BasicShelf.maxCapacity; i++) {
            shelf.stockItem(ITEM_COLA);
        }

        //execute
        ShelfException shelfException = assertThrows(ShelfException.class, () -> shelf.stockItem(ITEM_COLA));
        assertEquals(ShelfException.Reason.SHELF_CAPACITY_EXCEEDED, shelfException.getReason());
    }

    @Test
    public void notAllowRetrievingElementWhenShelfIsEmpty() {
        //setup
        BasicShelf shelf = new BasicShelf();

        //execute
        ShelfException shelfException = assertThrows(ShelfException.class, () -> shelf.retrieveItem());
        assertEquals(ShelfException.Reason.SHELF_IS_EMPTY, shelfException.getReason());
    }

    @Test
    public void returnItemAvailableWhenNextInLine() {

        //setup
        BasicShelf shelf = new BasicShelf();
        shelf.stockItem(ITEM_SNICKERS);
        shelf.stockItem(ITEM_COLA);

        //validate
        assertTrue(shelf.getAvailability(ITEM_COLA).isAvailable());
        assertFalse(shelf.getAvailability(ITEM_SNICKERS).isAvailable());
    }
    
}