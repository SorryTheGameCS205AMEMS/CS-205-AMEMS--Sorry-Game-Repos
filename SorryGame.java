import java.util.concurrent.ArrayBlockingQueue;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class SorryGame 
{
	/****************************************** Fields ********************************************/
	
	private int numOpponents;	// number of computer players
	private Deck deck;
	private HumanPlayer human; // Always going to be there.
	private ArrayBlockingQueue<Player> playerQueue;
	private BoardLogic board;
	private boolean gameOver = false; // To know when to break out of the game loop.
	
	// Pawn arrays
	private Pawn[] redPawns;
	private Pawn[] yellowPawns;
	private Pawn[] bluePawns;
	private Pawn[] greenPawns;
	
	/*************************************** Constructors *****************************************/
	
	/**
	 * Right now this just build everything needed for two players. The game logic is not here yet,
	 * but the players should be able to move their pawns around the board.
	 */
	public SorryGame()
	{
		/*
		// For getting user input
		Scanner scanner = new Scanner(System.in);
		String input;
		
		// Get the number of players
		System.out.print("Enter the number of players: ");
		numOpponents = scanner.nextInt();
		*/
		numOpponents = 2;
		playerQueue = new ArrayBlockingQueue<Player>(numOpponents);
		
		// Create the players
		HumanPlayer human1 = new HumanPlayer("Sean", Color.BLUE);
		HumanPlayer human2 = new HumanPlayer("Mullen", Color.GREEN);
		// Add the players to the queue
		playerQueue.offer(human1);
		playerQueue.offer(human2);	
		
		// Instantiate the pawns
		bluePawns = new Pawn[4];
		greenPawns = new Pawn[4];
		for (int i = 0; i < 4; i++)
		{
			bluePawns[i] = new Pawn(Color.BLUE);
			greenPawns[i] = new Pawn(Color.GREEN);
		}	
		
		// Instantiate the deck
		deck = new Deck();
		
		// Instantiate the board
		board = new BoardLogic();

		// Place pawns on the start spaces
		for (int i = 0; i < 4; i++)
		{
			
			System.out.println(bluePawns[i]);
			System.out.println(greenPawns[i]);
			
			// Getting a NullPointerException here, but not when I do the above print statements.
			// Fixed the problem: StartSpaces wern't instantiated.
			board.setPawnToStart(bluePawns[i]);
			board.setPawnToStart(greenPawns[i]);
			
			// These Pawns should report true for atStart, but they are not.
			// I added the Pawn.goToStart() method and now this works. The method is called
			// from the StartSpace.placePawn() method. - Sean
			System.out.println(bluePawns[i]);
			System.out.println(greenPawns[i]);

		}
		
	}
	
	/****************************************** Methods *******************************************/
	
	private void playGame()
	{
		// Scanner for user input, won't be necessary in the final version of the game.
		Scanner scanner = new Scanner(System.in);
		
		// To hold the current player
		Player currentTurn;
					
		// Loop through the players and have them take a turn
		while (!gameOver)
		{ 	
			// remove the Player whos current turn it is out of the queue.
			currentTurn = playerQueue.poll();
			System.out.println(playerQueue); // Show it is cycling through the players properly
											 // Problem must exist in Player.takeTurn() method
			
			// Have that player take their turn
			currentTurn.takeTurn();
			
			// Return Player to the Queue when they finish their turn.
			playerQueue.offer(currentTurn); // Something isn't working right here. Try put instead
			//playerQueue.put(currentTurn); // Not working either.
			
			// Ask if the game is over, because there is no game logic in place to do so yet.
			System.out.println("Is the game over? ");
			String input = JOptionPane.showInputDialog( null, "Is the game over? true or false" );
			gameOver = Boolean.parseBoolean(input);
			
		}
	}
	
	/**
	*/
	public Card getTopCard()
	{
		return deck.draw();
	}
	
	/**
	 *	takes in the coordinates of the pawn to move.
	 *	Then moves all the pawns to their respective locations.
	 *	returns all the pawns for the gui to draw.
	 */
	public Pawn[] movePawn(int x, int y)
	{
		int spaceNum;
		// Need to determine which pawn to move, how many spaces, and what other
		// pawns need to move as a consequence
		
		// Translate coordinate to a specific space.
		spaceNum = findCoordinates(x, y);
		
		// If there is a Pawn at this space.
		if (board.isPawnAt(spaceNum))
		{
			// Determine where it should move.
		
			// If there is a pawn at this space, put it at home.
		
			// Move the Pawn to its new location.
		}
		
		// Create the array of pawns to return
		Pawn[] allPawns = new Pawn[16];
		for (int i = 0; i < 4; i++)
		{
			allPawns[i] = redPawns[i];
			allPawns[i+4] = bluePawns[i];
			allPawns[i+8] = yellowPawns[i];
			allPawns[i+12] = greenPawns[i];
		}
		return allPawns;
	}
	
	/**
	 *	returns true if the game is over, false otherwise.
	 */
	public boolean isOver()
	{
		return gameOver;
	}
	
	/**
	 * Takes the coodinate system used by the GUI and translates it to a space on the
	 * logical board. Facillitates the communitaion between logic and GUI.
	 * @param x The row the pawn is at.
	 * @param y The column the pawn is at.
	 * @return An int that will index a correct space in the board logic.
	 */
	private int findCoordinates(int x, int y)
	{
		int space = -1;
		
		if (x == 0)
			 space = y;
		else if (y == 15)
			space = 15 + x;
		else if (x == 15)
			space = 30 + (15 - y);
		else if (y == 0)
			space = 45 + (15 - x);
			
		return space;
	}
	
	// main method for testing
	public static void main(String[] args)
	{
		SorryGame game = new SorryGame();
		
		game.playGame();
		
		System.exit(0);
	}

}
