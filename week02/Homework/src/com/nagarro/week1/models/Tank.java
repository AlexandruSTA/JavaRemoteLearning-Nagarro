package com.nagarro.week1.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Alexandru-Ioan Stanea
 * @version: 1.0
 * Designed and implemented Java class to simulate the operations of a stack
 */

public class Tank<T> {
    private final int MAX_NUMBER_OF_ITEMS = 100;
    private List<T> items;

    public Tank() {
        this.items = new ArrayList<>();
    }

    public Tank(T[] items) {
        this.items = new ArrayList<T>(List.of(items));
    }


    public int getCurrentSize() {
        return items.size();
    }


    public void push(T item) throws IllegalStateException {
        if (getCurrentSize() >= MAX_NUMBER_OF_ITEMS) throw new IndexOutOfBoundsException("Tank is full!");
        this.items.add(item);
    }

    public T pop() throws IllegalStateException {
        try {
            T extractedElement = items.remove(getCurrentSize()-1);
            if (getCurrentSize() < 0) {
                throw new IndexOutOfBoundsException("The current size of the tank is 0!");
            }
            return extractedElement;
        } catch (Exception exc) {
            throw new IndexOutOfBoundsException("The current size of the tank is 0!");
        }
    }

    public void cleanup() {
        this.items = null;
    }

    @Override
    public String toString() {
        StringBuilder itemsStringRepresentation = new StringBuilder("========================Items details========================\n");
        for (T item: items) {
            if (item != null) {
                itemsStringRepresentation.append(item).append("\n");
            }
        }
        return itemsStringRepresentation.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            if (items != null) {
                cleanup();
            }
        } catch (Exception exc) {
            throw new Throwable("Error while cleaning up the memory");
        }
        finally{
            super.finalize();
        }

    }
}
