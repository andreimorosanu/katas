package com.katas.algo.sorting;

import com.katas.utils.annotations.Contract;

public class NaiveSort implements SortingAlgorithm<Integer> {

    @Override
    @Contract(message = "Mutates the given input")
    public void sort(Integer[] input) {

        boolean swaped = true;
        while (swaped) {
            swaped = false;

            for (int i = 0; i < input.length - 1; i++) {
                if (input[i] > input[i + 1]) {
                    swaped = true;
                    swap(input, i, i + 1);
                }
            }

        }

    }

    private void swap(Integer[] input, int i, int j) {
        Integer aux = input[i];
        input[i] = input[j];
        input[j] = aux;
    }
}
