package ch.sc.snakesandladders;

import static org.junit.Assert.*;

import org.junit.*;

import java.util.ArrayList;

public class GameTest {
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
     *  This test tries to construct the Game with expected / normal parameters.
     *  If this test is negative, there's probably a fundamental flaw.
     */
    @Test
    public void testConstructNormal() {
        try {
            Game game = new Game(players, new Ui(), 10);
        } catch (Exception e) {
            fail("Exception when constructing with normal parameters.");
        }
    }

    /**
     * If we try to construct the Game without a Players object, we want to get a NullPointerException, which we
     * test here.
     */
    @Test
    public void testConstructWithoutPlayers() {
        try {
            Game game = new Game(null, new Ui(), 10);
        } catch (NullPointerException e) {
            return;
        }
        fail("NullPointerException expected");

    }

    /**
     * The Game is for 2-4 players. Therefore we want to receive an IllegalArgumentException when trying to create a
     * game with less players than that. We check whether we get the desired IllegalArgumentException here.
     */
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

    /**
     * The Game is for 2-4 players. Therefore we want to receive an IllegalArgumentException when trying to create a
     * game with more players than that. We check whether we get the desired IllegalArgumentException here.
     */
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

    /**
     *  We want to receive a NullPointerException when trying to create the Game without a Ui object. This is tested
     *  here.
     */
    @Test
    public void testConstructWithoutUI() {
        try {
            Game game = new Game(players, null, 10);
        } catch (NullPointerException e) {
            return;
        }
        fail("NullPointerException expected");

    }

    /**
     * The game boards size has no upper limit, but needs at least 2 squares. If we try to create a game with any
     * less than that, we want to get an IllegalArgumentException, which we test here.
     */
    @Test
    public void testConstructWithIllegalSize() {
        try {
            Game game = new Game(players, new Ui(), 0);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected");

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
