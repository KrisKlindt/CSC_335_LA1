package model;

public class Song {
    private String title;
    private String artist;
    private String album;
    private boolean favorite;

    private Song(String title, String artist, String album) {
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
    
    public void printAllDetails() {
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Album: " + album);
    }

}
