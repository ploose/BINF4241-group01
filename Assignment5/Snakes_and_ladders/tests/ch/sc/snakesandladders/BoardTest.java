package ch.sc.snakesandladders;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class BoardTest {
    private ArrayList<Player> list;
    private Players players;

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
        //TODO
    }

    @Test
    public void testGetSize() {
        Board board1 = new Board(10, players);
        Board board2 = new Board(-1, players);
        Board board3 = new Board(0, players);

        assertEquals("Board has wrong size.", 10, board1.getSize());
        assertNotEquals("Board could be initialized with unrealistic size.", -1, board2.getSize());
        assertNotEquals("Board could be initialized with unrealistic size.", 0, board3.getSize());
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
