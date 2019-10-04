package ch.sc.snakesandladders;

import ch.sc.squares.*;
import java.util.ArrayList;
import java.util.Queue;


public class Board {

    private ArrayList<Square> squareList;
    private int size;
    private FirstSquare firstSquare;
    private LastSquare lastSquare;
    // TODO
    private Players players;


    private Game game;

    public Board(){

    }

    public int getSize(){
        return this.size;
    }


    // Initializes board with given size
    // TODO: Find a way to let the board know all the players? Is this even necessary?
    private void initBoard(int size, ArrayList PlayerQueue, Game game){
        this.size = size;
        this.game = game;
        this.firstSquare = new FirstSquare(this,0); // Debugged by PM
        this.lastSquare = new LastSquare(this, size-1); // Debugged by PM
        Square square;

        // Creates a list with all squares in order
        // Add first square
        this.squareList.add(0, this.firstSquare);
        // Add normal, snake and ladder squares
        for (int i = 1; i < (size - 1); i++){

            // predefined ladder and snake places
            /*TODO: (optional)Randomize ladder/snake generation,

            */

            if ( i == 4 || i == 7){ square = new LadderSquare(this, i); } // Debugged by PM
            else if (i==9){ square = new SnakeSquare(this, i); } // Debugged by PM
            else { square = new NormalSquare(this, i); } // Debugged by PM
            this.squareList.add(i, square);
        }
        // Add last square
        this.squareList.add(size-1,lastSquare);
    }


    public Square findSquare(int index) {
        return squareList.get(index);
    } // Added by PM

    // Added by PM
    // TODO: This function should pass winning player (which it gets from lastsquare) to game
    public void setWinner(Player p){}
}
