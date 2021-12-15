package com.nagarro.week1.models;

import java.lang.reflect.Array;

/**
 * @author: Alexandru-Ioan Stanea
 * @version: 1.0
 * Designed and implemented Java class to simulate the operations of a stack
 */

public class Tank<T> {
    private final int MAX_NUMBER_OF_ITEMS = 100;
    private T[] items;
    private int currentSize;

    public Tank(Class<T> classType) {
        this.items = (T[]) Array.newInstance(classType, MAX_NUMBER_OF_ITEMS);
    }

    public Tank(T[] items) {
        this.currentSize = items.length;
        this.items = items;
    }


    public int getCurrentSize() {
        return currentSize;
    }


    public void push(T item) throws IndexOutOfBoundsException {
        if (this.currentSize >= MAX_NUMBER_OF_ITEMS) throw new IndexOutOfBoundsException("Tank is full!");
        this.items[this.currentSize++] = item;
    }

    public T pop() throws IndexOutOfBoundsException {
        try {
            T extractedElement = items[this.currentSize - 1];
            items[this.currentSize - 1] = null;
            this.currentSize--;
            if (this.currentSize < 0) {
                throw new IndexOutOfBoundsException("The current size of the tank is 0!");
            }
            return extractedElement;
        } catch (Exception exc) {
            throw new IndexOutOfBoundsException("The current size of the tank is 0!");
        }
    }

    public void clearMemory() {
        this.items = null;
        this.currentSize = 0;
    }

    @Override
    public String toString() {
        String itemsStringRepresentation = "========================Items details========================\n";
        for (int itemIndex = 0; itemIndex < this.currentSize; itemIndex++) {
            if (items[itemIndex] != null) {
                itemsStringRepresentation += (itemIndex + 1) + "." + items[itemIndex].toString() + "\n";
            }
        }
        return itemsStringRepresentation;
    }

    @Override
    public void finalize() throws Throwable {
        try {
            super.finalize();
            if (items != null) {
                clearMemory();
            }
        } catch (Exception exc) {
            throw new Throwable("Error while cleaning up the memory");
        }

    }
}
