package ch.sc.squares;

import ch.sc.snakesandladders.*;

public class LadderSquare extends Square {
    // TODO: fixes Javadoc / Readme
    private int jumpDistance, indexNext;

    public LadderSquare(Board board, int index, int indexNext) {
        super(board, index);

        this.indexNext = indexNext;
        jumpDistance = indexNext - index;

        if(index == indexNext){
            throw new IllegalArgumentException("Ladder can't connect to itself.");
        }
        if(index == 0){
            throw new IllegalArgumentException("Ladder can't be placed on first square.");
        }
        if(index == board.getSize()-1){
            throw new IllegalArgumentException("Ladder can't be placed on last square.");
        }
        if(indexNext == 0){
            throw new IllegalArgumentException("Ladder can't go to first square.");
        }
        if(indexNext == board.getSize()-1){
            throw new IllegalArgumentException("Ladder can't go to  last square.");
        }
        if(index > indexNext){
            throw new IllegalArgumentException("indexNext needs to be greater than index.");
        }
        if(indexNext < 0 || indexNext >= board.getSize()){
            throw new IllegalArgumentException("indexNext needs to be in range.");
        }
    }

    public Square requestLanding(Player p) {
        return moveAndLand(jumpDistance, p);
    }

    public String toString() {
        return "[" + (getIndex() + 1) + "->" + (this.indexNext + 1) + "]";
    }
}