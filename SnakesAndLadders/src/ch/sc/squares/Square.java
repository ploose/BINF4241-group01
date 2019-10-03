//Author: Pascal Marty
/* TODO: Squares need / call the following functions in Game:
- Squarelist to store all squares
- populate method to initialize gameboard
- getSize() : function that returns amount of squares on the gameboard
- findSquare(index) : Find and return square from Squarelist
 */
package ch.sc.squares;

import java.awt.Point;
import java.util.ArrayList;

import ch.sc.snakesandladders.Game;
import ch.sc.snakesandladders.Player;

public abstract class Square {
    private int index; // Index of tile instance
    private boolean singleSpace; // boolean that indicates, whether the tile is limited to one player (if true) or if there is no limit (if false)
    private ArrayList<Player> curPlayers = new ArrayList<Player>(); // ArrayList with all players that are currently on the tile
    private Game game;

/* unused constructor -PL
    public Square(Game game, int index) {
        Square(game, index, true);
    }
*/
    public Square(Game game, int index, boolean singleSpace) {
        this.game = game;
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

    public Square moveAndLand(int distance){
        //TODO: If we move onto an occupied square, do we stay or do we need to go to the very begining? Also how to handle 'overshots'
        // We can't move if we would 'fall' off the board
        if (getIndex() + distance <= board.getSize()){
            Square nextSquare = board.findSquare(getIndex() + distance);
            nextSquare = nextSquare.requestLanding();
            // If we can move to the requestLanding() function will return a valid Square object, else we get null
            if(nextSquare != null){
                return nextSquare;
            } else {
                return board.findSquare(0);
            }
        } else
            return board.findSquare(board.getSize() - ((getIndex() + distance) - board.getSize))
        // If we can't move, we will return the current Square (i.e. stay on the same square)
        return this;
    }

    public Square boolean requestLanding();
}