package Tests;

import HelperClasses.*;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.*;
import static org.junit.Assert.*;



import static junit.framework.TestCase.fail;


public class DeckTest {

    /**
     * This class tests the functionalities of the deck
     */


    /**
     * test fixture
     */
    Deck d;

    /**
     * Sets up the necessary fixture
     */
    @Before
    public void setUp() {
        d = new Deck();
        d.topCard = new NumberCard(Color.RED, Num.FIVE);
        d.cards = new Card[]{};
        d.initialize();
    }

    /**
     * See if it is possible to shuffle an empty deck
     */
    @Test (expected = NullPointerException.class)
    void emptyDeckShuffleTest() {
        d.clear();
        d.shuffle();
    }

    /**
     * Tests if the deck is properly shuffled. Might have to be done a few times (because of the randomness).
     */
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
     * Testing if the top card gets drawn correctly.
     */
    @Test
    public void drawTopCardTest() {
        d.clear();
        NumberCard numbercard = new NumberCard(Color.RED, Num.FOUR);
        d.add(numbercard);
        assertEquals("Top cards is not drawn!", d.draw(), numbercard);
    }

    /**
     * Tests the nullptr when drawin from an empty deck.
     */
    @Test (expected = NullPointerException.class)
    public void drawEmptyDeckTest() {
        d.clear();
        d.draw();
    }

    /**
     * Tests if the deck is marked as empty when the last card is drawn.
     */
    @Test
    public void drawLastCardTest() {
        d.clear();
        d.add(new NumberCard(Color.RED, Num.FOUR));
        d.draw();
        assertTrue(d.isempty());
    }

    /**
     * Tests the nullptr that should be given when drawing from a null element in the deck.
     */
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

    /**
     * Tests if draw() properly draws the first two cards.
     */

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
     * Testing combine() method. This test checks if the methods successfully combines two decks.
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

    /**
     * This tests checks if combine() successfully combines an empty deck into a full deck
     */

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

    /**
     * Testing if a deck successfully combines into a empty deck
     */

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
