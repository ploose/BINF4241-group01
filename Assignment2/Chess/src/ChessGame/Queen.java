package ChessGame;

import java.util.ArrayList;

class Queen extends Piece implements MovementStrategy {

    Color color = null;
    private boolean hasMoved;
    private ArrayList<Square> possibleMoveSquares;
    public void move() {

    }



    Queen(Color color){
        this.color = color;
    }
    // TODO: Current system allows player to land & eat own pieces, needs fixing!
    public boolean isValidMove(Board board, Square current, Square next) {
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
            x++;
            y--;
            if (x > 7 || y < 0) {
                break;
            }
            temp = board.getSquare(x, y);
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
            x++;
            y++;
            if (x > 7 || y > 8) {
                break;
            }
            temp = board.getSquare(x, y);
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
            x--;
            y++;
            if (x < 0 || y > 8) {
                break;
            }
            temp = board.getSquare(x, y);
            if (temp == next) {
                return true;
            } else if (temp.isOccupied()) {
                break;
            }
        }

        // Check movement up
        for (y = current.y - 1; y >= 0; y--) {
            temp = board.getSquare(current.x, y);
            if (temp == next) {
                return true;
            } else if (temp.isOccupied()) {
                break;
            }
        }
        // Check movement down
        for (y = current.y + 1; y < 8; y++) {
            temp = board.getSquare(current.x, y);
            if (temp == next) {
                return true;
            } else if (temp.isOccupied()) {
                break;
            }
        }

        // Check movement left
        for (x = current.x - 1; x >= 0; x--) {
            temp = board.getSquare(x, current.y);
            if (temp == next) {
                return true;
            } else if (temp.isOccupied()) {
                break;
            }
        }

        // Check movement right
        for (x = current.x + 1; x < 8; x++) {
            temp = board.getSquare(x, current.y);
            if (temp == next) {
                return true;
            } else if (temp.isOccupied()) {
                break;
            }
        }
        return false;
    }


    // TODO: Every piece has to know its current location and the board
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

        // Check movement up
        for (y = current.y - 1; y >= 0; y--) {
            temp = board.getSquare(current.x, y);
            if (temp.isOccupied()) {
                break;
            }
            else{
                possibleMoveSquares.add(temp);
            }
        }
        // Check movement down
        for (y = current.y + 1; y < 8; y++) {
            temp = board.getSquare(current.x, y);
            if (temp.isOccupied()) {
                break;
            }
            else{
                possibleMoveSquares.add(temp);
            }
        }

        // Check movement left
        for (x = current.x - 1; x >= 0; x--) {
            temp = board.getSquare(x, current.y);
            if (temp.isOccupied()) {
                break;
            }
            else{
                possibleMoveSquares.add(temp);
            }
        }

        // Check movement right
        for (x = current.x + 1; x < 8; x++) {
            temp = board.getSquare(x, current.y);
            if (temp.isOccupied()) {
                break;
            }
            else{
                possibleMoveSquares.add(temp);
            }
        }
        return possibleMoveSquares;
    }

    //needs to be implemented for Checkmate
    /*
    public boolean isBlocking(Square blockedSquare, Square targetSquare){
        if(){break;}
*/
    }
/*
    @Override
    public String toString() {
        return "Queen, " + getColor();
    }

 */
