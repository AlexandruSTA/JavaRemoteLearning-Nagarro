package com.nagarro.ju.problem3.services;

import java.util.List;

public interface PriorityQueueOperations<E extends Comparable<E>> {
    void insert(E element);
    E remove();
    void clear();
    E head();
    boolean isEmpty();
    List<E> sort(List<E> list);
}
