package ch.sc.snakesandladders;

public class Game {
    private static Player winner;
    private boolean isRunning;
    private Players players;
    private Player currentPlayer;
    private Board board;
    private Ui userInterface;
    private Dice dice;

    //Main the game
    public static void main(String[] args) {
        //TODO
        Ui userInterface = new Ui();
        Players players = userInterface.getPlayers();

        Game game = new Game(players);
        game.run();

        userInterface.celebrateWinner(winner);
    }

    //Constructor for the Game class
    private Game(Players players) {
        isRunning = false;
        this.players = players;
        currentPlayer = this.players.getCurrentPlayer();
        winner = null;
        board = new Board();
        dice = new Dice();
    }

    //Starts the game
    private void run() {
        isRunning = true;

        while (isRunning) {
            userInterface.getInputNextTurn();
            currentPlayer.moveFwd(Dice.throwDice());
            players.add(currentPlayer);

            currentPlayer = players.getCurrentPlayer();
        }
    }

    //Sets a winner if a player lands on the last Square
    public void setWinner(Player winner) {
        Game.winner = winner;
        isRunning = false;
    }
}