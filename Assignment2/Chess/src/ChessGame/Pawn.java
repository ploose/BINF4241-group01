package ChessGame;

import src.ChessGame.Enums.*;

class Pawn extends Piece{
    private boolean hasMoved = false;

    Pawn(Color color) {
        super(color);
    }

    public boolean CheckPromote(){
        return true;
    }

    boolean isValidMove(Board board, Square current, Square next) {
        Square temp;
        if(getColor() == Color.WHITE){ // only moves up
            // capture
            temp = board.getSquare(current.x - 1, current.y - 1);
            if (temp == next && temp.isOccupied()){
                return true;
            }
            temp = board.getSquare(current.x + 1, current.y - 1);
            if (temp == next && temp.isOccupied()){
                return true;
            }
            // move
            temp = board.getSquare(current.x, current.y - 1);
            if (temp == next){
                return true;
            }else if (temp.isOccupied()){
                return false;
            }
            if(!hasMoved){
                temp = board.getSquare(current.x, current.y - 2);
                if (temp == next){
                    return true;
                }
            }

        }else if (getColor() == Color.BLACK){ // only moves down
            // capture
            temp = board.getSquare(current.x - 1, current.y + 1);
            if (temp == next && temp.isOccupied()){
                return true;
            }
            temp = board.getSquare(current.x + 1, current.y + 1);
            if (temp == next && temp.isOccupied()){
                return true;
            }
            // move
            temp = board.getSquare(current.x, current.y + 1);
            if (temp == next){
                return true;
            }else if (temp.isOccupied()){
                return false;
            }
            if(!hasMoved){
                temp = board.getSquare(current.x, current.y + 2);
                if (temp == next){
                    return true;
                }
            }

        }

        if(!hasMoved){
            hasMoved = true;
        }
        return false;
    }
}
