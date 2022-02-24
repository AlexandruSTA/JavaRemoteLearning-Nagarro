package com.nagarro.models;

import com.nagarro.exceptions.IllegalNumberOfStudentsException;

import java.util.ArrayList;
import java.util.List;

public class University {
    private final int id;
    private final String name;
    private final Rank rank;
    private final List<Student> students = new ArrayList<>();
    private final int maximumNumberOfStudents;
    private int numberOfStudents;

    public University(int id, String name, Rank rank, int numberOfStudents, int maximumNumberOfStudents) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.numberOfStudents = numberOfStudents;
        this.maximumNumberOfStudents = maximumNumberOfStudents;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Rank getRank() {
        return rank;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public int getMaximumNumberOfStudents() {
        return maximumNumberOfStudents;
    }

    public void addStudent(Student student) {
        numberOfStudents++;
        boolean maximumNumberOfStudentsReached = isStudentCapacityReached();
        if (maximumNumberOfStudentsReached) {
            throw new IllegalNumberOfStudentsException("Maximum number of students for this university reached!");
        }
        student.setUniversityId(getId());
        this.students.add(student);
    }

    private boolean isStudentCapacityReached() {
        return getNumberOfStudents() > getMaximumNumberOfStudents();
    }

    @Override
    public String toString() {
        return "University Details:\nName: " + name + "; Rank: " + rank + "; Number of students:" + numberOfStudents + "\n";
    }
}
