package GoFishProject;
import java.util.List;
import java.util.Random;

public class ComputerPlayer implements Player {
    private String name;
    private List<Card> hand;

    public ComputerPlayer(String name, List<Card> hand) {
        this.name = name;
        this.hand = hand;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Card> getHand() {
        return hand;
    }

    @Override
    public void addToHand(Card card) {
        hand.add(card);
    }
    public void removeFromHand(Card card) {
    	hand.remove(card);
    }

    @Override
    public Card play() {
        //checking to see if the computer's hand is empty
        if (hand.isEmpty()) {
            System.out.println(getName() + " has no cards left to play.");
            
        }
    	
    	// Choosing a random card to ask for from the computer's hand 
        Random random = new Random();
        int index = random.nextInt(hand.size());
        Card cardToPlay = hand.get(index);
        
        
        System.out.println(getName() + " asks for a " + cardToPlay);
        
        return cardToPlay;

    }

	@Override
	public int checkForSets() {
		    int set = 0;
		    for (int i = 0; i < hand.size(); i++) {
		        int count = 1;
		        for (int j = i + 1; j < hand.size(); j++) {
		            if (hand.get(i).equals(hand.get(j))) {
		                count++;
		                if (count == 4) {
		                    set++;
		                    // Remove the set of cards from the hand
		                    for (int k = j; k >= i; k--) {
		                        hand.remove(k);
		                    }
		                    i = i - 1; // Adjust the outer loop index
		                    break;
		                }
		            }
		        }
		    }

		    if (set > 0) {
		        return set;
		    } else {
		        return -1;
		    }
		

	}
}
