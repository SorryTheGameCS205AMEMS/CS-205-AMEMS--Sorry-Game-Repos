import java.util.*;

public class BoardLogic {
	/****************************************** Fields ********************************************/
  
	// circular array with 60 spaces
	private ArrayList<BoardSpace> rectangleBoard;
	// 4 arrays of SafetySpaces, one of each color
	private SafetySpace[] safeR=new SafetySpace[5];
	private SafetySpace[] safeB=new SafetySpace[5];
	private SafetySpace[] safeY=new SafetySpace[5];
	private SafetySpace[] safeG=new SafetySpace[5];

	// 4 HomeSpaces
	/*
		Edited: HomeSpaces don't need to be arrays, because they don't 
		actually need to hold Pawns. They just need to know the number of
		Pawns that have reached that space. -Sean
	*/
	private HomeSpace homeR;
	private HomeSpace homeB;
	private HomeSpace homeY;
	private HomeSpace homeG;

	// 4 StartSpaces
	private StartSpace startR;
	private StartSpace startB;
	private StartSpace startY;
	private StartSpace startG;
	
/*************************************** Constructors *****************************************/
	public BoardLogic()
	{
		rectangleBoard = new ArrayList<BoardSpace>(60);
		/////////// Setup of saftey spaces
		for (int i = 0; i <= 4; i++)
		{
			safeR[i] = new SafetySpace(Color.RED, i);
			safeB[i] = new SafetySpace(Color.BLUE, i);
			safeY[i] = new SafetySpace(Color.YELLOW, i);
			safeG[i] = new SafetySpace(Color.GREEN, i);
		}
		
		////////setup of home spaces
		homeR = new HomeSpace(Color.RED);
		homeB = new HomeSpace(Color.BLUE);
		homeY = new HomeSpace(Color.YELLOW);
		homeG = new HomeSpace(Color.GREEN);
		
		// I added the StartSpaces here. I don't see them instantiated anywhere else. -Sean
		startR = new StartSpace(Color.RED);
		startB = new StartSpace(Color.BLUE);
		startY = new StartSpace(Color.YELLOW);
		startG = new StartSpace(Color.GREEN);
	
		ArrayList<SlideSpace> slides = new ArrayList<SlideSpace>();
		
		////////////////////
		//sets up the board in general as well as set slides and stuff.
		for (int i = 0; i<= 59; i++)
		{
			if (i>0 && i<5)
			{
				SlideSpace temp = new SlideSpace(Color.RED);
				if (i==1)
				{
					slides = new ArrayList<SlideSpace>(4);
					//temp.setLocation(i);
					temp.setArrow();
				}
				else if (i==4)
				{
					temp.setLanding();
					// Let the arrow space know the SlideSpaces it is connected to
					((SlideSpace) this.getSpaceAt(1)).connectSlideSpaces(slides);
				}
				else if (i==2)
				{
					temp.setEntry();	
				}
				
				temp.setLocation(i);
				slides.add(temp);
				rectangleBoard.add(temp);
			}
		 
			else if (i>8 && i<14)
			{
				SlideSpace temp = new SlideSpace(Color.RED);
				if (i == 9)
				{
					slides = new ArrayList<SlideSpace>(5);
					temp.setArrow();
				}
				else if (i == 13)
				{
					temp.setLanding();
					// Let the arrow space know the SlideSpaces it is connected to
					((SlideSpace) this.getSpaceAt(9)).connectSlideSpaces(slides);
				}
						
				temp.setLocation(i);
				slides.add(temp);
				rectangleBoard.add(temp);
			}
			 
			else if (i>=16 && i<20)
			{
				SlideSpace temp = new SlideSpace(Color.BLUE);
				
				if (i == 16)
				{
					slides = new ArrayList<SlideSpace>(4);
					temp.setArrow();
				}
				else if (i == 19)
				{
					temp.setLanding();
					// Let the arrow space know the SlideSpaces it is connected to
					((SlideSpace) this.getSpaceAt(16)).connectSlideSpaces(slides);
				}
				else if (i == 17)
					temp.setEntry();
						
				temp.setLocation(i);
				slides.add(temp);
				rectangleBoard.add(temp);
			}
			
			else if (i>=24 && i<29)
			{
				SlideSpace temp = new SlideSpace(Color.BLUE);
				
				if (i == 24)
				{
					slides = new ArrayList<SlideSpace>(5);
					temp.setArrow();
				}
				else if (i == 28)
				{
					temp.setLanding();
					// Let the arrow space know the SlideSpaces it is connected to
					((SlideSpace) this.getSpaceAt(24)).connectSlideSpaces(slides);
				}
				
				temp.setLocation(i);
				slides.add(temp);
				rectangleBoard.add(temp);
			}
			 
			else if (i>=31 && i<35)
			{
				SlideSpace temp = new SlideSpace(Color.YELLOW);
				
				if (i == 31)
				{
					slides = new ArrayList<SlideSpace>(4);
					temp.setArrow();
				}
				else if (i == 34)
				{
					temp.setLanding();
					// Let the arrow space know the SlideSpaces it is connected to
					((SlideSpace) this.getSpaceAt(31)).connectSlideSpaces(slides);
				}
				else if (i == 32)
					temp.setEntry();	
					
				temp.setLocation(i);
				slides.add(temp);
				rectangleBoard.add(temp);
			}
			
			else if (i>=39 && i<44)
			{
				SlideSpace temp = new SlideSpace(Color.YELLOW);
				
				if (i == 39)
				{
					slides = new ArrayList<SlideSpace>(5);
					temp.setArrow();
				}
				else if (i == 43)
				{
					temp.setLanding();	
					// Let the arrow space know the SlideSpaces it is connected to
					((SlideSpace) this.getSpaceAt(39)).connectSlideSpaces(slides);
				}
				
				temp.setLocation(i);
				slides.add(temp);
				rectangleBoard.add(temp);
			}
			
			else if (i>45 && i<50)
			{
				SlideSpace temp = new SlideSpace(Color.GREEN);
				
				if (i == 46)
				{
					slides = new ArrayList<SlideSpace>(4);
					temp.setArrow();
				}
				else if (i == 49)
				{
					temp.setLanding();
					// Let the arrow space know the SlideSpaces it is connected to
					((SlideSpace) this.getSpaceAt(46)).connectSlideSpaces(slides);
				}
				else if (i == 47)
					temp.setEntry();	
					
				temp.setLocation(i);
				slides.add(temp);
				rectangleBoard.add(temp);
			}
			
			else if (i>=54 && i<59)
			{
				SlideSpace temp = new SlideSpace(Color.GREEN);
				
				if (i == 54)
				{
					slides = new ArrayList<SlideSpace>(5);
					temp.setArrow();
				}
				else if (i == 58)
				{
					temp.setLanding();	
					// Let the arrow space know the SlideSpaces it is connected to
					((SlideSpace) this.getSpaceAt(54)).connectSlideSpaces(slides);
				}
					
				temp.setLocation(i);
				slides.add(temp);
				rectangleBoard.add(temp);
			}
			else
			{ 
				BoardSpace temp = new BoardSpace();
				temp.setLocation(i);
				rectangleBoard.add(temp);
			}
		 
		} // end for
	
	
	}
	/****************************************** Methods *******************************************/
	/////////////////////////////////////////
	//Checks if there is a pawn at the space
	public boolean isPawnAt(int index)
	{
		return rectangleBoard.get(index).isOccupied();
	}
	
	/////////////////////////////////////////////////
	//gets the pawn at a space by removing it from the space, returns null if no pawn present
	public Pawn getPawnAt(int index)
	{
		if(isPawnAt(index))
			return rectangleBoard.get(index).removePawn();
		else 
			return null;
	}
		
	//////////////////////////////////////////////
	//gets type of space at specfic index
	public BoardSpace getSpaceAt(int index)
	{
		return rectangleBoard.get(index);
	}
	
	//////////////////////////////////////////////////////////
	// returns slide's color and returns null if its not a slide
	/*
	public Color getSlideColor(int i)
	{
		if((i>0&&i<5)||(i>8&&i<14)||(i>16&&i<21)||(i>24&&i<30)||(i>31&&i<36)||(i>39&&i<45)||(i>46&&i<51)||(i>54&&i<60))
			return rectangleBoard.get(i).getColor();
		else 
			return null;
	}
	*/ // The getColor() method located in SlideSpace should be used instead. -Sean
	
	/**
	 * Places a Pawn at its respective start.
	 * @param p The Pawn to place at start.
	 */
	public void setPawnToStart(Pawn p)
	{
		if (p.getColor() == Color.RED)
			startR.placePawn(p);
		else if (p.getColor() == Color.BLUE)
			startB.placePawn(p);
		else if (p.getColor() == Color.YELLOW)
			startY.placePawn(p);
		else if (p.getColor() == Color.GREEN)
			startG.placePawn(p);
	}
	
	/**
	 * Places a Pawn at its respective home.
	 * @param p The Pawn to place at home.
	 */
	public void setPawnToHome(Pawn p)
	{
		if (p.getColor() == Color.RED)
			homeR.placePawn(p);
		else if (p.getColor() == Color.BLUE)
			homeB.placePawn(p);
		else if (p.getColor() == Color.YELLOW)
			homeY.placePawn(p);
		else if (p.getColor() == Color.GREEN)
			homeG.placePawn(p);
	}
	
	// Main method for testing
	public static void main(String[] args)
	{
		// Initialize a board
		BoardLogic board = new BoardLogic();
		
		BoardSpace space;
		
		// Print out each space on the board
		for (int i = 0; i < 60; i++)
		{
			space = board.getSpaceAt(i);
			if (space instanceof SlideSpace)
				System.out.println(space.getLocation() + ": SlideSpace " + ((SlideSpace) space).getColor());
			else
				System.out.println(i + ": BoardSpace");
		}
		
		// Test the slideSpaces ArrayList.
		ArrayList<SlideSpace> slides = ((SlideSpace) board.getSpaceAt(24)).getSlideSpaces();
		// Print out the SlideSpaces
		for (int i = 0; i < slides.size(); i++)
			System.out.println(slides.get(i));
		
		// Create Pawns and place them on the board.
		Pawn redPawn = new Pawn(Color.RED);
		Pawn bluePawn = new Pawn(Color.BLUE);
		Pawn yellowPawn = new Pawn(Color.YELLOW);
		Pawn greenPawn = new Pawn(Color.GREEN);
		
		// Place Pawn on boardSpace
		board.getSpaceAt(6).placePawn(yellowPawn);
		System.out.println(yellowPawn);
		board.getSpaceAt(11).placePawn(redPawn);
		System.out.println(redPawn);
		board.getSpaceAt(9).placePawn(greenPawn);
		System.out.println(redPawn);
		System.out.println(greenPawn);
		board.getSpaceAt(9).placePawn(bluePawn);
		System.out.println(bluePawn);
		System.out.println(greenPawn);
		board.getSpaceAt(9).placePawn(redPawn);
		System.out.println(redPawn);
		System.out.println(bluePawn); // SlideSpace appears to be working correctly!
		
	}
}
