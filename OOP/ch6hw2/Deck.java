package ch6hw2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/*
 * A playing card deck, like your grandpa used to use
 * 
 * @author Jim DiCesare
 * 
 */

public class Deck implements Iterable<Card>{
	
	/** The size of all decks*/
	private static final int DECK_SIZE = 52;
	
	/** The cards of the deck, cannot be null, must have 52 elements */
	private Card[] deck;
	
	/** How many cards are currently in the deck*/
	private int size;
	
	private void repOK() {
		assert (deck != null) : "deck cannot be null";
		assert (deck.length > 0) : "deck MUST be > 0";
		assert (size >= 0) : "deck cannot have less than 0 cards";
		assert (size <= deck.length) : "size must be less than deck.length";
	}

	/**
	 * Instantiates a Deck object and points
	 * all cards to null
	 */
	public Deck() {
		clear();
	}
	
	/**
	 * Builds a 52 card deck so your grandpa can play war
	 * 13 cards in 4 suits
	 * @return true if deck built successfully
	 */
	public boolean buildDeck() {
		Suit suitz[] = {Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES};
		for(int i = 0; i < 4; i++) {
			for(int j = 1; j < 14; j++) {
				deck[size] = new Card(j, suitz[i]);
				size++;
			}
		}
		repOK();
		return true;
	}

	/** Creates the deck - the list of Card objects representing a deck
	 *  Sets the number of cards in the deck to 0, points each Card object 
	 *  to null
	 */
	public void clear() {
		deck = new Card[DECK_SIZE];
			for(Card x : deck) {
				x = null;
			}
		size = 0;
		repOK();
	}

	/**
	 * Shows the current number of cards in the deck
	 * @return number of cards in the deck
	 */
	public int size() {
		return size;
	}

	/**
	 * Checks if the deck is empty
	 * @return true if deck is empty, false if no
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	
	/**
	 * Shuffles well enough to make your grandpa proud
	 * Randomizes the positions of Card objects in the deck
	 * @return true if sorted
	 */
	public boolean oldManshuffle() {
		int oldSize = this.size();
		Card[] tempDeck = deck;
		this.clear();
		Random rand = new Random();
			boolean assign = true;
			while(assign) {
				int randPos = rand.nextInt(oldSize);
				if(deck[randPos] == null) {
					deck[randPos] = tempDeck[this.size];
					this.size++;
				}
				else if(this.size() == oldSize)
					assign = false;
				else
					continue;
			}
		repOK();
		return true;
	}
	
	/**
	 * Shows the top card of the deck
	 * @return toString of the card on top
	 */
	public String pullTopCard() {
		return deck[size].toString();
	}
	
	/**
	 * Grab the top card of the deck, reduce deck size by
	 * 1 card
	 * @throws NoSuchElementException if the deck is empty
	 * @return the top card
	 */
	public Card draw() throws NoSuchElementException{
		if(size <= 0)
			throw new NoSuchElementException("The deck is empty!");
			
		Card top = deck[size-1];
		size--;
		repOK();
		return top;
	}
	
	/**
	 * Adds a single card to the top of the deck
	 * @return true if card added successfully, false if deck
	 * is already full
	 */
	public boolean stackDeck(Card e) {
		if(size >= 52)
			return false;
		if(e == null)
			return false;
		
		deck[size] = e;
		size++;
		repOK();
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ ");
		for(int i = 0; i < this.size; i++) {
			builder.append(deck[i].toString());
			builder.append(',');
		}
		builder.append(" ]");
		return builder.toString();
	}

	public Iterator<Card> iterator() {
		return new Iterator<Card>() {
			private int next = 0;
			
			public boolean hasNext() {
				return (next < size);
			}

			public Card next() {
				if(next >= size) {
					throw new NoSuchElementException();
				}
				return deck[next++];
			}
		};
	}


}
		
	
	
	

	

	

	

	
