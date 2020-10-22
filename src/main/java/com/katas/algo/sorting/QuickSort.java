package com.katas.algo.sorting;

public class QuickSort implements SortingAlgorithm<Integer> {


    @Override
    public void sort(Integer[] input) {
        quickSort(input, 0, input.length - 1);
    }

    private void quickSort(Integer[] input, int low, int high) {

        if (low < high) {
            int partitionPivot = partition(input, low, high);

            quickSort(input, low, partitionPivot - 1);
            quickSort(input, partitionPivot + 1, high);
        }
    }

    private int partition(Integer[] input, int low, int high) {
        int pivot = input[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (input[j] < pivot) {
                i++;
                swap(input, i, j);
            }
        }

        swap(input, i + 1, high);
        return i + 1;
    }

    private void swap(Integer[] input, int i, int j) {
        Integer aux = input[i];
        input[i] = input[j];
        input[j] = aux;
    }

}
