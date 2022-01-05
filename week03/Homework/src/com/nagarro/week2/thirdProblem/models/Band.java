package com.nagarro.week2.thirdProblem.models;

import com.nagarro.week2.thirdProblem.services.IBand;
import com.nagarro.week2.thirdProblem.services.ISong;

import java.util.ArrayList;
import java.util.List;

public class Band implements ISong, IBand {
    private final List<Song> songs;
    private final List<Guitarist> guitarists;
    private final String name;
    private Drummer drummer;

    public Band(String name) {
        this.songs = new ArrayList<>();
        this.guitarists = new ArrayList<>();
        this.name = name;
        this.drummer = new Drummer();
    }

    @Override
    public void addGuitarist(Guitarist guitarist) {
        guitarists.add(guitarist);
    }

    @Override
    public void removeGuitarist(Guitarist guitarist) {
        guitarists.remove(guitarist);
    }

    @Override
    public void addSong(Song song) {
        songs.add(song);
    }

    @Override
    public void removeSong(Song song) {
        songs.remove(song);
    }

    public void setDrummer(Drummer drummer) {
        this.drummer = drummer;
    }
    

    @Override
    public String toString() {
        String bandInformation = "==================BAND INFORMATION==================\n";
        bandInformation += "Name: " + name + "\n";
        bandInformation += "Guitarists: \n";
        for (Guitarist guitarist : guitarists) {
            bandInformation += " " + guitarist + "\n";
        }
        bandInformation += "Drummer: \n " + drummer + "\n";
        bandInformation += "Songs: \n";
        for (Song song : songs) {
            bandInformation += " " + song + "\n";
        }

        return bandInformation;

    }


}
