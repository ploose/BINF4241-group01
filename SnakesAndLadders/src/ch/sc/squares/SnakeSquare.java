//Author: Pascal Marty
package ch.sc.squares;

import ch.sc.snakesandladders.*;

import java.util.Random;

public class SnakeSquare extends Square {
    private int jumpDistance, indexNext;

    public SnakeSquare(Board board, int index, int indexNext) {
        super(board, index, "snake");
        this.indexNext = indexNext;
        jumpDistance = index - indexNext;
    }

    public Square requestLanding(Player p) {
        return moveAndLand(jumpDistance, p);
    }

    public String toString() {
        return "[" + this.indexNext + "<-" + (getIndex()+1) + "]";
    }
}