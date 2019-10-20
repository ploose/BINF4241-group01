package ChessGame;

import java.util.ArrayList;

class Knight extends Piece implements MovementStrategy, IKnight {
    private ArrayList<Square> possibleMoveSquares;

    Knight(Color color, Square current) {
        super(color, current);
    }

    //TODO
    public void move() {    }

    // TODO: Current system allows player to land & eat own pieces, needs fixing!
    public boolean isValidMove(Square current, Square next) {
        if(current == this.current && possibleMoveSquares.contains(next)){
            return true;
        }
        return false;
    }

    public ArrayList<Square> getMoveSquares(Board board){
        ArrayList<Square> possibleMoveSquares = new ArrayList<Square>();
        Square temp, current = this.current;
        // up-left
        if (current.x - 1 >= 0 && current.y - 2 >= 0) {
            temp = board.getSquare(current.x - 1, current.y - 2);
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    possibleMoveSquares.add(temp);
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }
        // up-right
        if (current.x + 1 < 8 && current.y - 2 >= 0) {
            temp = board.getSquare(current.x + 1, current.y - 2);
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    possibleMoveSquares.add(temp);
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }
        // right-up
        if (current.x + 2 < 8 && current.y - 1 >= 0) {
            temp = board.getSquare(current.x + 2, current.y - 1);
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    possibleMoveSquares.add(temp);
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }
        // right-down
        if (current.x + 2 < 8 && current.y + 1 < 8) {
            temp = board.getSquare(current.x + 2, current.y + 1);
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    possibleMoveSquares.add(temp);
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }
        // down-right
        if (current.x + 1 < 8 && current.y + 2 < 8) {
            temp = board.getSquare(current.x + 1, current.y + 2);
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    possibleMoveSquares.add(temp);
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }
        // down-left
        if (current.x - 1 >= 0 && current.y + 2 < 8) {
            temp = board.getSquare(current.x - 1, current.y + 2);
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    possibleMoveSquares.add(temp);
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }
        // left-down
        if (current.x - 2 >= 0 && current.y + 1 < 8) {
            temp = board.getSquare(current.x - 2, current.y + 1);
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    possibleMoveSquares.add(temp);
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }
        // left-up
        if (current.x - 2 >= 0 && current.y - 1 >= 0) {
            temp = board.getSquare(current.x - 2, current.y + 1);
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    possibleMoveSquares.add(temp);
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }

    /*
    // up-right

        temp = board.getSquare(current.x -1,current.y -2);
        if (!temp.isOccupied()) {possibleMoveSquares.add(temp);}
    // right-up


        temp = board.getSquare(current.x -1,current.y -2);
        if (!temp.isOccupied()) {possibleMoveSquares.add(temp);}
    // right-down

        temp = board.getSquare(current.x -1,current.y -2);
        if (!temp.isOccupied()) {possibleMoveSquares.add(temp);}
    // down-right

        temp = board.getSquare(current.x -1,current.y -2);
        if (!temp.isOccupied()) {possibleMoveSquares.add(temp);}
    // down-left

        temp = board.getSquare(current.x -1,current.y -2);
        if (!temp.isOccupied()) {possibleMoveSquares.add(temp);}
    // left-down

        temp = board.getSquare(current.x -1,current.y -2);
        if (!temp.isOccupied()) {possibleMoveSquares.add(temp);}
    // left-up

        temp = board.getSquare(current.x -1,current.y -2);
        if (!temp.isOccupied()) {possibleMoveSquares.add(temp);}

    // up-left

    temp = board.getSquare(current.x -1,current.y -2);
    if (!temp.isOccupied()) {possibleMoveSquares.add(temp);}
     */
    return possibleMoveSquares;
}

    @Override
    public String toString() {
        return color.toString().charAt(0) + "N";
    }
}
