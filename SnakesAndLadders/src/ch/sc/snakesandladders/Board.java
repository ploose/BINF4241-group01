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
    private Queue<Point> tupleQueue;

    Board(int size, Players players) {   //Constructor
        tupleQueue = tupleQueueGenerator();
        this.size = size;
        this.players = players;

        squareList = new ArrayList<>();

        initBoard();
    }

    public int getSize() {  //Returns size
        return size;
    }

    private void initBoard() {  // Initializes board with given size: Creates a list with all squares in order
        squareList.add(0, new FirstSquare(this, 0));    // Add first square

        for (int i = 1; i < (size - 1); i++) {  // fill the board with normal squares
            this.squareList.add(i, new NormalSquare(this, i));
        }

        squareList.add(size - 1, new LastSquare(this, size - 1));   // Add last square


        for (int i = 0; i < 2; i++){    // Add ladders
            Point tuple = tupleQueue.remove();
            int x = (int)tuple.getX();
            int y = (int)tuple.getY();
            this.squareList.set(x, new LadderSquare(this, x, y));
        }

        for (int i = 0; i < 2; i++) {   // Add snakes
            Point tuple = tupleQueue.remove();
            int x = (int) tuple.getX();
            int y = (int) tuple.getY();
            this.squareList.set(x, new SnakeSquare(this, y, x));
        }

        for (Player elem : players.getQueue()) {    //Sets every player on first square
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
        Queue<Point> myQueue = new LinkedList<>();

        for (int i = 0; i < 4; i++) {
            Point point = new Point();

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

