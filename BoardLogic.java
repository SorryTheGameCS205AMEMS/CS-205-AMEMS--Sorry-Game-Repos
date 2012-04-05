import java.util.*;

public class BoardLogic {
	/****************************************** Fields ********************************************/
  
	// circular array with 60 spaces
	private ArrayList<BoardSpace> RectangleBoard;
	// 4 arrays of SafetySpaces, one of each color
	private SafetySpace[] SafeR=new SafetySpace[5];
	private SafetySpace[] SafeB=new SafetySpace[5];
	private SafetySpace[] SafeY=new SafetySpace[5];
	private SafetySpace[] SafeG=new SafetySpace[5];

	// 4 HomeSpaces
	/*
		Edited: HomeSpaces don't need to be arrays, because they don't 
		actually need to hold Pawns. They just need to know the number of
		Pawns that have reached that space. -Sean
	*/
	private HomeSpace HomeR;
	private HomeSpace HomeB;
	private HomeSpace HomeY;
	private HomeSpace HomeG;

	// 4 StartSpaces
	private StartSpace startR;
	private StartSpace startB;
	private StartSpace startY;
	private StartSpace startG;
	
/*************************************** Constructors *****************************************/
	public BoardLogic()
	{
		RectangleBoard = new ArrayList(60);
		/////////// Setup of saftey spaces
		for (int i = 0; i <= 4; i++)
		{
			SafeR[i] = new SafetySpace(Color.RED);
			SafeB[i] = new SafetySpace(Color.BLUE);
			SafeY[i] = new SafetySpace(Color.YELLOW);
			SafeG[i] = new SafetySpace(Color.GREEN);
		}
		
		////////setup of home spaces
		HomeR = new HomeSpace(Color.RED);
		HomeB = new HomeSpace(Color.BLUE);
		HomeY = new HomeSpace(Color.YELLOW);
		HomeG = new HomeSpace(Color.GREEN);
		
		// I added the StartSpaces here. I don't see them instantiated anywhere else. -Sean
		startR = new StartSpace(Color.RED);
		startB = new StartSpace(Color.BLUE);
		startY = new StartSpace(Color.YELLOW);
		startG = new StartSpace(Color.GREEN);
	
		////////////////////
		//sets up the board in general as well as set slides and stuff.
		for (int i = 0; i<= 59; i++)
		{
			if (i>0 && i<5)
			{
				SlideSpace temp = new SlideSpace(Color.RED);
				if (i==1)
					temp.setArrow();
				else if (i==4)
					temp.setLanding();
				else if (i==2)
					temp.setEntry();	
					
				RectangleBoard.add(temp);
			}
		 
			else if (i>8 && i<14)
			{
				SlideSpace temp = new SlideSpace(Color.RED);
				if (i == 9)
					temp.setArrow();
				else if (i == 13)
					temp.setLanding();
						
				RectangleBoard.add(temp);
			}
			 
			else if (i>16 && i<21)
			{
				SlideSpace temp = new SlideSpace(Color.BLUE);
				
				if (i == 17)
					temp.setArrow();
				else if (i == 20)
					temp.setLanding();
				else if (i == 18)
					temp.setEntry();
						
				RectangleBoard.add(temp);
			}
			
			else if (i>24 && i<30)
			{
				SlideSpace temp = new SlideSpace(Color.BLUE);
				
				if (i == 15)
					temp.setArrow();
				else if (i == 29)
					temp.setLanding();
						
				RectangleBoard.add(temp);
			}
			 
			else if (i>31 && i<36)
			{
				SlideSpace temp = new SlideSpace(Color.YELLOW);
				
				if (i == 32)
					temp.setArrow();
				else if (i == 35)
					temp.setLanding();
				else if (i == 33)
					temp.setEntry();	
					
				RectangleBoard.add(temp);
			}
			
			else if (i>39&&i<45)
			{
				SlideSpace temp = new SlideSpace(Color.YELLOW);
				
				if (i == 30)
					temp.setArrow();
				else if (i == 44)
					temp.setLanding();	
					
				RectangleBoard.add(temp);
			}
			
			else if (i>46 && i<51)
			{
				SlideSpace temp = new SlideSpace(Color.GREEN);
				
				if (i == 46)
					temp.setArrow();
				else if (i == 50)
					temp.setLanding();
				else if (i == 48)
					temp.setEntry();	
					
				RectangleBoard.add(temp);
			}
			
			else if (i>54 && i<60)
			{
				SlideSpace temp = new SlideSpace(Color.GREEN);
				
				if (i == 55)
					temp.setArrow();
				else if (i == 59)
					temp.setLanding();	
					
				RectangleBoard.add(temp);
			}
			else
			{ 
				BoardSpace temp = new BoardSpace();
				RectangleBoard.add(temp);
			}
		 
		}
	
	
	}
	/****************************************** Methods *******************************************/
	/////////////////////////////////////////
	//Checks if there is a pawn at the space
	public boolean isPawnAt(int index)
	{
		return RectangleBoard.get(index).isOccupied();
	}
	
	/////////////////////////////////////////////////
	//gets the pawn at a space by removing it from the space, returns null if no pawn present
	public Pawn getPawnAt(int index)
	{
		if(isPawnAt(index))
			return RectangleBoard.get(index).removePawn();
		else 
			return null;
	}
		
	//////////////////////////////////////////////
	//gets type of space at specfic index
	public BoardSpace GetSpaceAt(int index)
	{
		return RectangleBoard.get(index);
	}
	
	//////////////////////////////////////////////////////////
	// returns slide's color and returns null if its not a slide
	public Color getSlideColor(int i)
	{
		if((i>0&&i<5)||(i>8&&i<14)||(i>16&&i<21)||(i>24&&i<30)||(i>31&&i<36)||(i>39&&i<45)||(i>46&&i<51)||(i>54&&i<60))
			return RectangleBoard.get(i).getColor();
		else 
			return null;
	}
	
	/////////////////////////////////////////////////
	//given a pawn it returns it to their respective start	
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
}
