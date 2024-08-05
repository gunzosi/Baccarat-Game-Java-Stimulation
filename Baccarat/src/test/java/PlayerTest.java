import com.jmc.Card;
import com.jmc.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {

    @Test
    public void testCalculateHandValue() {
        Player player = new Player("Test Player");

        // 3 lá bài 3
        player.addCard(new Card("♣", "3"));
        player.addCard(new Card("♠", "3"));
        player.addCard(new Card("♦", "3"));

        Assertions.assertEquals(9, player.calculateHandValue(), "Giá trị tay bài phải là 9");

        // K Q Q
        player = new Player("Test Player");
        player.addCard(new Card("♣", "K"));
        player.addCard(new Card("♠", "Q"));
        player.addCard(new Card("♦", "Q"));

        Assertions.assertEquals(0, player.calculateHandValue(), "Giá trị tay bài phải là 0");
    }

    @Test
    public void testHasBaccarat() {
        Player player = new Player("Test Player");

        // 3 cào
        player.addCard(new Card("♣", "J"));
        player.addCard(new Card("♠", "Q"));
        player.addCard(new Card("♦", "K"));

        assertTrue(player.hasBaccarat(), "Tay bài phải là 3 cào");

        // Không phải 3 cào
        player = new Player("Test Player");
        player.addCard(new Card("♣", "10"));
        player.addCard(new Card("♠", "Q"));
        player.addCard(new Card("♦", "K"));

        assertFalse(player.hasBaccarat(), "Tay bài không phải là 3 cào");
    }

    @Test
    public void testIsWinningHand() {
        Player player1 = new Player("Player 1");
        player1.addCard(new Card("♣", "J"));
        player1.addCard(new Card("♠", "Q"));
        player1.addCard(new Card("♦", "K"));

        Player player2 = new Player("Player 2");
        player2.addCard(new Card("♣", "3"));
        player2.addCard(new Card("♠", "3"));
        player2.addCard(new Card("♦", "3"));

        Player[] players = {player1, player2};

        assertTrue(player1.hasBaccarat(), "Player 1 phải có 3 cào");
        assertTrue(player1.isWinningHand(players), "Player 1 thắng vì có 3 cào");
        assertFalse(player2.isWinningHand(players), "Player 2 thua vì không có 3 cào");
    }
}
