package com.katas.designexercises.vendingmachine.try1.machine;

import com.katas.designexercises.vendingmachine.try1.machine.pricing.PricingManager;
import com.katas.designexercises.vendingmachine.try1.machine.shelves.ShelvesStoker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class BasicVendingMachineShould {

    @Mock
    private ShelvesStoker shelvesStoker;

    @Mock
    private PricingManager pricingManager;

    private VendingMachine vendingMachine;

    @BeforeEach
    public void setup() {

        vendingMachine = new BasicVendingMachine(shelvesStoker, pricingManager);
    }

    @Test
    public void notAllowAPurchaseIfOneAlreadyInProgress() {

        //setup
        vendingMachine.startPurchase();

        //verify
        VendingOperationException vendingOperationException = assertThrows(VendingOperationException.class, () -> vendingMachine.startPurchase());
        assertEquals(VendingOperationException.Reason.PURCHASE_ALREADY_IN_PROGRESS, vendingOperationException.getReason());
    }

    @Test
    public void notAllowAddingMoneyIfNoPurchaseInProgress() {
        //verify
        VendingOperationException vendingOperationException = assertThrows(VendingOperationException.class, () -> vendingMachine.addMoney("10.00"));
        assertEquals(VendingOperationException.Reason.NO_PURCHASE_IN_PROGRESS, vendingOperationException.getReason());
    }

    @Test
    public void notAllowSelectingAnItemIfNoPurchaseInProgress() {
        //verify
        VendingOperationException vendingOperationException = assertThrows(VendingOperationException.class, () -> vendingMachine.selectItem(""));
        assertEquals(VendingOperationException.Reason.NO_PURCHASE_IN_PROGRESS, vendingOperationException.getReason());
    }

    @Test
    public void notAllowCancelingAPurchaseIfPurchaseNotInProgress() {

    }

    @Test
    public void notAllowStockingItemIfPurchaseInProgress() {
        //setup
        vendingMachine.startPurchase();

        //verify
        VendingOperationException vendingOperationException = assertThrows(VendingOperationException.class, () -> vendingMachine.stockItem("", ""));
        assertEquals(VendingOperationException.Reason.CANNOT_STOCK_WHILE_PURCHASE_IN_PROGRESS, vendingOperationException.getReason());
    }

    @Test
    public void notAllowStockingChangeIfPurchaseInProgress() {
        //setup
        vendingMachine.startPurchase();

        //verify
        VendingOperationException vendingOperationException = assertThrows(VendingOperationException.class, () -> vendingMachine.stockChange(""));
        assertEquals(VendingOperationException.Reason.CANNOT_STOCK_WHILE_PURCHASE_IN_PROGRESS, vendingOperationException.getReason());
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
    public void checkItemAvailabilityWhenItemSelected() {

    }

    @Test
    public void checkChangeAvailabilityWhenItemSelected() {

    }

}