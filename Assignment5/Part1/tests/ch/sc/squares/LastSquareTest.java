package ch.sc.squares;

import ch.sc.snakesandladders.Board;
import ch.sc.snakesandladders.Player;
import ch.sc.snakesandladders.Players;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LastSquareTest {
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

        board = new Board(100, players);
    }

    /**
     *  This test tries to construct a LastSquare with expected / normal parameters.
     *  If this test is negative, there's probably a fundamental flaw.
     */
    @Test
    public void testConstructorNormal() {
        try {
            Square square = new LastSquare(board, board.getSize() - 1);
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
            Square square = new LastSquare(null, board.getSize() - 1);
        } catch (NullPointerException e) {
            return;
        }
        fail("NullPointerException expected");
    }

    /**
     *  If we construct a square with an illegal index, in the case of the LastSquare each index != size-1
     *  (i.e. the index of the last square), we want to get an IllegalArgumentException.
     *  This test validates that the wanted error is given.
     */
    @Test
    public void testConstructorWithIllegalIndex() {
        try {
            Square square = new LastSquare(board, 0);
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
        Square square = new LastSquare(board, board.getSize() - 1);
        square.addPlayer(new Player("Vlad"));
        assertEquals("toString() is behaving unexpected.", "[" + board.getSize() + "<Vlad>]",
                square.toString());
    }
}