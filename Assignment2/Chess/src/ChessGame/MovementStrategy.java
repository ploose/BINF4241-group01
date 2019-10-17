package ChessGame;

// Strategy every piece has to implement
public interface MovementStrategy {

    public boolean isValidMove(Board board, Square current, Square next);


}

// specialized behaviour for specific pieces
interface IPawn extends MovementStrategy{
    public boolean checkPromote();
}

interface IKing extends MovementStrategy{
    public boolean isCheckMate();
}


