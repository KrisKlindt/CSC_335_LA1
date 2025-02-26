package view;

import model.*;
import java.util.Scanner;

public class View {
	public static void main(String[] args) {
		LibraryModel library = new LibraryModel();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome User!\n This is your music library where you can add songs and Albums that are available within our store!");
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
		int command = scanner.nextInt();
		while (command < 18) {
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
		}
		System.out.println("Thank you for using our library!");
	}
}
