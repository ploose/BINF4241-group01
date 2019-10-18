package ChessGame;

import java.util.ArrayList;

class King extends Piece implements MovementStrategy, IKing{

    // TODO: We have to ask if we should use int or enums for the coordinates.
    //  Probably enums would be shit. Enums are shit

        ArrayList<Square> possibleMoveSquares;
        Color color = null;
        Square current;



    King(Color color, int x, int y, Board board){
            this.color = color;
            this.current = board.getSquare(x,y);
    }

    //TODO for all pieces
    public void move(){

    }
    // TODO !
    public boolean CanBeCaptured(){
        return true;
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

    public ArrayList<Square> getMoveSquares(Board board){

        Square current = this.current;
        int x, y;
        Square temp;
        // Check movement up
        y = current.y - 1;
        x = current.x;
        temp = board.getSquare(x, current.y);
        if (!temp.isOccupied()) { possibleMoveSquares.add(temp); }
        // Check movement down
        y = current.y + 1;
        temp = board.getSquare(x, current.y);
        if (!temp.isOccupied()) {possibleMoveSquares.add(temp);}

        // Check movement left
        x = current.x - 1;
        temp = board.getSquare(x, current.y);
        if (!temp.isOccupied()) { possibleMoveSquares.add(temp); }

        // Check movement right
        x = current.x + 1;
        temp = board.getSquare(x, current.y);
        if (!temp.isOccupied()) { possibleMoveSquares.add(temp);}

        return possibleMoveSquares;
    }
/*
        @Override
    public String toString() {
        return "King, " + getColor();
    }
*/
}


