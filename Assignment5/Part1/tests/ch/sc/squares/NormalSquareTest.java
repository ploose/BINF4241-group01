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

    @Test
    public void testConstructorNormal() {
        try {
            Square square = new NormalSquare(board, 1);
        } catch (Exception e) {
            fail("Exception when constructing with normal parameters.");
        }
    }

    @Test
    public void testConstructorWithoutBoard() {
        try {
            Square square = new NormalSquare(null, 1);
        } catch (NullPointerException e) {
            return;
        }
        fail("NullPointerException expected");
    }

    @Test
    public void testConstructorWithIllegalIndex() {
        try {
            Square square = new NormalSquare(board, -1);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    @Test
    public void testRequestLandingOnUnoccupied(){
        Square square = new NormalSquare(board, 1);
        assertEquals("Couldn't land on unoccupied square.", square, square.requestLanding(playerA));
    }

    @Test
    public void testRequestLandingOnOccupied(){
        Square square = new NormalSquare(board, 1);
        square.addPlayer(playerB);
        assertEquals("Couldn't land on unoccupied square.", null, square.requestLanding(playerA));
    }

    @Test
    public void testToString() {
        Square square = new NormalSquare(board, 1);
        square.addPlayer(new Player("Vlad"));
        assertEquals("toString() is behaving unexpected.", "[2<Vlad>]",
                square.toString());
    }

    // Testing general methods of the Square parent class
    @Test
    public void testIsOccupied(){
        Square square = new NormalSquare(board, 1);
        assertFalse("returns true although square is unoccupied.", square.isOccupied());

        square.addPlayer(new Player("Vlad"));
        assertTrue("returns false although square is occupied.", square.isOccupied());
    }

    @Test
    public void testAddPlayerOnUnoccupied(){
        Square square = new NormalSquare(board, 1);
        try {
            square.addPlayer(playerA);
        } catch (Exception e) {
            fail("Unexpected error when adding player to unnocupied square.");
        }

    }

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