package com.jmc;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final List<Card> hand;
    private ScoringStrategy strategy;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.strategy = new BaccaratScoringStrategy();
    }

    // -------------------------- Strategy Pattern --------------------------
    // Thông qua SETTER
    public void setScoringStrategy(ScoringStrategy strategy) {
        this.strategy = strategy;
    }
    // -------------------------- Strategy Pattern --------------------------

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    // Thêm một lá bài vào tay bài từ bộ bài
    public void drawCard(Deck deck) {
        Card card = deck.dealCard();
        hand.add(card);
    }

    // Phương thức thêm trực tiếp một lá bài vào tay bài (for testing)
    public void addCard(Card card) {
        hand.add(card);
    }

    // Tính toán giá trị tay bài
    // Luật Baccarat: nếu tổng giá trị lớn hơn 9, trừ 10
    // Nếu tổng giá trị là 10, 20, 30, trả về 0
    // Nếu 21, 31 trả về 1, v.v.
    public int calculateHandValue() {
        return strategy.calculateHandValue(this);
    }

    // Kiểm tra nếu người chơi có 3 lá bài J, Q, K
    public boolean hasBaccarat() {
        for (Card card : hand) {
            // Kiểm tra nhanh nếu quân bài không phải là J, Q, K
            if (!Card.FACE_CARDS.contains(card.getRank())) {
                return false;
            }
        }
        return true;
        // Tất cả các lá bài là J Q K
    }

    /**
     * Xác định nếu người chơi có tay bài thắng
     * Trả về true nếu có 3 cào hoặc giá trị tay bài lớn nhất
     */
    public boolean isWinningHand(Player[] players) {
        if (this.hasBaccarat()) {
            return true; // Người chơi có 3 cào, tự động thắng
        }

        // Nếu không có 3 cào, kiểm tra giá trị tay bài
        int highestValue = this.calculateHandValue();
        for (Player player : players) {
            if (player.calculateHandValue() > highestValue && !player.hasBaccarat()) {
                return false; // Có người chơi khác có giá trị tay bài lớn hơn và không có 3 cào
            }
        }
        return true; // Không ai có giá trị tay bài lớn hơn
    }

    @Override
    public String toString() {
        return name + " has  " + hand + " with all value is " + calculateHandValue() +
                (hasBaccarat() ? " (Baccarat)" : "");
    }
}
