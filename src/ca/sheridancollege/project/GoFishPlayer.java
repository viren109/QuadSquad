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
public class GoFishPlayer extends Player {
    
    private ArrayList<GoFishCard> hand;
    private GoFishGame game;
    
    public GoFishPlayer(String name, GoFishGame game) {
        super(name);
        hand = new ArrayList<>();
        this.game = game;
    }

    public ArrayList<GoFishCard> getHand() {
        return hand;
    }

    public void addCardToHand(GoFishCard card) {
        hand.add(card);
    }

    public boolean hasRank(String rank) {
        for (GoFishCard card : hand) 
        {
            if (card.getRank().equals(rank)) 
            {
                return true;
            }
        }
        return false;
    }

    public ArrayList<GoFishCard> giveAllCardsOfRank(String rank) {
        ArrayList<GoFishCard> cardsToGive = new ArrayList<>();
        hand.removeIf(card -> {
            if (card.getRank().equals(rank)) 
            {
                cardsToGive.add(card);
                return true;
            }
            return false;
        });
        return cardsToGive;
    }

    public void removePairs() {
        ArrayList<GoFishCard> newHand = new ArrayList<>();
        hand.sort((card1, card2) -> card1.getRank().compareTo(card2.getRank()));
        for (int i = 0; i < hand.size() - 1; i++) 
        {
            if (!hand.get(i).getRank().equals(hand.get(i + 1).getRank())) 
            {
                newHand.add(hand.get(i));
            } 
            else 
            {
                i++;
            }
        }
        if (!hand.isEmpty() && !hand.get(hand.size() - 1).getRank().equals(hand.get(hand.size() - 2).getRank())) 
        {
            newHand.add(hand.get(hand.size() - 1));
        }
        hand = newHand;
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getPlayerID() + "'s turn.");
        System.out.print("Enter a rank to ask for: ");
        String rank = scanner.nextLine();
        GoFishPlayer opponent = game.getOpponent(this);

        if (opponent.hasRank(rank)) 
        {
            System.out.println(opponent.getPlayerID() + " has " + rank + "!");
            ArrayList<GoFishCard> cards = opponent.giveAllCardsOfRank(rank);
            hand.addAll(cards);
            System.out.println(getPlayerID() + " takes " + cards.size() + " " + rank + "(s) from " + opponent.getPlayerID());
        } 
        else 
        {
            System.out.println(opponent.getPlayerID() + " does not have " + rank + ". Go Fish!");
            GoFishCard drawnCard = game.getDeck().drawCard();
            if (drawnCard != null) 
            {
                addCardToHand(drawnCard);
                System.out.println(getPlayerID() + " draws " + drawnCard);
            } 
            else 
            {
                System.out.println("The deck is empty. No card drawn.");
            }
        }

        removePairs();
        System.out.println(getPlayerID() + "'s hand: " + hand);
    }

    @Override
    public String toString() {
        return hand.toString();
    }
}
