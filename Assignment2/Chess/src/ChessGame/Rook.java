package ChessGame;

class Rook extends Piece {
    private final int speed;

    Rook(Color color, Square current) {
        super(color, current);

        speed = 8;
    }

    public void getMoveSquares(final Square[][] squares) {
        possibleMoveSquares.clear();
        canEat.clear();

        straightUp(squares, speed);
        straightDown(squares, speed);

        straightLeft(squares, speed);
        straightRight(squares, speed);
    }

    public String toString() {
        return color.toString().charAt(0) + "T";
    }
}
