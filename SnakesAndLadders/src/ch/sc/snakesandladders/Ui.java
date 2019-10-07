package ch.sc.snakesandladders;

import java.util.ArrayList;
import java.util.Scanner;


import ch.sc.snakesandladders.*;

class Ui {
    private Scanner input;

    Ui() {  //Constructor for Ui class
        input = new Scanner(System.in);
        System.out.println("Hello, and welcome to a new game of snakes and ladders!");
    }

    ArrayList<Player> getPlayers() {    //Takes user-input and creates players
        int numberOfPlayers = 0;
        System.out.println("How many players want to play?\n");

        // Checks for invalid input - PL
        while (numberOfPlayers < 2 || numberOfPlayers > 4) {
            System.out.println("Please enter a number between 2 and 4.");
            Scanner input = new Scanner(System.in);
            while(!input.hasNextInt()){
                System.out.println("Please enter a number between 2 and 4.");
                input.next();
            }
            numberOfPlayers = input.nextInt();

        }
        ArrayList<Player> playerList = new ArrayList<>();

        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Name of the " + i + ". player: \n");
            Player player = new Player(input.next());
            playerList.add(player);
        }

        return playerList;
    }

    void getInputNextTurn() {   //Takes user-input for resuming with next turn
        String answer;

        System.out.println("Ready for the next turn? (y for yes, n for no)");
        answer = input.nextLine();
        while (!answer.equals("y")) {
            System.out.println("Just print y if you're ready!");
            answer = input.nextLine();
        }
    }

    void celebrateWinner(Player winner) {   //Prints the winner of the game
        System.out.println("Hurrah, the player " + winner.getName() + " has won!");
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