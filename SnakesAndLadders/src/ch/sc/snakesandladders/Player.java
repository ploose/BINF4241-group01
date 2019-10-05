// Patrick Looser

/*
getCurrentSquare:
    return Square

setCurrentSquare:
    sets the current square
 */

package ch.sc.snakesandladders;
import ch.sc.squares.*;

public class Player {
    private String name;
    private Square CurrentSquare;


    public Player(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    public Square getCurrentSquare() {
        return CurrentSquare;
    }

    public void setCurrentSquare(Square currentSquare) {
        CurrentSquare = currentSquare;
    }

    // Moves the player forward to the square calculated by
    void moveFwd(int steps){
        CurrentSquare = CurrentSquare.moveAndLand(steps, this);
    }
}
