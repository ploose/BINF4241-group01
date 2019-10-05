//Author: Pascal Marty
/* TODO: Squares need / call the following functions in Game:
- Squarelist to store all squares
- populate method to initialize gameboard
- getSize() : function that returns amount of squares on the gameboard
- findSquare(index) : Find and return square from Squarelist
 */
package ch.sc.squares;

import java.util.ArrayList;

import ch.sc.snakesandladders.*; //Debugged TB

public abstract class Square {
    protected Board board;
    private int index; // Index of tile instance
    private boolean singleSpace; // boolean that indicates, whether the tile is limited to one player (if true) or if there is no limit (if false)
    private ArrayList<Player> currentPlayers = new ArrayList<Player>(); // ArrayList with all players that are currently on the tile
    private String type;

    // unused constructor -PL // Debugged because it is used in LastSquare ;) TB
    Square(Board board, int index, String type) {
        this.board = board;
        this.index = index;
        this.type = type;
        this.singleSpace = true;
    }

    public Square(Board board, int index, boolean singleSpace, String type) {
        this.board = board;
        this.index = index;
        this.type = type;
        this.singleSpace = singleSpace;
    }

    // Tile is occupied iff it's a singleSpace and there is already a player on it, otherwise it is not occupied.
    public boolean isOccupied() {
        return singleSpace && currentPlayers.size() == 1; //Debugged TB
    }

    public int getIndex() {
        return index; //Debugged TB
    }

    public void addPlayer(Player p) {
        this.currentPlayers.add(p);
    }

    public void removePlayer(Player p) {
        currentPlayers.remove(p); //Debugged TB
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        // Allowed types: "first", "last", "normal", "ladder", "snake"
        this.type = type;
    }

    // The square where the player is on calculates the next square for the current player occupying the square? -PL
    public Square moveAndLand(int distance, Player p) {
        //TODO: If we move onto an occupied square, do we stay or do we need to go to the very beginning? Also how to handle 'overshot's'
        // We can't move if we would 'fall' off the board
        if (getIndex() + distance <= board.getSize()) {
            Square nextSquare = board.findSquare(getIndex() + distance);
            nextSquare = nextSquare.requestLanding(p);
            // If we can move to the requestLanding() function will return a valid Square object, else we get null
            if (nextSquare != null) {
                return nextSquare;
            } else {
                return board.findSquare(0);
            }
        } else
            return board.findSquare(board.getSize() - ((getIndex() + distance) - board.getSize()));
    }

    // This method gets implemented in the children!
    public abstract Square requestLanding(Player p);
}