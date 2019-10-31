package ChessGame;

class Queen extends Piece {
    private final int speed;

    Queen(Color color, Square current){
        super(color, current);

        speed = 8;
    }

    public void getMoveSquares(final Square[][] squares){
        possibleMoveSquares.clear();
        canEat.clear();

        diagonalDownLeft(squares, speed);
        diagonalDownRight(squares, speed);
        diagonalUpLeft(squares, speed);
        diagonalUpRight(squares, speed);

        straightDown(squares, speed);
        straightUp(squares, speed);
        straightLeft(squares, speed);
        straightRight(squares, speed);
    }

    @Override
    public String toString() {
        return color.toString().charAt(0) + "Q";
    }
}