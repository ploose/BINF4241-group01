package Tests;

import HelperClasses.*;
import HelperClasses.Discardpile;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import HelperClasses.*;
import static org.junit.Assert.assertEquals;


public class PlayerpotTest {


    /**
     * This class tests the functionalities of the Playerpot
     */

    /**
     * Test fixture
     */
    Game g;
    Discardpile dis;
    Deck deck;

    /**
     * Setting up test fixture
     */
    @Before
    public void setUp() {
        g = new Game();
        g.initialize();
        g.direction = Direction.CLOCKWISE;
        g.playerpot = new Playerpot();
        g.playerpot.turnQueue = new LinkedList<Player>();
        dis = new Discardpile();
        deck = new Deck();
        deck.initialize(); // Sets up a deck with all cards.
    }

    /**
     * Testing if the turnQueue gets initialized correctly.
     */
    @Test
    void turnQueueTest() {
        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(new Player("p1"));
        playerList.add(new Player("p2"));
        playerList.add(new Player("p3"));
        g.playerpot.initialize(playerList);
        assertEquals("Expecting p1 to be the first player", g.playerpot.turnQueue.get(0).toString(), "p1");
    }

    /**
     * Tests if the skipMove() methods actually skips the player.
     */
    @Test
    void skipMoveTest() {
        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(new Player("p1"));
        playerList.add(new Player("p2"));
        playerList.add(new Player("p3"));
        g.playerpot.initialize(playerList);
        g.playerpot.skipMove();
        assertEquals("Expecting p2 to be the first player", g.playerpot.turnQueue.get(0).toString(), "p2");
    }



    /**
     * Testing if getCurrentPlayer return the current player.
     */

    @Test
    void getCurrentPlayerTest() {
        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(new Player("p1"));
        playerList.add(new Player("p2"));
        playerList.add(new Player("p3"));
        g.playerpot.initialize(playerList);
        assertEquals("Expecting p1 to be the returned player", g.playerpot.getCurrentPlayer().toString(), "p1");
    }
        /**
         * Testing if getCurrentPlayer returns null when there are no players set.
         */

        @Test (expected = NullPointerException.class)
        void getCurrentPlayerNullTest() {
            ArrayList<Player> playerList = new ArrayList<>();
            playerList.add(null);
            g.playerpot.initialize(playerList);
            g.playerpot.getCurrentPlayer();
        }


    /**
     * Testing if getNextPlayer returns the next player.
     */

    @Test
    void getNextPlayerTest() {
        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(new Player("p1"));
        playerList.add(new Player("p2"));
        playerList.add(new Player("p3"));
        g.playerpot.initialize(playerList);
        assertEquals("Expecting p2 to be the returned player", g.playerpot.getNextPlayer().toString(), "p2");
    }
    /**
     * Testing if getNextPlayer returns null when there are no players set.
     */

    @Test (expected = NullPointerException.class)
    void getNextPlayerNullTest() {
        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(null);
        playerList.add(null);
        g.playerpot.initialize(playerList);
        g.playerpot.getNextPlayer();
    }




}
