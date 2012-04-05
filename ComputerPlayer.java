public class ComputerPlayer extends Player
{
	/*************************** Constructors *********************************/
	
	public ComputerPlayer()
	{
		super(generateName(), Color.GREEN);
	}
	
	/******************************* Methods **********************************/
	
	public void takeTurn()
	{
		// Need to know more about game logic to write this.
	}

	private void generateName()
	{
		super.setName("default name");
	}
	
	// main method for testing.
	public static void main(String[] args)
	{
		ComputerPlayer player = new ComputerPlayer();
		System.out.println(player.getName());
		for (int i = 0; i < NUMPAWNS; i++)
		{
			System.out.println(player.pawnAt(i).color());
		}
	}
}