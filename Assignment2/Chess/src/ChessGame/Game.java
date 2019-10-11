package src.ChessGame;

import src.ChessGame.Enums.*;

class Game {
    private Board board;
    private Ui userInterface;
    private boolean isRunning;

    Game(){
        board = new Board(this);
        userInterface = new Ui();
        isRunning = false;
    }

    private void run() {
        isRunning = true;

        while (isRunning) {
            //TODO
        }
    }

    void setWinner(Color winner){
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
