package ch.sc.snakesandladders;

import static org.junit.Assert.*;

import org.junit.*;

import java.util.ArrayList;

public class PlayerTest {
    private ArrayList<Player> list;
    private Player playerA, playerB;
    private Players players;

    /**
     * Setting up variables for the tests
     */
    @Before
    public void setUp() {
        list = new ArrayList<>();
        playerA = new Player("Sam");
        playerB = new Player("Nathalie");

        list.add(playerA);
        list.add(playerB);

        players = new Players(list);

    }

    /**
     *  This test tries to construct a Player with expected / normal parameters.
     *  If this test is negative, there's probably a fundamental flaw.
     */
    @Test
    public void testConstructNormal() {
        try {
            Player temp = new Player("Norman");
        } catch (Exception e) {
            fail("Exception when constructing with normal parameters.");
        }
    }

    /**
     *  If we construct a player without a name / with null as parameter, we want to get a NullPointerException.
     *  This test validates that the wanted error is given.
     */
    @Test
    public void testConstructWithNull() {
        try {
            Player temp = new Player(null);
        } catch (NullPointerException e) {
            return;
        }
        fail("NullPointerException expected");
    }

    /**
     *  Checking whether the getName() method works as expected.
     */
    @Test
    public void testGetName() {
        assertEquals("getName() doesn't return correct playername.", "Sam", playerA.getName());
        assertEquals("getName() doesn't return correct playername.", "Nathalie", playerB.getName());
    }

    /**
     *  Checking, whether the MoveFwd() method moves the player to the desired unoccupied square.
     */
    @Test
    public void testMoveFwdNormal() {
        Board board = new Board(4, players);
        playerA.moveFwd(2);
        assertEquals("Player couldn't move to a normal, unoccupied square.", board.findSquare(2),
                playerA.getCurrentSquare());
    }

    /**
     *  Checking, whether the MoveFwd() method moves the player to the first square, when trying to land on an already
     *  occupied square.
     */
    @Test
    public void testMoveFwdToOccupied() {
        Board board = new Board(4, players);
        playerB.moveFwd(2);
        playerA.moveFwd(2);
        assertEquals("Player didn't move to first square after atempting to move to occupied square.",
                board.findSquare(0), playerA.getCurrentSquare());
    }

    /**
     *  Checking whether the MoveFwd() method moves the player the remaining 'moves' back from the last square when
     *  overshooting it.
     */
    @Test
    public void testMoveOverBoard() {
        Board board = new Board(4, players);
        playerA.moveFwd(4); // Move the player one square 'over' the last square
        assertEquals("Unexpected Player-Behavior when moving 'over' board-edge.",
                board.findSquare(2), playerA.getCurrentSquare());
    }

    /**
     *  Cleanup after tests
     */
    @After
    public void tearDown() {
        for (Player player : list) {
            player = null;
        }

        list = null;
    }
}
