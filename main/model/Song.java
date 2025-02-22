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
    
    public boolean getFavorite() {
    	return favorite;
    }
    
    public void rateSong() {
    	System.out.println("Please choose a rating 1 through 5.");
    	Scanner scanner = new Scanner(System.in);
    	int userRating = scanner.nextInt();
    	while (userRating < 1 || userRating > 5) {
    		System.out.println("Invalid input. Please choose a rating 1 through 5.");
        	userRating = scanner.nextInt();
    	}
    	scanner.close();
    	this.rating = userRating;
    	this.favorite = (userRating == 5);
    }
    
    public void markAsFavorite() {
    	this.favorite = true;
    }
    
    public void removeFavorite() {
    	this.favorite = false;
    }
    
    public void printAllDetails() {
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Album: " + album);
    }

}
