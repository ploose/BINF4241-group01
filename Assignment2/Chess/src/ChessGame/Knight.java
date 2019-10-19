package ChessGame;

import java.util.ArrayList;

class Knight extends Piece implements MovementStrategy, IKnight {
    private Color color;
    private Square current;
    private ArrayList<Square> possibleMoveSquares;

    //TODO
    public void move() {    }

    Knight(Color color, int x, int y, Board board) {
        this.color = color;
        this.current = board.getSquare(x,y);

    }

    // TODO: Current system allows player to land & eat own pieces, needs fixing!
    public boolean isValidMove(Board board, Square current, Square next) {
        Square temp;
        // up-left
        if (current.x - 1 >= 0 && current.y - 2 >= 0) {
            temp = board.getSquare(current.x - 1, current.y - 2);
            if (temp == next) {
                return true;
            }
        }
        // up-right
        if (current.x + 1 < 8 && current.y - 2 >= 0) {
            temp = board.getSquare(current.x + 1, current.y - 2);
            if (temp == next) {
                return true;
            }
        }
        // right-up
        if (current.x + 2 < 8 && current.y - 1 >= 0) {
            temp = board.getSquare(current.x + 2, current.y - 1);
            if (temp == next) {
                return true;
            }
        }
        // right-down
        if (current.x + 2 < 8 && current.y + 1 < 8) {
            temp = board.getSquare(current.x + 2, current.y + 1);
            if (temp == next) {
                return true;
            }
        }
        // down-right
        if (current.x + 1 < 8 && current.y + 2 < 8) {
            temp = board.getSquare(current.x + 1, current.y + 2);
            if (temp == next) {
                return true;
            }
        }
        // down-left
        if (current.x - 1 >= 0 && current.y + 2 < 8) {
            temp = board.getSquare(current.x - 1, current.y + 2);
            if (temp == next) {
                return true;
            }
        }
        // left-down
        if (current.x - 2 >= 0 && current.y + 1 < 8) {
            temp = board.getSquare(current.x - 2, current.y + 1);
            if (temp == next) {
                return true;
            }
        }
        // left-up
        if (current.x - 2 >= 0 && current.y - 1 >= 0) {
            temp = board.getSquare(current.x - 2, current.y + 1);
            if (temp == next) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<Square> getMoveSquares(Board board){
    Square temp;
    Square current = this.current;
    int x,y;

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


    return possibleMoveSquares;

}

    @Override
    public String toString() {
        return color.toString().charAt(0) + "N";
    }
}
