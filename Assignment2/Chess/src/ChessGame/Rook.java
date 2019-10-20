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

    public boolean isValidMove(Square current, Square next) {
        if(current == this.current && possibleMoveSquares.contains(next)){
            return true;
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
