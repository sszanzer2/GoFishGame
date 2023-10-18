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
		 int counter = 0;
    	 int set = 0;
         for(int i = 0; i< hand.size(); i++) {
        	 if(hand.get(i) == hand.get(i+1)) {
        		 counter++; 
        	 }
        	 
        	 if(counter == 4) {
            	 set++;
        		 
        	 }
         }
         
         if (set > 0) {
        	 return set;
         }
         else {
        	 return -1;
         }
	}
}
