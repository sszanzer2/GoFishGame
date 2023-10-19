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
    public int getSetCounter() {
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

    }

    public int checkForSets() {
        /*int set = 0;
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
        } */
        int set = 0;
        int i = 0; // Use a separate variable for the outer loop index
        while (i < hand.size()) {
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
                        break; // No need to adjust i here
                    }
                }
            }
            i++; // Move to the next card in the hand
        }
        return set;
    }

}
