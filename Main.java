package GoFishProject;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<Player>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter your name: ");
		Player hname = System.in();
		Player cname = "Computer";
		
		players.add(hname);
		players.add(cname);
		
		
		ImplementDeck deck = new ImplementDeck();
			
		HumanPlayer hPlayer = new HumanPlayer(hname, hand);
		ComputerPlayer cPlayer = new ComputerPlayer(cname, hand);
		
	}	

	}
}
	
	public static void playGame(ArrayList<Player> players, deck) {
		GoFishGame game = new GoFishGame(players, deck);
		game.playTurn(cPlayer);
	}


