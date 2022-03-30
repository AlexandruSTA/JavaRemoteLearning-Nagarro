package com.nagarro.ju.problem2.utils;

public interface Sortable {
    public <T extends Comparable<T>> void bubbleSort(T[] collection);
}
