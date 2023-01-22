package com.katas.designexercises.vendingmachine.try1.machine.shelves;

import com.katas.designexercises.vendingmachine.try1.inventory.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShelvesStokerImplShould {

    @Mock
    private Shelf firstShelf;

    @Mock
    private Shelf secondShelf;


    @Test
    public void returnsFirstAvailableItemInformation() {
        //setup
        Item desiredItem = new Item("COLA");

        ShelvesStoker stocker = new ShelvesStokerImpl();
        stocker.setShelves(List.of(firstShelf, secondShelf));

        when(firstShelf.getAvailability(desiredItem.getName())).thenReturn(buildAvailability(false));
        when(secondShelf.getAvailability(desiredItem.getName())).thenReturn(buildAvailability(true));

        //execute
        ItemAvailability availability = stocker.availability(desiredItem);

        //validate
        verify(firstShelf).getAvailability(desiredItem.getName());
        verify(secondShelf).getAvailability(desiredItem.getName());

        assertTrue(availability.isAvailable());

    }

    @Test
    public void returnNoAvailabilityIfNoShelvesHaveItem() {
        //setup
        Item desiredItem = new Item("COLA");

        ShelvesStoker stocker = new ShelvesStokerImpl();
        stocker.setShelves(List.of(firstShelf, secondShelf));

        when(firstShelf.getAvailability(desiredItem.getName())).thenReturn(buildAvailability(false));
        when(secondShelf.getAvailability(desiredItem.getName())).thenReturn(buildAvailability(false));

        //execute
        ItemAvailability availability = stocker.availability(desiredItem);

        //validate
        verify(firstShelf).getAvailability(desiredItem.getName());
        verify(secondShelf).getAvailability(desiredItem.getName());

        assertFalse(availability.isAvailable());
    }

    private ItemAvailability buildAvailability(boolean isAvailable) {
        ItemAvailability itemAvailability = new ItemAvailability();
        itemAvailability.setAvailable(isAvailable);

        return itemAvailability;
    }

}