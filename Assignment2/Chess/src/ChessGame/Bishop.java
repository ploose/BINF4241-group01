package ChessGame;

import java.util.ArrayList;

class Bishop extends Piece implements MovementStrategy, IBishop {
    private ArrayList<Square> possibleMoveSquares;

    Bishop(Color color, Square current){
        super(color, current);
    }

    //TODO
    public void move(){}

    public boolean isValidMove(Square current, Square next) {
        if(current == this.current && possibleMoveSquares.contains(next)){
            return true;
        }
        return false;
    }

    //needs to be implemented for Checkmate
    public boolean isBlocking(Square blockedSquare, Square targetSquare){
        return false;
    }

    @Override
    public ArrayList<Square> getMoveSquares(Board board){
        ArrayList<Square> possibleMoveSquares = new ArrayList<Square>();
        Square temp, current = this.current;
        int x, y;
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
                if(hasEnemy(temp)){
                    possibleMoveSquares.add(temp);
                }
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
                if(hasEnemy(temp)){
                    possibleMoveSquares.add(temp);
                }
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
            if (x > 7 || y > 7) {
                break;
            }
            temp = board.getSquare(x, y);
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    possibleMoveSquares.add(temp);
                }
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
            if (x < 0 || y > 7) {
                break;
            }
            temp = board.getSquare(x, y);
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    possibleMoveSquares.add(temp);
                }
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
