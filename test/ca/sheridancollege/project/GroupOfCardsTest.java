/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class GroupOfCardsTest {
    private GroupOfCards groupOfCards;

    @BeforeAll
    public void setUp() {
        groupOfCards = new GroupOfCards(52);
        groupOfCards.addCard(new GoFishCard("A", "Hearts"));
        groupOfCards.addCard(new GoFishCard("2", "Diamonds"));
    }

    @Test
    public void testAddCard() {
        GoFishCard card = new GoFishCard("3", "Clubs");
        groupOfCards.addCard(card);
        assertTrue(groupOfCards.getCards().contains(card));
    }

    @Test
    public void testDrawCard() {
        GoFishCard card = groupOfCards.drawCard();
        assertNotNull(card);
        assertFalse(groupOfCards.getCards().contains(card));
    }

    @Test
    public void testDrawCardWhenEmpty() {
        groupOfCards.drawCard();
        groupOfCards.drawCard();
        assertNull(groupOfCards.drawCard());
    }

    @Test
    public void testShuffle() {
        ArrayList<GoFishCard> originalOrder = new ArrayList<>(groupOfCards.getCards());
        groupOfCards.shuffle();
        assertFalse(originalOrder.equals(groupOfCards.getCards()));
    }
}
