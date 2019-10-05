//Author: Pascal Marty
package ch.sc.squares;

import ch.sc.snakesandladders.*;

public class FirstSquare extends Square {
    public FirstSquare(Board board, int index) {
        super(board, index, "first");
    }

    public Square requestLanding(Player p) {
        return this;
    }
}