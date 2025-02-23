package database;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import model.Song;
import model.Album;
import model.PlayList;

class MusicStoreTest {
	MusicStore ms = new MusicStore();

	@Test
	void testSearchSongByTitleOne() {
		ArrayList<Song> songList = ms.searchSongByTitle("I Feel The Earth Move", false);
		assertTrue(songList.size() == 1);
		assertEquals(songList.get(0).getTitle(), "I Feel The Earth Move");
	}
	 
	@Test
	void testSearchBySongTitleMultiple() {
		ArrayList<Song> songList = ms.searchSongByTitle("Lullaby", false);
		assertTrue(songList.size() == 2);
		assertEquals(songList.get(0).getTitle(), "Lullaby");
		assertEquals(songList.get(1).getTitle(), "Lullaby");
	}
	
	@Test
	void testSearchBySongTitleNotInStore() {
		ArrayList<Song> songList = ms.searchSongByTitle("Not in Store", false);
		assertTrue(songList.size() == 0);
	}
	
	@Test
	void testSearchSongByArtist() {
		ArrayList<Song> songList = ms.searchSongByArtist("Adele", false);
		assertTrue(songList.size() == 24);
		assertEquals(songList.get(0).getArtist(), "Adele");
		assertEquals(songList.get(23).getArtist(), "Adele");
	}
	
	@Test
	void testSearchSongByArtistNotInStore() {
		ArrayList<Song> songList = ms.searchSongByArtist("Laufey", false);
		assertTrue(songList.size() == 0);
	}
	
	@Test
	void testSearchAlbumByTitle() {
		ArrayList<Album> albumList = ms.searchAlbumByTitle("Sons", false);
		assertTrue(albumList.size() == 1);
		assertEquals(albumList.get(0).getTitle(), "Sons");
	}
	
	@Test
	void testSearchAlbumByTitleNotInStore() {
		ArrayList<Album> albumList = ms.searchAlbumByTitle("Goddess", false);
		assertTrue(albumList.size() == 0);
	}
	
	@Test
	void testSearchAlbumByArtist() {
		ArrayList<Album> albumList = ms.searchAlbumByArtist("Ben Harper", false);
		assertTrue(albumList.size() == 1);
		assertEquals(albumList.get(0).getArtist(), "Ben Harper");
	}
	
	@Test
	void testSearchAlbumByArtistMultiple() {
		ArrayList<Album> albumList = ms.searchAlbumByArtist("Adele", false);
		assertTrue(albumList.size() == 2);
		assertEquals(albumList.get(0).getArtist(), "Adele");
		assertEquals(albumList.get(1).getArtist(), "Adele");
	}
	
	@Test
	void testSearchAlbumByArtistNotInStore() {
		ArrayList<Album> albumList = ms.searchAlbumByArtist("Laufey", false);
		assertTrue(albumList.size() == 0);
	}

}
