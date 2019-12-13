package ch.sc.squares;

import ch.sc.snakesandladders.*;

public class LastSquare extends Square {

    public LastSquare(Board board, int index) {
        super(board, index);
        // TODO: Fixes in Javadoc / Readme
        if(board == null) {
            throw new NullPointerException();
        }
        if(index != board.getSize()-1){
            throw new IllegalArgumentException();
        }
    }

    public Square requestLanding(Player winner) {
        super.board.setWinner(winner);
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