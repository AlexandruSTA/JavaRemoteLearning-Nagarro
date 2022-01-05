package com.nagarro.week2.thirdProblem.models;

public class IPod extends MusicPlayer {
    public IPod(Playlist playlist) {
        super(playlist);
    }

    @Override
    public String toString() {
        return "IPOD\n" + super.toString();
    }
}
