package com.katas.algo.sorting;

import com.katas.utils.annotations.Contract;

public class MergeSort implements SortingAlgorithm<Integer> {


    @Override
    @Contract(message = "Mutates the given input")
    public void sort(Integer[] input) {
        int left = 0;
        int right = input.length - 1;
        mergeSort(input, left, right);


    }

    private void mergeSort(Integer[] input, int left, int right) {

        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(input, left, middle);
            mergeSort(input, middle + 1, right);

            merge(input, left, middle, right);
        }
    }

    private void merge(Integer[] input, int left, int middle, int right) {
        int firstArraySize = middle - left + 1;
        int secondArraySize = right - middle;

        Integer[] firstArray = new Integer[firstArraySize];
        Integer[] secondArray = new Integer[secondArraySize];

        for (int i = 0; i < firstArraySize; i++) {
            firstArray[i] = input[left + i];
        }

        for (int i = 0; i < secondArraySize; i++) {
            secondArray[i] = input[middle + i + 1];
        }


        int i = 0;
        int j = 0;

        //initial merge
        int k = left;
        while (i < firstArraySize && j < secondArraySize) {
            if (firstArray[i] <= secondArray[j]) {
                input[k] = firstArray[i];
                i++;
            } else {
                input[k] = secondArray[j];
                j++;
            }
            k++;
        }

        copyRemainigValuesFromArray(input, firstArraySize, firstArray, i, k);
        copyRemainigValuesFromArray(input, secondArraySize, secondArray, j, k);
    }

    private void copyRemainigValuesFromArray(Integer[] input, int firstArraySize, Integer[] firstArray, int i, int k) {
        while (i < firstArraySize) {
            input[k] = firstArray[i];
            i++;
            k++;
        }
    }
}
