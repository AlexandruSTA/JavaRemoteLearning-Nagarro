package com.nagarro.ju.problem1;

import com.nagarro.ju.problem1.collections.MyCollectionImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class App {
    public static void main(String[] args) {
        stringCollectionManagement();
        integerCollectionManagement();
    }

    public static void stringCollectionManagement() {
        System.out.println("\n========================================String Collection Management========================================");
        MyCollectionImpl<String> stringCollection = new MyCollectionImpl<>();
        Collection<String> strings = new ArrayList<>(Arrays.asList("What", "a", "beautiful", "day", "!"));
        System.out.println("External collection of String content ===> " + strings);
        System.out.println("addAll Strings operation status ===> " + stringCollection.addAll(strings));
        System.out.println("Collection of String content ===> " + stringCollection.getCollection());
        System.out.println("addAll Strings operation status ===> " + stringCollection.addAll(strings));
        System.out.println("Collection of String content ===> " + stringCollection.getCollection());
        System.out.println("containsAll Strings operation status ===> " + stringCollection.containsAll(strings));
        strings.add("Definitely!");
        System.out.println("Updated external collection of Strings ===> " + strings);
        System.out.println("containsAll Strings operation status ===> " + stringCollection.containsAll(strings));
        System.out.println("===========================================================================================================\n");
    }

    public static void integerCollectionManagement() {
        System.out.println("\n========================================Integer Collection Management========================================");
        MyCollectionImpl<Integer> integerCollection = new MyCollectionImpl<>();
        Collection<Integer> integers = new ArrayList<>(Arrays.asList(528, 491, 3, 14));
        System.out.println("External collection of Integer content ===> " + integers);
        System.out.println("addAll Integers operation status ===> " + integerCollection.addAll(integers));
        System.out.println("Collection of Integer content ===> " + integerCollection.getCollection());
        System.out.println("addAll Integers operation status ===> " + integerCollection.addAll(integers));
        System.out.println("Collection of Integers content ===> " + integerCollection.getCollection());
        System.out.println("containsAll Integers operation status ===> " + integerCollection.containsAll(integers));
        integers.add(42);
        System.out.println("Updated external collection of Integers ===> " + integers);
        System.out.println("containsAll Integers operation status ===> " + integerCollection.containsAll(integers));
        System.out.println("=============================================================================================================\n");
    }

}
