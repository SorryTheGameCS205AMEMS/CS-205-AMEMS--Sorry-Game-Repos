
public class Pawn {
	/****************************************** Fields ********************************************/
	
	private Color color; 
	private Integer location;
	private Integer safetySpace;
	private boolean atStart = false;
	private boolean atHome = false;
	private Integer boardCell; 
	
	/*************************************** Constructors *****************************************/
	
	/**
	 * The only unique thing about a Pawn at the beginning of a game is its color.
	 * @param clr The color of the Pawn.
	 */
	public Pawn(Color clr)
	{
		color = clr;
	}
	
	/****************************************** Methods *******************************************/
	
	/**
	 * Sets the location of the Pawn on the main loop of spaces, not including StartSpace, HomeSpace
	 * and SafetySpace. This method should be passed a null value when the Pawn is at one of these
	 * locations.
	 * @param space The location of the Pawn, null if Pawn is at Start, Safety, or home space
	 */
	public void setBoardLocation(Integer space)
	{
		location = space;
	}
	
	/**
	 * Returns the index of the Pawn on the Board.
	 * @return The location of the pawn on the board.
	 */
	public Integer getBoardLocation()
	{
		return location;
	}
	
	/**
	 * The leaveStart method is to be called from the StartSpace when the pawn is removed from it.
	 */
	public void leaveStart()
	{
		atStart = false;
	}
	
	/**
	 * This method should be called when the Pawn is placed at a StartSpace.
	 */
	public void goToStart()
	{
		atStart = true;
		location = null;
		atHome = false;
		safetySpace = null;
	}
	
	/**
	 * Called when the Pawn reach home. Makes them unavailable for the rest of the game play.
	 */
	public void getHome()
	{
		atHome = true;
		location = null;
		atStart = false;
		
	}
	
	/**
	 * Sets all fields that identify the location of the pawn to null or false.
	 */
	public void remove()
	{
		location = null;
		safetySpace = null;
		atStart = false;
		atHome = false;
	}
	
	/**
	 * @return The color of the pawn.
	 */
	public Color getColor()
	{
		return color;
	}
	
	/**
	 * toString() method returns the state of the Pawn as a string.
	 */
	public String toString()
	{
		// Declare string
		String string;
		
		string = "Color: " + color + ", Location: " + location + ", Safety Space: " + safetySpace +
				", At Home: " + atHome + ", At Start: " + atStart;
		
		return string;
	}
	
	/**
	 * Returns the the cell number of the space the pawn is located.
	 * @return boardCell
	 */
	public Integer getCell()
	{
		return boardCell;
	}
	
	/**
	 * Sets the location of the Pawn in the safetySpace array.
	 * @param space The index of the Pawn in the SafetySpace array.
	 */
	public void setSafety(int space)
	{
		safetySpace = space;
	}
	
	// main method for testing
	public static void main(String[] args)
	{
		// make a new Pawn of each color
		Pawn redPawn = new Pawn(Color.RED);
		Pawn yellowPawn = new Pawn(Color.YELLOW);
		Pawn greenPawn = new Pawn(Color.GREEN);
		Pawn bluePawn = new Pawn(Color.BLUE);
		
		// test the toString method. It works!
		System.out.println(redPawn);
		
		/**
		 * List of methods to test.
		 * getColor(): It works!
		 * setBoardLocation(Integer space): It works!
		 * getBoardLocation(): It works!
		 * leaveStart(): Needs more work.
		 * goToStart(): It works!
		 * getHome(): 
		 */
		System.out.println(yellowPawn.getColor());
		greenPawn.setBoardLocation(46);
		System.out.println(greenPawn.getBoardLocation());
		bluePawn.goToStart();
		System.out.println(bluePawn);
		bluePawn.leaveStart();
		System.out.println(bluePawn);
		greenPawn.getHome();
		System.out.println(greenPawn);
	}
}
