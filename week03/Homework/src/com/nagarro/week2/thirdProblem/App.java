package com.nagarro.week2.thirdProblem;

import com.nagarro.week2.thirdProblem.models.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) {
        playMusic();
    }

    public static void playMusic() {
        Playlist retroPlaylist = new Playlist("Retro Playlist", Genre.Retro);
        Playlist jazzPlaylist = new Playlist("Jazz Playlist", Genre.Jazz);

        Song firstSong = new Song("First Song", "RetroBand", LocalDate.of(2020, 1, 1), LocalTime.of(0, 3, 25));
        Song secondSong = new Song("Second Song", "RetroBand", LocalDate.of(2021, 3, 15), LocalTime.of(0, 2, 15));
        Song thirdSong = new Song("Third Song", "RetroBand", LocalDate.of(2021, 4, 25), LocalTime.of(0, 3, 44));

        Guitar leadGuitar = new Guitar(Manufacturer.Guild);
        Guitar rhytmGuitar = new Guitar(Manufacturer.Seagull);
        Guitar bassGuitar = new Guitar(Manufacturer.Yamaha);

        Guitarist leadGuitarist = new LeadGuitarist("Miguel", 10, leadGuitar);
        Guitarist rhytmGuitarist = new RhytmGuitarist("Angel", 20, rhytmGuitar);
        Guitarist bassGuitarist = new BassGuitarist("Esteban", 30, bassGuitar);

        Drumset drumset = new Drumset("A set of drums, cymbals, and other percussion instruments");

        Drummer drummer = new Drummer("Julio", drumset);

        Band band = new Band("RetroBand");
        band.addGuitarist(leadGuitarist);
        band.addGuitarist(rhytmGuitarist);
        band.addGuitarist(bassGuitarist);
        band.setDrummer(drummer);
        band.addSong(firstSong);
        band.addSong(firstSong);
        band.addSong(secondSong);
        System.out.println(band);
        band.removeGuitarist(bassGuitarist);
        System.out.println(band);

        MusicPlayer cdPlayer = new CDPlayer(retroPlaylist);
        MusicPlayer iPod = new IPod(jazzPlaylist);

        cdPlayer.addSong(firstSong);
        cdPlayer.addSong(secondSong);
        cdPlayer.addSong(thirdSong);
        System.out.println(cdPlayer);
        cdPlayer.removeSong(firstSong);
        System.out.println(cdPlayer);

        iPod.addSong(firstSong);
        iPod.addSong(secondSong);
        iPod.addSong(thirdSong);
        System.out.println(iPod);
        iPod.removeSong(thirdSong);
        System.out.println(iPod);

    }
}
