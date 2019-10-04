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
    private Board board;
    private Dice dice;
    private Game game;


    public Player(String name, Game game) {

        this.game = game;
        this.name = name;
        this.board = this.game.getBoard();
        this.CurrentSquare = this.board.findSquare(0);
        this.dice = game.getDice();
    }

    public String getName() {
        return name;
    }

    public Square getCurrentSquare() {
        return CurrentSquare;
    }

    public void setCurrentSquare(Square currentSquare) {
        CurrentSquare = currentSquare;
    }

    // Moves the player forward to the square calculated by
    public void moveFwd(int steps){

        int throwNumber = this.dice.throwDice();
        this.CurrentSquare = this.CurrentSquare.moveAndLand(throwNumber, this);



    }
}
