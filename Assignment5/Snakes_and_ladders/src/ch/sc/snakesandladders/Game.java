package ch.sc.snakesandladders;

class Game {
    private static Player winner;
    private boolean isRunning;
    private Players players;
    private Player currentPlayer;
    private Board board;
    private Ui userInterface;

    Game(Players players, Ui userInterface, int size) {   //Constructor for the Game class
        this.players = players;
        this.userInterface = userInterface;
        board = new Board(size, players);
        currentPlayer = this.players.getCurrentPlayer();
    }

    void run() {    //Starts the game
        isRunning = true;
        int steps;

        userInterface.printInitialState(board);

        while (isRunning) {
            steps = Dice.throwDice();
            currentPlayer.moveFwd(steps);

            userInterface.printTurn(board, steps, currentPlayer);

            players.add(currentPlayer);

            currentPlayer = players.getCurrentPlayer();

            checkWinner();
        }
        userInterface.celebrateWinner(board, winner);
    }

    private void checkWinner() {  //Sets a winner if a player lands on the last Square
        winner = board.getWinner();
        if (winner != null) {
            isRunning = false;
        }
    }
}