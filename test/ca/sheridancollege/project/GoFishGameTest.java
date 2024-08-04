/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GoFishGameTest {
    private GoFishGame game;
    private GoFishPlayer player1;
    private GoFishPlayer player2;

    @BeforeAll
    public void setUp() {
        game = new GoFishGame();
        player1 = new GoFishPlayer("Player1", game);
        player2 = new GoFishPlayer("Player2", game);
        game.getPlayers().add(player1);
        game.getPlayers().add(player2);
    }

    @Test
    public void testInitializeDeck() {
        assertEquals(52, game.getDeck().getCards().size());
    }

    @Test
    public void testGetOpponent() {
        assertEquals(player2, game.getOpponent(player1));
        assertEquals(player1, game.getOpponent(player2));
    }

    @Test
    public void testGameOverWhenDeckIsEmpty() {
        while (!game.getDeck().getCards().isEmpty()) 
        {
            game.getDeck().drawCard();
        }
        assertTrue(game.gameOver());
    }

    @Test
    public void testGameOverWhenPlayerHandIsEmpty() {
        player1.getHand().clear();
        assertTrue(game.gameOver());
    }
}
