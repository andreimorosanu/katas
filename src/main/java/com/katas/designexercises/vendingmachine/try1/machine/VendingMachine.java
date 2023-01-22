package com.katas.designexercises.vendingmachine.try1.machine;

import com.katas.designexercises.vendingmachine.try1.currency.Money;

import java.util.List;

public interface VendingMachine {

    void stockItem(String item, String amount);

    void stockChange(String amount);

    List<Money> cancelPurchase();

    void startPurchase();

    void addMoney(String amount);

    void selectItem(String item);


}
