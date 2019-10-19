package ChessGame;

class Game {
    private Board board;
    private Ui userInterface;
    private Player currentPlayer, black, white;
    private boolean isRunning;


    Game() {
        board = new Board(this);
        board.initPiecePot();
        board.setPieces();

        userInterface = new Ui();
        isRunning = false;

        getPlayers();

        currentPlayer = black;

        run();
    }

    public Board getBoard() {
        return board;
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

    private boolean checkCheck() {
        return black.isChecked() || white.isChecked();
    }

    private boolean checkCheckMate() { //TODO
        return false;
    }

    private void move(Square currentSpot, Square newSpot) {   // Gets input from interface

    }

    private void getPlayers() {

    }
}
