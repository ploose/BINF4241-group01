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
    private Players players;
    Queue<Point> tupleQueue;

    public Board(int size, Players players) {
        tupleQueue = tupleQueueGenerator();
        this.size = size;
        this.players = players;

        squareList = new ArrayList<>(size);

        initBoard();
    }

    public int getSize() {
        return this.size;
    }

    // Initializes board with given size: Creates a list with all squares in order
    private void initBoard() {
        for (int i = 1; i < (size - 1); i++) {  // fill the board with normal squares
            this.squareList.set(i, new NormalSquare(this, i));
        }
        // Add ladders
        for (int i = 0; i < 2; i++){
            Point tuple = tupleQueue.remove();
            int x = (int)tuple.getX();
            int y = (int)tuple.getY();
            this.squareList.set(x, new LadderSquare(this, x, y));
        }
        // Add snakes
        for (int i = 0; i < 2; i++) {
            Point tuple = tupleQueue.remove();
            int x = (int) tuple.getX();
            int y = (int) tuple.getY();
            this.squareList.set(x, new SnakeSquare(this, y, x));
        }

        // Add first square
        squareList.set(0, new FirstSquare(this, 0));

        // Add last square
        squareList.set(size - 1, new LastSquare(this, size - 1));

        for (Player elem : players.getQueue()) {    //Sets every player on square one
            elem.setCurrentSquare(findSquare(0));
        }
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

