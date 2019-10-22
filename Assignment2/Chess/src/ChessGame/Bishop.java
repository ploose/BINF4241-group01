package ChessGame;

class Bishop extends Piece {
    private final int speed;

    Bishop(Color color, Square current){
        super(color, current);

        speed = 8;
    }

    //needs to be implemented for Checkmate
    public boolean isBlocking(Square blockedSquare, Square targetSquare){
        return false;
    }

    @Override
    public void getMoveSquares(Square[][] squares){
        diagonalDownLeft(squares, speed);
        diagonalDownRight(squares, speed);
        diagonalUpLeft(squares, speed);
        diagonalUpRight(squares, speed);
    }

    @Override
    public String toString() {
        return color.toString().charAt(0) + "B";
    }
}
