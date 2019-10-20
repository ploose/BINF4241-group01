package ChessGame;

class Square {
    int x, y;
    private Piece currentPiece;

    Square(int x, int y) {
        this.x = x;
        this.y = y;
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
