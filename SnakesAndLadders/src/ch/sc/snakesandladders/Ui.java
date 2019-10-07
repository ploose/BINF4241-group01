package ch.sc.snakesandladders;

import java.util.ArrayList;
import java.util.Scanner;

class Ui {
    private Scanner input;

    Ui() {  //Constructor for Ui class
        input = new Scanner(System.in);
        System.out.println("Hello and Welcome to a new Game of Snakes & Ladders!\n");
    }

    public int getBoardSize(){ // Takes user-input and returns given size Added by PM
        int boardSize = 0;
        System.out.println("How many squares should the gameboard have?");

        while (boardSize < 2) {
            System.out.print("Please enter a number greater or equal to 2: ");
            Scanner input = new Scanner(System.in);
            while(!input.hasNextInt()){
                System.out.print("Please enter a number greater or equal to 2: ");
                input.next();
            }
            boardSize = input.nextInt();
        }
        System.out.println("");
        return boardSize;
    }

    ArrayList<Player> getPlayers() {    //Takes user-input and creates players
        int numberOfPlayers = 0;
        System.out.println("How many players want to play?");

        // Checks for invalid input - PL
        while (numberOfPlayers < 2 || numberOfPlayers > 4) {
            System.out.print("Please enter a number between 2 and 4: ");
            Scanner input = new Scanner(System.in);
            while(!input.hasNextInt()){
                System.out.print("Please enter a number between 2 and 4: ");
                input.next();
            }
            numberOfPlayers = input.nextInt();
        }
        ArrayList<Player> playerList = new ArrayList<>();

        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Name of the " + i + ". player: ");
            Player player = new Player(input.next());
            playerList.add(player);
        }
        System.out.println("");
        return playerList;
    }

    void celebrateWinner(Board board, Player winner) {   //Prints the winner of the game
        System.out.print("Final state: ");
        printBoard(board);
        System.out.println(winner.getName() + " wins!");
    }

    void printTurn(Board board, int steps, Player current){
        System.out.print(current.getName() + " rolls " + steps + ":   ");
        printBoard(board);
    }

    void printInitialState(Board board){
        System.out.print("Initial state: ");
        printBoard(board);
    }

    void printBoard(Board board){
        String output = "";
        for (int i = 0; i < board.getSize(); i++){
            output+= board.findSquare(i).toString();
        }
        System.out.println(output);

    }
}