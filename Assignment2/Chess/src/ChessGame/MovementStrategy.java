package ChessGame;

public interface MovementStrategy {

    public boolean isValidMove(Board board, Square current, Square next);
}

interface IPawn extends MovementStrategy{
    public boolean canBePromoted();
}

