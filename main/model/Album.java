package model;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String title;
    private String artist;
    private List<Song> songs;

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void printAlbumDetails() {
        System.out.println("Album: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Songs:");
        for (Song song : songs) {
            System.out.println(" - " + song.getTitle());
        }
    }
}
