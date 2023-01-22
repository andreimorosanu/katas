package com.katas.designexercises.vendingmachine.try1.machine.payment;

import com.katas.designexercises.vendingmachine.try1.currency.Money;
import com.katas.designexercises.vendingmachine.try1.inventory.Item;

import java.util.List;

public interface ChangeManager {

    void stockChange(String amount);

    void addMoneyForPurchase(String amount);

    List<Money> cancelBuy();

    List<Money> buy(Item desiredItem);
}
