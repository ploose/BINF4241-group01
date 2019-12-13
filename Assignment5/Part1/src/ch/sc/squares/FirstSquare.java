package ch.sc.squares;

import ch.sc.snakesandladders.*;

public class FirstSquare extends Square {
    public FirstSquare(Board board, int index) {
        super(board, index);
        // TODO: Fixes in Javadoc / Readme
        if(board == null) {
            throw new NullPointerException();
        }
        if(index != 0){
            throw new IllegalArgumentException();
        }

    }

    public Square requestLanding(Player p) {
        return this;
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