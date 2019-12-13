package ch.sc.snakesandladders;

import static org.junit.Assert.*;

import org.junit.*;

import java.util.ArrayList;

public class PlayerTest {
    private ArrayList<Player> list;
    private Player playerA, playerB;
    private Players players;
    // TODO: Javadoc
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

    @Test
    public void testGetName() {
        assertEquals("getName() doesn't return correct playername.", "Sam", playerA.getName());
        assertEquals("getName() doesn't return correct playername.", "Nathalie", playerB.getName());
    }

    // TODO: Do we really need to test moveFwd as it is basically a fancy setter?
    @Test
    public void testMoveFwdNormal() {
        Board board = new Board(4, players);
        playerA.moveFwd(2);
        assertEquals("Player couldn't move to a normal, unoccupied square.", board.findSquare(2),
                playerA.getCurrentSquare());
    }

    @Test
    public void testMoveFwdToOccupied() {
        Board board = new Board(4, players);
        playerB.moveFwd(2);
        playerA.moveFwd(2);
        assertEquals("Player didn't move to first square after atempting to move to occupied square.",
                board.findSquare(0), playerA.getCurrentSquare());
    }

    @Test
    public void testMoveOverBoard() {
        Board board = new Board(4, players);
        playerA.moveFwd(4); // Move the player one square 'over' the last square
        assertEquals("Unexpected Player-Behavior when moving 'over' board-edge.",
                board.findSquare(2), playerA.getCurrentSquare());
    }

    @After
    public void tearDown() {
        for (Player player : list) {
            player = null;
        }

        list = null;
    }
}
