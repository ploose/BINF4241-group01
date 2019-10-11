package src.ChessGame;

class Square {
    private Piece currentPiece;

    void addPiece(Piece piece) {
        currentPiece = piece;
    }

    Piece removePiece() {
        Piece tmp = currentPiece;
        currentPiece = null;
        return tmp;
    }
}
