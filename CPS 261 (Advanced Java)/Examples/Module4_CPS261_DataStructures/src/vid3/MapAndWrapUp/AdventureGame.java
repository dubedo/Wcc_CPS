package vid3.MapAndWrapUp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdventureGame {

	private static Map<Integer, AdventureGameLocation> ourLocations;

	public AdventureGame() {
		ourLocations = new HashMap<>();

		ourLocations.put(0, new AdventureGameLocation(0, "Sitting In Front of A Desk Learning Java"));

		ourLocations.put(1, new AdventureGameLocation(1, "Moved Into the Basement to Stretch Your Legs"));
		ourLocations.put(2, new AdventureGameLocation(2, "You are Now Upstairs to See Charlie"));
		ourLocations.put(3, new AdventureGameLocation(3, "Sarah Yells at You that She Doesnt Have Time To Talk"));
		ourLocations.put(4, new AdventureGameLocation(4, "You Run For The Stairs"));
		ourLocations.put(5, new AdventureGameLocation(5, "You Are in Your Room"));

		ourLocations.get(5).addExit("Square 1", 1);
		ourLocations.get(5).addExit("Square 2", 2);
		ourLocations.get(5).addExit("Square 4", 4);

		ourLocations.get(1).addExit("Square 2", 2);
		ourLocations.get(1).addExit("Square 4", 4);
		ourLocations.get(1).addExit("Square 5", 5);

		ourLocations.get(2).addExit("Square 3", 3);
		ourLocations.get(2).addExit("Square 4", 4);

		ourLocations.get(3).addExit("Square 2", 2);
		ourLocations.get(3).addExit("Square 4", 4);

		ourLocations.get(4).addExit("Square 1", 1);
		ourLocations.get(4).addExit("Square 2", 2);
		ourLocations.get(4).addExit("Square 3", 3);
		ourLocations.get(4).addExit("Square 5", 5);

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Scanner kbInput = new Scanner(System.in);
		int currentLocation = 5;

		AdventureGame myGame = new AdventureGame();

		while (true) {

			System.out.println(ourLocations.get(currentLocation).getDescription());

			if (currentLocation == 0) {
				break;
			}

			System.out.println("The Directions you Can Go: ");

			Map<String, Integer> exits = ourLocations.get(currentLocation).getExits();

			for (String directions : exits.keySet()) {
				System.out.println(directions);
			}

			String directionToGo = kbInput.nextLine();

			if (exits.containsKey(directionToGo)) {
				currentLocation = exits.get(directionToGo);
			} else {
				System.out.println("You Can Not Go There.");
			}

		}

		kbInput.close();

	}

}
