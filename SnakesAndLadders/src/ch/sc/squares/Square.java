package ch.sc.squares;

import java.util.ArrayList;

import ch.sc.snakesandladders.*;

public abstract class Square {
    Board board;
    private int index; // Index of tile instance
    private boolean singleSpace; // boolean that indicates, whether the tile is limited to one player (if true) or if there is no limit (if false)
    private ArrayList<Player> currentPlayers = new ArrayList<>(); // ArrayList with all players that are currently on the tile

    Square(Board board, int index) {
        this.board = board;
        this.index = index;
        this.singleSpace = true;
    }

    // Tile is occupied iff it's a singleSpace and there is already a player on it, otherwise it is not occupied.
    boolean isOccupied() {
        return singleSpace && currentPlayers.size() == 1;
    }

    int getIndex() {
        return index;
    }


    public void addPlayer(Player p) {
        this.currentPlayers.add(p);
    }

    public void removePlayer(Player p) {
        currentPlayers.remove(p);
    }

    ArrayList<Player> getPlayers() {
        return currentPlayers;
    }

    // The square where the player is on calculates the next square for the current player occupying the square? -PL
    public Square moveAndLand(int distance, Player p) {
        Square nextSquare;
        if (getIndex() + distance < board.getSize()) {
            nextSquare = board.findSquare(getIndex() + distance);
            nextSquare = nextSquare.requestLanding(p);
            // If we can move to the requestLanding() function will return a valid Square object, else we get null
            if (nextSquare != null) {
                return nextSquare;
            } else {
                return board.findSquare(0);
            }
        } else {
            // nextSquare = board.findSquare((board.getSize() - 1) - ((getIndex() + distance) % (board.getSize() - 1)));
            int position = (board.getSize() - 1) - (distance - (board.getSize() - 1) + getIndex());
            if (position < 0) {
                position = 0;
            }
            nextSquare = board.findSquare(position);
            nextSquare = nextSquare.requestLanding(p);
            // If we can move to the requestLanding() function will return a valid Square object, else we get null
            if (nextSquare != null) {
                return nextSquare;
            } else {
                return board.findSquare(0);
            }
        }

    }

    // This method gets implemented in the children!
    public abstract Square requestLanding(Player p);

    public abstract String toString();
}