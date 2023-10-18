package GoFishProject;

import java.util.List;

public interface Player {
	String getName();
    List<Card> getHand();
    void addToHand(Card card);
    Card play();
	void removeFromHand(Card card);
	int checkForSets();

}
