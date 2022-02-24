package com.nagarro;

import com.nagarro.ju.StringList;

public class App {
    public static void main(String[] args) {
        StringList stringList = new StringList();
        stringList.add("10");
        System.out.println("Size of stringList: " +stringList.size());
        stringList.add("10");
        System.out.println("Size of stringList: " +stringList.size());
        System.out.println(stringList.get(0));
        System.out.println(stringList.get(1));
        System.out.println(stringList.size());

        System.out.println(stringList.displayOperations());
    }
}
