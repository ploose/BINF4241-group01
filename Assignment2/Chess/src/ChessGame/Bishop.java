package ChessGame;

import java.util.ArrayList;

class Bishop extends Piece implements MovementStrategy, IBishop {
    private Color color;
    private Square current;
    private ArrayList<Square> possibleMoveSquares;

    Bishop(Color color, int x, int y, Board board){
        this.color = color;
        this.current = board.getSquare(x,y);
    }

    //TODO
    public void move(){}

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

    @Override
    public ArrayList<Square> getMoveSquares(Board board){
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

    @Override
    public String toString() {
        return color.toString().charAt(0) + "B";
    }
}
