package ch.sc.snakesandladders;

import ch.sc.snakesandladders.*;
import java.util.ArrayList;

public class Main {

    //Main the game
    public static void main(String[] args) {
        //TODO
        Ui userInterface = new Ui();

        ArrayList playerList;
        playerList = userInterface.getPlayers();

        Players players = new Players(playerList);

        Game game = new Game(players, userInterface);
        game.run();

        userInterface.celebrateWinner(game.getWinner());
    }
}
