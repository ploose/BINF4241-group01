import HelperClasses.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import HelperClasses.*;
import org.junit.Before;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.*;

import java.awt.*;
import java.util.*;

import java.util.ArrayList;


import static org.junit.Assert.*;

public class DeckTest {

    /**
     * This class tests the functionalities of the deck
     */

    Deck d;

    @Before
    public void setUp() {
        d = new Deck();
        d.topCard = new NumberCard(Color.RED, Num.FIVE);
        d.cards = new Card[]{};
        d.initialize();
    }

    /**
     * Testing shuffle()
     */
    @Test (expected = NullPointerException.class)
    void emptyDeckShuffleTest() {
        d.clear();
        d.shuffle();
    }

    @Test
    public void deckIsShuffledTest() {
        d.clear();
        Card[] firstDeckCards = new Card[]{
                new ActionCard(CardType.WILD),
                new NumberCard(Color.RED, Num.FOUR),
                new ActionCard(CardType.DRAWTWO),
                new NumberCard(Color.GREEN, Num.SEVEN),
                new ActionCard(CardType.SKIP),
                new NumberCard(Color.YELLOW, Num.EIGHT)
        };
        d.shuffle();
        assertNotEquals("Deck has not been shuffled!", d.cards, firstDeckCards);
    }



    /**
     * Testing draw()
     */
    @Test
    public void drawTopCardTest() {
        d.clear();
        NumberCard numbercard = new NumberCard(Color.RED, Num.FOUR);
        d.add(numbercard);
        assertEquals("Top cards is not drawn!", d.draw(), numbercard);
    }

    @Test (expected = NullPointerException.class)
    public void drawEmptyDeckTest() {
        d.clear();
        d.draw();
    }

    @Test
    public void drawLastCardTest() {
        d.clear();
        d.add(new NumberCard(Color.RED, Num.FOUR));
        d.draw();
        assertTrue(d.isempty());
    }

    @Test
    public void drawNullTest() {
        d.clear();
        d.add(null);

        try {
            d.draw();
        } catch(NullPointerException e) {
            return;
        }
        fail("NullPointerException expected");
    }

    @Test
    public void drawTwoCardsTest() {
        d.clear();

        NumberCard num1 = new NumberCard(Color.RED, Num.FOUR);
        ActionCard act1 = new ActionCard(CardType.WILD);
        d.add(num1);
        d.add(act1);
        assertEquals("Not Right first card drawn!", d.draw(), act1 );
        assertEquals("Not right second card drawn!", d.draw(), num1);
    }

    /**
     * Testing combine()
     */
    @Test
    public void combineTest() {
        d.clear();
        Card[] firstDeckCards = new Card[]{
                new ActionCard(CardType.WILD),
                new NumberCard(Color.RED, Num.FOUR),
                new ActionCard(CardType.DRAWTWO),
                new NumberCard(Color.GREEN, Num.SEVEN),
                new ActionCard(CardType.SKIP),
                new NumberCard(Color.YELLOW, Num.EIGHT)
        };
        d.addAll(firstDeckCards);
        ArrayList<Card> secondsDeckCards = new ArrayList<Card>();
        secondsDeckCards.addAll(Arrays.asList(d.cards));
        secondsDeckCards.addAll(Arrays.asList(firstDeckCards));
        d.combine(firstDeckCards);
        assertEquals("Decks have not been combined correctly!", d.cards, secondsDeckCards);
    }



    @Test
    public void combineEmptyDeck() {
        d.clear();
        Card[] firstDeckCards = new Card[]{
                new ActionCard(CardType.WILD),
                new NumberCard(Color.RED, Num.FOUR),
                new ActionCard(CardType.DRAWTWO),
                new NumberCard(Color.GREEN, Num.SEVEN),
                new ActionCard(CardType.SKIP),
                new NumberCard(Color.YELLOW, Num.EIGHT)
        };
        d.addAll(firstDeckCards);

        Card[] secondsDeckCards = new Card[]{null};

        d.combine(secondsDeckCards);
        assertEquals("Empty deck has not been merged correctly", d.cards, firstDeckCards);
    }

    @Test
    public void combineIntoEmptyDeck() {
        d.clear();
        Card[] firstDeckCards = new Card[]{
                new ActionCard(CardType.WILD),
                new NumberCard(Color.RED, Num.FOUR),
                new ActionCard(CardType.DRAWTWO),
                new NumberCard(Color.GREEN, Num.SEVEN),
                new ActionCard(CardType.SKIP),
                new NumberCard(Color.YELLOW, Num.EIGHT)
        };
        Card[] secondsDeckCards = new Card[]{};
        d.cards = secondsDeckCards;
        d.combine(firstDeckCards);
        assertEquals("Deck has not been combined into empty deck correclty!", d.cards, firstDeckCards);
    }


}
