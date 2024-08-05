package com.jmc;

import java.util.Map;
import java.util.Set;

public class Card {
    private String suit;
    private String rank;

    // Các ký hiệu chất bài được khai báo public để truy cập từ bên ngoài
    public static final String[] SUITS = {"♣", "♥", "♦", "♠"};
    // Tập hợp các giá trị bài hình
    public static final Set<String> FACE_CARDS = Set.of("J", "Q", "K");

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Priority of SUITS ♠ < ♣ < ♦ < ♥
    /*
    public int getSuitPriority() {
        return switch (suit) {
            case "♠" -> 4;
            case "♣" -> 3;
            case "♦" -> 2;
            case "♥" -> 1;
            default -> 0;
        };
    }*/

    public int getSuitPriority() {
        return Map.of(
                "♠", 1,
                "♣", 2,
                "♦", 3,
                "♥", 4
        ).getOrDefault(suit, 0);
    }



    /**
     * Trả về giá trị của lá bài theo quy tắc Baccarat.
     * A có giá trị là 1.
     * 2 đến 10 có giá trị tương ứng với số của chúng.
     * J, Q, K có giá trị là 10.
     */
    public int getValue() {
        if (rank.equals("A")) {
            return 1;
        } else if (FACE_CARDS.contains(rank)) {
            return 10; // J, Q, K có giá trị 10
        } else {
            return Integer.parseInt(rank); // Các quân bài từ 2-10 giữ nguyên giá trị
        }
    }

    @Override
    public String toString() {
        return rank + suit;
        // Biểu diễn lá bài theo định dạng "rank + suit"
        // Ví dụ: "A♠", "2♥", "3♣", "J♦", "K♣"
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }
}
