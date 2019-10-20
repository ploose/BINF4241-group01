package ChessGame;

import java.util.ArrayList;

class Pawn extends Piece implements MovementStrategy, IPawn {
    private ArrayList<Square> possibleMoveSquares;
    private boolean hasMoved;

    private ArrayList<Square> possibleAttackSquares;

    Pawn(Color color, Square current) {
        super(color, current);
    }

    public boolean CanBeCaptured() {
        return true;
    }

    //TODO:
    public void move() {
    }

    public boolean checkPromote() {
        return true;
    }

    public boolean isValidMove(Square current, Square next) {
        if(current == this.current && possibleMoveSquares.contains(next)){
            return true;
        }
        return false;
    }

    public boolean canBePromoted() {
        return true;
    }
    //TODO: Is this really necessary? What's the difference between a possible movesquare which holds an enemy and an attacksquare?
    //TODO: Important: seperate the movesquares from the attacksquares for the pawn!
    //TODO: Check if out of board
    public ArrayList<Square> getMoveSquares(Board board) {
        ArrayList<Square> possibleMoveSquares = new ArrayList<Square>();
        Square temp, current = this.current;
        int x, y;
        if (this.color == Color.WHITE) { // only moves up
            if (current.y - 1 >= 0) { // Check whether in range
                // capture left
                if (current.x - 1 >= 0) { // Check whether in range
                    temp = board.getSquare(current.x - 1, current.y - 1);
                    if (temp.isOccupied()) {
                        if (hasEnemy(temp)) {
                            possibleMoveSquares.add(temp);
                        }
                    }
                }
                // capture right
                if (current.x + 1 < 8) { // Check whether in range
                    temp = board.getSquare(current.x + 1, current.y - 1);
                    if (temp.isOccupied()) {
                        if (hasEnemy(temp)) {
                            possibleMoveSquares.add(temp);
                        }
                    }
                }
                // move
                temp = board.getSquare(current.x, current.y - 1);
                if (!temp.isOccupied()) {
                    possibleMoveSquares.add(temp);
                }
                if (!hasMoved) { // Can move 2 squares on first move
                    temp = board.getSquare(current.x, current.y - 2);
                    if (!temp.isOccupied()) {
                        possibleMoveSquares.add(temp);
                    }
                }
            }
        } else if (this.color == Color.BLACK) { // only moves down
            if (current.y + 1 < 8) { // Check whether in range
                // capture left
                if (current.x - 1 >= 0) { // Check whether in range
                    temp = board.getSquare(current.x - 1, current.y + 1);
                    if (temp.isOccupied()) {
                        if (hasEnemy(temp)) {
                            possibleMoveSquares.add(temp);
                        }
                    }
                }
                // capture right
                if (current.x + 1 < 8) { // Check whether in range
                    temp = board.getSquare(current.x + 1, current.y + 1);
                    if (temp.isOccupied()) {
                        if (hasEnemy(temp)) {
                            possibleMoveSquares.add(temp);
                        }
                    }
                }
                // move
                temp = board.getSquare(current.x, current.y + 1);
                if (!temp.isOccupied()) {
                    possibleMoveSquares.add(temp);
                }
                if (!hasMoved) { // Can move 2 squares on first move
                    temp = board.getSquare(current.x, current.y + 2);
                    if (!temp.isOccupied()) {
                        possibleMoveSquares.add(temp);
                    }
                }
            }
        }
        if (!hasMoved) {
            hasMoved = true;
        }
        /*
        if (this.color == Color.WHITE) { // only moves up
            // capture
            temp = board.getSquare(current.x - 1, current.y - 1);
            if (!temp.isOccupied()) {
                possibleAttackSquares.add(temp);
            }

            temp = board.getSquare(current.x + 1, current.y - 1);
            if (!temp.isOccupied()) {
                possibleAttackSquares.add(temp);
            }

            // move
            temp = board.getSquare(current.x, current.y - 1);
            if (!temp.isOccupied()) {
                possibleMoveSquares.add(temp);
            }

            if (!hasMoved) {
                temp = board.getSquare(current.x, current.y - 2);
                if (!temp.isOccupied()) {
                    possibleMoveSquares.add(temp);
                }
            }

        } else if (this.color == Color.BLACK) { // only moves down
            // capture
            temp = board.getSquare(current.x - 1, current.y + 1);
            if (!temp.isOccupied()) {
                possibleAttackSquares.add(temp);
            }

            temp = board.getSquare(current.x + 1, current.y + 1);
            if (!temp.isOccupied()) {
                possibleAttackSquares.add(temp);
            }

            // move
            temp = board.getSquare(current.x, current.y + 1);
            if (!temp.isOccupied()) {
                possibleMoveSquares.add(temp);
            }

            if (!hasMoved) {
                temp = board.getSquare(current.x, current.y + 2);
                if (!temp.isOccupied()) {
                    possibleMoveSquares.add(temp);
                }
            }

        }
         */
        return possibleMoveSquares;
    }

    public String toString() {
        return color.toString().charAt(0) + "P";
    }
}
