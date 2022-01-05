package com.nagarro.week2.thirdProblem.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Song {
    private final String title;
    private final LocalDate releaseDate;
    private final LocalTime elapsedTime;
    private final String author;

    public Song(String title, String author, LocalDate releaseDate, LocalTime elapsedTime) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.elapsedTime = elapsedTime;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Release date: " + releaseDate + ", Elapsed time: " + elapsedTime;
    }
}
