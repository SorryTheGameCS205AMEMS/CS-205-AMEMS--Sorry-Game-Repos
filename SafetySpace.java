
public class SafetySpace extends BoardSpace 
{
	
	/****************************************** Fields ********************************************/
	private Color color;
	private int index;
	
	/*************************************** Constructors *****************************************/
	
	/**
	 * All SafetySpaces have a color
	 * @param clr The color of the space.
	 */
	public SafetySpace(Color clr, int i)
	{
		color = clr;
		index = i;
	}
	
	/****************************************** Methods *******************************************/
	
	/**
	 * Places a Pawn on the space. Sets the pawns 
	 */
	public void placePawn(Pawn p)
	{
		if (isOccupied() && p.getColor() == this.getColor())
		{
			System.out.println("Space is occupied!");
		}
		else if (p.getColor() == this.getColor())
		{
			setOccupied(true);
			p.setSafety(index);
			setPawn(p);
		}
		else
			System.out.println("Wrong Color!");
	}
	
	/**
	 * Returns the color of the SafetySpace.
	 * @return The color of the SafetySpace.
	 */
	public Color getColor()
	{
		return color;
	}

}
