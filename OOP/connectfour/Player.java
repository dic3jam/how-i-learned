package connectfour;

import java.util.Collection;
import java.util.HashSet;

/**
 * Represents a player in connect four
 * @author jeremy
 */
public abstract class Player {
	/** Player's name, never null, never empty */
	private String name;
	
	/** Player's marker to place on game board, must not be {@link Game#EMPTY} */
	private char marker;
	
	/** All names used */
	private static Collection<String> namesUsed = new HashSet<>();
	
	/** All markers used */
	private static Collection<Character> markersUsed = new HashSet<>();
	
	protected void repOK() {
		assert(name != null);
		assert(name.length() > 0);
		assert(marker != Game.EMPTY);
	}
	
	/**
	 * Creates a new player
	 * @param name - player's name, never null, never empty, must be unique
	 * @param marker - marker for this player on game board, must be unique, must not be {@link Game#EMPTY}
	 * @throws NullPointerException if name is null
	 * @throws IllegalArgumentException if name is empty or not unique, or if marker is not unique or equal to {@link Game#EMPTY}  
	 */
	public Player(String name, char marker) throws NullPointerException, IllegalArgumentException {
		if (name == null) {
			throw new NullPointerException();
		}
		
		if (name.length() == 0) {
			throw new IllegalArgumentException("name cannot be empty");
		}
		
		if (marker == Game.EMPTY) {
			throw new IllegalArgumentException("Illegal marker " + marker);
		}
		
		if (namesUsed.contains(name)) {
			throw new IllegalArgumentException("name " + name + " already used");
		}
		
		if (markersUsed.contains(marker)) {
			throw new IllegalArgumentException("marker " + marker + " already used");
		}
		
		namesUsed.add(name);
		markersUsed.add(marker);
		
		this.name = name;
		this.marker = marker;
		repOK();
	}
	
	/**
	 * @return this player's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return this player's marker
	 */
	public char getMarker() {
		return marker;
	}
	
	/**
	 * Chooses a move given a game state
	 * @param game
	 * @return the column index where the player would like to move 
	 * @throws NullPointerException if game is null
	 */
	public abstract int chooseMove(Game game) throws NullPointerException; 

}


