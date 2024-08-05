package com.jmc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private static Deck instance;
    private final List<Card> cards;

    private Deck() {
        cards = new ArrayList<>();
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        // Tạo bộ bài 52 lá
        for(String suit : Card.SUITS) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    // -------------------- Singleton Pattern --------------------
    public static Deck getInstance() {
        if (instance == null) {
            instance = new Deck();
        }
        return instance;
    }
    // -------------------- Singleton Pattern --------------------

    public void shuffleRandom() {
        // Xào bài (đảo thứ tự các lá bài trong bộ bài)
        for (int i = 0; i < cards.size(); i++) {
            int randomIndex = (int) (Math.random() * cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(randomIndex));
            cards.set(randomIndex, temp);
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("No more cards on the deck");
        }
        // return cards.remove(cards.size() - 1);
         return cards.removeLast();
    }

    public int cardsLeft() {
        return cards.size();
    }


}
