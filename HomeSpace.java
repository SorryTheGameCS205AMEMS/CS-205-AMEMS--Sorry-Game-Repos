
public class HomeSpace extends BoardSpace 
{
	/***************************************** Fields *********************************************/
	private int numHome = 0; 
	private Color color;

	/*************************************** Constructors *****************************************/
	
	/**
	 * The only thing that needs to be set when the HomeSpace is constructed is its color.
	 * @param clr The color of the HomeSpace.
	 */
	public HomeSpace(Color clr)
	{
		color = clr;
	}
	
	/****************************************** Methods *******************************************/

	/**
	 * Places a pawn in the HomeSpace, making it unavailable for gameplay.
	 * @param p The Pawn to place at home.
	 */
	public void placePawn(Pawn p)
	{
		p.getHome();
		numHome++;
		
		if (numHome == 4)
		{
			// We have a winner
		}
	}
}
