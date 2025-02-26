package view;

import model.*;
import java.util.Scanner;

public class View {
	public static void main(String[] args) {
		LibraryModel library = new LibraryModel();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome User!\n This is your music library where you can add songs and Albums that are available within our store!");
		int command = 0;
		while (command < 18) {
			System.out.println("Here are the features available to you.");
			System.out.println("1. Create a playlist");
			System.out.println("2. Add a song");
			System.out.println("3. Add an album");
			System.out.println("4. Search for a playlist");
			System.out.println("5. Add a song to a playlist");
			System.out.println("6. Remove a song from a playlist");
			System.out.println("7. Search for a song by the title");
			System.out.println("8. Search for a song by the artist");
			System.out.println("9. Search an an album by the title");
			System.out.println("10. Search for an album by the artist");
			System.out.println("11. Mark a song as a favorite");
			System.out.println("12. Rate a song 1 - 5");
			System.out.println("13. Get the titles of the songs in your library");
			System.out.println("14. Get the artists in your library");
			System.out.println("15. Get the titles of the albums in your library");
			System.out.println("16. Get the playlists in your library");
			System.out.println("17. Get your favorite songs in your library");
			
			System.out.println("Please enter the integer of the command you'd like to use: ");
			System.out.println("Or enter a negative integer to exit");
			
			command = scanner.nextInt();
			if (command < 0) {
				break;
			}
			if (command == 1) {
				String pName = scanner.nextLine();
				library.addAlbum(pName);
			}
			else if (command == 2) {
				String sTitle = scanner.nextLine();
				library.addSong(sTitle);
			}
			else if (command == 3) {
				String albName = scanner.nextLine();
				library.searchPlayList(albName);
			}
			else if (command == 4) {
				String pName = scanner.nextLine();
				library.addAlbum(pName);
			}
			else if (command == 5) {
				System.out.println("Please put in the playlist you'd like to add to: ");
				String pName = scanner.nextLine();
				System.out.println("Pkease put in the name of the song you'd like to add: ");
				String sTitle = scanner.nextLine();
				library.addSongToPlayList(pName, sTitle);
			}
			else if (command == 6) {
				System.out.println("Please put in the playlist you'd like to remove from: ");
				String pName = scanner.nextLine();
				System.out.println("Pkease put in the name of the song you'd like to remove: ");
				String sTitle = scanner.nextLine();
				library.removeSongFromPlayList(pName, sTitle);
			}
			else if (command == 7) {
				System.out.println("What song would you like to search for? ");
				String sTitle = scanner.nextLine();
				library.searchSongByTitle(sTitle);
			}
			else if (command == 8) {
				System.out.println("What artist would you like to search for? ");
				String artist = scanner.nextLine();
				library.searchSongByArtist(artist);
			}
			else if (command == 9) {
				System.out.println("Please put in the name of the album you'd like to search for: ");
				String albTitle = scanner.nextLine();
				library.searchAlbumByTitle(albTitle);
			}
			else if (command == 10) {
				System.out.println("Which artist's album would you like to search for? ");
				String albArtist = scanner.nextLine();
				library.searchAlbumByArtist(albArtist);
			}
			else if (command == 11) {
				System.out.println("What's the title of the song would you like to favorite? ");
				String sTitle = scanner.nextLine();
				library.favoriteSong(sTitle);
				}
			else if (command == 12) {
				System.out.println("What's the title of the song you'd like to rate? ");
				String sTitle = scanner.nextLine();
				library.rateSong(sTitle);
			}
			else if (command == 13) {
				library.getSongTitles();
			}
			else if (command == 14) {
				library.getArtists();
			}
			else if (command == 15) {
				library.getAlbumTitles();
			}
			else if (command == 16) {
				library.getPlayLists();
			}
			else if (command == 17) {
				library.getFavoriteSongs();
			}
			else {
				System.out.println("Invalid input. Please choose an integer 1 - 17");
			}
		}
		System.out.println("Thank you for using our library!");
	}
}
