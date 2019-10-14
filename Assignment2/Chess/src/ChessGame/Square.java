package ChessGame;

class Square {
    int x, y;

    Square(int x, int y){
        this.x = x;
        this.y = y;
    }

    private Piece currentPiece;

    void addPiece(Piece piece) {
        currentPiece = piece;
    }

    public boolean isOccupied(){
        return currentPiece != null;
    }

    Piece removePiece() {
        Piece tmp = currentPiece;
        currentPiece = null;
        return tmp;
    }
}
