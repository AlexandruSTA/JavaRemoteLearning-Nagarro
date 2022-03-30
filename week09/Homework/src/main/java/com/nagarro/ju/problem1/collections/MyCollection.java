package com.nagarro.ju.problem1.collections;

import java.util.Collection;

public interface MyCollection<T> {
    public boolean containsAll(Collection<T> collection);

    public boolean addAll(Collection<T> collection);
}
