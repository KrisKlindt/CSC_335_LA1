package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SongTest {
	private Song song1 = new Song("one", "Joe Biden", "yes");
	
	@Test
	void getTitleTest() {
		assertEquals(song1.getTitle(), "one");
	}

	@Test
	void getArtistTest() {
		assertEquals(song1.getArtist(), "Joe Biden");
	}
	
	// Not sure what or how to test for printAllDetails
}
