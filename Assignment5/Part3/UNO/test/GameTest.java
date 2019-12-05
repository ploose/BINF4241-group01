import HelperClasses.ActionCard;
import HelperClasses.Card;
import HelperClasses.Discardpile;
import HelperClasses.NumberCard;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.*;

import java.awt.*;
import java.lang.reflect.Type;
import java.util.*;

import java.util.ArrayList;

public class GameTest {

    // HelperClasses.Discardpile

    /**
     * This class tests the functionalities of the discardpile
     */

    Game g;
    Discardpile dis;
    Deck deck;


    @Before
    public void setUp() {
        g = new Game();
        g.initialize();
        g.direction = Direction.CLOCKWISE;
        g.playerpot = new Playerpot();
        dis = new Discardpile();
        deck = new Deck();
        deck.initialize(); // Sets up a deck with all cards.
    }

    /**
     * Testing isValidMove(Card)
     */
    @Test
    void invalidMoveByColorTest() {
        dis.topCard = new NumberCard(Color.RED, Num.FOUR);
        assertFalse("Invalid move was not flagged invalid!", g.isValidMove(new NumberCard(Color.YELLOW, Num.FOUR)));
    }

    @Test
    void invalidMoveByNumberTest() {
        dis.topCard = new NumberCard(Color.RED, Num.FOUR);
        assertFalse("Invalid move was not flagged invalid!", g.isValidMove(new NumberCard(Color.RED, Num.FIVE)));
    }

    @Test
    void validMoveByNumberTest() {
        dis.topCard = new NumberCard(Color.RED, Num.FOUR);
        assertTrue("Valid move was not flagged valid!", g.isValidMove(new NumberCard(Color.YELLOW, Num.FOUR)));
    }

    @Test
    void validMoveByColorTest() {
        dis.topCard = new NumberCard(Color.RED, Num.FOUR);
        assertTrue("Valid move was not flagged valid!", g.isValidMove(new NumberCard(Color.RED, Num.FIVE)));
    }

    @Test (expected = IllegalArgumentException.class)
    void invalidInputTest() {
        dis.topCard = new NumberCard(Color.RED, Num.FOUR);
        g.isValidMove(5);
    }

    /**
     * Testing draw()
     * This is very short, because the draw method is reall implemented in the deck class.
     */
    @Test
    public void drawTest() {
        NumberCard numberCard = new NumberCard(Color.RED, Num.FOUR);
        deck.cards.add(numberCard);
        assertEquals("game draw method not drawing the correct card!", g.draw(), numberCard);
    }



    /**
     * Testing playCard()
     */

    @Test
    public void playWrongCardTest() {
            dis.topCard = new NumberCard(Color.RED,Num.EIGHT);
            NumberCard card = new NumberCard(Color.BLUE, Num.FIVE)
            g.playCard(card);

            assertNotEquals("Invalid move has been made", dis.topCard,card);

    }

    @Test
    public void playRightCardTest() {
        dis.topCard = new NumberCard(Color.RED,Num.EIGHT);
        NumberCard card = new NumberCard(Color.RED, Num.FIVE)
        g.playCard(card);

        assertEquals("Valid move could not be made", dis.topCard,card);
    }



    /**
     * Testing getDirection()
     */

    @Test
    void directionChangeTest() {
        Direction d1 = Direction.CLOCKWISE;
        g.direction = d1;
        assertEquals("Direction not changed successfully!",g.getDirection(),d1 );
        Direction d2 = Direction.COUNTERCLOCKWISE;
        g.direction = d2;
        assertEquals("Direction not changed successfully!",g.getDirection(),d2 );
    }

    @Test
    void directionChangeToSameTest() {
        Direction d1 = Direction.CLOCKWISE;
        g.direction = d1;
        assertEquals("Direction not changed successfully!",g.getDirection(),d1 );
        g.direction = d1;
        assertEquals("Direction not changed successfully!",g.getDirection(),d2 );
    }

    /**
     * Testing nextTurn()
     */

    @Test
    public void nextTurnTest() {
        Player player = g.playerpot.getCurrentPlayer();
        Player player2 = g.playerpot.getNextPlayer();
        dis.topCard = new NumberCard(Color.RED, Num.FIVE);
        g.nextTurn();
        assertEquals("Next turn without skipping not working!", g.playerpot.getCurrentPlayer(), player2);
    }

    @Test
    public void skippedNextTurnTest() {
        Player player = g.playerpot.getCurrentPlayer();
        Player player2 = g.playerpot.getNextPlayer();
        dis.topCard = new ActionCard(Type.SKIP);
        g.nextTurn();
        assertNotEquals("Skipping not working!", g.playerpot.getCurrentPlayer(), player2);
    }
}
