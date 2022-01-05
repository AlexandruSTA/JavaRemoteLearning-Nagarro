package com.nagarro.week2.thirdProblem.models;

import com.nagarro.week2.thirdProblem.services.ISong;

public abstract class MusicPlayer implements ISong {
    protected Playlist playlist;

    public MusicPlayer(Playlist playlist) {
        this.playlist = playlist;
    }

    @Override
    public void addSong(Song song) {
        playlist.addSong(song);
    }

    @Override
    public void removeSong(Song song) {
        playlist.removeSong(song);
    }

    @Override
    public String toString() {
        return playlist.toString();
    }
}
