package com.katas.designexercises.vendingmachine.try1.inventory;


import com.katas.designexercises.vendingmachine.try1.currency.Money;

public class Item {

    private String name;
    private Money pricePerUnit;

    public Item(String name) {

        this.name = name;
    }

    public Item(String name, Money pricePerUnit) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Money pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}
