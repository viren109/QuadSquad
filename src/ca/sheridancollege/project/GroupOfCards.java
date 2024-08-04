/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GroupOfCards {

    private ArrayList<GoFishCard> cards;
    private int size;

    public GroupOfCards(int givenSize) {
        size = givenSize;
        cards = new ArrayList<>(size);
    }

    public ArrayList<GoFishCard> getCards() {
        return cards;
    }

    public void addCard(GoFishCard card) {
        cards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public GoFishCard drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int givenSize) {
        size = givenSize;
    }

    public void showCards() {
        for (GoFishCard card : cards) {
            System.out.println(card);
        }
    }

}//end class
