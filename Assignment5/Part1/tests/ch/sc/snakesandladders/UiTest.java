package ch.sc.snakesandladders;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.jupiter.api.BeforeAll;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class UiTest {
    private Ui userInterface;
    private ArrayList<Player> list;
    private Players players;

    @Before
    public void setUp() {
        userInterface = new Ui();

        list = new ArrayList<>();

        list.add(new Player("Sam"));
        list.add(new Player("Nathalie"));
        list.add(new Player("Alexis"));

        players = new Players(list);
    }

    @Test
    public void testGetBoardSizeWithLegalInput() {
        String input = "10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        try {
            int size = userInterface.getBoardSize();
        } catch (Exception e) {
            fail("Unexpected exception when getting normal input.");
        }
    }

    @Test
    public void testGetBoardSizeWithIllegalInput() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        try {
            int size = userInterface.getBoardSize();
        } catch (Exception e) {
            return;
        }
        fail("UI accepted illegal size parameter (x < 2)");
    }

    // TODO: Test this or just write that it couldn't be done?
//    @Test
//    public void testGetPlayersNormalInput() {
//        ArrayList<Player> expected = new ArrayList<>(), playerList = null;
//        expected.add(new Player("Sam"));
//        expected.add(new Player("Nathalie"));
//        expected.add(new Player("Alexis"));
//
//        String simulatedUserInput = "3" + System.getProperty("line.separator") +System.
//                + "Sam" + System.getProperty("line.separator") + "Nathalie" + System.getProperty("line.separator")
//                + "Alexis" + System.getProperty("line.separator");
//
//        InputStream savedStandardInputStream = System.in;
//        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
//
//        try {
//            playerList = userInterface.getPlayers();
//        } catch (Exception e) {
//            fail("Unexpected exception when getting normal input.");
//        }
//
//        System.setIn(savedStandardInputStream);
//
//        assertEquals("Unexpected playerlist from normal input.", expected, playerList);
//
//    }


}
