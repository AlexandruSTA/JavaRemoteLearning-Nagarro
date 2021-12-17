package com.nagarro.week1.models;

/**
 * @author: Alexandru-Ioan Stanea
 * @version: 1.0
 * Designed and implemented Java class used to store valuable information regarding an administrator, which extends the User class
 */

public class Administrator extends User {
    {
        System.out.println("Administrator Class Initialization Block");
    }

    public Administrator() {
        System.out.println("Administrator Class Default Constructor Called");
    }


    @Override
    public void adminOperations() {
        System.out.println("adminOperations called in Administrator class");
    }

    static {
        System.out.println("Static block in Administrator");
    }

}
