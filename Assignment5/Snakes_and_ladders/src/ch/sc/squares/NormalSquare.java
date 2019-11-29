package ch.sc.squares;

import ch.sc.snakesandladders.*;

public class NormalSquare extends Square {

    public NormalSquare(Board board, int index) {
        super(board, index);
    }

    public Square requestLanding(Player p) {
        if (!isOccupied()) {
            return this;
        }
        return null;
    }

    public String toString() {
        StringBuilder output = new StringBuilder("[" + (getIndex() + 1));
        for (Player p : getPlayers()) {
            output.append("<").append(p.getName()).append(">");
        }
        output.append("]");
        return output.toString();
    }
}