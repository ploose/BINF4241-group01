package HelperClasses;

import java.util.ArrayList;
import java.util.LinkedList;

public class Playerpot {
    public ArrayList<Player> playerList;
    public LinkedList<Player> turnQueue;

    public Player getCurrentPlayer() {
        return new Player("test");
    }

    public Player getNextPlayer() {
        return new Player("test");
    }

    public void initialize(ArrayList<Player> playerList) {
    }

    public void skipMove() {
    }
}
