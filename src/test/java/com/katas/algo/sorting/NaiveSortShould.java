package com.katas.algo.sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class NaiveSortShould {

    private NaiveSort naiveSort = new NaiveSort();

    private static Stream<Arguments> provideArraysForTest() {

        return Stream.of(
                Arguments.of((Object) new Integer[]{44, 12, 566, 1212, 56436, 7233}),
                Arguments.of((Object) new Integer[]{-22, 2, 16, 1212, 36, 36, 36, 0, 55})
        );


    }

    @ParameterizedTest
    @MethodSource("provideArraysForTest")
    public void sortArrayInAscendingOrder(Integer[] inputArray) {

        //setup
        Integer[] sortedByJava = Arrays.copyOf(inputArray, inputArray.length);

        //execute
        naiveSort.sort(inputArray);

        //verify
        Arrays.sort(sortedByJava);
        assertArrayEquals(sortedByJava, inputArray);

    }


}