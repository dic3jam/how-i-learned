package connectfour;

/**
 * Represents a gameboard, and processes moves
 * for a ConnectFour game
 * @author Jim DiCesare
 * CIS2260 OOP
 */
public class Game {

	/** Number of columns for the game, never < 4 note: This is protected because 
	 * player needs to access it directly*/ 
	protected static int N_COLS = 7;
	
	/**
	 * Number of rows for the game - always 6
	 */
	protected static int N_ROWS = 6;
	
	/** 
	 * What character will represent an empty space on the board
	 */
	protected static char EMPTY;

	/** concrete representation of the ConnectFour board */
	protected char[][] board; 
	
	/** keeps track of how many markers are in each board column*/
	protected int[] col_count;
	
	/** The players*/
	Player p1;
	Player p2;

	void repOk() {
		assert(N_COLS > 4);
		assert(N_ROWS == 6);
		assert(EMPTY == '-');	
		assert(board != null);
		assert(col_count != null);
		assert(p1 != null);
		assert(p2 != null);
		for(int i = 0; i < this.N_COLS; i++)
			for(int j = 0; j < this.N_ROWS; j++)
				assert(board[i][j] == this.EMPTY || board[i][j] == p1.getMarker() || board[i][j] == p2.getMarker());
	}
	
	/**
	 * Creates a new game  
	 * @param p1 Player object 
	 * @param p2 Player object
	 * @throws NullPointerException if p1 or p2 is null
	 */
	public Game(Player _p1, Player _p2) throws NullPointerException{
		
		if( _p1 == null || _p2 == null)
			throw new NullPointerException("Send me a real champion");
		
		p1 = _p1;

		p2 = _p2;

		EMPTY = '-';
		
		col_count = new int[N_COLS];

		board = new char[N_COLS][N_ROWS];

		for(int i = 0; i < N_COLS; i++) {
				col_count[i] = 0;
			for(int j = 0; j < N_ROWS; j++)
				board[i][j] = EMPTY;
		}
		
		repOk();
	}
	
	/**
	 * Calls upon the chooseMove method from the Player class and adds a move to the board
	 * will call upon isOver to check if the game has been complete or all positions are filled 
	 */
	public void playTurn() {
		
		int p1Move = p1.chooseMove(this);
		board[p1Move][col_count[p1Move]] = p1.getMarker();
		col_count[p1Move]++;
		
		int p2Move = p2.chooseMove(this);
		board[p2Move][col_count[p2Move]] = p2.getMarker();
		col_count[p2Move]++;
		
		repOk();

	}

	/**
	 * Runs the checks to see if any of the win conditions have been met by the end of a Playturn
	 * or if the board has been filled
	 * @param p1 Player one
	 * @param p2 Player two
	 * @return True if a player has won, false if not
	 */
	public boolean isOver() {
		
		if(playerWin(p1))
			return true;
		
		if(playerWin(p2))
			return true;
			
		if(boardFull())
			return true;
		
		return false;
		
	}
	/**
	 * Checks the player against each input 
	 * @param p the player to check for win conditions
	 * @return true and a message if a win is found
	 */
	private boolean playerWin(Player p) {

		if(checkHorizontal(p)) {
			endGame(p, "horizontal win");
			return true;
		}
	
		if(checkVertical(p)) {
			endGame(p, "vertical win");
			return true;
		}
	
		if(checkDiagonal(p)) {
			endGame(p, "diagonal win");
			return true;
		}
		
		return false;
	}
	
	/**
	 * Exits the game immediately upon a win condition
	 */
	private void endGame(Player p, String winType) {
		System.out.println(p.getName() + " " + winType);
		printBoard();
	}

	/**
	 * abstract representation of the Game - prints a ConnectFour board to 
	 * the screen
	 */
	public void printBoard() {

		for(int i = N_ROWS - 1; i >= 0; i--) {
			System.out.printf("\n");
			for(int j = 0; j < N_COLS; j++)
				System.out.printf("%c ", board[j][i]);
		}
		
		System.out.printf("\n\n");

	}

	/**
	 * Ensures that a player move is valid 
	 * @param column the column that the player is attempting to put the move into
	 * must be > 0 and less than or equal to N_COLS
	 * @return true if move is valid, false if not
	 */
	public boolean isValidMove(int column) {
		
		if( column < 0 || column > N_COLS - 1)
			return false;
		
		if( col_count[column] > N_ROWS - 1 )
			return false;

		return true;
	}

	/**
	 * Checks current state of board to see if there is 4 in a row
	 * horizontally
	 * @return true if there is a horizontal win, false if not
	 */
	private boolean checkHorizontal(Player p) {
		
		for(int k = 0; k+3 < N_COLS; k++) {
			for(int i = 0; i < N_ROWS; i++) {
				int c = k;
				if(board[c][i] == p.getMarker()) {
					while(c < k+3 && (p.getMarker() == board[c+1][i])){
						if(c == k+2)
							return true;
						c++;
					}
				}
			}
		}
		
		return false;
	}

	/**
	 * Checks current state of board to see if there is 4 in a row
	 * vertically 
	 * @return true if there is a vertical win, false if not
	 */	
	private boolean checkVertical(Player p) {
		
		for(int k = 0; k < N_COLS; k++) {
			for(int i = 0; i+3 < N_ROWS; i++) {
				int j = i;
				if(board[k][i] == p.getMarker()) {
					while( j+1 < N_ROWS && (p.getMarker() == board[k][j+1]))  {
						if(j == i+2)
							return true;
						j++;
					}
				}
			}
		}
		
		return false;
	}

	/**
	 * Checks current state of board to see if there is 4 in a row
	 * in any diagonal direction 
	 * @return true if there is a diagonal win, false if not
	 */
	private boolean checkDiagonal(Player p) {
		
		for(int k = 0; k+3 < N_COLS; k++) {
				for(int i = 0; i+3 < N_ROWS; i++) {
					int c = k;
					int j = i;
					if(board[c][j] == p.getMarker()) {
						while(c < k+3 && (p.getMarker() == board[c+1][j+1])){
							if(c == k+2)
								return true;
							c++;
							j++;
						}
					}
				}
			}
		
		for(int k = 0; k+3 < N_COLS; k++) {
				for(int i = N_ROWS - 1; i-3 > 0; i--) {
					int c = k;
					int j = i;
					if(board[c][j] == p.getMarker()) {
						while(c < k+3 && (p.getMarker() == board[c+1][j-1])) {
							if(c == k+2)
								return true;
							c++;
							j--;
						}
					}
				}
			}
			
		return false;
	}
	
	/**
	 * Checks to see if all positions in board are filled
	 * @return true if the board is full, false if not
	 */
	private boolean boardFull() {
		
		boolean count = true;

		for(int i = 0; i < N_COLS; i++) {
			for(int j = 0; j < N_ROWS; j++) {
				if(board[i][j] == EMPTY) {
					count = false;
					break;
			}
			if(count == false)
				break;
			}

		}
		if(count == true)
			System.out.println("Board full game over");
			printBoard();
		return count;
	}
}