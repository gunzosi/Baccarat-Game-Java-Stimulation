package com.jmc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Continue prompting the user to enter a valid number of players
            int numPlayers = 0;
            while (true) {
                // Determine the number of players (max 17 players to ensure there are enough cards for each player to have 3 cards)
                System.out.print("Enter the number of players (up to 17): ");
                numPlayers = scanner.nextInt();

                // Validate the number of players
                if (numPlayers <= 0) {
                    System.out.println("Error: The number of players must be greater than 0.");
                } else if (numPlayers * 3 > 52) {
                    System.out.println("Error: There aren't enough cards to deal \"three\" cards to each player.");
                } else {
                    break; // Exit the loop if the number of players is valid
                }
            }

            // Initialize the Baccarat game with a valid number of players
            BaccaratGame game = new BaccaratGame(numPlayers);

            // Add Observer to the game
            PlayerDisplay display = new PlayerDisplay();
            game.addObserver(display);

            game.showHands(); // Display each player's hand

            System.out.println("------------------------------");
            for (int i = 0; i < numPlayers; i++) {
                Player player = game.getPlayers()[i];
                System.out.printf("Player no. %d has total value: %d%n", i + 1, player.calculateHandValue());
            }
            System.out.println("------------------------------");
            System.out.println();

            // Determine and print the winner
            Player winner = game.determineWinner();
            if (winner != null) {
                System.out.println("------------------------------------");
                System.out.printf("> %s is the winner with a hand value of %d!%n", winner.getName(), winner.calculateHandValue());
                System.out.println("------------------------------------");
            } else {
                System.out.println("There's no WINNER.");
            }

            // Ask the player if they want to continue or exit
            System.out.print("Do you want to play again? (type 'exit' to quit, or press Enter to continue): ");
            scanner.nextLine(); // Clear the buffer
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for playing. Goodbye.");
                break; // Exit the main loop, ending the program
            }
        }
        scanner.close();
    }
}
