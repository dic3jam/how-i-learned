package connectfour;

import java.util.Collection;
import java.util.HashSet;

/**
 * Represents a player in connect four
 * @author jeremy
 */
public class RandomPlayer extends Player {

	/**
	 * Creates a new RandomPlayer
	 * @param name - player's name, never null, never empty, must be unique
	 * @param marker - marker for this player on game board, must be unique, must not be {@link Game#EMPTY}
	 * @throws NullPointerException if name is null
	 * @throws IllegalArgumentException if name is empty or not unique, or if marker is not unique or equal to {@link Game#EMPTY}  
	 */
	public RandomPlayer(String name, char marker) {
		super(name, marker);
	}

	/**
	 * Chooses a random move like a chump
	 * @param game
	 * @return the column index where the player would like to move 
	 * @throws NullPointerException if game is null
	 */
	@Override
	public int chooseMove(Game game) throws NullPointerException {
		if(game == null)
			throw new NullPointerException();
		int column;
		do {
			column = (int) (Game.N_COLS * Math.random());
		} while (!game.isValidMove(column));

		return column;
	}
}


