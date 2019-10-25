package ChessGame;

import java.util.ArrayList;

class Pawn extends Piece implements MovementStrategy, IPawn {
    private final int speed;

    Pawn(Color color, Square current) {
        super(color, current);

        speed = 1;
    }

    public void getMoveSquares(final Square[][] squares) {
        possibleMoveSquares.clear();
        canEat.clear();
        Square temp;
        int x = current.x, y = current.y;

        if (this.color == Color.WHITE) { // only moves up
            if (hasMoved) {
                straightUp(squares, speed);
            } else {
                straightUp(squares, speed + 1);
            }

            if ((x - 1) >= 0 && (y - 1) >= 0) {
                temp = squares[x - 1][y - 1];
                if (temp.isOccupied()) {
                    if (hasEnemy(temp)) {
                        canEat.add(temp);
                    }
                }
            }

            if ((x + 1) <= 7 && (y - 1) >= 0) {
                temp = squares[x + 1][y - 1];
                if (temp.isOccupied()) {
                    if (hasEnemy(temp)) {
                        canEat.add(temp);
                    }
                }
            }

            if (squares[x][y - 1].isOccupied()) {
                canEat.remove(squares[x][y - 1]);
            }

        } else if (this.color == Color.BLACK) { // only moves down
            if (hasMoved) {
                straightDown(squares, speed);
            } else {
                straightDown(squares, speed + 1);
            }
            if ((x - 1) >= 0 && (y + 1) <= 7) {
                temp = squares[x - 1][y + 1];
                if (temp.isOccupied()) {
                    if (hasEnemy(temp)) {
                        canEat.add(temp);
                    }
                }
            }

            if ((x + 1) <= 7 && (y + 1) <= 7) {
                temp = squares[x + 1][y + 1];
                if (temp.isOccupied()) {
                    if (hasEnemy(temp)) {
                        canEat.add(temp);
                    }
                }
            }

            if (squares[x][y - 1].isOccupied()) {
                canEat.remove(squares[x][y - 1]);
            }
        }
    }

    public String toString() {
        return color.toString().charAt(0) + "P";
    }
}
