// Patrick Looser

/*
getCurrentSquare:
    return Square

setCurrentSquare:
    sets the current square
 */

package ch.sc.snakesandladders;
public class Player {

    private String Name;
    private Square CurrentSquare;

    public Square getCurrentSquare() {
        return CurrentSquare;
    }

    public void setCurrentSquare(Square currentSquare) {
        CurrentSquare = currentSquare;
    }

    public void moveFwd(){

    }
}
