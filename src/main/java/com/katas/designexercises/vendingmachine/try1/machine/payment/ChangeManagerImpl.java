package com.katas.designexercises.vendingmachine.try1.machine.payment;

import com.katas.designexercises.vendingmachine.try1.currency.Money;
import com.katas.designexercises.vendingmachine.try1.inventory.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.katas.designexercises.vendingmachine.try1.currency.Money.from;

public class ChangeManagerImpl implements ChangeManager {

    private static final List<String> validCoins = Arrays.asList("0.25", "0.50", "1.00", "2.00", "5.00");

    private List<Money> availableChange = new ArrayList<>();
    private List<Money> loadedChangeForPurchase = new ArrayList<>();

    private ChangeCalculator changeCalculator = new ChangeCalculator();

    public ChangeManagerImpl() {

    }

    // TODO: 11/2/2020 change this to money
    @Override
    public void stockChange(String amount) {

        if (!validCoins.contains(amount)) {
            throw new MoneyException(MoneyException.Reason.UNEXPECTED_COIN_DENOMINATION);

        }
    }

    @Override
    public void addMoneyForPurchase(String amount) {
        loadedChangeForPurchase.add(from(amount));
    }

    @Override
    public List<Money> cancelBuy() {

        List<Money> monies = List.copyOf(loadedChangeForPurchase);
        loadedChangeForPurchase.clear();

        return monies;

    }

    @Override
    public List<Money> buy(Item desiredItem) {

        Money totalAmount = loadedChangeForPurchase.stream().reduce(from("0"), Money::add);

        if (totalAmount.compareTo(desiredItem.getPricePerUnit()) < 0) {
            throw new MoneyException(MoneyException.Reason.NOT_ENOUGH_MONEY_PAID);
        }

        return changeCalculator.getChange(desiredItem.getPricePerUnit(), loadedChangeForPurchase, availableChange);
    }


    //Visible for testing
    protected List<Money> getAvailableChange() {
        return List.copyOf(availableChange);
    }
}
