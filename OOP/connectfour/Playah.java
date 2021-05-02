package connectfour;

import java.util.Collection;
import java.util.HashSet;

/**
 * Represents a player in connect four
 * @author jeremy
 */
public class Playah extends Player {

	private int column; 

	/**
	 * Creates a new Playah, hatah
	 * @param name - player's name, never null, never empty, must be unique
	 * @param marker - marker for this player on game board, must be unique, must not be {@link Game#EMPTY}
	 * @throws NullPointerException if name is null
	 * @throws IllegalArgumentException if name is empty or not unique, or if marker is not unique or equal to {@link Game#EMPTY}  
	 */
	public Playah(String name, char marker) {
		super(name, marker);
		this.column = 2;
	}

	protected void repOK() {
		super.repOK();
		assert(column < Game.N_COLS);
	}

	/**
	 * Chooses a random move like a champ
	 * @param game
	 * @return the column index where the player would like to move 
	 * @throws NullPointerException if game is null
	 */
	@Override
	public int chooseMove(Game game) throws NullPointerException {
		if(game == null)
			throw new NullPointerException();
		int luckyColumn = column;
		if(game.isValidMove(luckyColumn)){
			this.column++;
			return luckyColumn;
		} else {
			int chumpStatus = 0;
			while(!game.isValidMove(0))
				chumpStatus++;
			repOK();
			return chumpStatus;
		}
			
	}
}



