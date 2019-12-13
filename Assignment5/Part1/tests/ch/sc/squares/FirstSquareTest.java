package ch.sc.squares;

import ch.sc.snakesandladders.Board;
import ch.sc.snakesandladders.Player;

import ch.sc.snakesandladders.Players;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FirstSquareTest {
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
     *  This test tries to construct a FirstSquare with expected / normal parameters.
     *  If this test is negative, there's probably a fundamental flaw.
     */
    @Test
    public void testConstructorNormal() {
        try {
            FirstSquare square = new FirstSquare(board, 0);
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
            FirstSquare square = new FirstSquare(null, 0);
        } catch (NullPointerException e) {
            return;
        }
        fail("NullPointerException expected");
    }

    /**
     *  If we construct a square with an illegal index, in the case of the FirstSquare each index != 0
     *  (i.e. the index of the first square), we want to get an IllegalArgumentException.
     *  This test validates that the wanted error is given.
     */
    @Test
    public void testConstructorWithIllegalIndex() {
        try {
            FirstSquare square = new FirstSquare(board, 10);
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
        Square square = new FirstSquare(board, 0);
        square.addPlayer(new Player("Vlad"));
        assertEquals("toString() is behaving unexpected.", "[1<Vlad>]",
                square.toString());
    }
}