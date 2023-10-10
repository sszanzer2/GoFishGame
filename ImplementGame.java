package GoFishProject;

import java.util.*;

public class ImplementGame implements Game{
    private List<Player> players;
    private Deck deck;

    public ImplementGame(List<Player> players, Deck deck){
        this.players = players;
        this.deck = deck;
    }

    @Override
    public void startGame(){
        System.out.println("Let's begin playing Go Fish!");

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
    public boolean isGameOver(){
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
    public void playTurn(Player player){

    }

    @Override
    public void endGame(){

    }
}
