package model;

import java.util.ArrayList;
import java.util.Scanner;

import database.MusicStore;

public class LibraryModel {
	private ArrayList<Song> songs;
	private ArrayList<Album> albums;
	private ArrayList<PlayList> playLists;
	private MusicStore mStore;
	
	public LibraryModel() {
		this.albums = new ArrayList<Album>();
		this.playLists = new ArrayList<PlayList>();
		this.songs = new ArrayList<Song>();
		this.mStore = new MusicStore();
	}
	
	public void createPlayList(String title) {
		// check to see if there is already a PlayList with the same name
		boolean flag = true;
		for(PlayList p: playLists) {
			if(p.getTitle().equalsIgnoreCase(title)) {
				flag = false;
				System.out.println("There already exists a PlayList with this name");
			}
		}
		
		if (flag) {
			PlayList playlist = new PlayList(title);
			playLists.add(playlist);
		}
	}
	
	public void addSong(String title) {
		ArrayList<Song> song = mStore.searchSongByTitle(title, false);
		if (song.size() == 0) {
			System.out.println("This song title is not in the music store, cannot add to library");
		}
		
		else {
			if (song.size() == 1) {
				songs.addAll(song);
				System.out.println("Song added to the library");
			}
			
			else {
				System.out.println("There are multiple songs with this name");
				for (Song s: song) {
					s.printAllDetails();
				}
				
				System.out.println("Would you like to add all songs? (yes or no)");
				Scanner scanner = new Scanner(System.in);
		    	
		    	int count = 0;
		    	while(count < 1) {
			    	String choice = scanner.nextLine();
			    	
			    	if(choice.equalsIgnoreCase("yes")) {
			    		songs.addAll(song);
			    		System.out.println("All songs added to the library");
			    		count++;
			    	}
			    	
			    	else if (choice.equalsIgnoreCase("no")) {
			    		System.out.println("Which artist's song would you like to add?");
			    		String artistName = scanner.nextLine();
			    		boolean flag = false;
			    		for (Song s: song) {
			    			if(s.getArtist().equalsIgnoreCase(artistName)){
			    				songs.add(s);
			    				flag = true;
			    				System.out.println("Song added to the library");
			    				break;
			    			}
			    		}
			    		
			    		if(flag == false) {
			    			System.out.println("None of the chosen songs were written by this artist");
			    		}
			    		count++;
			    	}
			    	
			    	else {
			    		System.out.println("You typed neither yes nor no, please type either yes or no");
			    	}
				}
		    	scanner.close();
			}
		}
	}
	

	// This is only meant to be used to add songs to the library when they 
	// are added to a PlayList or added via an album
	private void addSong(Song song) {
		for(Song s: songs) {
			// If the user already added a song to the library, do not add it again
			if(!(s.equalTo(song))) {
				songs.add(song);
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
				for (Song s: alb.get(0).getAlbum()) {
					addSong(s);
				}
				System.out.println("Album added to the library");
			}
			
			else {
				System.out.println("There are multiple albums with this name");
				for (Album a: alb) {
					a.printTitleAndArtist();
					System.out.println(); // space between each album
				}
				
				System.out.println("Would you like to add all albums? (yes or no)");
				Scanner scanner = new Scanner(System.in);
		    	
		    	int count = 0;
		    	while(count < 1) {
			    	String choice = scanner.nextLine();
			    	
			    	if(choice.equalsIgnoreCase("yes")) {
			    		albums.addAll(alb);
			    		for (Album a: alb) {
							for (Song s: a.getAlbum()) {
								addSong(s);
							}
						}
			    		System.out.println("All albums were added to the library");
			    		count++;
			    	}
			    	
			    	else if (choice.equalsIgnoreCase("no")){
			    		System.out.println("Which artist's album would you like to add?");
			    		String artistName = scanner.nextLine();
			    		boolean flag = false;
			    		
			    		for (Album a : alb) {
			    			if(a.getArtist().equalsIgnoreCase(artistName)){
			    				albums.add(a);
			    				flag = true;
			    				for (Song s: a.getAlbum()) {
			    					addSong(s);
			    				}
			    				System.out.println("Album added to the library");
			    				break;
			    			}
			    		}
			    		
			    		if(flag == false) {
			    			System.out.println("None of the chosen albums were written by this artist");
			    		}
			    		count++;
			    	}
			    	
			    	else {
			    		System.out.println("You typed neither yes nor no, please type either yes or no");
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
	
	public void addSongToPlayList(String pLTitle, String songTitle) {
		Scanner scanner = new Scanner(System.in);
		
		boolean flag = false;
		for(PlayList p : playLists) {
			if (p.getTitle().equalsIgnoreCase(pLTitle)) {
				flag = true;
				
				ArrayList<Song> song = mStore.searchSongByTitle(songTitle, false);
				
				if (song.size() == 0) {
					System.out.println("This song title is not in the music store");
					break;
				}
				
				else if (song.size() == 1) {
					p.addSong(song.get(0)); // adds to the PlayList
					addSong(song.get(0)); // adds to the library song list, if not already in there
					System.out.println("Song added to PlayList and library");
					break;
				}
				
				else {
					System.out.println("There are multiple songs with this name");
					for (Song s: song) {
						s.printAllDetails();
					}
					
					System.out.println("Would you like to add all songs? (yes or no)");
			    	
			    	int count = 0;
			    	while(count < 1) {
				    	String choice = scanner.nextLine();
				    	
				    	if(choice.equalsIgnoreCase("yes")) {
				    		for (Song s: song) {
								p.addSong(s); // adds to the PlayList
								addSong(s); // adds to the library, if not already there
							}
				    		System.out.println("All songs added to the PlayList and library");
				    		count++;
				    	}
				    	
				    	else if (choice.equalsIgnoreCase("no")) {
				    		System.out.println("Which artist's song would you like to add?");
				    		String artistName = scanner.nextLine();
				    		boolean f = false;
				    		for (Song s: song) {
				    			if(s.getArtist().equalsIgnoreCase(artistName)){
				    				p.addSong(s); // adds to the PlayList
				    				addSong(s); // adds to the library, if not already there
				    				System.out.println("Song added to the Playlist and library");
				    				f = true;
				    				break;
				    			}
				    		}
				    		
				    		if(f == false) {
				    			System.out.println("None of the chosen songs were written by this artist");
				    		}
				    		count++;
				    	}
				    	
				    	else {
				    		System.out.println("You typed neither yes nor no, please type either yes or no");
				    	}
					}
				}
			}
		}
		
		if (!(flag)) {
			System.out.println("There is no PlayList with that name in the library");
			System.out.println("Please create a PlayList with that name first, and then add a song to it");
		}
		
		scanner.close();
	}
	
	public ArrayList<Song> searchSongByTitle(String title) {
		ArrayList<Song> songList = new ArrayList<Song>();
		for (Song s: songs) {
			if (s.getTitle().equalsIgnoreCase(title)) {
				songList.add(s);
			}
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
		for (Song s: songs) {
			if (s.getArtist().equalsIgnoreCase(artist)) {
				songList.add(s);
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
