//Author: Pascal Marty
package ch.sc.squares;

import ch.sc.snakesandladders.*;

import java.util.Random;

public class SnakeSquare extends Square {
    private int jumpDistance;

    public SnakeSquare(Board board, int index, int indexNext) {
        super(board, indexNext, "snake");
        jumpDistance = index - indexNext;
    }

    public Square requestLanding(Player p) {
        return moveAndLand(jumpDistance, p);
    }
}