package ch.sc.snakesandladders;

import static org.junit.Assert.*;

import org.junit.*;

import java.util.ArrayList;

public class GameTest {
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
    public void testConstructNormal() {
        try {
            Game game = new Game(players, new Ui(), 10);
        } catch (Exception e) {
            fail("Exception when constructing with normal parameters.");
        }
    }

    @Test
    public void testConstructWithoutPlayers() {
        try {
            Game game = new Game(null, new Ui(), 10);
        } catch (NullPointerException e) {
            return;
        }
        fail("NullPointerException expected");

    }

    @Test
    public void testConstructWithSinglePlayer() {
        list = new ArrayList<>();
        list.add(new Player("Sam"));
        players = new Players(list);

        try {
            Game game = new Game(players, new Ui(), 10);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");

    }

    @Test
    public void testConstructWithFivePlayers() {
        list.add(new Player("Boris"));
        list.add(new Player("Jeremy"));
        players = new Players(list);

        try {
            Game game = new Game(players, new Ui(), 10);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    @Test
    public void testConstructWithoutUI() {
        try {
            Game game = new Game(players, null, 10);
        } catch (NullPointerException e) {
            return;
        }
        fail("NullPointerException expected");

    }

    @Test
    public void testConstructWithIllegalSize() {
        try {
            Game game = new Game(players, new Ui(), 0);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");

    }

    @After
    public void tearDown() {
        for (Player player : list) {
            player = null;
        }

        list = null;
    }
}
