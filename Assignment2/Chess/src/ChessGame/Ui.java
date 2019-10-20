package ChessGame;

import java.util.Scanner;

class Ui {
    private Scanner input;

    Ui() {
        input = new Scanner(System.in);
    }

    void celebrateWinner(Player winner) {
        System.out.println("Hurrah, the player " + winner.getName() + " has won!");
    }

    void printBoard(String board) {
        System.out.print(board);
    }

    void printScore(String score) {
        System.out.print(score);
    }

    boolean printWrongInput() {
        System.out.println("Invalid Input!");
        return false;
    }

    String getPlayerName(Color color) {
        System.out.println("What's the name of the player with the color " + color + "? ");
        return input.nextLine();
    }

    String getMove(Player player) {
        System.out.print("It's " + player.getName() + "'s move. Please enter your move. Command: ");
        return input.nextLine();
    }
}
