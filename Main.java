package GoFishProject;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<Player>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter your name: ");
		String hname = scanner.nextLine();
		String cname = "Computer";
		
		players.add(hname);
		players.add(cname);
		
		ImplementCard card = new ImplementCard(rank, suit);
		ImplementDeck deck = new ImplementDeck();
		
		GoFishGame game = new GoFishGame(players, deck);
		
		HumanPlayer hPlayer = new HumanPlayer(hname, hand);
		ComputerPlayer cPlayer = new ComputerPlayer(cname, hand);
		
		
		

	}

}
