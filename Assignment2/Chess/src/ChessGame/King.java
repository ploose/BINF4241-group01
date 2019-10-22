package ChessGame;

class King extends Piece {
    private final int speed;

    King(Color color, Square current){
        super(color, current);

        speed = 1;
    }

    // TODO:
    public boolean CanBeCaptured(){
        return true;
    }

    public boolean isCheckMate() {
        return false;
        }

    public void getMoveSquares(final Square[][] squares) {
        straightDown(squares, speed);
        straightUp(squares, speed);
        straightLeft(squares, speed);
        straightRight(squares, speed);
        diagonalDownLeft(squares, speed);
        diagonalDownRight(squares, speed);
        diagonalUpLeft(squares, speed);
        diagonalUpRight(squares, speed);
    }

    @Override
    public String toString() {
        return color.toString().charAt(0) + "K";
    }
}


