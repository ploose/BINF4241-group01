package ChessGame;

import java.util.ArrayList;

class Rook extends Piece implements MovementStrategy, IRook {
    private ArrayList<Square> possibleMoveSquares;

    Rook(Color color, Square current){
        super(color, current);
    }

    //TODO
    public void move(){    }

    // TODO: Current system allows player to land & eat own pieces, needs fixing!
    public boolean isValidMove(Board board, Square current, Square next) {
        // Check if alignment is correct
        if (current.x != next.x && current.y != next.y){
            return false;
        }
        // Check movement up
        for(int y = current.y - 1; y >= 0; y--){
            Square temp = board.getSquare(current.x, y);
            if (temp == next){
                return true;
            }else if (temp.isOccupied()){
                break;
            }
        }
        // Check movement down
        for(int y = current.y + 1; y < 8; y++){
            Square temp = board.getSquare(current.x, y);
            if (temp == next){
                return true;
            }else if (temp.isOccupied()){
                break;
            }
        }

        // Check movement left
        for(int x = current.x - 1; x >= 0; x--){
            Square temp = board.getSquare(x, current.y);
            if (temp == next){
                return true;
            }else if (temp.isOccupied()){
                break;
            }
        }

        // Check movement right
        for(int x = current.x + 1; x < 8; x++){
            Square temp = board.getSquare(x, current.y);
            if (temp == next){
                return true;
            }else if (temp.isOccupied()){
                break;
            }
        }
        return false;
    }

    //needs to be implemented for Checkmate
    public boolean isBlocking(Square blockedSquare, Square targetSquare){
        return false;
    }

    public ArrayList<Square> getMoveSquares(Board board){

        Square current = this.current;
        int x;
        int y;
        Square temp;

        // Check movement up
        y = current.y - 1;
        temp = board.getSquare(current.x, y);
        if (!temp.isOccupied()) {possibleMoveSquares.add(temp); }

        // Check movement down
        y = current.y + 1;
        temp = board.getSquare(current.x, y);
        if (!temp.isOccupied()) {possibleMoveSquares.add(temp); }

        // Check movement left
        x = current.x - 1;
        temp = board.getSquare(x, current.y);
        if (!temp.isOccupied()) {possibleMoveSquares.add(temp); }

        // Check movement right
        x = current.x + 1;
        temp = board.getSquare(x, current.y);
        if (!temp.isOccupied()) {possibleMoveSquares.add(temp); }

        return possibleMoveSquares;

    }

    public String toString() {
        return color.toString().charAt(0) + "T";
    }
}
