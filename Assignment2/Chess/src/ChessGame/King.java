package ChessGame;

import java.util.ArrayList;

class King extends Piece implements MovementStrategy, IKing{
    private ArrayList<Square> possibleMoveSquares;

    King(Color color, Square current){
            super(color, current);
    }

    //TODO:
    public void move(){    }

    // TODO:
    public boolean CanBeCaptured(){
        return true;
    }

    public boolean isValidMove(Square current, Square next) {
        if(current == this.current && possibleMoveSquares.contains(next)){
            return true;
        }
        return false;
    }

    public boolean isCheckMate() {
        return false;
        }

    public ArrayList<Square> getMoveSquares(Board board){
        ArrayList<Square> possibleMoveSquares = new ArrayList<Square>();
        Square temp, current = this.current;
        int x, y;
        if (current.y - 1 >= 0) {
            // Check movement up
            y = current.y - 1;
            temp = board.getSquare(current.x, y);
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    possibleMoveSquares.add(temp);
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }
        // Check movement down
        if(current.y + 1 < 8){
            y = current.y + 1;
            temp = board.getSquare(current.x, y);
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    possibleMoveSquares.add(temp);
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }
        // Check movement left
        if(current.x - 1 >= 0){
            x = current.x - 1;
            temp = board.getSquare(x, current.y);
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    possibleMoveSquares.add(temp);
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }
        // Check movement right
        if(current.x + 1 < 8){
            x = current.x + 1;
            temp = board.getSquare(x, current.y);
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    possibleMoveSquares.add(temp);
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }
        return possibleMoveSquares;
    }

    @Override
    public String toString() {
        return color.toString().charAt(0) + "K";
    }
}


