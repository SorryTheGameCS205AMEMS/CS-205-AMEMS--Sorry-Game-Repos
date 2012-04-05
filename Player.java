
public abstract class Player 
{
	protected Color playerColor;
	protected String name;  
	/******************************** Methods *****************************************************/
	public abstract void takeTurn();
	
	public Player( String n, Color col )
	{
		setColor( col );  
		setName( n ); 
	}
	
	public void setColor( Color c )
	{
		playerColor = c; 
	}
	
	public Color getColor()
	{
		return playerColor; 
	}
	
	public void setName( String n )
	{
		name = new String( n ); 
	}
	
	public String getName()
	{
		return name; 
	}
	
	public void choosePeg()
	{
	}
}
