package com.katas.designexercises.vendingmachine.try1.machine;

public interface VendingMachine {

    void stockItem(String item, String amount);

    void stockChange(String amount);

    void cancelPurchase();

    void startPurchase();

    void addMoney(String amount);

    void selectItem(String item);


}
