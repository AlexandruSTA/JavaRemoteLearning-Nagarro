package com.nagarro.week2.thirdProblem.models;

import com.nagarro.week2.thirdProblem.services.ISong;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements ISong {
    private final String name;
    private final Genre genre;
    private final List<Song> songs = new ArrayList<>();

    public Playlist(String name, Genre genre) {
        this.name = name;
        this.genre = genre;
    }

    @Override
    public void addSong(Song song) {
        songs.add(song);
    }

    @Override
    public void removeSong(Song song) {
        songs.remove(song);
    }

    @Override
    public String toString() {
        String playlistInformation = "==================PLAYLIST INFORMATION==================\n";
        playlistInformation += "Name: " + name + "\n";
        playlistInformation += "Genre: " + genre + "\n";
        playlistInformation += "Songs: \n";
        for (Song song : songs) {
            playlistInformation += " " + song + "\n";
        }
        return playlistInformation;
    }
}
