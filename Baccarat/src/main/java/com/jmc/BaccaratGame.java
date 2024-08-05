package com.jmc;

import java.util.ArrayList;
import java.util.List;

public class BaccaratGame extends Game {
    private final Player[] players;
    private final Deck deck;

    public BaccaratGame(int numPlayer) {
        if (numPlayer * 3 > 52) {
            throw new IllegalArgumentException("Too many players, not enough cards");
        }

        this.deck = Deck.getInstance(); // Singleton
        deck.shuffle(); // Xáo bài

        players = new Player[numPlayer];
        for (int i = 0; i < numPlayer; i++) {
            players[i] = new Player("Player no. " + (i + 1));

        }

        // Deal card to each Player and OBSERVER for player
        for (int i = 0; i < 3; i++) {
            for (Player player : players) {
                player.drawCard(deck);
                notifyObservers(player);
            }
        }
    }

    public Player[] getPlayers() {
        return players;
    }

    // Show all CARD of all PLAYER
    public void showHands() {
        for (Player player : players) {
            System.out.println(player);
        }
    }

    // Show all PLAYER and their SCORE
    public void showAllPlayersScore() {
        for (Player player : players) {
            System.out.println("---------------------------");
            System.out.println(player.getName() + " has total value is : " + player.calculateHandValue());
        }
    }


    // Determine the Winner
    public Player determineWinner() {
        Player winner = null;
        int highestScore = -1;

        for (Player player : players) {
         if (player.hasBaccarat()) {
             // If the player has Baccarat, they're the winner
             System.out.println(player.getName() + " has Baccarat!");
             return player;
         }
            int score = player.calculateHandValue();
            if (score > highestScore) {
                highestScore = score;
                winner = player;
            }
        }
//        showAllPlayersScore();
//        System.out.println("------------------------------------");
        return winner;
    }


}
