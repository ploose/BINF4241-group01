import Dice;

public class Game {
    private boolean isRunning;
    private Players players;
    private Player current;
    private Board board;
    private Ui userInterface;
    private Dice dice;

    public static void main(String[] args) {
        //TODO
        Ui userInterface = new Ui();
        Players players = userInterface.getUserInput;

        Game game = new Game(players);
        game.runTheGame();
    }

    private Game(Players players) {
        is_running = false;
        this.players = players;
        current = this.players.currentPlayer();
        board = new Board();
        dice = new Dice();
    }

    private void runTheGame() {
        while (is_running) {
            this.userInterface.getInputNextTurn();
            current.move(Dice.throwDice());
        }
    }
}