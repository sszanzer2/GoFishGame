package GoFishProject;
import java.util.List;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private String name;
    private List<Card> hand;
    private int hSetCounter;
    
    
    Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name, List<Card> hand) {
        this.name = name;
        this.hand = hand;
        hSetCounter = 0;
    }
    

    @Override
    public String getName() {
        return name;
    }
    public int gethSetCounter() {
    	return hSetCounter;
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
        if (hand.isEmpty()) {
            System.out.println(getName() + ", you have no cards to play.");
            
        }

        // Print the player's hand
        System.out.println(getName() + ", your current hand:");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println((i + 1) + ". " + hand.get(i));
        }
        
        System.out.print("Enter the number of the card you want to play (1-" + hand.size() + "): ");
        int selectedCardIndex = scanner.nextInt() - 1;

        if (selectedCardIndex < 0 || selectedCardIndex >= hand.size()) {
            System.out.println("Invalid card selection. Please select a valid card.");
           
        }

        Card cardToPlay = hand.get(selectedCardIndex);
        
        System.out.println(getName() + " asks for " + cardToPlay);
        
        return cardToPlay;
        
      
        
        
     // Implement the logic to ask for a rank from the other player and handle the response
     // You need to define the logic to check if the other player has the requested rank,
     // and if they do, take those cards and add them to your hand.
     // You also need to handle the case where the other player says "Go Fish" and you draw a card.

    }

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
