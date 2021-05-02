package ch6hw2;

import java.util.ArrayList;

public class War {

	/** Player decks and their discard piles*/
	Deck player1;
	Deck player2;
	Deck discard1; 
	Deck discard2; 
	Deck gameDeck;
	
	/**
	 * Starts a game of War by splitting a shuffled deck among 2 player decks
	 * @param gameDeck SHOULD be shuffled, though I suppose it does not have to be
	 */
	public War(Deck gameDeck) {
		this.gameDeck = gameDeck;
		player1 = new Deck();
		player2 = new Deck();
		discard1 = new Deck();
		discard2 = new Deck();
		
		while(!gameDeck.isEmpty()) {
			player1.stackDeck(gameDeck.draw());
			player2.stackDeck(gameDeck.draw());
		}
		repOK();
	}
	
	private void repOK() {
		assert(player1 != null) : "deck cannot be null";
		assert(player2 != null) : "deck cannot be null";
		assert(discard1 != null) : "deck cannot be null";
		assert(discard1 != null) : "deck cannot be null";
		assert(gameDeck.isEmpty()) : "all cards must be dealt";
		assert(player1.size() == 26) : "must start with half of the deck";
		assert(player2.size() == 26) : "must start with half of the deck";
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player 1 Deck: " + player1.toString() + "Size: " + player1.size() +"\n");
		builder.append("Player 1 Discard: " + discard1.toString() + "Size: " + discard1.size() + "\n");
		builder.append("Player 2 Deck: " + player2.toString() + "Size: " + player2.size() + "\n");
		builder.append("Player 2 Discard: " + discard2.toString() + "Size: " + discard2.size() + "\n");
		int size = player1.size() + player2.size() + discard1.size() + discard2.size();
		builder.append("Cards in play: " + size + "\n");
		return builder.toString();
	}
	
	/**
	 * Completes one turn of a game of War
	 */
	public void playTurn() {
		deckEmpty();
		Card one = player1.draw();
		System.out.println("Player 1 plays: " + one.toString());
		Card two = player2.draw();
		System.out.println("Player 2 plays: " + two.toString());
		if(one.getRank() > two.getRank()) {
			discard1.stackDeck(one);
			discard1.stackDeck(two);
			System.out.println("Player one wins [ " + one.toString() + "," + two.toString() + " ]");
		}
		else if(two.getRank() > one.getRank()) {
			discard2.stackDeck(one);
			discard2.stackDeck(two);
			System.out.println("Player two wins [ " + one.toString() + "," + two.toString() + " ]");
		}
		else
			war(one, two);
		repOK();
	}
	
	/**
	 * If both players draw the same card, takes over the game for a war
	 * Each player places 2 cards facedown (in an array of Cards) and one faceup
	 * The faceup card from each is compared, the winner gets all the cards added to their
	 * discard pile
	 * In the event of a tie, war() will call itself recursively. There will be no peace until victory.
	 * @return true when we have a clear winner
	 */
	private boolean war(Card uno, Card dos) {
		System.out.println("War!");
		ArrayList<Card> facedown = new ArrayList<Card>();
		facedown.add(uno);
		facedown.add(dos);
		for(int i = 0; i < 2; i++) {
			deckEmpty();
			facedown.add(player1.draw());
			facedown.add(player2.draw());
		}
		deckEmpty();
		Card one = player1.draw();
		Card two = player2.draw();
		facedown.add(one);
		facedown.add(two);
		if(one.getRank() > two.getRank()) {
			System.out.println("Player 1 wins: " + facedown.toString());
			for(Card x : facedown)
				discard1.stackDeck(x);
		}
		else if(two.getRank() > one.getRank()) {
			System.out.println("Player 2 wins: " + facedown.toString());
			for(Card x : facedown)
				discard2.stackDeck(x);
		}
		else
			war(facedown);
		repOK();
		return true;
			
	}
	/**
	 * Overload for recursive calls
	 */
	private boolean war(ArrayList<Card> spoils) {
		System.out.println("War!");
		ArrayList<Card> facedown = new ArrayList<Card>();
		for(int i = 0; i < 2; i++) {
			deckEmpty();
			facedown.add(player1.draw());
			facedown.add(player2.draw());
		}
		deckEmpty();
		Card one = player1.draw();
		Card two = player2.draw();
		facedown.add(one);
		facedown.add(two);
		if(one.getRank() > two.getRank()) {
			facedown.addAll(spoils);
			System.out.println("Player 1 wins: " + facedown.toString());
			for(Card x : facedown)
				discard1.stackDeck(x);
		}
		else if(two.getRank() > one.getRank()) {
			facedown.addAll(spoils);
			System.out.println("Player 2 wins: " + facedown.toString());
			for(Card x : facedown)
				discard2.stackDeck(x);
		}
		else {
			facedown.addAll(spoils);
			war(facedown);
		}
		repOK();
		return true;
			
	}

	/**
	 * Checks to see if either player deck is empty
	 * @return true if player decks still have cards in them, false if a player deck is empty
	 */
	private boolean deckEmpty() {
		if(player1.isEmpty())
			player1 = assignDiscard(player1, discard1);
		if(player2.isEmpty())
			player2 = assignDiscard(player2, discard2);
		repOK();
		return true;
	}
	
	/**
	 * If a players hand becomes empty, shuffles the discard pile
	 * assigns that as the players deck, and empties the discard pile
	 * @throws NullPointerException if the deck or discard pile is null
	 * @return true when complete
	 */
	private Deck assignDiscard(Deck deck, Deck discard) throws NullPointerException{
		if(deck == null)
			throw new NullPointerException("Deck cannot be null");
		if(discard == null)
			throw new NullPointerException("Discard pile cannot be null");
		if(deck.size() == 0 && discard.size() == 0) {
			this.wonGame();
			System.exit(0);
		}
		for(Card x : discard)
			deck.stackDeck(x);
		deck.oldManshuffle();
		discard.clear();
		return deck;
	}
	
	/**
	 * When the length of a players discard plus their deck is 52 (which means they have all of the cards)
	 * the game is over
	 * @return true if no one has won, false if there is a winner, prints a string to declare the winner,
	 * and the final state of each deck/discard pile
	 */
	public boolean wonGame() {
		if(((player1.size()) + (discard1.size())) >= 51) {
			System.out.println("PLAYER 1 VICTORY\n");
			System.out.println(this.toString());
			return true;
		}

		if(((player2.size()) + (discard2.size())) >= 51) {
			System.out.println("PLAYER 2 VICTORY\n");
			System.out.println(this.toString());
			return true;
		}
		
		return false;

	}
}
