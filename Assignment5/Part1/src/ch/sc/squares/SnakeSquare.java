package ch.sc.squares;

import ch.sc.snakesandladders.*;

public class SnakeSquare extends Square {
    private int jumpDistance, indexNext;

    public SnakeSquare(Board board, int index, int indexNext) {
        super(board, index);


        this.indexNext = indexNext;
        jumpDistance = indexNext - index;

        if(index == indexNext){
            throw new IllegalArgumentException("Snake can't connect to itself.");
        }
        if(index == 0){
            throw new IllegalArgumentException("Snake can't be placed on first square.");
        }
        if(index == board.getSize()-1){
            throw new IllegalArgumentException("Snake can't be placed on last square.");
        }
        if(indexNext == 0){
            throw new IllegalArgumentException("Snake can't go to first square.");
        }
        if(indexNext == board.getSize()-1){
            throw new IllegalArgumentException("Snake can't go to  last square.");
        }
        if(index < indexNext){
            throw new IllegalArgumentException("indexNext needs to be smaller than index.");
        }
        if(indexNext < 0 || indexNext >= board.getSize()){
            throw new IllegalArgumentException("indexNext needs to be in range.");
        }
    }

    public Square requestLanding(Player p) {
        return moveAndLand(jumpDistance, p);
    }

    public String toString() {
        return "[" + (this.indexNext+1) + "<-" + (getIndex()+1) + "]";
    }
}