package ChessGame;

import java.util.ArrayList;

class Bishop extends Piece implements MovementStrategy, IBishop {

    Color color = null;
    private boolean hasMoved;
    ArrayList<Square> possibleMoveSquares;
    public void move(){

    }


    Bishop(Color color){
        this.color = color;
  }

    // TODO: Current system allows player to land & eat own pieces, needs fixing!
    public boolean isValidMove(Board board, Square current, Square next) {
        int x, y;
        // Check movement up-left
        x = current.x;
        y = current.y;
        while (true) {
            x --;
            y --;
            if (x < 0 || y < 0) {
                break;
            }
            Square temp = board.getSquare(x, y);
            if (temp == next) {
                return true;
            } else if (temp.isOccupied()) {
                break;
            }
        }

        // Check movement up-right
        x = current.x;
        y = current.y;
        while (true) {
            x ++;
            y --;
            if (x > 7 || y < 0) {
                break;
            }
            Square temp = board.getSquare(x, y);
            if (temp == next) {
                return true;
            } else if (temp.isOccupied()) {
                break;
            }
        }

        // Check movement down-right
        x = current.x;
        y = current.y;
        while (true) {
            x ++;
            y ++;
            if (x > 7 || y > 8) {
                break;
            }
            Square temp = board.getSquare(x, y);
            if (temp == next) {
                return true;
            } else if (temp.isOccupied()) {
                break;
            }
        }

        // Check movement down-left
        x = current.x;
        y = current.y;
        while (true) {
            x --;
            y ++;
            if (x < 0 || y > 8) {
                break;
            }
            Square temp = board.getSquare(x, y);
            if (temp == next) {
                return true;
            } else if (temp.isOccupied()) {
                break;
            }
        }

        return false;
    }

    //needs to be implemented for Checkmate
    public boolean isBlocking(Square blockedSquare, Square targetSquare){
        return false;
    }
    public ArrayList<Square> getMoveSquares(Board board, Square current){
        int x, y;
        Square temp;
        // Check movement up-left
        x = current.x;
        y = current.y;
        while (true) {
            x--;
            y--;
            if (x < 0 || y < 0) {
                break;
            }
            temp = board.getSquare(x, y);

            if (temp.isOccupied()) {
                break;
            }
            else{
                possibleMoveSquares.add(temp);
            }
        }

        // Check movement up-right
        x = current.x;
        y = current.y;
        while (true) {
            x++;
            y--;
            if (x > 7 || y < 0) {
                break;
            }
            temp = board.getSquare(x, y);
            if (temp.isOccupied()) {
                break;
            }
            else{
                possibleMoveSquares.add(temp);
            }
        }

        // Check movement down-right
        x = current.x;
        y = current.y;
        while (true) {
            x++;
            y++;
            if (x > 7 || y > 8) {
                break;
            }
            temp = board.getSquare(x, y);
            if (temp.isOccupied()) {
                break;
            }
            else{
                possibleMoveSquares.add(temp);
            }
        }

        // Check movement down-left
        x = current.x;
        y = current.y;
        while (true) {
            x--;
            y++;
            if (x < 0 || y > 8) {
                break;
            }
            temp = board.getSquare(x, y);
            if (temp.isOccupied()) {
                break;
            }
            else{
                possibleMoveSquares.add(temp);
            }
        }


        return possibleMoveSquares;
    }
/*

    @Override
    public String toString() {
        if (getColor() == Color.BLACK){
            return "BB";
        } else {
            return "WB";
        }
    }

 */
}
