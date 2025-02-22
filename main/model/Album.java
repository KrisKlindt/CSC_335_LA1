package model;

import java.util.ArrayList;
//import java.util.List;

public class Album {
	private String title;
	private String artist;
	private String year;
	private String genre;
	private ArrayList<Song> songs;

	public Album(String title, String artist, String genre, String year) {
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.year = year;
		this.songs = new ArrayList<>();
	}

	public void addSong(Song song) {
		songs.add(song);
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public ArrayList<Song> getAlbum(){
		ArrayList<Song> alb = new ArrayList<Song>(songs);
		return alb;
	}
	
	public void printTitleAndArtist() {
		System.out.println("Album: " + title);
		System.out.println("Artist: " + artist);
	}

	public void printAlbumDetails() {
		System.out.println("Album: " + title);
		System.out.println("Artist: " + artist);
		System.out.println("Genre: " + genre);
		System.out.println("Year: " + year);
		System.out.println("Songs:");
		for (Song song : songs) {
			System.out.println(" - " + song.getTitle());
		}
	}

	public ArrayList<Song> searchByTitle(String title){
		ArrayList<Song> foundsongs = new ArrayList<Song>();
		// search through each song, return all with the same title if multiple
		// I think the comparison should ignore case, so capitalization doesn't matter
		for (Song song: this.songs) {
			if (song.getTitle().equalsIgnoreCase(title)) {
				foundsongs.add(song);
			}
		}
		return foundsongs;
	}
}
