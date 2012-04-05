/**
 * The Card class creates an instanse of a Card to be added to the Deck
 *
 * @author Jake Montanaro
 * @version 0.0 Mar 13, 2012
 * 
 *
 */


public class Card{
	
	public int value;
	public boolean sorryCard;
	
	/**
	 * Constructs instance of a Card given 2 parameters
	 * @param num Integer of the new card (0 if Sorry! card).
	 * @param sor Boolean value for Sorry! cards
	 */
	public Card(int num, boolean sor){
		if (sor == true){
			sorryCard = sor;
			value = 0;
		}else{
			value = num;
			sorryCard = false;
		}
	}
	
	/**
	 * Constructs instance of a Card given 1 parameter
	 * @param num The value of the new card (0 if Sorry! card).
	 */
	public Card(int num){
		if (num == 0)
			sorryCard = true;
		else
			sorryCard = false;
		
		value = num;
	}
	
	/**
	 * Gets card value
	 * @return value assigned to the card
	 */
	public int getValue(){
		return value;
	}
	
	/**
	 * Checks if card is a Sorry! card
	 * @return true if sorryCard == true
	 */
	public boolean getSorry(){
		return sorryCard;
	}
	
	/**
	 * Returns the most basic String representation fo the Card
	 * @return s number value, or "Sorry!"
	 */
	public String toStringBasic(){
		String s = "";
		if(sorryCard)
			s = "Sorry!";
		else
			s = Integer.toString(value);
		return s;
	}
	
	/**
	 * Reuturns String value of the Card including it's function
	 * @return s Card value plus instructions
	 */
	public String toStringFull(){
		String s = "";
		if (sorryCard){
			s = "Sorry!" +
				": \n" + 
				"Move any one pawn from Start to a square occupied by any opponent, sending that pawn back to its own Start.\n";
		}else{
			switch (value) {
				case 1: s = value +
							": \n" + 
							"Move a pawn from Start or move a pawn 1 space forward.\n";
					break;
				case 2: s = value + 
							": \n" + 
							"Move a pawn from Start or move a pawn 2 spaces forward. Drawing a 2 entitles the player to draw again at the end of his or her turn. If you cannot use 2, you can still draw again.\n";
					break;
				case 3: s = value + 
							": \n" + 
							"Move a pawn 3 spaces forward.\n";
					break;
				case 4: s = value +
							": \n" + 
							"Move a pawn 4 spaces backwards.\n";
					break;
				case 5: s = value +
							": \n" + 
							"Move a pawn 5 spaces forward.\n";
					break;
				case 7: s = value +
							": \n" + 
							"Move one pawn 7 spaces forward or split the 7 spaces between two pawns (such as four spaces for one pawn and three for another). This makes it possible for two pawns to enter Home on the same turn, for example. The 7 cannot be split into a 6 and 1 or a 5 and 2 for the purposes of moving out of Start. The entire seven spaces must be used one way or the other or the turn is lost.\n";
					break;
				case 8: s = value +
							": \n" + 
							"Move a pawn 8 spaces forward.\n";
					break;
				case 10: s = value +
							": \n" + 
							"Move a pawn 10 spaces forward or 1 space backward. If a player cannot go forward ten spaces, he/she must go back one space.\n";
					break;
				case 11: s = value +
							": \n" + 
							"Move 11 spaces forward or switch places with one opposing pawn; if the player cannot move 11 spaces, he/she is not forced to switch and instead can forfeit his or her turn.\n";
					break;
				case 12: s = value +
							": \n" + 
							"Move a pawn 12 spaces forward.\n";
					break;
				case 0: s = "Sorry!" +
							": \n" + 
							"Move any one pawn from Start to a square occupied by any opponent, sending that pawn back to its own Start.\n";
					break;
				default: s = "This doesn't appear to be a Sorry! Card";
					break;
			}//switch
		}//if else
		return s;//String Rep of Card
	}//toStringFull()
	
}//Class Card









