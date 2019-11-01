package ChessGame;

class Bishop extends Piece implements GenericMovementStrategy, MovementStrategy {
    private final int speed;

    Bishop(Color color, Square current){
        super(color, current);

        speed = 8;
    }

    @Override
    public void getMoveSquares(Square[][] squares){
        possibleMoveSquares.clear();
        canEat.clear();

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
