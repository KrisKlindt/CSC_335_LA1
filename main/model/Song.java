package model;
import java.util.Scanner;

public class Song {
    private String title;
    private String artist;
    private String album;
    private boolean favorite;
    private int rating;

    public Song(String title, String artist, String album) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.favorite = false;
    }

    public String getTitle() {
		return title;
	}
    
    public String getArtist() {
    	return artist;
    }
    
    public String getAlbum() {
    	return album;
    }
    
    public boolean getFavorite() {
    	return favorite;
    }
    
        public void rateSong(int rating) {
    	this.rating = rating;
    	this.favorite = (rating == 5);
    }
    
    public void markAsFavorite() {
    	this.favorite = true;
    }
    
    public void removeFavorite() {
    	this.favorite = false;
    }
    
    public boolean equalTo(Song song2) {
    	return (title.equalsIgnoreCase(song2.getTitle()) && 
    			artist.equalsIgnoreCase(song2.getArtist()) && 
    			album.equalsIgnoreCase(song2.getAlbum()));
    }
    
    public void printAllDetails() {
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Album: " + album);
    }

}
