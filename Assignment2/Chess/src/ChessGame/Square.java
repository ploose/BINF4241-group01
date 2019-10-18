package ChessGame;

class Square {
    int x, y;
    private Object currentPiece;

    Square(int x, int y){
        this.x = x;
        this.y = y;
    }

    void addPiece(Object object) {
        currentPiece = object;
    }

    // TODO: Does this work for squares "outside" the board?
    boolean isOccupied(){
        return currentPiece != null;
    }

    Object removePiece() {
        Object tmp = currentPiece;
        currentPiece = null;
        return tmp;
    }

    String printPiece() {
        if (currentPiece == null) {
            return "  ";
        } else {
            return currentPiece.toString();
        }
    }

}
