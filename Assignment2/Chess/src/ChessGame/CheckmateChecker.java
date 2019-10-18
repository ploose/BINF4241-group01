package ChessGame;

import java.util.ArrayList;

public class CheckmateChecker {

    Square kingSquare;
    boolean isChecked;
    Board board;
    Color color;
    PiecePot piecePot;
    Object piece;

// TODO:      - Can i move out of mate?
//            - Can I block mate?
//            - Can I take the attacker?

    public boolean isChecked(PiecePot piecePot, Square kingSquare, Color color){

        boolean isChecked = false;

        if (color == Color.WHITE){
            for (Object piece : piecePot.whitePlayerList){
                for (Square square : piece.getAttackedSquares){
                    if (square == kingSquare){
                        isChecked = true;
                    }
                }
            }
        }
        else{
            for (Object piece : piecePot.blackPlayerList){
                for (Square square : piece.getAttackedSquares){
                    if (square == kingSquare){
                        isChecked = true;
                    }
                }
            }
            }
        return isChecked;
        // Returns if the square is checked

        }
        for (Object piece : piecePot.)){
            piece.checkAttacked(kingSquare);
        }
    }

}
