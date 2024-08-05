package com.jmc;

public class BaccaratScoringStrategy implements ScoringStrategy {
    @Override
    public int calculateHandValue(Player player) {
        int handValue = 0;
        for (Card card : player.getHand()) {
            handValue += card.getValue();
        }
        return handValue % 10;
    }
}
