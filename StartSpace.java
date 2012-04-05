import java.util.Stack; // To hold the pointers to Pawns at the StartSpace

public class StartSpace extends BoardSpace {
	/****************************************** Fields ********************************************/
	private Color color;
	private int numPawns = 0;
	private Stack<Pawn> pawnStack;
	private BoardSpace boardStart; // Where the Pawn is placed when it exits the StartSpace
	
	/*************************************** Constructors *****************************************/
	
	public StartSpace(Color clr)
	{
		color = clr;
		pawnStack = new Stack<Pawn>();
	}
	
	/****************************************** Methods *******************************************/
	
	/**
	 * Adds a pawn to the start space. There should be no more than 4 pawns in one start space.
	 * @param pawn The Pawn to place.
	 */
	public void placePawn(Pawn pawn)
	{
		if (pawn.getColor() == this.color && this.numPawns < 4)
		{
			// Increment number of pawns
			numPawns++;
				
			// Take the pawn off the regular spaces
			pawn.setBoardLocation(null);
			
			// Set the atStart to true;
			pawn.goToStart();
				
			// Add pawn to pawnStack
			pawnStack.push(pawn);
		}
	}
	
	/**
	 * Removes a Pawn from the StartSpace.
	 * @param pawn
	 * @return
	 */
	public Pawn removePawn()
	{
		// Initialize pawn variable
		Pawn pawn; 
		
		// Decrease the number of pawns in the start space.
		numPawns--;
		
		// Remove a Pawn from the stack.
		pawn = pawnStack.pop();
		
		// The pawn leaves start.
		pawn.leaveStart();
		
		// Return the pawn to be placed elsewhere on the board.
		return pawn;
	}
	
	/**
	 * 
	 * @return true if there are no Pawn at the StartSpace, false otherwise.
	 */
	public boolean isEmpty()
	{
		return pawnStack.isEmpty();
	}
	
	/**
	 * Getter method for numPawns.
	 * @return The number of Pawns in the StartSpace.
	 */
	public int getNumPawns()
	{
		return numPawns;
	}
	
	public String toString()
	{
		// Declare string
		String string;
		
		string = "Color: " + color + ", Pawns: " + numPawns;
		return string;
	}
	
	// Main method for testing
	public static void main(String[] args)
	{
		// Instantiate pawns
		Pawn pawn1 = new Pawn(Color.RED); Pawn pawn2 = new Pawn(Color.RED);
		Pawn pawn3 = new Pawn(Color.RED); Pawn pawn4 = new Pawn(Color.RED);
		Pawn pawn5 = new Pawn(Color.RED); Pawn greenPawn = new Pawn(Color.GREEN);
		
		// Instantiate StartSpace
		StartSpace space = new StartSpace(Color.RED);
		
		/**
		 * Methods to test.
		 * placePawn(Pawn pawn): It works!
		 * removePawn(): It works!
		 * isEmpty(): It works!
		 * getNumPawns(): It works!
		 * toString(): It works!
		 */
		
		System.out.println(space.isEmpty());
		// Add the pawns
		space.placePawn(pawn1);
		System.out.println(space.isEmpty());
		System.out.println(space);
		System.out.println(space.getNumPawns());
		System.out.println(pawn1); // Check to see if the pawn knows it position, atStart == true
		space.placePawn(pawn2); space.placePawn(pawn3); space.placePawn(pawn4); space.placePawn(pawn5); // This Pawn should not be placed
		System.out.println(space); // 5 pawn placed, but only 4 should be at this space.
		// Remove Pawns
		Pawn removedPawn;
		removedPawn = space.removePawn();
		System.out.println(removedPawn);
		System.out.println(space);
		// Place a green Pawn in a red StartSpace
		space.placePawn(greenPawn); 
		System.out.println(space); // space should have the same number of pawns
		System.out.println(greenPawn);
		
	}
}
