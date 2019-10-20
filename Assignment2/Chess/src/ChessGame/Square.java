package ChessGame;

class Square {
    private Piece currentPiece;

    Square(){
    }

    void addPiece(Piece piece) {
        currentPiece = piece;
    }

    boolean isOccupied(){
        return currentPiece != null;
    }

    Piece removePiece() {
        Piece tmp = currentPiece;
        currentPiece = null;
        return tmp;
    }

    public String toString() {
        if (currentPiece == null) {
            return "  ";
        } else {
            return currentPiece.toString();
        }
    }
}
