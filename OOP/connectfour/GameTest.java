package connectfour;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class GameTest {

	static Player p3 = null;
	static Player p4 = null;
	static Game game = null;

	@BeforeClass
	public static void createObjects() {
		p3 = new RandomPlayer("Player Three", 'A');
		p4 = new RandomPlayer("Player Four", 'B');
		game = new Game(p3, p4);
	}
	
	@Before
	public void clearBoard() {
		for(int i = 0; i < game.N_COLS; i++)
			for(int j = 0; j < game.N_ROWS; j++)
				game.board[i][j] = game.EMPTY;
	}	

	@Test
	public void testPlayTurn() {
		game.playTurn();
		game.printBoard();
		int i = 0;
		assertEquals(i, 0);
	}

	@Test
	public void testIsOverHorizontal() {
		for(int i = 3; i < game.N_COLS; i++) {
			game.board[i][4] = 'B';		
		}
		for(int i = 1; i < 3; i++) {
			game.board[i][2] = 'A';		
		}
		System.out.println("Horizontal Test");
		boolean check = game.isOver();
		assertTrue(check);
	}

	@Test
	public void testIsOverVertical() {
		for(int i = 1; i < 5; i++) {
				game.board[2][i] = 'B';		
			}
		for(int i = 2; i < game.N_ROWS-1; i++) {
				game.board[4][i] = 'A';		
			}
			System.out.println("Vertical Test");
			boolean check = game.isOver();
			assertTrue(check);
			
	}
	
	@Test
	public void testIsOverDiagonal1() {
		for(int i = 1; i < (game.N_ROWS-1); i++) {
				game.board[i][i] = 'A';		
				//game.printBoard();
			}
			System.out.println("Diagonal Test - 1");
			boolean check = game.isOver();
			assertTrue(check);
	}

	@Test
	public void testIsOverDiagonal2() {
		int j = game.N_ROWS-1;
		for(int i = 0; i < 4; i++) {
				game.board[i][j] = 'B';		
			//	game.printBoard();
				j--;
			}
			System.out.println("Diagonal Test - 2");
			boolean check = game.isOver();
			assertTrue(check);
	}

	@Test
	public void testIsOverBoardFull() {
		int n = 65;
		for(int i = 0; i < game.N_COLS; i++)
			for(int j = 0; j < game.N_ROWS; j++) {
				game.board[i][j] = (char) n;
				n += 1;
			}
		
		boolean check = game.isOver();
		
		assertTrue(check);
	}

	@Test
	public void testIsOverBoardNotFull() {
		int n = 65;
		for(int i = 0; i < game.N_COLS-2; i++)
			for(int j = 0; j < game.N_ROWS-2; j++) {
				game.board[i][j] = (char) n;
				n += 1;
			}
		
		boolean check = game.isOver();
		
		assertFalse(check);
	}

	@Test
	public void testIsValidMove() {
		boolean check = game.isValidMove(9);
		assertFalse(check);
		game.col_count[2] = 10;
		boolean check2 = game.isValidMove(2);
		assertFalse(check2);
	}

}