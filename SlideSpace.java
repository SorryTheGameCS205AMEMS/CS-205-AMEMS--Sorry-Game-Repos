import java.util.ArrayList;

public class SlideSpace extends BoardSpace 
{
	
	/****************************************** Fields ********************************************/
	private boolean arrow = false; // True if it is the arrow slide space
	private Color color;
	private boolean landing = false; ////true if is end spot of a slide
	private boolean entry = false; ////t
	private ArrayList<SlideSpace> slideSpaces;
	
	/*************************************** Constructors *****************************************/
	
	/**
	 * This constructor is to be used if the space is not an arrow space.
	 * @param clr The color of the SlideSpace
	 */
	public SlideSpace(Color clr)
	{
		color = clr;
	}
	
	/**
	 * This constructor can be used for any of the SlideSpaces, but must be used for an arrow space.
	 * @param clr The color of the SlideSpace
	 * @param arw True if it is an arrow space, false otherwise.
	 */
	public SlideSpace(Color clr, boolean arw)
	{
		color = clr;
		arrow = arw;
	}
	
	/****************************************** Methods *******************************************/
	
	/**
	 * 
	 * @return The color of the slide space.
	 */
	public Color getColor()
	{
		return color;
	}
	// Somewhere there needs to be a method that checks if the space is an arrow space,
	// and if so, moves the pawns accordingly.
	
	/**
	 * Places the pawn at its appropriate location and bumps any Pawns back home that need
	 * to be as a result of placing the Pawn.
	 * @param p The Pawn to place.
	 */
	public void placePawn(Pawn p) // not working yet
	{
		Pawn removedPawn; // To hold a Pawn after it is removed from a space.
		
		// This also need to check if the exact space it's landing is occupied.
		if (arrow && (p.getColor() != this.getColor()))
		{
			for (int i = 0; i < slideSpaces.size(); i++)
			{
				if (slideSpaces.get(i).isOccupied())
				{
					System.out.println(i + " is occupied");
					removedPawn = slideSpaces.get(i).removePawn();
					removedPawn.goToStart();
				}
			}
			slideSpaces.get(slideSpaces.size() - 1).setOccupied(true);
			slideSpaces.get(slideSpaces.size() - 1).setPawn(p); // Create pointer to Pawn
			p.setBoardLocation(slideSpaces.get(slideSpaces.size() - 1).getLocation()); // Set the Pawns board location
			
		}
		else
		{
			setOccupied(true);
			p.setBoardLocation(getLocation());
			setPawn(p);
		}
	}
	
	//////////////////////////////////////////////////////////////////////
	//Arrow,landing,and entry Check and setters for slide by Nestor 
	public boolean isArrow()
	{
		return arrow;
	}
	  
	public void setArrow()
	{
		arrow = true;
	}
  
	public boolean isLanding()
	{
		return landing;
	}
	  
	public void setLanding()
	{
		landing=true;
	}
	  
	public boolean isEntry()
	{
		return entry;
	}
	  
	public void setEntry()
	{
		entry=true;
	}
///////////////////////////////////////////////////////////
	
	/**
	 * If the SlideSpace is an arrow, it needs to know all the places it slides past.
	 * @param slides An array of the SlideSpaces connected to the arrow.
	 */
	public void connectSlideSpaces(ArrayList<SlideSpace> slides)
	{
		slideSpaces = slides;
	}
	
	/**
	 * I made this just for testing, but it might be useful.
	 * @return If and arrow space it returns the list of slideSpaces it is connected to, 
	 * null otherwise.
	 */
	public ArrayList<SlideSpace> getSlideSpaces()
	{
		return slideSpaces;
	}
  
}
