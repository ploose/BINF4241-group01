package ch.sc.snakesandladders;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private Scanner input;

    //Constructor for Ui class
    Ui() {
        input = new Scanner(System.in);
        System.out.println("Hello, and welcome to a new game of snakes and ladders!");
    }

    //Takes user-input and creates players
    Players getPlayers() {
        int numberOfPlayers = 0;

        while (numberOfPlayers < 2 || numberOfPlayers > 4) {
            System.out.println("How many players want to play? (2-4 players) ");
            numberOfPlayers = input.nextInt();
        }
        ArrayList<Player> playerList = new ArrayList<Player>();

        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Name of the " + i + ". player: ");
            Player player = new Player(input.nextLine());
            playerList.add(player);
        }

        Players players = new Players(playerList);
        return players;
    }

    //Takes user-input for resuming with next turn
    void getInputNextTurn() {
        String answer;

        System.out.println("Ready for the next turn? (y for yes, n for no)");
        answer = input.nextLine();
        while (!answer.equals("y")) {
            System.out.println("Just print y if you're ready!");
            answer = input.nextLine();
        }
    }

    //Prints the winner of the game
    void celebrateWinner(Player winner) {
        System.out.println("Hurrah, the player " + winner.getName() + " has won!");
    }

    //Describes what happened in this turn
    public void printTurn() {
        //TODO: Print what happened in that round
    }
}