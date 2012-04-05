import java.util.*;

/** 
 * The Deck class represents the Deck
 *
 * @author Jake Montanaro
 * @version 0.0 Mar 13, 2012
 *
 *
 */
public class Deck{
	
	/**
	 * Array of cards to represent the Deck
	 */
	private Card [] cards;
	
	/**
	 * The number of Cards remaining
	 */
	private int cardsLeft;
	
	/**
	 * Constant limiting the Cards in a deck
	 */
	private int MAX_DECK_LENGTH = 45;
	
	/**
	 * Deck Class Contructor, no Parameters
	 */
	public Deck(){
		cards = new Card [MAX_DECK_LENGTH];
		cardsLeft = MAX_DECK_LENGTH;
		initialize();//creates and adds cards to deck
	}
	
	/**
	 * Initializes Cards and Adds them to the array, then calls shuffle
	 */
	private void initialize(){
		for(int i = 0; i < 5; i++)
			cards[i] = new Card(1, false);
		for(int i = 5; i < 9; i++)
			cards[i] = new Card(2, false);
		for(int i = 9;i < 13; i++)
			cards[i] = new Card(3, false);
		for(int i = 13; i < 17; i++)
			cards[i] = new Card(4, false);	
		for(int i = 17; i < 21; i++)
			cards[i] = new Card(5, false);
		for(int i = 21; i < 25; i++)
			cards[i] = new Card(7, false);
		for(int i = 25; i < 29; i++)
			cards[i] = new Card(8, false);
		for(int i = 29; i < 33; i++)
			cards[i] = new Card(10, false);
		for(int i = 33; i < 37; i++)
			cards[i] = new Card(11, false);
		for(int i = 37; i < 41; i++)
			cards[i] = new Card(12, false);
		for(int i = 41; i < MAX_DECK_LENGTH; i++)
			cards[i] = new Card(0, true);
			
		shuffle();
	}
	
	/**
	 * Shuffles the Deck
	 */
	 private void shuffle(){
	 	for (int i = 0; i < MAX_DECK_LENGTH; i++){
	 		Random generator = new Random();
	 		int randIndex = generator.nextInt(MAX_DECK_LENGTH);
	 		Card temp = cards[i];
	 		cards[i] = cards[randIndex];
	 		cards[randIndex] = temp;
	 	}
	 }
	 
	 /**
	  * Pops Card off Deck, decrements cardsLeft
	  * @return cards[cardsLeft] the top card on deck
	  */
	 public Card draw(){
	 	Card topCard = cards[cardsLeft - 1];
	 	cardsLeft--;
	 	return topCard;
	 }
	 
	 /**
	  * Peek at top Card
	  * @return String value of top Card
	  */
	 public String peek(){
	 	return cards[cardsLeft - 1].toStringBasic();
	 }
	
	/**
	 * Returns number of cards remaining in Deck
	 * @return cardLeft
	 */
	public int getCardsLeft(){
		return cardsLeft;
	}
	
	/**
	 * Returns String representation of the Deck
	 * @return String value of Deck
	 */
	public String toString(){
		String s = "";
		for (int i = 0; i < cardsLeft; i++)
			s += i + "). " + cards[i].toStringBasic() + "\n";
		return s;
	}
	
	public static void main(String[] args)
	{
		Deck deck = new Deck();
	}
}