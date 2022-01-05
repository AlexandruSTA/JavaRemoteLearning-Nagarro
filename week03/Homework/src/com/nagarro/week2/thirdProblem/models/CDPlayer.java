package com.nagarro.week2.thirdProblem.models;

public class CDPlayer extends MusicPlayer {
    public CDPlayer(Playlist playlist) {
        super(playlist);
    }

    @Override
    public String toString() {
        return "CD PLAYER\n" + super.toString();
    }
}
