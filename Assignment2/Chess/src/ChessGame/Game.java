package ChessGame;

class Game {
    private Board board;
    private Ui userInterface;
    private Player currentPlayer, black, white;
    private boolean isRunning;


    Game() {
        board = new Board(this, new PiecePot());

        userInterface = new Ui();
        isRunning = false;

        getPlayers();

        currentPlayer = black;

        run();
    }

    private void run() {
        isRunning = true;

        boolean isValidMove = false;

        while (isRunning) {
            //
            userInterface.printBoard(board.toString());
            userInterface.printScore(currentPlayer.lostPieces());
            isRunning = false;

            while (!isValidMove) {
                isValidMove = board.move();
            }
        }
    }

    void setWinner(Player winner) {
        isRunning = false;
        userInterface.celebrateWinner(winner);
    }

    private void checkCheck() {
    }

    private void checkCheckMate() {
        if (black.isChecked() || white.isChecked()) {

        }
    }

    private void move(Square currentSpot, Square newSpot) {   // Gets input from interface

    }

    private void getPlayers() {

    }
}
