package src.ChessGame;

import src.ChessGame.Enums.*;

class Knight extends Piece{

    Knight(Color color) {
        super(color);
    }

    @Override
    boolean isValidMove(Square current, Square next) {
        return false;
    }
}
