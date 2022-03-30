package com.nagarro.ju.problem1.collections;

import java.util.ArrayList;
import java.util.Collection;

public class MyCollectionImpl<T> implements MyCollection<T> {
    private Collection<T> collection = new ArrayList<T>();

    public Collection<T> getCollection() {
        return collection;
    }

    @Override
    public boolean containsAll(Collection<T> collection) {
        return this.collection.containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<T> collection) {
        return this.collection.addAll(collection);
    }
}
