package ch.sc.snakesandladders;

import java.util.ArrayList;
import java.util.Scanner;

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

    void printTurn(int positionBeforeTurn, int positionAfterTurn, int steps, Player current) {  //Describes what happened in this turn
        // Types are probably a better alternative to find out what is goind on. / Added by PM
        if(current.getCurrentSquare().getType() == "ladder"){
            System.out.println("The Player " + current.getName() + " diced a " + steps + ".");
            System.out.println("He landed on the field " + (positionBeforeTurn + steps + 1));
            System.out.println("This field was a ladder and thus he landed on the field " + (positionAfterTurn + 1) + ".");
        }else if(current.getCurrentSquare().getType() == "snake"){
            System.out.println("The Player " + current.getName() + " diced a " + steps + ".");
            System.out.println("He landed on the field " + (positionBeforeTurn + steps + 1));
            System.out.println("This field was a snake and thus he landed on the field " + (positionAfterTurn + 1) + ".");
        }else{
            System.out.println("The Player " + current.getName() + " diced a " + steps + ".");
            System.out.println("He landed on the field " + (current.getCurrentSquare().getIndex()+1));
        }

        /*
        if (positionBeforeTurn + steps < positionAfterTurn) {
            System.out.println("The Player " + current.getName() + " diced a " + steps + ".");
            System.out.println("He landed on the field " + (positionBeforeTurn + steps + 1));
            System.out.println("This field was a ladder and thus he landed on the field " + (positionAfterTurn + 1) + ".");
        } else if (positionBeforeTurn + steps > positionAfterTurn) {
            System.out.println("The Player " + current.getName() + " diced a " + steps + ".");
            System.out.println("He landed on the field " + (positionBeforeTurn + steps + 1));
            System.out.println("This field was a snake and thus he landed on the field " + (positionAfterTurn + 1) + ".");
        } else {
            System.out.println("The Player " + current.getName() + " diced a " + steps + ".");
            System.out.println("He landed on the field " + (positionBeforeTurn + steps + 1));
        }
        */
    }
}