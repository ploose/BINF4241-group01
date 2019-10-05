package ch.sc.snakesandladders;

class Game {
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
        board = new Board(12, players);
        currentPlayer = this.players.getCurrentPlayer();
        winner = null;
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

            checkWinner();
        }
        userInterface.celebrateWinner(winner);
    }


    private void checkWinner() {  //Sets a winner if a player lands on the last Square
        winner = board.getWinner();
        if (winner != null) {
            isRunning = false;
        }
    }
}