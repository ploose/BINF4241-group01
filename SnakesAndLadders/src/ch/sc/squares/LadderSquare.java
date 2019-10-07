//Author: Pascal Marty
package ch.sc.squares;

import ch.sc.snakesandladders.*;

public class LadderSquare extends Square {
    private int jumpDistance, indexNext;
    //private Square squareTarget;

    public LadderSquare(Board board, int index, int indexNext) {
        super(board, index, "ladder");
        this.indexNext = indexNext;
        jumpDistance = indexNext - index;
        //squareTarget = requestLanding(null);
        //squareTarget.setType("ladder");
    }

    public Square requestLanding(Player p) {
        return moveAndLand(jumpDistance, p);
    }

    public String toString() {
        return "[" + (getIndex()+1) + "->" + this.indexNext + "]";
    }
}