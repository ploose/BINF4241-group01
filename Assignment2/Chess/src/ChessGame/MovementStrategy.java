package ChessGame;

import java.util.ArrayList;

// Strategy every piece has to implement
public interface MovementStrategy {

    public boolean isValidMove(Board board, Square current, Square next);

    // We need this to check for potential checkmate
    public ArrayList<Square> getMoveSquares();


}

// specialized behaviour for specific pieces
interface IPawn extends MovementStrategy{
    public boolean checkPromote();
}

interface IKing extends MovementStrategy{
    public boolean isCheckMate();
}

interface IBlockedPath {

    public boolean isBlocking(Square blockedSquare, Square targetSquare);

}


