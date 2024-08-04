/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class GoFishGame extends Game {
    private GroupOfCards deck;
    private ArrayList<GoFishPlayer> players;

    public GoFishGame() {
        super("Go Fish");
        deck = new GroupOfCards(52);
        players = new ArrayList<>();
        initializeDeck();
        initializePlayers(2);
    }

    private void initializeDeck() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String rank : ranks) 
        {
            for (String suit : suits) 
            {
                deck.addCard(new GoFishCard(rank, suit));
            }
        }
        deck.shuffle();
    }

    private void initializePlayers(int numPlayers) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numPlayers; i++) 
        {
            System.out.print("Enter player " + (i + 1) + " name: ");
            String playerName = scanner.nextLine();
            GoFishPlayer player = new GoFishPlayer(playerName, this);
            players.add(player);
            for (int j = 0; j < 7; j++) 
            { 
                player.addCardToHand(deck.drawCard());
            }
        }
    }

    @Override
    public void play() {
        boolean gameEnded = false;

        while (!gameEnded) 
        {
            for (GoFishPlayer player : players) 
            {
                player.play();
                if (gameOver()) 
                {
                    gameEnded = true;
                    break;
                }
            }
        }
        declareWinner();
    }

    public GoFishPlayer getOpponent(GoFishPlayer currentPlayer) {
        for (GoFishPlayer player : players) 
        {
            if (!player.equals(currentPlayer)) 
            {
                return player;
            }
        }
        return null;
    }

    public GroupOfCards getDeck() {
        return deck;
    }

    @Override
    public void declareWinner() {
        int maxPairs = -1;
        GoFishPlayer winner = null;

        for (GoFishPlayer player : players) 
        {
            int pairs = player.getHand().size();
            if (pairs > maxPairs) 
            {
                maxPairs = pairs;
                winner = player;
            }
        }

        System.out.println("The winner is " + winner.getPlayerID() + " with " + maxPairs + " cards!");
    }

    public boolean gameOver() {
        if (deck.getCards().isEmpty()) 
        {
            return true;
        }
        for (GoFishPlayer player : players) 
        {
            if (player.getHand().isEmpty()) 
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GoFishGame game = new GoFishGame();
        game.play();
    }
}
