package database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Album;
import model.Song;

public class MusicStore {
	private ArrayList<Album> albums;
	
	public MusicStore() {
		this.albums = new ArrayList<Album>();
		
		// open albums.txt and create albums/songs from it
		try {
			BufferedReader in = new BufferedReader(new FileReader("albums/albums.txt"));
			
			ArrayList<String[]> albs = new ArrayList<String[]>();
			String line;
			// Goes through albums.txt to get name and artist of each album
            while ((line = in.readLine()) != null) {
                String[] l = line.split(",");
                albs.add(l);
            }
            
            // for each album, create an Album object
            for (String[] alb: albs) {
            	String title = alb[0];
            	String artist = alb[1];
            	
            	String filepath = "albums/" + title + "_" + artist + ".txt";
            	
            	BufferedReader in2 = new BufferedReader(new FileReader(filepath));
            	String lin = in2.readLine();
            	String[] albumInfo = lin.split(",");
            	Album album = new Album(albumInfo[0], albumInfo[1], albumInfo[2], albumInfo[3]);
            	
            	// go through each album.txt and create a Song object for each song
            	while ((lin = in2.readLine()) != null) {
                    // lin will be the name of a song
            		Song song = new Song(lin, album.getArtist(), album.getTitle());
                    album.addSong(song);
                }
            	
            	// add the newly created album to albums
            	albums.add(album);
            	in2.close();
            }
            
            in.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
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
