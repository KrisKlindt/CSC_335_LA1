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
	}
	 
	@Test
	void testSearchBySongTitleMultiple() {
		ArrayList<Song> songList = ms.searchSongByTitle("Lullaby", false);
		assertTrue(songList.size() == 2);
	}
	
	@Test
	void testSearchBySongTitleNotInStore() {
		ArrayList<Song> songList = ms.searchSongByTitle("Not in Store", false);
		assertTrue(songList.size() == 0);
	}

}
