package ch.sc.snakesandladders;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class PlayersTest {
    /**
     *  Some general tests for the Players class.
     *
     *  First we add 3 players and check whether getQueue() method returns a list of the correct size.
     *
     *  Next we check that the getCurrentPlayer() method, which rotates through the saved players and removes the front
     *  one & gives it back, gives the correct names in the correct order.
     *
     *  We then check whether the queue is indeed empty after getting all 3 previously saved players.
     *
     *  We then add 3 new players and once again check, whether the size() method gives the correct result.
     */
    @Test
    public void testPlayers() {
        ArrayList<Player> player = new ArrayList<>();
        player.add(new Player("Sam"));
        player.add(new Player("Anna"));
        player.add(new Player("Thomas"));

        Players players = new Players(player);

        List<Player> test = players.getQueue();

        assertEquals("Wrong numbers of players", test.size(), 3);

        assertEquals("Wrong player is currentPlayer.", players.getCurrentPlayer().getName(), "Sam");
        assertEquals("Wrong player is currentPlayer.", players.getCurrentPlayer().getName(), "Anna");
        assertEquals("Wrong player is currentPlayer.", players.getCurrentPlayer().getName(), "Thomas");

        test = players.getQueue();
        assertEquals("Did not remove players from list.", test.size(), 0);

        players.add(new Player("Jan"));
        players.add(new Player("Stefan"));
        players.add(new Player("Janine"));

        test = players.getQueue();
        assertEquals("Did not add players.", test.size(), 3);
    }
}
