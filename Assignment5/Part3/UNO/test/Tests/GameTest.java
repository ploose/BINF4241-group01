package Tests;

import HelperClasses.*;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;


import static org.junit.Assert.*;

public class GameTest {

    // HelperClasses.Discardpile

    /**
     * This class tests the functionalities of the discardpile
     */

    /**
     * Test fixture
     */

    Game g;
    Discardpile dis;
    Deck deck;

    /**
     * Setting up test fixture.
     */

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
     * Testing if an invalid move due to color difference is recognized correctly.
     */
    @Test
    void invalidMoveByColorTest() {
        dis.topCard = new NumberCard(Color.RED, Num.FOUR);
        assertFalse("Invalid move was not flagged invalid!", g.isValidMove(new NumberCard(Color.YELLOW, Num.FOUR)));
    }

    /**
     * Testing if an invalid move due to number difference is recognized correctly.
     */
    @Test
    void invalidMoveByNumberTest() {
        dis.topCard = new NumberCard(Color.RED, Num.FOUR);
        assertFalse("Invalid move was not flagged invalid!", g.isValidMove(new NumberCard(Color.RED, Num.FIVE)));
    }

    /**
     * Testing if a valid move is recognized correctly (by number).
     */
    @Test
    void validMoveByNumberTest() {
        dis.topCard = new NumberCard(Color.RED, Num.FOUR);
        assertTrue("Valid move was not flagged valid!", g.isValidMove(new NumberCard(Color.YELLOW, Num.FOUR)));
    }
    /**
     * Testing if a valid move is recognized correctly (by color).
     */
    @Test
    void validMoveByColorTest() {
        dis.topCard = new NumberCard(Color.RED, Num.FOUR);
        assertTrue("Valid move was not flagged valid!", g.isValidMove(new NumberCard(Color.RED, Num.FIVE)));
    }

    /**
     * testing if isValidMove() accepts an invalid argument.
     */
    @Test (expected = IllegalArgumentException.class)
    void invalidInputTest() {
        dis.topCard = new NumberCard(Color.RED, Num.FOUR);
        g.isValidMove(new Card());
    }

    /**
     * Testing draw() method. Tests if the top card is drawn/returned correctly.
     * This is very short, because the draw method is really implemented in the deck class.
     */
    @Test
    public void drawTest() {
        NumberCard numberCard = new NumberCard(Color.RED, Num.FOUR);
        deck.add(numberCard);
        assertEquals("game draw method not drawing the correct card!", g.draw(), numberCard);
    }



    /**
     * Tests if the playCard(Card) method allows for invalid moves.
     */

    @Test
    public void playWrongCardTest() {
            dis.topCard = new NumberCard(Color.RED,Num.EIGHT);
            NumberCard card = new NumberCard(Color.BLUE, Num.FIVE);
            g.playCard(card);

            assertNotEquals("Invalid move has been made", dis.topCard,card);

    }

    /**
     * Tests if a valid move is recognized correctly.
     */
    @Test
    public void playRightCardTest() {
        dis.topCard = new NumberCard(Color.RED,Num.EIGHT);
        NumberCard card = new NumberCard(Color.RED, Num.FIVE);
        g.playCard(card);

        assertEquals("Valid move could not be made", dis.topCard,card);
    }



    /**
     * Tests if the direction correctly changes and returned when calling getDirection().
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

    /**
     * Tests if the direction correctly changes and returned when calling getDirection() after changing the direction to the same.
     */

    @Test
    void directionChangeToSameTest() {
        Direction d1 = Direction.CLOCKWISE;
        g.direction = d1;
        assertEquals("Direction not changed successfully!",g.getDirection(),d1 );
        g.direction = d1;
        assertEquals("Direction not changed successfully!",g.getDirection(),d1 );
    }

    /**
     * Tests if nextTurn() correctly changes the current player to the next player according to the direction of the game.
     */

    @Test
    public void nextTurnTest() {
        Player player = g.playerpot.getCurrentPlayer();
        Player player2 = g.playerpot.getNextPlayer();
        dis.topCard = new NumberCard(Color.RED, Num.FIVE);
        g.nextTurn();
        assertEquals("Next turn without skipping not working!", g.playerpot.getCurrentPlayer(), player2);
    }

    /**
     * Tests if a player gets skipped correctly.
     */
    @Test
    public void skippedNextTurnTest() {
        Player player = g.playerpot.getCurrentPlayer();
        Player player2 = g.playerpot.getNextPlayer();
        dis.topCard = new ActionCard(CardType.SKIP);
        g.nextTurn();
        assertNotEquals("Skipping not working!", g.playerpot.getCurrentPlayer(), player2);
    }
}
