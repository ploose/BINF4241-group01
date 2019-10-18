package ChessGame;

class Game {
    private Board board;
    private Ui userInterface;
    private boolean isRunning;

<<<<<<< Updated upstream
    Game(){
        board = new Board(this);
=======
    Game() {
        board = new Board(this, new PiecePot());
>>>>>>> Stashed changes
        userInterface = new Ui();
        isRunning = false;

        run();
    }

    private void run() {
        isRunning = true;

        while (isRunning) {
            //
            userInterface.printBoard(board.getBoard());
            isRunning = false;
        }
    }

    void setWinner(Player winner){
        isRunning = false;
        userInterface.celebrateWinner(winner);
    }

    private void checkCheck() {}

    private void checkCheckMate() {}

    private void move(Square currentSpot, Square newSpot) {   // Gets input from interface

    }
 /* Might not be needed
    private void initQueue() {}
 */
    private void getCurrentPlayer() {}
}
