//Author: Pascal Marty
package ch.sc.squares;

import ch.sc.snakesandladders.*;

import java.util.Random;

public class LadderSquare extends Square {
    private int jumpDistance;
    private Square squareTarget;

    public LadderSquare(Board board, int index) {
        super(board, index, "ladder");
        initJumpDistance(index);
        squareTarget = requestLanding(null); // get square the ladder points to
        squareTarget.setType("ladder"); // set that square's type to "ladder"
    }

    // Initializes distance, which the ladder will move the player, calculated between (index+1) and (end-1)
    // TODO: Multiple ladders could end up at same square, also snakes could spawn on ladders
    private void initJumpDistance(int index) {
        Random random = new Random();
        this.jumpDistance = random.nextInt((board.getSize() - index - 1) + 1 + index);
    }

    public Square requestLanding(Player p) {
        return moveAndLand(jumpDistance, p);
    }
}