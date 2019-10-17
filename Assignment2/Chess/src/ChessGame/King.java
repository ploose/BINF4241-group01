package ChessGame;

    class King implements MovementStrategy, IKing{

    // TODO: We have to ask if we should use int or enums for the coordinates.
    //  Probably enums would be shit. Enums are shit


        Color color = null;
        private boolean hasMoved;

        public boolean CanBeCaptured(){
        return true;
    }

    King(Color color){
            this.color = color;
    }

    // TODO: Current system allows player to land & eat own pieces, needs fixing!
    public boolean isValidMove(Board board, Square current, Square next) {
        for(int x = current.x - 1; x < 8; x++){
            for(int y = current.y - 1; y < 8; y++){
                // Ignores square the king is currently on
                if (x == current.x  && y == current.y){
                    continue;
                }
                Square temp = board.getSquare(x, y);
                if (temp == next){
                    return true;
                }else if (temp.isOccupied()){
                    break;
                }
            }
        }
        return false;
    }

    public boolean isCheckMate() {
        return false;
        }
/*
        @Override
    public String toString() {
        return "King, " + getColor();
    }
*/
}


