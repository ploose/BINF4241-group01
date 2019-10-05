package ch.sc.snakesandladders;

import ch.sc.squares.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.awt.Point;


public class Board {

    private ArrayList<Square> squareList;
    private int size;
    private FirstSquare firstSquare;
    private LastSquare lastSquare;
    // TODO
    private Players players;
    Queue<Point> tupleQueue;


    private Game game;

    public Board() {
        tupleQueue = tupleQueueGenerator();
    }

    public int getSize() {
        return this.size;
    }


    // Initializes board with given size
    // TODO: Find a way to let the board know all the players? Is this even necessary?
    private void initBoard(int size, ArrayList PlayerQueue, Game game) {
        this.size = size;
        this.game = game;

        Square square;

        // Creates a list with all squares in order

        // fill the board with normal squares
        for (int i = 1; i < (size - 1); i++) {
            // predefined ladder and snake places
            /* TODO: (optional)Randomize ladder/snake generation,
                Tupel übergeben (umkehren für snake)
            */
                square = new NormalSquare(this, i);
                this.squareList.add(i, square);
        }

        // Add ladders
        for (int i = 0; i < 2; i++){
            Point tuple = tupleQueue.remove();
            int x = (int)tuple.getX();
            int y = (int)tuple.getY();
            square = new LadderSquare(this,x,y);
            this.squareList.add(x,square);
        }
        // Add snakes
        for (int i = 0; i < 2; i++) {
            Point tuple = tupleQueue.remove();
            int x = (int) tuple.getX();
            int y = (int) tuple.getY();
            square = new SnakeSquare(this, y, x);
            this.squareList.add(x, square);
        }

        // Add first square
        this.firstSquare = new FirstSquare(this, 0);
        this.squareList.add(0, this.firstSquare);
        // Add last square
        this.lastSquare = new LastSquare(this, size - 1);
        this.squareList.add(size - 1, this.lastSquare);
    }


    public Square findSquare(int index) {
        return squareList.get(index);
    } // Added by PM

    // Added by PM
    // TODO: This function should pass winning player (which it gets from lastsquare) to game
    public void setWinner(Player p) {
    }


    private Queue<Point> tupleQueueGenerator() {

        int result1;
        int result2;
        Random r = new Random();
        int low = 1;
        int high = 10;
        Point point = new Point();
        Queue<Point> myQueue = new LinkedList<>();

        for (int i = 0; i < 4; i++) {

            result1 = r.nextInt(high - low) + low;
            result2 = result1;
            while (result2 == result1) {
                result2 = r.nextInt(high - low) + low;
            }
            point.setLocation(result1, result2);
            myQueue.add(point);

        }
        return myQueue;
    }
}

