package ChessGame;

public interface MovementStrategy {

    boolean move(Square current, Square next, final Square[][] squares);
    boolean eat(Square current, Square next, final Square[][] squares);
    boolean hasMoved();
    Color getColor();



}



