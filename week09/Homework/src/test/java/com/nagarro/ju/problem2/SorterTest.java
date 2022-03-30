package com.nagarro.ju.problem2;

import com.nagarro.ju.problem2.utils.Sorter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class SorterTest {
    private Integer[] numbers;
    private String[] strings;
    private Sorter sorter = new Sorter();

    @BeforeEach
    public void initialize() {
        numbers = new Integer[]{15, 2, 3, 2};
        strings = new String[]{"ab", "a", ""};
    }

    @Test
    public void testNumbersContent() {
        Assertions.assertArrayEquals(new Integer[]{15, 2, 3, 2}, numbers);
    }

    @Test
    public void testStringsContent() {
        Assertions.assertArrayEquals(new String[]{"ab", "a", ""}, strings);
    }

    @Test
    public void testBubbleSortInteger() {
        sorter.bubbleSort(numbers);
        Assertions.assertArrayEquals(new Integer[]{2, 2, 3, 15}, numbers);
    }

    @Test
    public void testBubbleSortString() {
        sorter.bubbleSort(strings);
        Assertions.assertArrayEquals(new String[]{"", "a", "ab"}, strings);
    }

    @Test
    public void testBubbleSortNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            sorter.bubbleSort(null);
        });
    }

    @Test
    public void testBubbleSortIntegerWithNullElement() {
        numbers[0] = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            sorter.bubbleSort(numbers);
        });
    }

    @Test
    public void testBubbleSortStringWithNullElement() {
        strings[0] = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            sorter.bubbleSort(strings);
        });
    }
}
