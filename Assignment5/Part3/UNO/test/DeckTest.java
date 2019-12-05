import HelperClasses.ActionCard;
import HelperClasses.Card;
import HelperClasses.NumberCard;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.AssertEquals.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;

public class DeckTest {

    /**
     * This class tests the functionalities of the deck
     */

    Deck d;

    @Before
    public void setUp() {
        d = new Deck();
        d.topCard = new NumberCard();
        d.cards = new ArrayList<Card>();
        d.initialize();
    }

    /**
     * Testing shuffle()
     */
    @Test (expected = NullPointerException.class)
    void emptyDeckShuffleTest() {
        d.cards.clear();
        d.shuffle();
    }

    @Test
    public void deckIsShuffledTest() {
        d.cards.clear();
        ArrayList<Card> firstDeckCards = new ArrayList<Card>(
                new ActionCard(Type.WILD),
                new NumberCard(Color.RED, Num.FOUR),
                new ActionCard(Type.DRAWTWO),
                new NumberCard(Color.GREEN, Num.FIVE),
                new ActionCard(Type.SKIP),
                new NumberCard(Color.YELLOW, Num.SEVEN)
        );
        d.cards.addAll(firstDeckCards);
        d.shuffle();
        assertNotEquals("Deck has not been shuffled!", d.cards, firstDeckCards);
    }



    /**
     * Testing draw()
     */
    @Test
    public void drawTopCardTest() {
        d.cards.clear();
        NumberCard numbercard = new NumberCard(Color.RED, Num.FOUR);
        d.cards.add(numbercard);
        assertEquals("Top cards is not drawn!", d.draw(), numbercard);
    }

    @Test (expected = NullPointerException.class)
    public void drawEmptyDeckTest() {
        d.cards.clear();
        d.draw();
    }

    @Test
    public void drawLastCardTest() {
        d.cards.clear();
        d.cards.add(new NumberCard(Color.RED, Num.FOUR));
        d.draw();
        assertTrue(d.cards.isempty());
    }

    @Test
    public void drawNullTest() {
        d.cards.clear();
        d.cards.add(null);

        try {
            d.draw();
        } catch(NullPointerException e) {
            return;
        }
        fail("NullPointerException expected");
    }

    @Test
    public void drawTwoCardsTest() {
        d.cards.clear();

        NumberCard num1 = new NumberCard(Color.RED, Num.FOUR);
        ActionCard act1 = new ActionCard(Type.WILD);
        d.cards.add(num1);
        d.cards.add(act1);
        assertEquals("Not Right first card drawn!", d.draw(), act1 );
        assertEquals("Not right second card drawn!", d.draw(), num1);
    }

    /**
     * Testing combine()
     */
    @Test
    public void combineTest() {
        d.cards.clear();
        ArrayList<Card> firstDeckCards = new ArrayList<Card>(
                new ActionCard(Type.WILD),
                new NumberCard(Color.RED, Num.FOUR),
                new ActionCard(Type.DRAWTWO),
                new NumberCard(Color.GREEN, Num.SEVEN),
                new ActionCard(Type.SKIP),
                new NumberCard(Color.YELLOW, Num.EIGHT)
        );
        d.cards.addAll(firstDeckCards);
        ArrayList<Card> secondsDeckCards = new ArrayList<Card>();
        secondsDeckCards.addAll(d.cards);
        secondsDeckCards.addAll(firstDeckCards);
        d.combine(firstDeckCards);
        assertEquals("Decks have not been combined correctly!", d.cards, secondsDeckCards);
    }

    @Test
    public void combineEmptyDeck() {
        d.cards.clear();
        ArrayList<Card> firstDeckCards = new ArrayList<Card>(
                new ActionCard(Type.WILD),
                new NumberCard(Color.RED, Num.FOUR),
                new ActionCard(Type.DRAWTWO),
                new NumberCard(Color.GREEN, Num.SEVEN),
                new ActionCard(Type.SKIP),
                new NumberCard(Color.YELLOW, Num.EIGHT)
        );
        d.cards.addAll(firstDeckCards);

        ArrayList<Card> secondsDeckCards = new ArrayList<Card>();
        d.combine(secondsDeckCards);
        assertEquals("Empty deck has not been merged correctly", d.cards, firstDeckCards);
    }

    @Test
    public void combineEmptyDeck() {
        d.cards.clear();
        ArrayList<Card> firstDeckCards = new ArrayList<Card>(
                new ActionCard(Type.WILD),
                new NumberCard(Color.RED, Num.FOUR),
                new ActionCard(Type.DRAWTWO),
                new NumberCard(Color.GREEN, Num.SEVEN),
                new ActionCard(Type.SKIP),
                new NumberCard(Color.YELLOW, Num.EIGHT)
        );
        d.cards.addAll(firstDeckCards);

        ArrayList<Card> secondsDeckCards = new ArrayList<Card>();
        secondsDeckCards.add(null);
        d.combine(secondsDeckCards);
        assertEquals("Empty deck has not been merged correctly", d.cards, firstDeckCards);
    }

    @Test
    public void combineIntoEmptyDeck() {
        d.cards.clear();
        ArrayList<Card> firstDeckCards = new ArrayList<Card>(
                new ActionCard(Type.WILD),
                new NumberCard(Color.RED, Num.FOUR),
                new ActionCard(Type.DRAWTWO),
                new NumberCard(Color.GREEN, Num.SEVEN),
                new ActionCard(Type.SKIP),
                new NumberCard(Color.YELLOW, Num.EIGHT)
        );
        ArrayList<Card> secondsDeckCards = new ArrayList<Card>();
        secondsDeckCards.addAll(firstDeckCards);
        d.combine(secondsDeckCards);
        assertEquals("Deck has not been combined into empty deck correclty!", d.cards, firstDeckCards);
    }


}
