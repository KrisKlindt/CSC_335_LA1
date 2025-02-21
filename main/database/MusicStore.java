package database;

import java.util.ArrayList;

import model.Album;
import model.Song;

public class MusicStore {
	private ArrayList<Album> albums;
	
	public MusicStore() {
		this.albums = new ArrayList<Album>();
		
		// open albums.txt and create albums/songs from it
	}
	
	public void searchSongByTitle(String title) {
		ArrayList<Song> songList = new ArrayList<Song>();
		for (Album album : albums) {
			ArrayList<Song> songs = album.searchByTitle(title);
			songList.addAll(songs);
		}
		
		if (songList.size() == 0) {
			System.out.println("This song title is not in the music store");
		}
		else {
			for (Song song: songList) {
				song.printAllDetails();
				System.out.println(); // so there is a space between each song
			}
		}
	}
	
	public void searchSongByArtist(String artist) {
		ArrayList<Song> songList = new ArrayList<Song>();
		for (Album album : albums) {
			if (album.getArtist().equalsIgnoreCase(artist)) {
				ArrayList<Song> songs = album.getAlbum();
				songList.addAll(songs);
			}
		}
		
		if (songList.size() == 0) {
			System.out.println("This song artist is not in the music store");
		}
		else {
			for (Song song: songList) {
				song.printAllDetails();
				System.out.println(); // so there is a space between each song
			}
		}
	}
	
	public void searchAlbumByTitle(String title) {
		ArrayList<Album> albumList = new ArrayList<Album>();
		for (Album album : albums) {
			if (album.getArtist().equalsIgnoreCase(title)) {
				albumList.add(album);
			}
		}
		
		if (albumList.size() == 0) {
			System.out.println("This album title is not in the music store");
		}
		else {
			for (Album alb: albumList) {
				alb.printAlbumDetails();
				System.out.println(); // so there is a space between each album
			}
		}
	}
	
	public void searchAlbumByArtist(String artist) {
		ArrayList<Album> albumList = new ArrayList<Album>();
		for (Album album : albums) {
			if (album.getArtist().equalsIgnoreCase(artist)) {
				albumList.add(album);
			}
		}
		
		if (albumList.size() == 0) {
			System.out.println("This album artist is not in the music store");
		}
		else {
			for (Album alb : albums) {
				alb.printAlbumDetails();
				System.out.println(); // so there is a space between each album
			}
		}
	}
}
