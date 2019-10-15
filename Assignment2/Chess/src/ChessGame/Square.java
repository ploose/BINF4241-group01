package ChessGame;

class Square {
    int x, y;
    private Piece currentPiece;

    Square(int x, int y){
        this.x = x;
        this.y = y;
    }

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

    String printPiece() {
        if (currentPiece == null) {
            return "";
        } else {
            return currentPiece.toString();
        }
    }

}
