package vid3.MapAndWrapUp;

import java.util.HashMap;
import java.util.Map;

public class AdventureGameLocation {

	private final int id;
	private final String description;

	private Map<String, Integer> exits;

	public AdventureGameLocation(int id, String description) {
		this.id = id;
		this.description = description;
		exits = new HashMap<>();
		exits.put("Square 0", 0);
	}

	public Map<String, Integer> getExits() {
		return new HashMap<String, Integer>(exits);
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void addExit(String directionGoing, int locationId) {
		exits.put(directionGoing, locationId);
	}

}
