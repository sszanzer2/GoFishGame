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

    }

    @Override
    public boolean isGameOver(){
        if (deck.isEmpty()){
            return true;
        } else if () {

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
