package generic;

import java.util.ArrayList;

class Player {
	private String playersName;

	public Player(String playersName) {
		this.playersName = playersName;
	}

	public String getPlayersName() {
		return playersName;
	}
}

class FootballPlayer extends Player {

	public FootballPlayer(String playersName) {
		super(playersName);
	}

}

class HockeyPlayer extends Player {

	public HockeyPlayer(String playersName) {
		super(playersName);
	}

}

class BaseballPlayer extends Player {

	public BaseballPlayer(String playersName) {
		super(playersName);
	}

}

public class Team<T extends Player> {

	public int won;
	public int lost;
	public int gamesPlayed;

	public String teamName;

	ArrayList<T> players;

	public Team() {
		players = new ArrayList<>();
	}

	public Team(String teamName) {
		this.teamName = teamName;
		players = new ArrayList<>();
	}

	public void addPlayer(T thePlayer) {
		players.add(thePlayer);
	}

	public void printPlayers() {
		for (T player : players) {
			System.out.println(player.getPlayersName());
		}
	}

	public void play(Team<T> otherTeam) {

		this.gamesPlayed += 1;
		this.won += 1;

		otherTeam.gamesPlayed += 1;
		otherTeam.lost -= 1;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		HockeyPlayer hockeyPlayer = new HockeyPlayer("Hockey Player");
		BaseballPlayer baseballPlayer = new BaseballPlayer("Baseball Player");
		FootballPlayer footballPlayer = new FootballPlayer("Football Player");

		Team<HockeyPlayer> hockeyTeam = new Team<>("Hockey Team");
		Team<BaseballPlayer> baseballTeam = new Team<>("Baseball Team");

		hockeyTeam.addPlayer(hockeyPlayer);

		// We Don't Want This To Work
		// hockeyTeam.addPlayer(baseballPlayer);

		// We Don't Want This To Work Either. (Due To Casting)
		// Team<String> invalidTeam = new Team<>("Invalid Team");
		// String myString = "Hi";
		// invalidTeam.addPlayer(myString);
		// invalidTeam.printPlayers();

		// We Don't want this to work either. Type Inference in the Declaration of Play
		// Method.
		// hockeyTeam.play(baseballTeam);

		hockeyTeam.printPlayers();

	}

}
