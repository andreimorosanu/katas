package com.katas.designexercises.vendingmachine.try1.machine;

import com.katas.designexercises.vendingmachine.try1.machine.shelves.ShelvesStoker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BasicVendingMachineShould {

    @Mock
    private ShelvesStoker shelvesStoker;

    @Mock
    private PricingManager pricingManager;

    private VendingMachine vendingMachine;

    @BeforeAll
    public void setup() {
        vendingMachine = new BasicVendingMachine(shelvesStoker, pricingManager);
    }

    @Test
    public void notAllowAPurchaseIfOneAlreadyInProgress() {

    }

    @Test
    public void notAllowAddingMoneyIfNoPurchaseInProgress() {

    }

    @Test
    public void notAllowSelectingAnItemIfNoPurchaseInProgess() {

    }

    @Test
    public void notAllowCancelingAPurchaseIfPurchaseNotInProgress() {

    }

    @Test
    public void notAllowStockingItemIfPurchaseInProgress() {

    }

    @Test
    public void notAllowStockingChangeIfPurchaseInProgress() {

    }

    @Test
    public void stockChangeForMachine() {

    }

    @Test
    public void startingPurchase() {

    }

    @Test
    public void addingMoneyForPurchase() {

    }

    @Test
    public void returnMoneyWhenCanceling() {

    }

    @Test
    public void returnSelectedItemIfPossible() {

    }

    @Test
    public void checkItemAvailability() {

    }
    

}