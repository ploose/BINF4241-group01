package ChessGame;

import java.util.ArrayList;

class Pawn extends Piece implements MovementStrategy, IPawn {
    private ArrayList<Square> possibleAttackSquares;

    Pawn(Color color, Square current) {
        super(color, current);

        possibleAttackSquares = new ArrayList<>();
    }

    public boolean isValidMove(Square current, Square next) {
        return (current == this.current && (possibleAttackSquares.contains(next) || possibleMoveSquares.contains(next)));
    }

    public boolean CanBeCaptured() {
        return true;
    }

    public boolean checkPromote() {
        return true;
    }

    public boolean canBePromoted() {
        return true;
    }

    //TODO: Is this really necessary? What's the difference between a possible movesquare which holds an enemy and an attacksquare?
    //TODO: Check if out of board
    public void getMoveSquares(final Square[][] squares) {
        Square temp, current = this.current;
        int x, y;

        if (this.color == Color.WHITE) { // only moves up
            if (8 > (current.y - 1) && (current.y - 1) >= 0) { // Check whether in range
                // capture left
                if (8 > (current.x - 1) && (current.x - 1) >= 0) { // Check whether in range
                    temp = squares[current.x - 1][current.y - 1];
                    if (temp.isOccupied()) {
                        if (hasEnemy(temp)) {
                            possibleAttackSquares.add(temp);
                        }
                    }
                }

                // capture right
                if (current.x + 1 < 8) { // Check whether in range
                    temp = squares[current.x + 1][current.y - 1];
                    if (temp.isOccupied()) {
                        if (hasEnemy(temp)) {
                            possibleAttackSquares.add(temp);
                        }
                    }
                }
                // move
                temp = squares[current.x][current.y - 1];
                if (!temp.isOccupied()) {
                    possibleMoveSquares.add(temp);
                }
                if (!hasMoved) { // Can move 2 squares on first move
                    temp = squares[current.x][current.y - 2];
                    if (!temp.isOccupied()) {
                        possibleMoveSquares.add(temp);
                    }
                }
            }

        } else if (this.color == Color.BLACK) { // only moves down
            if (current.y + 1 < 8) { // Check whether in range
                // capture left
                if (current.x - 1 >= 0) { // Check whether in range
                    temp = squares[current.x - 1][current.y + 1];
                    if (temp.isOccupied()) {
                        if (hasEnemy(temp)) {
                            possibleAttackSquares.add(temp);
                        }
                    }
                }

                // capture right
                if (current.x + 1 < 8) { // Check whether in range
                    temp = squares[current.x + 1][current.y + 1];
                    if (temp.isOccupied()) {
                        if (hasEnemy(temp)) {
                            possibleAttackSquares.add(temp);
                        }
                    }
                }

                // move
                temp = squares[current.x][current.y + 1];
                if (!temp.isOccupied()) {
                    possibleMoveSquares.add(temp);
                }
                if (!hasMoved) { // Can move 2 squares on first move
                    temp = squares[current.x][current.y + 1];
                    if (!temp.isOccupied()) {
                        possibleMoveSquares.add(temp);
                    }
                }
            }
        }
    }

    public String toString() {
        return color.toString().charAt(0) + "P";
    }
}
