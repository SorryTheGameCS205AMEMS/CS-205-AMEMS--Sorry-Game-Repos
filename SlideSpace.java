
public class SlideSpace extends BoardSpace {
	
	/****************************************** Fields ********************************************/
	private boolean arrow = false; // True if it is the arrow slide space
	private Color color;
	private boolean landing=false; ////true if is end spot of a slide
	private boolean entry=false; ////t
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
	
	public void placePawn(Pawn p)
	{
		if (arrow)
		{
			//do something
		}
		else
		{
			setOccupied(true);
			setPawn(p);
		}
	}
//////////////////////////////////////////////////////////////////////
//Arrow,landing,and entry Check and setters for slide by Nestor 
  public boolean isArrow(){
  return arrow;
  }
  
  public void setArrow(){
  arrow=true;
  }
  
  public boolean isLanding(){
  return landing;
  }
  
  public void setLanding(){
  landing=true;
  }
  
  public boolean isEnrty(){
  return entry;
  }
  
  public void setEntry(){
  entry=true;
  }


  
}
