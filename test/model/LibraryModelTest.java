package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import database.MusicStore;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import model.Song;
import model.Album;
import model.PlayList;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

class LibraryModelTest {
	LibraryModel lm = new LibraryModel();
	
	@Test
	void testCreatePlayList() {
		lm.createPlayList("Mood");
		assertTrue(lm.getPlayLists().size() == 1);
		lm.createPlayList("Angst");
		assertTrue(lm.getPlayLists().size() == 2);
	}
	
	@Test
	void testCreatePlayListSameName() {
		lm.createPlayList("Angst");
		assertTrue(lm.getPlayLists().size() == 2);
	}
	
	@Test
	void testAddSongNotInStore() {
		lm.addSong("Letter To My 13 Year Old Self");
		assertTrue(lm.getSongTitles().size() == 0);
	}
	
	@Test
	void testAddSongSingle() {
		lm.addSong("Set Fire To The Rain");
		assertTrue(lm.getSongTitles().size() == 1);
	}
	
	@Test
	void testAddSongMultipleYes() {
		String input = ("yes\n");
		ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        	System.setIn(testIn);
		lm.addSong("Lullaby");
		assertTrue(lm.getSongTitles().size() == 3);
	}
	
	@Test
	void testSearchSongByTitleOne() {
		lm.addSong("I Feel The Earth Move");
		ArrayList<Song> songList = lm.searchSongByTitle("I Feel The Earth Move");
		assertTrue(songList.size() == 1);
		assertEquals(songList.get(0).getTitle(), "I Feel The Earth Move");
	}
	 
	@Test
	void testSearchBySongTitleMultiple() {
		ArrayList<Song> songList = lm.searchSongByTitle("Lullaby");
		assertTrue(songList.size() == 2);
		assertEquals(songList.get(1).getTitle(), "Lullaby");
		assertEquals(songList.get(2).getTitle(), "Lullaby");
	}
	
	@Test
	void testSearchBySongTitleNotInLibrary() {
		ArrayList<Song> songList = lm.searchSongByTitle("Not in Library");
		assertTrue(songList.size() == 0);
	}
	
	@Test
	void testSearchSongByArtist() {
		ArrayList<Song> songList = lm.searchSongByArtist("Adele");
		assertTrue(songList.size() == 1);
		assertEquals(songList.get(0).getArtist(), "Adele");
	}
	
	@Test
	void testSearchSongByArtistNotInLibrary() {
		ArrayList<Song> songList = lm.searchSongByArtist("Laufey");
		assertTrue(songList.size() == 0);
	}
	
	@Test
	void testAddAlbum() {
		lm.addAlbum("Sons");
		ArrayList<String> albumList = lm.getAlbumTitles();
		assertTrue(albumList.size() == 1);
		assertEquals(albumList.get(0), "Sons");
	}
	
	@Test
	void testSearchAlbumByTitle() {
		ArrayList<Album> albumList = lm.searchAlbumByTitle("Sons");
		assertTrue(albumList.size() == 1);
		assertEquals(albumList.get(0).getTitle(), "Sons");
	}
	
	@Test
	void testSearchAlbumByTitleNotInLibrary() {
		ArrayList<Album> albumList = lm.searchAlbumByTitle("Goddess");
		assertTrue(albumList.size() == 0);
	}
	
	@Test
	void testSearchAlbumByArtist() {
		ArrayList<Album> albumList = lm.searchAlbumByArtist("The Heavy");
		assertTrue(albumList.size() == 1);
		assertEquals(albumList.get(0).getArtist(), "The Heavy");
	}
	
//	@Test
//	void testSearchAlbumByArtistMultiple() {
//		ArrayList<Album> albumList = lm.searchAlbumByArtist("Adele");
//		assertTrue(albumList.size() == 2);
//		assertEquals(albumList.get(0).getArtist(), "Adele");
//		assertEquals(albumList.get(1).getArtist(), "Adele");
//	}
	
	@Test
	void testSearchAlbumByArtistNotInLibrary() {
		ArrayList<Album> albumList = lm.searchAlbumByArtist("Laufey");
		assertTrue(albumList.size() == 0);
	}
}
