package ChessGame;

import src.ChessGame.Enums.*;

class Pawn extends Piece{

    Pawn(Color color) {
        super(color);
    }

    public boolean CheckPromote(){
        return true;
    }

    @Override
    boolean isValidMove(Square current, Square next) {
        return false;
    }
}
