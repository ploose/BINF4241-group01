//Author: Pascal Marty
package ch.sc.squares;

import ch.sc.snakesandladders.*;

import java.util.Random;

public class SnakeSquare extends Square {
    private int jumpDistance;

    public SnakeSquare(Board board, int index) {
        super(board, index);
        initJumpDistance(index);
    }

    // Initializes distance, which the snake will move the player, calculated between (index-1) and (start+1)
    // TODO: Multiple snakes could end up at same square, also ladders could spawn on snakes

    // added "void" -PL
    private void initJumpDistance(int index) {

        Random random = new Random();
        this.jumpDistance = random.nextInt(index - 2) + 2;
    }

    public Square requestLanding(Player p) {
        return moveAndLand(jumpDistance, p);
    }
}