package com.katas.designexercises.vendingmachine.try1.machine.payment;

import com.katas.designexercises.vendingmachine.try1.currency.Money;

import java.util.ArrayList;
import java.util.List;

import static com.katas.designexercises.vendingmachine.try1.currency.Money.from;

public class ChangeCalculator {

    public List<Money> getChange(Money itemPrice, List<Money> loadedChangeForPurchase, List<Money> availableChange) {

        Money remainingAmount = loadedChangeForPurchase.stream().reduce(from("0"), Money::add);
        remainingAmount = remainingAmount.subtract(itemPrice);

        List<Money> allChange = List.copyOf(availableChange);
        allChange.addAll(loadedChangeForPurchase);
        loadedChangeForPurchase.clear();

        List<Money> change = new ArrayList<>();
        while (true) {

            if (remainingAmount.isZero()) {
                break;
            }

            boolean foundChange = false;


        }

        return change;
    }
}
