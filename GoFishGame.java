package GoFishProject;
import java.util.ArrayList;
import java.util.List;


public class GoFishGame implements Game {
    private ArrayList<Player> players;
    private Deck deck;

    public GoFishGame(ArrayList<Player> players, Deck deck) {
        this.players = players;
        this.deck = deck;
    }

    @Override
    public void startGame() {
        // Implement the game initialization here
        System.out.println("Let's begin playing Go Fish!");

        //shuffle the deck
        deck.shuffleDeck();

        //hand out 7 cards to each player
        for (Player player : players) {
            for (int i = 1; i <=7; i++) {
                Card cardToAdd = deck.drawCard(); // Draw a card from the deck. This method also removes it from deck
                player.addToHand(cardToAdd); // Add the card to the player's hand
            }
        }

        //start the players turn
        while (!isGameOver()){
            for (Player player : players) {
                if(!isGameOver()){
                    playTurn(player);
                    isGameOver();
                }
            }
        }
        endGame();
    }


    @Override
    public boolean isGameOver() {
        // Implement the game-over condition here
        //the game is over if the deck finishes or if a player finishes his cards
        if (deck.isEmpty()){
            return true;
        } else if (players.get(0).getHand() == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void playTurn(Player player) {
        // Implement the game logic for playing a turn here
    	Player opponent = new Player();
        //draw a card for the player and add it to their hand
        Card newCard = deck.drawCard();
        player.addToHand(newCard);

        Card card = player.play();
        

        if (opponent.getHand().contains(card)) {
           // Transfer cards from the opponent to the current player
           //List<Card> cards = opponent.getHand(card);
           player.addToHand(card);
           opponent.removeFromHand(card);
           
           // Check for sets and remove them from the hand
           //checkForSets();
       } else {
           System.out.println(player.getName() + " says 'Go Fish.'");
           // Draw a card from the deck
           Card drawnCard = deck.drawCard();
           player.getHand().add(drawnCard);

           // Check if the drawn card makes a set
           int answer = player.checkForSets();
           
           if(answer > 0) {
        	   System.out.println(player.getName() + " has " + answer + " set(s)");
           }else {
        	   System.out.println("No sets");
           }
           
       }
       
        
    }

    @Override
    public void endGame() {
        // Implement game-ending actions here
        System.out.println("Game Over!");

        //determine the winner by checking who has more sets
    }
}
