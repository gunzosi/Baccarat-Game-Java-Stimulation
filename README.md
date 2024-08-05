# BACCARAT GAME SIMULATION

Welcome to the Baccarat Game Simulation! This project provides a simple yet comprehensive implementation of the classic card game Baccarat, using object-oriented programming principles in Java.

## Getting Started

### Requirements

- **Java Development Kit (JDK) 8 or later**
- **IDE**: IntelliJ IDEA, Eclipse, or any preferred Java IDE
- **Build Tool**: Apache Maven (optional, if you're using Maven for dependency management)

### Installation

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/gunzosi/Baccarat-Game-Java-Stimulation.git
   cd Baccarat
   ```

2. **Open in Your IDE:**

    - Open the project folder in your favorite IDE.
    - Ensure all dependencies are loaded if you're using Maven.

3. **Run the Game:**

    - Locate the `Main` class in `src/main/java/com/jmc/Main.java`.
    - Run the `Main` class to start the game simulation.

### Running the Game

To run the game, execute the `Main` class. You will be prompted to enter the number of players (up to 17), and the game will automatically deal cards, calculate scores, and determine the winner.

```plaintext
Enter the number of players (up to 17): 3

Player no. 1 has [6♥, A♦, 6♣] with all value is 3
Player no. 2 has [Q♠, 6♦, 4♣] with all value is 0
Player no. 3 has [2♥, 10♣, 10♥] with all value is 2

------------------------------
Player no. 1 has total value: 3
Player no. 2 has total value: 0
Player no. 3 has total value: 2

------------------------------------
Player no. 1 is the winner with a hand value of 3!
```

> ![img.png](img.png)

After the game ends, you will have the option to play again or exit.

## Project Structure

The project consists of four main classes, each serving a specific purpose:

1. **Card**: Represents a single playing card with a suit and rank.
2. **Deck**: Manages the collection of cards, including shuffling and dealing.
3. **Player**: Represents a player in the game, holding their cards and calculating hand values.
4. **BaccaratGame**: Coordinates the game flow, including dealing cards and determining the winner.

## Design Patterns Used

This project incorporates several design patterns to improve code organization, flexibility, and maintainability:

1. **Singleton Pattern**:
    - **Class**: `Deck`
    - **Purpose**: Ensures a single instance of the deck is used throughout the game, allowing consistent card management.

2. **Observer Pattern**:
    - **Classes**: `GameSubject`, `PlayerObserver`, `PlayerDisplay`
    - **Purpose**: Enables the game to notify observers (like the display) about changes in player states, such as when cards are dealt.

3. **Strategy Pattern**:
    - **Class**: `ScoringStrategy`, `BaccaratScoringStrategy`
    - **Purpose**: Provides flexibility in calculating hand values, allowing for easy extension or modification of scoring rules.

## Features

- **Interactive Gameplay**: Allows for multiple rounds of play with a prompt to continue or exit.
- **Dynamic Card Dealing**: Shuffles and deals cards dynamically to each player.
- **Comprehensive Scoring**: Implements Baccarat scoring rules, including automatic win conditions.
- **Observer Notifications**: Displays updates to the console whenever a player's state changes.

