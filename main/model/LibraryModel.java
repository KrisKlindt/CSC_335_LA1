package model;

import java.util.ArrayList;
import java.util.Scanner;

import database.MusicStore;

public class LibraryModel {
	ArrayList<Song> songs;
	ArrayList<Album> albums;
	ArrayList<PlayList> playLists;
	MusicStore mStore = new MusicStore();
	
	public LibraryModel() {
		this.albums = new ArrayList<Album>();
		this.playLists = new ArrayList<PlayList>();
		this.songs = new ArrayList<Song>();
	}
	
	public void createPlayList(String title) {
		PlayList playlist = new PlayList(title);
		playLists.add(playlist);
	}
	
	public void addSong(String title) {
		ArrayList<Song> song = mStore.searchSongByTitle(title, false);
		if (song.size() == 0) {
			System.out.println("This song title is not in the music store, cannot add to library");
		}
		else {
			if (song.size() == 1) {
				songs.addAll(song);
			}
			else {
				System.out.println("There are multiple songs with this name");
				for (Song s: song) {
					s.printAllDetails();
				}
				System.out.println("Would you like to add all songs? (yes or no)");
				Scanner scanner = new Scanner(System.in);
		    	String choice = scanner.nextLine();
		    	
		    	if(choice.equalsIgnoreCase("yes")) {
		    		songs.addAll(song);
		    	}
		    	else {
		    		System.out.println("Which artist's song would you like to add?");
		    		String artistName = scanner.nextLine();
		    		boolean flag = false;
		    		for (Song s: song) {
		    			if(s.getArtist().equalsIgnoreCase(artistName)){
		    				songs.add(s);
		    				flag = true;
		    				break;
		    			}
		    		}
		    		if(flag == false) {
		    			System.out.println("None of the chosen songs were written by this artist");
		    		}
		    	}
		    	
		    	scanner.close();
			}
		}
	}
	
	public void addAlbum(String title) {
		ArrayList<Album> alb = mStore.searchAlbumByTitle(title, false);
		if (alb.size() == 0) {
			System.out.println("This album title is not in the music store, cannot add to library");
		}
		else {
			if (alb.size() == 1) {
				albums.addAll(alb);
			}
			else {
				System.out.println("There are multiple albums with this name");
				for (Album a: alb) {
					a.printAlbumDetails();
				}
				System.out.println("Would you like to add all albums? (yes or no)");
				Scanner scanner = new Scanner(System.in);
		    	String choice = scanner.nextLine();
		    	
		    	if(choice.equalsIgnoreCase("yes")) {
		    		albums.addAll(alb);
		    	}
		    	else {
		    		System.out.println("Which artist's album would you like to add?");
		    		String artistName = scanner.nextLine();
		    		boolean flag = false;
		    		for (Album a : alb) {
		    			if(a.getArtist().equalsIgnoreCase(artistName)){
		    				albums.add(a);
		    				flag = true;
		    				break;
		    			}
		    		}
		    		if(flag == false) {
		    			System.out.println("None of the chosen albums were written by this artist");
		    		}
		    	}
		    	
		    	scanner.close();
			}
		}
	}
	
	public void searchPlayList(String title) {
		boolean flag = false;
		for (PlayList p : playLists) {
			if (p.getTitle().equalsIgnoreCase(title)) {
				p.printPlaylist();
				flag = true;
			}
		}
		
		if (flag == false) {
			System.out.println("There is no playlist in the library with this name");
		}
	}
	
	public ArrayList<Song> searchSongByTitle(String title) {
		ArrayList<Song> songList = new ArrayList<Song>();
		for (Album album : albums) {
			ArrayList<Song> songs = album.searchByTitle(title);
			songList.addAll(songs);
		}
		
		if (songList.size() == 0) {
			System.out.println("This song title is not in the library");
		}
		else {
			for (Song song: songList) {
				song.printAllDetails();
				System.out.println(); // so there is a space between each song
			}
		}
		
		return songList;
	}
	
	public ArrayList<Song> searchSongByArtist(String artist) {
		ArrayList<Song> songList = new ArrayList<Song>();
		for (Album album : albums) {
			if (album.getArtist().equalsIgnoreCase(artist)) {
				ArrayList<Song> songs = album.getAlbum();
				songList.addAll(songs);
			}
		}
		
		if (songList.size() == 0) {
			System.out.println("This song artist is not in the library");
		}
		else {
			for (Song song: songList) {
				song.printAllDetails();
				System.out.println(); // so there is a space between each song
			}
		}
		
		return songList;
	}
	
	public ArrayList<Album> searchAlbumByTitle(String title) {
		ArrayList<Album> albumList = new ArrayList<Album>();
		for (Album album : albums) {
			if (album.getTitle().equalsIgnoreCase(title)) {
				albumList.add(album);
			}
		}
		
		if (albumList.size() == 0) {
			System.out.println("This album title is not in the library");
		}
		else {
			for (Album alb: albumList) {
				alb.printAlbumDetails();
				System.out.println(); // so there is a space between each album
			}
		}
		
		return albumList;
	}
	
	public ArrayList<Album> searchAlbumByArtist(String artist) {
		ArrayList<Album> albumList = new ArrayList<Album>();
		for (Album album : albums) {
			if (album.getArtist().equalsIgnoreCase(artist)) {
				albumList.add(album);
			}
		}
		
		if (albumList.size() == 0) {
			System.out.println("This album artist is not in the library");
		}
		else {
			for (Album alb : albums) {
				alb.printAlbumDetails();
				System.out.println(); // so there is a space between each album
			}
		}
		
		return albumList;
	}
	
	// These 4 methods are so that there is not a need to make a MusicStore object
	// in both LibraryModel and View
	
	public ArrayList<Song> mS_SearchSongByTitle(String title){
		ArrayList<Song> s = mStore.searchSongByTitle(title, true);
		return s;
	}
	
	public ArrayList<Song> mS_SearchSongByArtist(String artist){
		ArrayList<Song> s = mStore.searchSongByArtist(artist, true);
		return s;
	}
	
	public ArrayList<Album> mS_SearchAlbumByTitle(String title){
		ArrayList<Album> albs = mStore.searchAlbumByTitle(title, true);
		return albs;
	}
	
	public ArrayList<Album> mS_SearchAlbumByArtist(String artist){
		ArrayList<Album> albs = mStore.searchAlbumByArtist(artist, true);
		return albs;
	}
}
