package ChessGame;

import java.util.ArrayList;

class Rook extends Piece implements MovementStrategy, IRook {
    private ArrayList<Square> possibleMoveSquares;

    Rook(Color color, Square current) {
        super(color, current);
    }

    //TODO
    public void move() {
    }

    public boolean isValidMove(Board board, Square current, Square next) {
        // Check if alignment is correct
        if (current.x != next.x && current.y != next.y) {
            return false;
        }
        // Check movement up
        for (int y = current.y - 1; y >= 0; y--) {
            Square temp = board.getSquare(current.x, y);
            if (temp == next) {
                return true;
            } else if (temp.isOccupied()) {
                break;
            }
        }
        // Check movement down
        for (int y = current.y + 1; y < 8; y++) {
            Square temp = board.getSquare(current.x, y);
            if (temp == next) {
                return true;
            } else if (temp.isOccupied()) {
                break;
            }
        }

        // Check movement left
        for (int x = current.x - 1; x >= 0; x--) {
            Square temp = board.getSquare(x, current.y);
            if (temp == next) {
                return true;
            } else if (temp.isOccupied()) {
                break;
            }
        }

        // Check movement right
        for (int x = current.x + 1; x < 8; x++) {
            Square temp = board.getSquare(x, current.y);
            if (temp == next) {
                return true;
            } else if (temp.isOccupied()) {
                break;
            }
        }
        return false;
    }

    //needs to be implemented for Checkmate
    public boolean isBlocking(Square blockedSquare, Square targetSquare) {
        return false;
    }

    public ArrayList<Square> getMoveSquares(Board board) {
        ArrayList<Square> possibleMoveSquares = new ArrayList<Square>();
        Square temp, current = this.current;
        int x, y;
        // Check movement up
        for (y = current.y - 1; y >= 0; y--) {
            temp = board.getSquare(current.x, y);
            // Add square if empty or enemy on it
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    possibleMoveSquares.add(temp);
                }
                break;
            } else {
                possibleMoveSquares.add(temp);
            }
        }
        // Check movement down
        for (y = current.y + 1; y < 8; y++) {
            temp = board.getSquare(current.x, y);
            // Add square if empty or enemy on it
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    possibleMoveSquares.add(temp);
                }
                break;
            } else {
                possibleMoveSquares.add(temp);
            }
        }
        // Check movement left
        for (x = current.x - 1; x >= 0; x--) {
            temp = board.getSquare(x, current.y);
            // Add square if empty or enemy on it
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    possibleMoveSquares.add(temp);
                }
                break;
            } else {
                possibleMoveSquares.add(temp);
            }
        }
        // Check movement right
        for (x = current.x + 1; x < 8; x++) {
            temp = board.getSquare(x, current.y);
            // Add square if empty or enemy on it
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    possibleMoveSquares.add(temp);
                }
                break;
            } else {
                possibleMoveSquares.add(temp);
            }
        }
        return possibleMoveSquares;

    }

    public String toString() {
        return color.toString().charAt(0) + "T";
    }
}
