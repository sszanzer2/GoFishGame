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

        //hand out number cards to each player based on number players
        if (players.size() == 2 || players.size() == 3) {
            for (Player player : players) {
                for (int i = 1; i <=7; i++) {
                    player.addToHand(deck.drawCard());
                }
            }
        } else if (players.size() > 3) {
            for (Player player : players) {
                for (int i = 1; i <=5; i++) {
                    player.addToHand(deck.drawCard());
                }
            }
        }

        //start the players turn
        while (!isGameOver()){
            players.get(0).play();
        }
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
