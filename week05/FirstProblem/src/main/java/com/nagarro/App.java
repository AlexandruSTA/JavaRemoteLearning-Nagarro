package com.nagarro;

import com.nagarro.exceptions.IllegalNumberOfStudentsException;
import com.nagarro.models.Rank;
import com.nagarro.models.Student;
import com.nagarro.models.University;

public class App {
    public static void main(String[] args) {

        try {
            University university = new University(1, "Babes-Bolyai", Rank.Top, 95, 100);
            System.out.println(university);
            Student student = new Student("John Doe", 22, "john.doe@gmail.com");
            university.addStudent(student);
            System.out.println(university);
            university.addStudent(student);
            university.addStudent(student);
            university.addStudent(student);
            university.addStudent(student);
            System.out.println(university);
            university.addStudent(student);
            System.out.println(university);
            university.addStudent(student);
        } catch (IllegalNumberOfStudentsException exception) {
            System.out.println(exception.getMessage());
        }

    }

}
