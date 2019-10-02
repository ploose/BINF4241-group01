//Author: Pascal Marty
import java.awt.Point;
import java.util.ArrayList;

import Player;

public abstract class Square {
    private int index; // Index of tile instance
    private boolean singleSpace; // boolean that indicates, whether the tile is limited to one player (if true) or if there is no limit (if false)
    private ArrayList<Player> curPlayers = new ArrayList<Player>(); // ArrayList with all players that are currently on the tile

    public Square(int index) {
        Square(index, true);
    }

    public Square(int index, boolean singleSpace) {
        this.index = index;
        this.singleSpace = singleSpace;
    }

    public boolean isOccupied() {
        // Tile is occupied iff it's a singleSpace and there is already a player on it
        if (singleSpace && curPlayers.size() == 1): return true;
        return false; // Otherwise it is not occupied
    }

    public Point getIndex() {
        return index;
    }

    public Player addPlayer(Player p) {
        this.curPlayers.add(p);
    }

    public Player removePlayer(Player p) {
        return curPlayers.remove(p);
    }

    public abstract boolean requestLanding();

}