package ChessGame;

class Game {
    private Board board;
    private Ui userInterface;
    private Player currentPlayer, black, white;
    private boolean isRunning;

    Game() {
        board = new Board(this);

        userInterface = new Ui();
        isRunning = false;

        getPlayers();

        currentPlayer = black;

        run();
    }

    //TODO
    private void getPlayers() {}

    private void run() {
        isRunning = true;

        boolean isValidMove = false;

        while (isRunning) {
            userInterface.printBoard(board.toString());
            userInterface.printScore(board.lostPieces());

            isRunning = false;

            while (!isValidMove) {
                isValidMove = move();
            }

            swapPlayer();
        }
    }

    private boolean checkCheck() {
        return black.isChecked() || white.isChecked();
    }

    private boolean checkCheckMate() { //TODO
        return false;
    }

    //TODO: Gets input from interface
    private boolean move() {
        return true;
    }

    private void swapPlayer() {
        if (currentPlayer == black) {
            currentPlayer = white;
        } else {
            currentPlayer = black;
        }
    }

    void setWinner(Player winner) {
        isRunning = false;
        userInterface.celebrateWinner(winner);
    }
}
