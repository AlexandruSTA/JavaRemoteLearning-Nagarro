package com.nagarro.ju.problem3;

import com.nagarro.ju.problem3.models.GenericPriorityQueue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class GenericPriorityQueueTest {
    GenericPriorityQueue<Integer> integerPriorityQueue;
    GenericPriorityQueue<String> stringPriorityQueue;
    List<Integer> numbers;
    List<String> strings;

    @BeforeEach
    public void initialize() {
        integerPriorityQueue = new GenericPriorityQueue<>();
        stringPriorityQueue = new GenericPriorityQueue<>();
        numbers = new ArrayList<>(List.of(15, 23, 24, 123, 232, 10, 1, 1, 100, -1));
        strings = new ArrayList<>(List.of("abc", "aab", "def", "a"));
    }

    @Test
    public void testNumbersContent() {
        Assertions.assertArrayEquals(new Integer[]{15, 23, 24, 123, 232, 10, 1, 1, 100, -1}, numbers.toArray());
    }

    @Test
    public void testStringsContent() {
        Assertions.assertArrayEquals(new String[]{"abc", "aab", "def", "a"}, strings.toArray());
    }

    @Test
    public void testPriorityQueueInsert() {
        Assertions.assertTrue(integerPriorityQueue.isEmpty());
        Assertions.assertTrue(stringPriorityQueue.isEmpty());
        integerPriorityQueue.insert(10);
        stringPriorityQueue.insert("a");
        Assertions.assertTrue(!integerPriorityQueue.isEmpty());
        Assertions.assertTrue(!stringPriorityQueue.isEmpty());
    }

    @Test
    public void testPriorityQueueRemove() {
        integerPriorityQueue.insert(10);
        stringPriorityQueue.insert("a");
        Assertions.assertEquals(10, integerPriorityQueue.remove());
        Assertions.assertEquals("a", stringPriorityQueue.remove());
    }

    @Test
    public void testEmptyPriorityQueueRemove() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            integerPriorityQueue.remove();
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            stringPriorityQueue.remove();
        });
    }

    @Test
    public void testPriorityQueueClear() {
        integerPriorityQueue.insert(10);
        integerPriorityQueue.insert(12);
        Assertions.assertTrue(!integerPriorityQueue.isEmpty());
        integerPriorityQueue.clear();
        Assertions.assertTrue(integerPriorityQueue.isEmpty());

        stringPriorityQueue.insert("a");
        stringPriorityQueue.insert("b");
        Assertions.assertTrue(!stringPriorityQueue.isEmpty());
        stringPriorityQueue.clear();
        Assertions.assertTrue(stringPriorityQueue.isEmpty());
    }

    @Test
    public void testEmptyPriorityQueueClear() {
        Assertions.assertDoesNotThrow(() -> {
            integerPriorityQueue.clear();
            stringPriorityQueue.clear();
        });
    }

    @Test
    public void testPriorityQueueHead() {
        integerPriorityQueue.insert(10);
        Assertions.assertEquals(10, integerPriorityQueue.head());
        Assertions.assertTrue(!integerPriorityQueue.isEmpty());

        stringPriorityQueue.insert("a");
        Assertions.assertEquals("a", stringPriorityQueue.head());
        Assertions.assertTrue(!stringPriorityQueue.isEmpty());
    }

    @Test
    public void testEmptyPriorityQueueHead() {
        Assertions.assertDoesNotThrow(() -> {
            integerPriorityQueue.head();
        });

        Assertions.assertDoesNotThrow(() -> {
            stringPriorityQueue.head();
        });
    }

    @Test
    public void testPriorityQueueSort() {
        List<Integer> sortedNumbers = integerPriorityQueue.sort(numbers);
        Assertions.assertArrayEquals(List.of(232, 123, 100, 24, 23, 15, 10, 1, 1, -1).toArray(), sortedNumbers.toArray());
        List<String> sortedStrings = stringPriorityQueue.sort(strings);
        Assertions.assertArrayEquals(List.of("def", "abc", "aab", "a").toArray(), sortedStrings.toArray());
    }

}
