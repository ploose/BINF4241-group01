package ch.sc.snakesandladders;

import ch.sc.squares.*;
import java.util.ArrayList;
import java.util.Queue;


public class Board {

    private ArrayList<Square> squareList;
    private int size;
    private FirstSquare firstSquare;
    private LastSquare lastSquare;


    private Game game;

    public Board(){

    }

    public int getSize(){
        return this.size;
    }

    // Initializes board with given size
    private void initBoard(int size, ArrayList PlayerQueue, Game game){
        this.size = size;
        this.game = game;
        this.firstSquare = new FirstSquare(this.game ,0);
        this.lastSquare = new LastSquare(this.game, size-1);
        Square square;

        // Creates a list with all squares in order
        // Add first square
        this.squareList.add(0, this.firstSquare);
        // Add normal, snake and ladder squares
        for (int i = 1; i < (size - 1); i++){

            // predefined ladder and snake places
            /*TODO: (optional)Randomize ladder/snake generation,
                What's with the singleSpace?
            */

            if ( i == 4 || i == 7){ square = new LadderSquare(this.game, i); }
            else if (i==9){ square = new SnakeSquare(this.game, i); }
            else { square = new NormalSquare(this.game, i); }
            this.squareList.add(i, square);
        }
        // Add last square
        this.squareList.add(size-1,lastSquare);
    }

    public Square findSquare(int index) {
        return squareList.get(index);
    } // Added by PM
}
