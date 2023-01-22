package com.katas.designexercises.vendingmachine.try1.machine.payment;

import com.katas.designexercises.vendingmachine.try1.currency.Money;
import com.katas.designexercises.vendingmachine.try1.inventory.Item;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.katas.designexercises.vendingmachine.try1.currency.Money.from;
import static org.junit.jupiter.api.Assertions.*;

class ChangeManagerImplShould {


    @Test
    public void resetAddedMoneyIfPurchaseCanceled() {

        //setup
        ChangeManager changeManager = new ChangeManagerImpl();
        String m1 = "1.00";
        String m2 = "14.00";
        String m3 = "3.00";

        changeManager.addMoneyForPurchase(m1);
        changeManager.addMoneyForPurchase(m2);
        changeManager.addMoneyForPurchase(m3);

        //execute
        List<Money> monies = changeManager.cancelBuy();
        List<Money> secondCall = changeManager.cancelBuy();

        //verify
        assertEquals(from(m1), monies.get(0));
        assertEquals(from(m2), monies.get(1));
        assertEquals(from(m3), monies.get(2));

        assertTrue(secondCall.isEmpty());

    }

    @Test
    public void validateCorrectCoinsStocked() {
        //setup
        ChangeManager changeManager = new ChangeManagerImpl();

        //execute & verify
        MoneyException moneyException = assertThrows(MoneyException.class, () -> changeManager.stockChange("22"));
        assertEquals(MoneyException.Reason.UNEXPECTED_COIN_DENOMINATION, moneyException.getReason());
    }


    @Test
    public void validateNotEnoughChange() {
        //setup
        ChangeManager changeManager = new ChangeManagerImpl();

        changeManager.stockChange("2.00");
        changeManager.stockChange("5.00");

        changeManager.addMoneyForPurchase("22.00");

        Item item = new Item("COKE", from("3.00"));

        // execute & verify
        MoneyException moneyException = assertThrows(MoneyException.class, () -> changeManager.buy(item));
        assertEquals(MoneyException.Reason.NOT_ENOUGH_CHANGE, moneyException.getReason());
    }

    @Test
    public void validateInsufficientMoneyAdded() {
        //setup
        ChangeManager changeManager = new ChangeManagerImpl();
        changeManager.addMoneyForPurchase("2.00");
        changeManager.addMoneyForPurchase("0.25");
        changeManager.addMoneyForPurchase("0.25");

        Item item = new Item("COKE", from("3.00"));

        // execute & verify
        MoneyException moneyException = assertThrows(MoneyException.class, () -> changeManager.buy(item));
        assertEquals(MoneyException.Reason.NOT_ENOUGH_MONEY_PAID, moneyException.getReason());

    }


    @Test
    public void returnChangeWhenPurchaseComplete() {
        //setup
        ChangeManager changeManager = new ChangeManagerImpl();

        changeManager.stockChange("5.00");
        changeManager.stockChange("14.00");
    }


}