package com.nagarro.ju.problem3.models;

import com.nagarro.ju.problem3.services.PriorityQueueOperations;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class GenericPriorityQueue<E extends Comparable<E>> implements Comparable<GenericPriorityQueue<E>>, PriorityQueueOperations<E> {
    private static final int MAX_SIZE = 10000;
    private E[] elements;
    private int size;

    public GenericPriorityQueue() {
        this.elements = (E[]) new Comparable[MAX_SIZE];
        this.size = 0;
    }

    public GenericPriorityQueue(int maxSize) {
        this.elements = (E[]) new Comparable[maxSize];
        this.size = 0;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    public void swap(E[] elements, int i, int j) {
        E aux = elements[i];
        elements[i] = elements[j];
        elements[j] = aux;
    }

    public void maxHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;

        if (left <= size && elements[left].compareTo(elements[largest]) > 0) {
            largest = left;
        }
        if (right <= size && elements[right].compareTo(elements[largest]) > 0) {
            largest = right;
        }
        if (largest != i) {
            swap(elements, i, largest);
            maxHeapify(largest);
        }
    }

    @Override
    public void insert(E element) {
        if (size >= MAX_SIZE) {
            throw new RuntimeException("Priority Queue is full!");
        }
        elements[size++] = element;
        int i = size - 1;
        while (i != 0 && elements[parent(i)].compareTo(elements[i]) < 0) {
            swap(elements, i, parent(i));
            i = parent(i);
        }
    }

    @Override
    public E remove() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("Empty priority queue!");
        }
        E maxItem = elements[0];
        elements[0] = elements[size - 1];
        size--;
        maxHeapify(0);
        return maxItem;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    @Override
    public E head() {
        return elements[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int compareTo(@NotNull GenericPriorityQueue<E> priorityQueue) {
        return Integer.compare(this.size, priorityQueue.size);
    }

    @Override
    public List<E> sort(List<E> list) {
        List<E> sortedList = new ArrayList<>();
        GenericPriorityQueue<E> priorityQueue = new GenericPriorityQueue<>(list.size());
        for (E element : list) {
            priorityQueue.insert(element);
        }
        while (!priorityQueue.isEmpty()) {
            sortedList.add(priorityQueue.remove());
        }
        return sortedList;
    }

    public void printQueue() {
        System.out.println("==================QUEUE CONTENT==================");
        for (int i = 0; i < size; i++) {
            System.out.print("Element:" + elements[i] + "; ");
        }
        System.out.println("\n======================================================");
    }
}
