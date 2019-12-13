package ch.sc.snakesandladders;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class PlayersTest {

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
