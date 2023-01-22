package com.katas.designexercises.vendingmachine.try1.machine;

import com.katas.designexercises.vendingmachine.try1.currency.Money;
import com.katas.designexercises.vendingmachine.try1.machine.payment.ChangeManager;
import com.katas.designexercises.vendingmachine.try1.machine.shelves.ShelvesStoker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.katas.designexercises.vendingmachine.try1.currency.Money.from;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BasicVendingMachineShould {

    @Mock
    private ShelvesStoker shelvesStoker;

    @Mock
    private ChangeManager changeManager;


    private VendingMachine vendingMachine;

    @BeforeEach
    public void setup() {

        vendingMachine = new BasicVendingMachine(shelvesStoker, changeManager);
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
        //setup
        String amount = "20.00";

        //execute
        vendingMachine.stockChange(amount);

        //verify
        verify(changeManager).stockChange(eq(amount));
    }

    @Test
    public void addMoneyForPurchase() {
        //setup
        vendingMachine.startPurchase();
        String amount = "20.00";

        //execute
        vendingMachine.addMoney(amount);

        //verify
        verify(changeManager).addMoneyForPurchase(eq(amount));

    }

    @Test
    public void returnMoneyWhenCanceling() {

        //setup
        vendingMachine.startPurchase();
        String amount = "20.00";
        String amount2 = "21.11";

        when(changeManager.cancelBuy()).thenReturn(List.of(from(amount), from(amount2)));

        //execute
        List<Money> change = vendingMachine.cancelPurchase();

        //verify
        verify(changeManager).cancelBuy();
        assertEquals(from(amount), change.get(0));
        assertEquals(from(amount2), change.get(1));
    }

    @Test
    public void returnSelectedItemIfPossible() {

    }

//    @Test
//    public void notifyUserIfItemNotAvailableWhenItemSelected() {
//        //setup
//        vendingMachine.startPurchase();
//        String productName = "COKE";
//        Item item = new Item(productName);
//
//        when(shelvesStoker)
//
//        //execute
//        vendingMachine.selectItem(productName);
//
//        //verify
//
//    }

    @Test
    public void notifyUserNotEnoughMoneyWhenItemSelected() {

    }

}