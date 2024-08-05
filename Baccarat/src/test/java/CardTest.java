

import com.jmc.Card;
import com.jmc.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardTest {

    @Test
    public void testCardValue() {
        Card aceOfSpades = new Card("♠", "A");
        Card twoOfHearts = new Card("♥", "2");
        Card threeOfClubs = new Card("♣", "3");
        Card jackOfDiamonds = new Card("♦", "J");
        Card kingOfClubs = new Card("♣", "K");

        assertEquals(1, aceOfSpades.getValue(), "Ace should have value 1");
        assertEquals(2, twoOfHearts.getValue(), "2 should have value 2");
        assertEquals(3, threeOfClubs.getValue(), "3 should have value 3");
        assertEquals(10, jackOfDiamonds.getValue(), "Jack should have value 10");
        assertEquals(10, kingOfClubs.getValue(), "King should have value 10");
    }

    @Test
    public void testCardToString() {
        Card aceOfSpades = new Card("♠", "A");
        Card twoOfHearts = new Card("♥", "2");
        Card threeOfClubs = new Card("♣", "3");
        Card jackOfDiamonds = new Card("♦", "J");
        Card kingOfClubs = new Card("♣", "K");

        assertEquals("A♠", aceOfSpades.toString(), "Ace of Spades should be A♠");
        assertEquals("2♥", twoOfHearts.toString(), "2 of Hearts should be 2♥");
        assertEquals("3♣", threeOfClubs.toString(), "3 of Clubs should be 3♣");
        assertEquals("J♦", jackOfDiamonds.toString(), "Jack of Diamonds should be J♦");
        assertEquals("K♣", kingOfClubs.toString(), "King of Clubs should be K♣");
    }

    @Test
    public void testCardPriority() {
        // 2♠ < 2♣ < 2♦ < 2♥
        Card twoOfSpades = new Card("♠", "2");
        Card twoOfClubs = new Card("♣", "2");
        Card twoOfDiamonds = new Card("♦", "2");
        Card twoOfHearts = new Card("♥", "2");

        assertEquals(1, twoOfSpades.getSuitPriority(), "♠ should have priority 4");
        assertEquals(2, twoOfClubs.getSuitPriority(), "♣ should have priority 3");
        assertEquals(3, twoOfDiamonds.getSuitPriority(), "♦ should have priority 2");
        assertEquals(4, twoOfHearts.getSuitPriority(), "♥ should have priority 1");

        // Test Lesser priority 5♠ < 5♣
        Card fiveOfSpades = new Card("♠", "5");
        Card fiveOfClubs = new Card("♣", "5");

        assertEquals(1, fiveOfSpades.getSuitPriority(), "♠ should have priority 4");

        // Test 2 priority 2♠ < 2♣ < 2♦ < 2♥ trả về true / false
        assertTrue(twoOfSpades.getSuitPriority() < twoOfClubs.getSuitPriority(), "♠ should have priority 4");
        assertTrue(twoOfClubs.getSuitPriority() < twoOfDiamonds.getSuitPriority(), "♣ should have priority 3");
        assertTrue(twoOfDiamonds.getSuitPriority() < twoOfHearts.getSuitPriority(), "♦ should have priority 2");
        assertTrue(twoOfHearts.getSuitPriority() < fiveOfSpades.getSuitPriority(), "♥ should have priority 1");
    }


}
