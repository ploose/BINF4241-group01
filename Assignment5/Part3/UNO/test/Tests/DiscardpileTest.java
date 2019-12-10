package Tests;

import HelperClasses.*;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DiscardpileTest {

// HelperClasses.Discardpile

    /**
    * This class tests the functionalities of the discardpile
    */

    /**
     * fixture
     */

Discardpile d;

    /**
     * Sets up the necessary fixture for the test
     */
        @Before
        public void setUp() {
            d = new Discardpile();
            d.topCard = new NumberCard(Color.RED, Num.FOUR);
            d.discardCards = new ArrayList<Card>().toArray(new Card[0]);
        }

    /**
     * Testing if you can get a card from an empty discardpile.
     */
    @Test  (expected = NullPointerException.class)
    public void emptyPileGetTopCardTest() {
        d.clear();
        d.setTopCard();
        d.getTopCard();

    }

    /**
     * Tests if you can get a null element from a discardpile.
     */
    @Test  (expected = NullPointerException.class)
    public void nullPileGetTopCardTest() {
        d.clear();
        d.add(null);
        d.getTopCard();

    }

    /**
     * Tests if you can get the correct card from the discardpile.
     */
    @Test
    public void getTopCardTest() {
        Card numberCard = new NumberCard(Color.RED, Num.FOUR);
        d.clear();
        d.add(numberCard);
        assertEquals("Expected red 4!", numberCard, d.getTopCard());
    }



    /**
     * Tests if you can set a top card while the pile is empty.
     */
    @Test  (expected = NullPointerException.class)
    public void emptyPileSetTopCardTest() {
        d.clear();
        d.setTopCard();
    }

    /**
     * Tests if you can set a null element as the top card.
     */
    @Test  (expected = NullPointerException.class)
    public void nullPileSetTopCardTest() {
        d.clear();
        d.add(null);
        d.setTopCard();
    }

    /**
     * Tests if you can set the top card correctly.
     */
    @Test
    public void setTopCardTest(){
        d.clear();
        ActionCard actionCard = new ActionCard(CardType.WILD);
        d.add(new NumberCard(Color.RED, Num.FOUR));
        d.add(actionCard);
        d.setTopCard();
        assertEquals("Top card not right!", d.topCard, actionCard);
    }

    /**
     * Tests if you can get an element out of an empty pile.
     */

    @Test (expected = NullPointerException.class)
    public void emptyPileEmptyTest() {
        d.clear();
        d.empty();
        d.get(0);
    }

    /**
     * Tests if the empty() method correctly empties the pile
     */
    @Test (expected = NullPointerException.class)
    public void nonemptyPileEmptyTest() {
        d.clear();
        d.add(new NumberCard(Color.RED, Num.FOUR));
        d.add(new ActionCard(CardType.WILD));
        d.empty();
        d.get(0);
    }

    /**
     * Tests if the empty() method correctly return all the cards from the pile.
     */

    @Test
    public void returnPileTest() {
        d.clear();
        d.add(new NumberCard(Color.RED, Num.FOUR));
        d.add(new ActionCard(CardType.WILD));
        assertEquals("Does not return the discardpile!", d.empty(), d.discardCards);
    }

}

