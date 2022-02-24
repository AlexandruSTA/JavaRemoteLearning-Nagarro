package com.nagarro.models;

public class Student extends Person{
    private int universityId;
    public Student(String name, int age, String email) {
        super(name, age, email);
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }
}
