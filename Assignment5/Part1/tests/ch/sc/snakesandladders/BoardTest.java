package ch.sc.snakesandladders;

import ch.sc.squares.*;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class BoardTest {
    private ArrayList<Player> list;
    private Players players;

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
    }

    /**
     * This test checks, that the first square is of type FirstSquare, the last square of type Last Square and all in-
     * between either of type NormalSquare, SnakeSquare or LadderSquare.
     */
    @Test
    public void testFirstInit() {
        Board board = new Board(100, players);

        assertTrue("First Square is not instance of FirstSquare.", board.findSquare(0) instanceof FirstSquare);

        for (int i = 1; i < 99; ++i) {
            assertTrue("Wrong field found: field " + i, board.findSquare(i) instanceof NormalSquare ||
                    board.findSquare(i) instanceof SnakeSquare || board.findSquare(i) instanceof LadderSquare);
        }

        assertTrue("Last Square is not instance of LastSquare.", board.findSquare(99) instanceof LastSquare);
    }


    /**
     *  This test checks that a board constructed with a given size also really has that size.
     */
    @Test
    public void testConstructBoardNormal() {
        Board board1 = new Board(10, players);
        assertEquals("Board has wrong size.", 10, board1.getSize());
    }

    /**
     *  This test tries to construct a board with an illegal size and checks that an IllegalArgumentException is thrown.
     */
    @Test
    public void testConstructBoardZero() {
        try {
            Board board = new Board(0, players);
        } catch(IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    /**
     *  This test tries to construct a board with an illegal size and checks that an IllegalArgumentException is thrown.
     */
    @Test
    public void testConstructBoardNegative() {
        try {
            Board board = new Board(-1, players);
        } catch(IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");
    }


    /**
     *  Checking whether the setWinner() & getWinner() methods in Board work.
     */
    @Test
    public void testSetGetWinner() {
        Board board = new Board(12, players);
        board.setWinner(players.getCurrentPlayer());

        assertEquals("Sam", board.getWinner().getName());
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
