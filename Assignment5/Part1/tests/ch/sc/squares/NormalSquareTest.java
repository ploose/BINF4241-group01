package ch.sc.squares;

import ch.sc.snakesandladders.Board;
import ch.sc.snakesandladders.Player;
import ch.sc.snakesandladders.Players;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class NormalSquareTest {
    private ArrayList<Player> list;
    private Players players;
    private Player playerA, playerB;
    private Board board;
    // TODO: Javadoc / Readme

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
        list.add(new Player("Alexis"));

        players = new Players(list);

        board = new Board(100, players);
    }

    /**
     *  This test tries to construct a NormalSquare with expected / normal parameters.
     *  If this test is negative, there's probably a fundamental flaw.
     */
    @Test
    public void testConstructorNormal() {
        try {
            Square square = new NormalSquare(board, 1);
        } catch (Exception e) {
            fail("Exception when constructing with normal parameters.");
        }
    }

    /**
     *  If we construct a square without a board, we want to get a NullPointerException.
     *  This test validates that the wanted error is given.
     */
    @Test
    public void testConstructorWithoutBoard() {
        try {
            Square square = new NormalSquare(null, 1);
        } catch (NullPointerException e) {
            return;
        }
        fail("NullPointerException expected");
    }

    /**
     * The NormalSquare's index needs to be in the valid range(0 to (board.getSize()-1)). If an illegal
     * index is given, we want to receive an IllegalArgumentException, which this test validates.
     *
     * This test checks an illegal value at the lower border.
     */
    @Test
    public void testConstructorOutOfRangeIndexA() {
        try {
            Square square = new NormalSquare(board, -1);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    /**
     * The NormalSquare's index needs to be in the valid range(0 to (board.getSize()-1)). If an illegal
     * index is given, we want to receive an IllegalArgumentException, which this test validates.
     *
     * This test checks an illegal value at the upper border.
     */
    @Test
    public void testConstructorOutOfRangeIndexB() {
        try {
            Square square = new NormalSquare(board, board.getSize());
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");
    }


    /**
     *  Testing whether NormalSquare returns a reference to itself, if unoccupied and called by a player.
     */
    @Test
    public void testRequestLandingOnUnoccupied(){
        Square square = new NormalSquare(board, 1);
        assertEquals("Couldn't land on unoccupied square.", square, square.requestLanding(playerA));
    }

    /**
     *  Testing whether NormalSquare returns null, if occupied and called by a player.
     */
    @Test
    public void testRequestLandingOnOccupied(){
        Square square = new NormalSquare(board, 1);
        square.addPlayer(playerB);
        assertEquals("Could land on occupied square.", null, square.requestLanding(playerA));
    }

    /**
     *  This test validates whether the toString() method behaves as expected.
     */
    @Test
    public void testToString() {
        Square square = new NormalSquare(board, 1);
        square.addPlayer(new Player("Vlad"));
        assertEquals("toString() is behaving unexpected.", "[2<Vlad>]",
                square.toString());
    }

    // Testing general methods of the Square parent class


    /**
     * Testing whether the isOccupied() method returns false when unoccupied and true when occupied.
     */
    @Test
    public void testIsOccupied(){
        Square square = new NormalSquare(board, 1);
        assertFalse("returns true although square is unoccupied.", square.isOccupied());

        square.addPlayer(new Player("Vlad"));
        assertTrue("returns false although square is occupied.", square.isOccupied());
    }


    /**
     * Checking whether we can add a player to an unoccupied square (which we should be able to).
     */
    @Test
    public void testAddPlayerOnUnoccupied(){
        Square square = new NormalSquare(board, 1);
        try {
            square.addPlayer(playerA);
        } catch (Exception e) {
            fail("Unexpected error when adding player to unnocupied square.");
        }

    }

    /**
     * Checking that a NullPointerException is thrown when not passing any parameters to the addPlayer() method.
     */
    @Test
    public void testAddNull(){
        Square square = new NormalSquare(board, 1);
        try {
            square.addPlayer(null);
        } catch (NullPointerException e) {
            return;
        }
        fail("NullPointerException expected.");

    }

    /**
     * This test checks, that an IllegalStateException is thrown when we try to add a player to an already occupied
     * NormalSquare (Note: The SingleSquare is able to have players added when already containing other players).
     */
    @Test
    public void testAddPlayerOnOccupied(){
        Square square = new NormalSquare(board, 1);
        square.addPlayer(playerB);
        try {
            square.addPlayer(playerA);
        } catch (IllegalStateException e) {
            return;
        }
        fail("Unexpected error when adding player to unnocupied square.");
    }


    /**
     * Checking that no unexpected errors are thrown when removing a player from its square.
     */
    @Test
    public void testRemovePlayerNormal(){
        Square square = new NormalSquare(board, 1);
        square.addPlayer(playerA);
        try {
            square.removePlayer(playerA);
        } catch (Error e) {
            fail("Unexpected error when removing player from his square.");
        }
    }

    /**
     * Checking that a NullPointerException is thrown when passing null as parameter to the removePlayer() method.
     */
    @Test
    public void testRemovePlayerNull(){
        Square square = new NormalSquare(board, 1);
        square.addPlayer(playerA);
        try {
            square.removePlayer(null);
        } catch (NullPointerException e) {
            return;
        }
        fail("NullPointerException expected.");
    }


    /**
     * Testing that no unexpected error is thrown when removing a player from a square he's not on.
     */
    @Test
    public void testRemovePlayerNotOnSquare(){
        Square square = new NormalSquare(board, 1);
        try {
            square.removePlayer(playerA);
        } catch (Exception e) {
            fail("Unexpected exception when removing player from square he's not on.");
        }
    }

}