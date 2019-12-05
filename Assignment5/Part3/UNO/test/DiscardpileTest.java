import HelperClasses.ActionCard;
import HelperClasses.Card;
import HelperClasses.Discardpile;
import HelperClasses.NumberCard;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

import java.util.ArrayList;

public class DiscardpileTest {

// HelperClasses.Discardpile

/**
 * This class tests the functionalities of the discardpile
 */

Discardpile d;

        @Before
        public void setUp() {
            d = new Discardpile();
            d.topCard = new NumberCard(Color.RED, Number.FOUR);
            d.discardCards = new ArrayList<Card>();
        }

    /**
     * Testing getTopCard()
     */
    @Test  (expected = NullPointerException.class)
    public void emptyPileGetTopCardTest() {
        d.discardCards.clear();
        d.setTopCard();
        d.getTopCard();

    }

    @Test  (expected = NullPointerException.class)
    public void nullPileGetTopCardTest() {
        d.discardCards.clear();
        d.discardCards.add(null);
        d.getTopCard();

    }

    @Test
    public void getTopCardTest() {
        Card numberCard = new NumberCard(Color.RED, Num.FOUR);
        d.discardCards.clear();
        d.discardCards.add(numberCard);
        assertEquals("Expected red 4!", numberCard, d.setTopCard());
    }



    /**
     * Testing setTopCard()
     */
    @Test  (expected = NullPointerException.class)
    public void emptyPileSetTopCardTest() {
        d.discardCards.clear();
        d.setTopCard();
    }

    @Test  (expected = NullPointerException.class)
    public void nullPileSetTopCardTest() {
        d.discardCards.clear();
        d.discardCards.add(null);
        d.setTopCard();
    }

    @Test
    public void setTopCardTest(){
        d.discardCards.clear();
        actionCard = new ActionCard(Type.WILD);
        d.discardCards.add(new NumberCard(Color.RED, Num.FOUR));
        d.discardCards.add(actionCard);
        d.setTopCard();
        assertEquals("Top card not right!", d.topCard, actionCard);
    }



    /**
     * Testing empty()
     */

    @Test (expected = NullPointerException.class)
    public void emptyPileEmptyTest() {
        d.discardCards.clear();
        d.empty();
        d.discardCards.get(0);
    }

    @Test (expected = NullPointerException.class)
    public void nonemptyPileEmptyTest() {
        d.discardCards.clear();
        d.discardCards.add(new NumberCard(Color.RED, Num.FOUR));
        d.discardCards.add(new ActionCard(Type.WILD));
        d.empty();
        d.discardCards.get(0);
    }

    @Test
    public void returnPileTest() {
        d.discardCards.clear();
        d.discardCards.add(new NumberCard(Color.RED, Num.FOUR));
        d.discardCards.add(new ActionCard(Type.WILD));
        assertEquals("Does not return the discardpile!", d.empty(), d.discardCards);
    }

}

