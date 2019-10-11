package src.ChessGame;

import src.ChessGame.Enums.*;

class Queen extends Piece {

    Queen(Color color) {
        super(color);
    }

    @Override
    boolean isValidMove(Square current, Square next) {
        return false;
    }
}
