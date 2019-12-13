package ch.sc.squares;

import ch.sc.snakesandladders.Board;
import ch.sc.snakesandladders.Player;
import ch.sc.snakesandladders.Players;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LadderSquareTest {
    private ArrayList<Player> list;
    private Players players;
    private Board board;
    // TODO: Javadoc / Readme
    /**
     * Setting up variables for the tests
     */
    @Before
    public void setUp() {
        list = new ArrayList<>();
        list.add(new Player("Sam"));
        list.add(new Player("Nathalie"));
        list.add(new Player("Alexis"));

        players = new Players(list);

        board = new Board(10, players);
    }

    /**
     *  This test tries to construct a LadderSquare with expected / normal parameters.
     *  If this test is negative, there's probably a fundamental flaw.
     */
    @Test
    public void testConstructorNormal() {
        try {
            Square square = new LadderSquare(board, 3,5);
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
            Square square = new LadderSquare(null, 3,5);
        } catch (NullPointerException e) {
            return;
        }
        fail("NullPointerException expected");
    }

    /**
     * A LadderSquare can only be placed between the firstSquare and the lastSquare, but not on them.
     * Therefore the valid indices are 1 to (board.getSize()-2). If we try to construct a LadderSquare with illegal
     * parameters, we want to receive an IllegalArgumentException, which this test validates.
     *
     * This test checks that a jump from an illegal square to a legal square leads to an IllegalArgumentException.
     */
    @Test
    public void testConstructorWithIllegalIndexA() {
        try {
            Square square = new LadderSquare(board, 0, 5);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    /**
     * A LadderSquare can only be placed between the firstSquare and the lastSquare, but not on them.
     * Therefore the valid indices are 1 to (board.getSize()-2). If we try to construct a LadderSquare with illegal
     * parameters, we want to receive an IllegalArgumentException, which this test validates.
     *
     * This test checks that a jump from a legal square to an illegal square leads to an IllegalArgumentException.
     */
    @Test
    public void testConstructorWithIllegalIndexB() {
        try {
            Square square = new LadderSquare(board, 5, board.getSize()-1);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    /**
     * A LadderSquare's target can't be equal to the LadderSquare itself. If we try to construct a LadderSquare with
     * itself as target, we want to receive an IllegalArgumentException, which this test validates.
     */
    @Test
    public void testConstructorWithIllegalJumpA() {
        try {
            Square square = new LadderSquare(board, 3, 3);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    /**
     *  A LadderSquare's target can't be smaller (or equal) to the LadderSquare itself. If we try to construct a
     *  LadderSquare with a target index greater than its index, we want to receive an IllegalArgumentException,
     *  which this test validates.
     */
    @Test
    public void testConstructorWithIllegalJumpB() {
        try {
            Square square = new LadderSquare(board, 5, 3);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    /**
     * The LadderSquare index needs to in the valid range (1 to (board.getSize()-2)). If an illegal index is given, we
     * want to receive an IllegalArgumentException, which this test validates.
     *
     * This test checks that a jump from an illegal square to a legal square leads to an IllegalArgumentException.
     */
    @Test
    public void testConstructorOutOfRangeIndexA() {
        try {
            Square square = new LadderSquare(board, -100, 5);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    /**
     * The LadderSquare index needs to in the valid range (1 to (board.getSize()-2)). If an illegal index is given, we
     * want to receive an IllegalArgumentException, which this test validates.
     *
     * This test checks that a jump from a legal square to an illegal square leads to an IllegalArgumentException.
     */
    @Test
    public void testConstructorOutOfRangeIndexB() {
        try {
            Square square = new LadderSquare(board, 5, 100);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    /**
     *  This test validates whether the toString() method behaves as expected.
     */
    @Test
    public void testToString() {
        Square square = new LadderSquare(board, 3, 5);
        square.addPlayer(new Player("Vlad"));
        assertEquals("toString() is behaving unexpected.", "[" + 4 + "->"+ 6+"]",
                square.toString());
    }
}