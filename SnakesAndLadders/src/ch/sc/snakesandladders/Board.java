package ch.sc.snakesandladders;

import ch.sc.squares.*;

import java.sql.SQLInvalidAuthorizationSpecException;
import java.util.*;
import java.awt.Point;


public class Board {

    private ArrayList<Square> squareList;
    private int size;
    private Player winner;
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
            // Add first square to players
            elem.setCurrentSquare(findSquare(0));
            // Add players to first square
            findSquare(0).addPlayer(elem); // Debugged by PM
        }
    }


    public Square findSquare(int index) {
        return squareList.get(index);
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    Player getWinner() {
        return winner;
    }

    private Queue<Point> tupleQueueGenerator() {
        int result1;
        int result2;
        Random r = new Random();
        int low = 1;
        int high = 10;
        Queue<Point> myQueue = new LinkedList<>();
        List<Integer> usedSquares = new ArrayList<Integer>();

        usedSquares.add(0);
        result1 = 0;
        result2 = 0;

        for (int i = 0; i < 4; i++) {
            Point point = new Point();

            while (true){
            if (usedSquares.contains(result1)){
                result1 = r.nextInt(high - low) + low;
            }
                usedSquares.add(result1);
                break;
            }

            while (true){

                if (usedSquares.contains(result2)){
                    result2 = r.nextInt(high - low) + low;
                }
                usedSquares.add(result2);
                break;
            }
            System.out.println("R1: " + result1);
            System.out.println("R2: " + result2);
            if (result1 < result2){
                point.setLocation(result1, result2);
                myQueue.add(point);
            }

            else{
                point.setLocation(result2, result1);
                myQueue.add(point);
            }
        }
        for(int ints : usedSquares) {
            System.out.println(ints);
        }
        return myQueue;
    }
}

