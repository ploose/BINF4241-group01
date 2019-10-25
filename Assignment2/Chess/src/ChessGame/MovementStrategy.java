package ChessGame;

import java.util.ArrayList;

// Strategy every piece has to implement


public interface MovementStrategy {


    //boolean isValidMove(Square current, Square next);

    boolean move(Square current, Square next, final Square[][] squares);
    boolean hasMoved();
    Color getColor();

    // We need this to check for potential checkmate
    //ArrayList<Square> getMoveSquares();


}

// specialized behaviour for specific pieces
    interface IPawn extends MovementStrategy {
        //public boolean checkPromote();
    }
    interface IKing extends MovementStrategy{
        public boolean isCheckMate();
    }

    interface IQueen extends MovementStrategy{
        public boolean move();
    }
    interface IBishop extends MovementStrategy{
        boolean move(Square current, Square next, Square[][] squares);
    }
    interface IKnight extends MovementStrategy{
        public void move();
    }
    interface IRook extends MovementStrategy{
        public void move();
    }


interface IBlockedPath {

    public boolean isBlocking(Square blockedSquare, Square targetSquare);
}


