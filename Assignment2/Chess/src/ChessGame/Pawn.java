package ChessGame;

import java.util.ArrayList;

class Pawn extends Piece implements MovementStrategy, IPawn {
    private final int speed;

    Pawn(Color color, Square current) {
        super(color, current);

        speed = 1;
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

    public void getMoveSquares(final Square[][] squares) {
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
        }
    }

    public String toString() {
        return color.toString().charAt(0) + "P";
    }
}
