package GoFishProject;
import java.util.List;
import java.util.Scanner;

public class GoFishGame implements Game {
    private List<Player> players;
    private Deck deck;

    public GoFishGame(List<Player> players, Deck deck) {
        this.players = players;
        this.deck = deck;
    }

    @Override
    public void startGame() {
        // Implement the game initialization here
        System.out.println("Let's begin playing Go Fish!");

        // Shuffle the deck
        deck.shuffleDeck();

        // Hand out 7 cards to each player
        for (Player player : players) {
            for (int i = 1; i <= 7; i++) {
                Card cardToAdd = deck.drawCard();
                player.addToHand(cardToAdd);
            }
        }

        // Start the players' turns in a game loop
        int currentPlayerIndex = 0;
        int numPlayers = players.size();

        while (!isGameOver()) {
            Player currentPlayer = players.get(currentPlayerIndex);

            // Display current player's turn
            System.out.println(currentPlayer.getName() + "'s turn");

            // Player takes a turn
            playTurn(currentPlayer);

            // Move to the next player
            currentPlayerIndex = (currentPlayerIndex + 1) % numPlayers;
        }

        endGame();
    }

    @Override
    public boolean isGameOver() {
        // Implement the game-over condition here
        // The game is over if the deck is empty or if any player's hand is empty.
        if (deck.isEmpty()) {
            return true;
        } else {
            for (Player player : players) {
                if (player.getHand().isEmpty()) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public void playTurn(Player player) {
        // Implement the game logic for playing a turn here
        // You need to find the opponent for the current player

        Player opponent = findOpponent(player);

        // Draw a card for the player and add it to their hand
        Card newCard = deck.drawCard();
        player.addToHand(newCard);

        Card card = player.play();

        if (opponent.getHand().contains(card)) {
            // Transfer cards from the opponent to the current player
        	player.addToHand(card);
            opponent.removeFromHand(card);
           

            // Check for sets and remove them from the hand
            int sets = player.checkForSets();
            if (sets > 0) {
                System.out.println(player.getName() + " has " + sets + " set(s)");
            }
        } else {
            System.out.println(opponent.getName() + " says 'Go Fish.'");
            // Draw a card from the deck
            Card drawnCard = deck.drawCard();
            player.addToHand(drawnCard);

            // Check if the drawn card makes a set
            int sets = player.checkForSets();
            if (sets > 0) {
                System.out.println(player.getName() + " has " + sets + " set(s)");
            } else {
                System.out.println("No sets");
            }
        }
    }

    @Override
    public void endGame() {
        // Implement game-ending actions here
        System.out.println("Game Over!");

        // Determine the winner by checking who has more sets
        Player winner = determineWinner();
        if (winner != null) {
            System.out.println(winner.getName() + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    private Player findOpponent(Player currentPlayer) {
        // Simple logic for finding an opponent
        for (Player player : players) {
            if (player != currentPlayer) {
                return player;
            }
        }
        return null;
    }

    private Player determineWinner() {
        Player winner = null;
        int maxSets = -1;

        for (Player player : players) {
            int sets = player.checkForSets();
            if (sets > maxSets) {
                maxSets = sets;
                winner = player;
            }
        }

        // If there's a tie, return null
        if (maxSets == 0) {
            winner = null;
        }

        return winner;
    }
}
