/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class GoFishPlayerTest {
    private GoFishGame game;
    private GoFishPlayer player;

    @BeforeAll
    public void setUp() {
        game = new GoFishGame();
        player = new GoFishPlayer("Player", game);
    }

    @Test
    public void testAddCardToHand() {
        GoFishCard card = new GoFishCard("A", "Hearts");
        player.addCardToHand(card);
        assertTrue(player.getHand().contains(card));
    }

    @Test
    public void testHasRank() {
        GoFishCard card = new GoFishCard("A", "Hearts");
        player.addCardToHand(card);
        assertTrue(player.hasRank("A"));
        assertFalse(player.hasRank("K"));
    }

    @Test
    public void testGiveAllCardsOfRank() {
        GoFishCard card1 = new GoFishCard("A", "Hearts");
        GoFishCard card2 = new GoFishCard("A", "Diamonds");
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        ArrayList<GoFishCard> cards = player.giveAllCardsOfRank("A");
        assertTrue(cards.contains(card1));
        assertTrue(cards.contains(card2));
        assertFalse(player.getHand().contains(card1));
        assertFalse(player.getHand().contains(card2));
    }

    @Test
    public void testRemovePairs() {
        player.addCardToHand(new GoFishCard("A", "Hearts"));
        player.addCardToHand(new GoFishCard("A", "Diamonds"));
        player.addCardToHand(new GoFishCard("K", "Clubs"));
        player.removePairs();
        assertEquals(1, player.getHand().size());
        assertEquals("K", player.getHand().get(0).getRank());
    }
}
