package ch.sc.squares;

import ch.sc.snakesandladders.Board;
import ch.sc.snakesandladders.Player;
import ch.sc.snakesandladders.Players;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SnakeSquareTest {
    private ArrayList<Player> list;
    private Players players;
    private Board board;
    // TODO: Javadoc / Readme
    @Before
    public void setUp() {
        list = new ArrayList<>();
        list.add(new Player("Sam"));
        list.add(new Player("Nathalie"));
        list.add(new Player("Alexis"));

        players = new Players(list);

        board = new Board(10, players);
    }

    @Test
    public void testConstructorNormal() {
        try {
            Square square = new SnakeSquare(board, 5,3);
        } catch (Exception e) {
            fail("Exception when constructing with normal parameters.");
        }
    }

    @Test
    public void testConstructorWithoutBoard() {
        try {
            Square square = new SnakeSquare(null, 5,3);
        } catch (NullPointerException e) {
            return;
        }
        fail("NullPointerException expected");
    }

    @Test
    public void testConstructorWithIllegalIndexA() {
        try {
            Square square = new SnakeSquare(board, board.getSize()-1, 5);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    @Test
    public void testConstructorWithIllegalIndexAndJump() {
        try {
            Square square = new SnakeSquare(board, board.getSize()-1, 0);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    @Test
    public void testConstructorWithIllegalJumpA() {
        try {
            Square square = new SnakeSquare(board, 3, 3);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    @Test
    public void testConstructorWithIllegalJumpB() {
        try {
            Square square = new SnakeSquare(board, 5, -1);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    @Test
    public void testConstructorOutOfRangeIndex() {
        try {
            Square square = new SnakeSquare(board, -1, -10);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    @Test
    public void testToString() {
        Square square = new SnakeSquare(board, 5, 3);
        square.addPlayer(new Player("Vlad"));
        assertEquals("toString() is behaving unexpected.", "[" + 4 + "<-"+ 6+"]",
                square.toString());
    }
}