package ch.sc.snakesandladders;
import ch.sc.snakesandladders.*;

public class Main {

    //Main the game
    public static void main(String[] args) {
        //TODO
        Ui userInterface = new Ui();
        Players players = userInterface.getPlayers();

        Game game = new Game(players);
        game.run();

        userInterface.celebrateWinner(game.getWinner());
    }
}
