import HelperClasses.*;
import org.junit.Before;
import HelperClasses.Discardpile;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.*;

import java.awt.*;
import java.util.*;

import java.util.ArrayList;

public class PlayerpotTest {


    /**
     * This class tests the functionalities of the Playerpot
     */


    Game g;
    Discardpile dis;
    Deck deck;


    @Before
    public void setUp() {
        g = new Game();
        g.initialize();
        g.direction = Direction.CLOCKWISE;
        g.playerpot = new Playerpot();
        dis = new Discardpile();
        deck = new Deck();
        deck.initialize(); // Sets up a deck with all cards.
    }

    /**
     * Testing skipMove();
     */



}
