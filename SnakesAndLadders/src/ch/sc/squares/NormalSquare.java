//Author: Pascal Marty
package ch.sc.squares;

import ch.sc.snakesandladders.*;

public class NormalSquare extends Square {

    public NormalSquare(Board board, int index) {
        super(board, index);
    }


    public Square requestLanding(Player p) {
        if (!isOccupied) {
            return this;
        }
        return null;
    }
}