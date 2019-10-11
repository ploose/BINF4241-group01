package src.ChessGame;

import src.ChessGame.Enums.*;

public class King extends Piece{

    // TODO: We have to ask if we should use int or enums for the coordinates.
    //  Probably enums would be shit. Enums are shit
    King(Color color){
        super(color);
    }

    public boolean CanBeCaptured(){
        return true;
    }

    @Override
    boolean isValidMove(Square current, Square next) {
        return false;
    }
}
