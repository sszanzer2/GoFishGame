package GoFishProject;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		    // Create and initialize your players
		    List<Player> players = new ArrayList<>();
		    players.add(new HumanPlayer("Player 1", new ArrayList<Card>()));
		    players.add(new ComputerPlayer("Computer", new ArrayList<Card>()));
		    
		    // Create and initialize your deck
		    Deck deck = new ImplementDeck();

		    // Create the game and start it
		    GoFishGame game = new GoFishGame(players, deck);
		    game.startGame();
		
	}


}