package ch6hw2;

public enum Suit {
	CLUBS('C'), DIAMONDS('D'), HEARTS('H'), SPADES('S');

	private final char C;
	
	private Suit(char c) {
		this.C = c;
	}
	
	public char getChar() {
		return C;
	}
}