package com.nagarro.ju.problem2.utils;

import org.jetbrains.annotations.NotNull;

public class Sorter<T extends Comparable<? super T>> implements Sortable {
    @Override
    public <T extends Comparable<T>> void bubbleSort(@NotNull final T[] collection) {
        int collectionSize = collection.length;
        for (int i = 0; i < collectionSize; i++) {
            for (int j = 0; j < collectionSize - i - 1; j++) {
                if (collection[j].compareTo(collection[j + 1]) > 0) {
                    swap(collection, j);
                }
            }
        }
    }

    private <T extends Comparable<T>> void swap(T[] collection, int j) {
        T aux = collection[j];
        collection[j] = collection[j + 1];
        collection[j + 1] = aux;
    }
}
