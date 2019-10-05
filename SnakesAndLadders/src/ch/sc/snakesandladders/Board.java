package ch.sc.snakesandladders;

import ch.sc.squares.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Queue;


public class Board {

    private ArrayList<Square> squareList;
    private int size;
    private Players players;
    private Game game;

    public Board(int size, Players players, Game game){
        this.size = size;
        this.players = players;
        this.game = game;

        initBoard();
    }

    public int getSize(){
        return this.size;
    }


    // Initializes board with given size, fills list with Squares and sets every player to Square one, TB
    // TODO: Find a way to let the board know all the players? Is this even necessary?
    private void initBoard(){
        for (Player elem : players.getQueue()) {    //Set currentSquare of every Player to firstSquare, TB
            elem.setCurrentSquare(findSquare(0));
        }

        squareList.add(0, new FirstSquare(this,0));    // Add first square

        for (int i = 1; i < (size - 1); i++){   // Add normal, snake and ladder squares (predefined), TB

            //TODO: (optional)Randomize ladder/snake generation

            if ( i == 4 || i == 7){
                squareList.add(i, new LadderSquare(this, i)); // Debugged by TB
            }
            else if (i==9){
                squareList.add(i, new SnakeSquare(this, i));  // Debugged by TB
            }
            else {
                squareList.add(i, new NormalSquare(this, i)); // Debugged by TB
            }
        }

        squareList.add(size-1, new LastSquare(this, size-1));   // Add last square
    }


    public Square findSquare(int index) {
        return squareList.get(index);
    } // Added by PM

    // Added by PM
    // TODO: This function should pass winning player (which it gets from lastsquare) to game
    public void setWinner(Player p){}
}
