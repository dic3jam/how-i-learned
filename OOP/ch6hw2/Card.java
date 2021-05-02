package ch6hw2;

/**
 * Immutable representation of a standard playing card
 * 
 * @author jeremy
 *
 */
public class Card {
	public static final int[] RANKS = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

	/** Card's rank, 1 - 13, 1 = Ace, 2 = 2, ... 11 = J, 12 = Q, 13 = K */
	private int rank;

	/** Card's suit */
	private Suit suit;

	private void repOK() {
		assert(rank >= 1 && rank <= 13) : "invalid rank value " + rank;
		assert(suit != null);
	}

	/**
	 * Create a card with the specificed suit and rank
	 * 
	 * @param rank - the rank of the card from 1 to 13, 1 = Ace, 11 = Jack, 12 =
	 *             Queen, 13 = King
	 * @param suit - never null
	 * @throws NullPointerException if suit is null
	 * @throws IllegalArgumentException if rank is invalid
	 */
	public Card(int rank, Suit suit) throws NullPointerException, IllegalArgumentException {
		if (rank < 1 || rank > 13) {
			throw new IllegalArgumentException("Invalid rank: " + rank);
		}
		
		if (suit == null) {
			throw new NullPointerException("suit cannot be null");
		}
		
		this.rank = rank;
		this.suit = suit;
		repOK();
	}

	/**
	 * @return the card's rank
	 */
	public int getRank() {
		return rank;
	}

	@Override
	public String toString() throws IllegalStateException {
		String rankString;
		if (rank == 1) {
			rankString = "A";
		} else if (rank == 11) {
			rankString = "J";
		} else if (rank == 12) {
			rankString = "Q";
		} else if (rank == 13) {
			rankString = "K";
		} else {
			rankString = Integer.toString(rank);
		}

		return rankString + suit.getChar();
	}	
}