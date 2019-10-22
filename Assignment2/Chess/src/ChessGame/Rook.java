package ChessGame;

class Rook extends Piece {
    private final int speed;

    Rook(Color color, Square current) {
        super(color, current);

        speed = 8;
    }

    //needs to be implemented for Checkmate
    public boolean isBlocking(Square blockedSquare, Square targetSquare) {
        return false;
    }

    public void getMoveSquares(final Square[][] squares) {
        straightUp(squares, speed);
        straightDown(squares, speed);

        straightLeft(squares, speed);
        straightRight(squares, speed);
    }

    public String toString() {
        return color.toString().charAt(0) + "T";
    }
}
