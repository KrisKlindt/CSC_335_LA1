package model;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
	private String title;
    private List<Song> songs;
    
    public PlayList(String title) {
    	this.title = title;
        this.songs = new ArrayList<>();
    }
    
    public void addSong(Song song) {
        songs.add(song);
    }
    
    public void removeSong(Song song) {
    	songs.remove(song);
    }
    
    public void printPlaylist() {
    	System.out.println(title + ":");
    	for (Song song:songs) {
    		System.out.println(song.getTitle() + " by " + song.getArtist());
    	}
    }
}
