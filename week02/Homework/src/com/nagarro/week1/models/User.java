package com.nagarro.week1.models;

import java.util.Objects;

/**
 * @author: Alexandru-Ioan Stanea
 * @version: 1.0
 * Designed and implemented Java class used to store valuable information regarding a user
 */

public class User {
    protected int id;
    protected String username;
    static int userCount = 0;
    static final int currentUserId;

    public User() {
        System.out.println("User Class Default Constructor Called");
        this.id = 0;
        this.username = "";
        userCount++;
    }

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    static {
        System.out.println("Static block in User");
        currentUserId = userCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void adminOperations() {
        System.out.println("adminOperations called in User class");
    }

    public void getProductById(int id) {
        System.out.println("Local variable id value ====>" + id);
        System.out.println("Field id value ====>" + this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
