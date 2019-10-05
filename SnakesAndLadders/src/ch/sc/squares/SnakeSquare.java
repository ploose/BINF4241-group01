//Author: Pascal Marty
package ch.sc.squares;

import ch.sc.snakesandladders.*;

import java.util.Random;

public class SnakeSquare extends Square {
    private int jumpDistance;

    public SnakeSquare(Board board, int index, int indexNext) {
        super(board, index, "snake");
        jumpDistance = indexNext - index;
        System.out.println("Snake:" + jumpDistance);
    }

    public Square requestLanding(Player p) {
        return moveAndLand(jumpDistance, p);
    }
}