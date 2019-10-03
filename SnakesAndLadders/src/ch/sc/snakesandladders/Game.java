import Dice;

public class Game {
    private boolean isRunning;
    private Players players;
    private Player current;
    private Player winner;
    private Board board;
    private Ui userInterface;
    private Dice dice;

    public static void main(String[] args) {
        //TODO
        Ui userInterface = new Ui();
        Players players = userInterface.getUserInput;

        Game game = new Game(players);
        game.runTheGame();

        game.celebrateWinner();
    }

    private Game(Players players) {
        isRunning = false;
        this.players = players;
        current = this.players.currentPlayer();
        winner = null;
        board = new Board();
        dice = new Dice();
    }

    private void runTheGame() {
        isRunning = true;

        while (isRunning) {
            this.userInterface.getInputNextTurn();
            current.move(Dice.throwDice());
        }
    }

    public void setWinner(Player winner) {
        this.winner = winner;
        isRunning = false;
    }
}