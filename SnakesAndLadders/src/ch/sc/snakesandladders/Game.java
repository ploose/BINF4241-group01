package ch.sc.snakesandladders;

public class Game {
    private static Player winner;
    private boolean isRunning;
    private Players players;
    private Player currentPlayer;
    private Board board;
    private Ui userInterface;

    //Constructor for the Game class
    Game(Players players, Ui userInterface) {
        isRunning = false;
        this.players = players;
        currentPlayer = this.players.getCurrentPlayer();
        winner = null;
        board = new Board(21, players, this);
        this.userInterface = userInterface;
    }

    //Starts the game
    void run() {
        isRunning = true;
        int positionBeforeTurn;
        int positionAfterTurn;
        int steps;

        while (isRunning) {
            userInterface.getInputNextTurn();

            steps = Dice.throwDice();

            positionBeforeTurn = currentPlayer.getCurrentSquare().getIndex();
            currentPlayer.moveFwd(steps);
            positionAfterTurn = currentPlayer.getCurrentSquare().getIndex();

            userInterface.printTurn(positionBeforeTurn, positionAfterTurn, steps, currentPlayer);

            players.add(currentPlayer);

            currentPlayer = players.getCurrentPlayer();
        }
    }

    //Sets a winner if a player lands on the last Square
    public void setWinner(Player winner) {
        Game.winner = winner;
        isRunning = false;
    }

    Player getWinner() {
        return winner;
    }

    // Added getter method to have the player to access the board
    public Board getBoard(){
        return this.board;
    }
}