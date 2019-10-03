//Author: Pascal Marty, Tim Brunner
package ch.sc.squares;

import ch.sc.snakesandladders.*; //Debugged TB

public class LastSquare extends Square {

    public LastSquare(Board board, int index) {
        super(board, index);
    }

    public Square requestLanding(Player p) {
        game.setWinner(p);
        return this;
    }
}