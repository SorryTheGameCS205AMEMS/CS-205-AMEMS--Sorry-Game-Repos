import javax.swing.JOptionPane; 

public class HumanPlayer extends Player
{
	/****************************************** Fields ********************************************/
	private boolean cardDrawn;
	private boolean turnOver;
	/***************************************** Methods *******************************************/
	
	public HumanPlayer( String n, Color col )
	{
		super( n, col ); 
		cardDrawn = false; 
		turnOver = true; 
	}
	
	public void takeTurn()
	{
		turnOver = false;
		
		System.out.println("Waiting for you to draw a card..."); 
		while(!cardDrawn)
		{
			listenForDraw();
		}
		System.out.println("Card drawn! Time to do other stuff..."); 
		
		// choose a pawn
		System.out.println("Please choose a pawn to move"); 
		
		// apply card value to peg
	}
	
	public void listenForDraw()
	{
		int x = 0; 
		String input = null; 
		while( x == 0 )
		{
			input = JOptionPane.showInputDialog( null, "Enter a non-zero integer to draw a card" );
			x = Integer.parseInt( input ); 
		} 
		
		setCardDrawn( true );
	}
	
	public void setCardDrawn( boolean isDrawn) 
	{
		cardDrawn = true; 
	}
	
	public static void main(String[] args)
	{
		HumanPlayer me = new HumanPlayer("Ash", Color.GREEN);
		me.takeTurn();
	}
	
}
