package src.ChessGame;

class Rook extends Piece {

    Rook(Enums.Color color) {
        super(color);
    }

    @Override
    boolean isValidMove(Square current, Square next) {
        return false;
    }
}
