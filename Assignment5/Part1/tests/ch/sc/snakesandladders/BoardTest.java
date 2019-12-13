package ch.sc.snakesandladders;

import ch.sc.squares.*;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class BoardTest {
    private ArrayList<Player> list;
    private Players players;
    // TODO: add missing javadoc
    @Before
    public void setUp() {
        list = new ArrayList<>();

        list.add(new Player("Sam"));
        list.add(new Player("Nathalie"));
        list.add(new Player("Alexis"));

        players = new Players(list);
    }

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


    // TODO: Buggy test?
//    @Test
//    public void testNoLoop() {
//        Board board = new Board(100, players);
//
//        for (int i = 1; i < board.getSize() - 1; ++i) {
//            if (board.findSquare(i) instanceof LadderSquare || board.findSquare(i) instanceof SnakeSquare) {
//                assertNotEquals("Endless loop found on field: " + i,
//                        board.findSquare(i), board.findSquare(i).moveAndLand(0, players.getCurrentPlayer()));
//            }
//        }
//    }

    @Test
    public void testConstructBoardNormal() {
        Board board1 = new Board(10, players);
        assertEquals("Board has wrong size.", 10, board1.getSize());
    }

    @Test
    public void testConstructBoardZero() {
        try {
            Board board = new Board(0, players);
        } catch(IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    @Test
    public void testConstructBoardNegative() {
        try {
            Board board = new Board(-1, players);
        } catch(IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    @Test
    public void testSetGetWinner() {
        Board board = new Board(12, players);
        board.setWinner(players.getCurrentPlayer());

        assertEquals("Sam", board.getWinner().getName());
    }

    @After
    public void tearDown() {
        for (Player player : list) {
            player = null;
        }

        list = null;
    }
}
