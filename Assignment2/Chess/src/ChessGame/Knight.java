package src.ChessGame;

class Knight extends Piece{

    Knight(Color color) {
        super(color);
    }

    // TODO: Current system allows player to land & eat own pieces, needs fixing!
    boolean isValidMove(Board board, Square current, Square next) {
        Square temp;
        // up-left
        if(current.x - 1 >= 0 && current.y - 2 >= 0){
            temp = board.getSquare(current.x - 1, current.y - 2);
            if (temp == next){
                return true;
            }
        }
        // up-right
        if(current.x + 1 < 8 && current.y - 2 >= 0){
            temp = board.getSquare(current.x + 1, current.y - 2);
            if (temp == next){
                return true;
            }
        }
        // right-up
        if(current.x + 2 < 8 && current.y - 1 >= 0){
            temp = board.getSquare(current.x + 2, current.y - 1);
            if (temp == next){
                return true;
            }
        }
        // right-down
        if(current.x + 2 < 8 && current.y + 1 < 8){
            temp = board.getSquare(current.x + 2, current.y + 1);
            if (temp == next){
                return true;
            }
        }
        // down-right
        if(current.x + 1 < 8 && current.y + 2 < 8){
            temp = board.getSquare(current.x + 1, current.y + 2);
            if (temp == next){
                return true;
            }
        }
        // down-left
        if(current.x - 1 >= 0 && current.y + 2 < 8){
            temp = board.getSquare(current.x - 1, current.y + 2);
            if (temp == next){
                return true;
            }
        }
        // left-down
        if(current.x - 2 >= 0 && current.y + 1 < 8){
            temp = board.getSquare(current.x - 2, current.y + 1);
            if (temp == next){
                return true;
            }
        }
        // left-up
        if(current.x - 2 >= 0 && current.y -1 >= 0){
            temp = board.getSquare(current.x - 2, current.y + 1);
            if (temp == next){
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "Knight, " + getColor();
    }
}
