package ch6hw2;

public class WarRunner {

	public static void main(String[] args) {
		Deck gameDeck = new Deck();
		gameDeck.buildDeck();
		gameDeck.oldManshuffle();
		War gameOn = new War(gameDeck);
		while(!gameOn.wonGame()) {
			gameOn.playTurn();
			System.out.println(gameOn.toString());
		}
	}

}
