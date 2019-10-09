package ch.sc.snakesandladders;

import java.util.ArrayList;

public class Main {

    //Main of the game
    public static void main(String[] args) {
        Ui userInterface = new Ui();

        int size = userInterface.getBoardSize();

        ArrayList<Player> playerList;
        playerList = userInterface.getPlayers();

        Players players = new Players(playerList);

        Game game = new Game(players, userInterface, size);
            game.run();
        }
}
