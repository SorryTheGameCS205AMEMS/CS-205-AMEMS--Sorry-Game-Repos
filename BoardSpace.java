
public class BoardSpace {
	/****************************************** Fields ********************************************/
	private boolean occupied = false; // Is there a pawn there?
	private Pawn pawn; // holds color and which pawn
	//private Color color;
	private int location;

	/*************************************** Constructors *****************************************/
	
	public BoardSpace()
	{
		// not much to do here.
	}
	//////////////////////////////////////////////////////
	//Extra constructor Added to intialize color to make it easy to use for board
	//by nestor
	/**
	 * But not all board spaces have a color. Any board space that does have a color can have this
	 * in its own constructor. The color field should be removed from this class.
	 * -Sean
	 */
	/*
	public BoardSpace(Color clr)
	{
		color = clr;
	}
	*/
	/****************************************** Methods *******************************************/
	
	/**
	 * Check to see if there is a Pawn at this space.
	 * @return true if there is a Pawn here, false otherwise.
	 */
	 public boolean isOccupied()
	{
		return occupied;
	}
	
	/**
	 * Places a pawn at this location.
	 * @param p	The Pawn to place.
	 */
	public void placePawn(Pawn p)
	{
		if (isOccupied())
		{
			// Place the pawn occupying this space back at start.
			Pawn removedPawn;
			removedPawn = removePawn();
			removedPawn.goToStart();
			
			// Update the space with the new Pawn.
			p.setBoardLocation(location);
			setPawn(p);
			setOccupied(true);
		}
		else
		{
			// Update the space with the new Pawn.
			p.setBoardLocation(location);
			setPawn(p);
			setOccupied(true);
		}
	}
	
	/**
	 * Removes the Pawn from the board.
	 * @return The removed Pawn.
	 */
	public Pawn removePawn()
	{
		if (this.isOccupied())
		{
			occupied = false;
			pawn.remove();
			return pawn;
		}
		else
			return null; // An exception would be better
	}
	
	/**
	 * This method was originally public, but only placePawn and removPawn should
	 * be able to call this, so I set it to private. -Sean
	 * @param occ true if there is a pawn on this space, false otherwise.
	 */
	public void setOccupied(boolean occ)
	{
		occupied = occ;
	}
	
	/**
	 * This method was originally public, but only placePawn and removPawn should
	 * be able to call this, so I set it to private. -Sean
	 * @param p the Pawn the place.
	 */
	public void setPawn(Pawn p)
	{
		pawn = p;
	}
	
	/**
	 * @return A String representation of the board space.
	 */
	public String toString()
	{
		String str = "Occupied: ";
		
		if (isOccupied())
			str = str + isOccupied() + " Pawn: " + pawn.toString() + " Location: " + getLocation();
		else
			str = str + isOccupied()  + " Location: " + getLocation();
		
		return str;
	}
////////////////////////////////////////////
//pass over from slide space 	
	/**
	 * 
	 * @return The color of the slide space.
	 */
	/*
	public Color getColor()
	{
		return color;
	}
	*/
	
	/**
	 * Returns the index of the space in the board.
	 * @return location
	 */
	public int getLocation()
	{
		return location;
	}
	
	/**
	 * Sets the location of the space in the board. Should be set when the board is built.
	 * @param l The index of the space in the ArrayList.
	 */
	public void setLocation(int l)
	{
		location = l;
	}
	
	// main method for testing
	public static void main(String[] args)
	{
		/**
		 * Methods to test.
		 * isOccupied(): It works!
		 * placePawn(Pawn p): Works so far, but needs to set a location for the Pawn.
		 * removePawn(): It works!
		 * toString(): It works!
		 */
		
		// Initialize BoardSpace and a pawn to place on it.
		BoardSpace space = new BoardSpace();
		Pawn pawn = new Pawn(Color.RED);
		
		System.out.println(space);
		space.placePawn(pawn);
		System.out.println(space);
		space.removePawn();
		System.out.println(space);
		
	}

}
