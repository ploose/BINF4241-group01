package ch.sc.squares;

import ch.sc.snakesandladders.*;

public class NormalSquare extends Square {

    public NormalSquare(Board board, int index) {
        super(board, index, "normal");
    }

    public Square requestLanding(Player p) {
        if (!isOccupied()) {
            return this;
        }
        return null;
    }

    public String toString() {
        String output = "[" + (getIndex()+1);
        for (Player p : getPlayers()) {
            output += "<" + p.getName() + ">";
        }
        output+="]";
        return output;
    }
}