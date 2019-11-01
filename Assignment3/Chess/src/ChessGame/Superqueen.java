package ChessGame;

import java.util.ArrayList;
import java.util.Iterator;

public class Superqueen extends Piece implements MovementStrategy, SuperqueenMovementStrategy {

    private final int speed;

    Superqueen(Color color, Square current) {
        super(color, current);

        speed = 8;
    }

    public void getMoveSquares(final Square[][] squares) {
    }

    @Override
    public String toString() {
        return color.toString().charAt(0) + "Q";
    }


    public void getSuperqueenMoveSquares(final Square[][] squares) {
        possibleMoveSquares.clear();
        canEat.clear();
        Square temp, current = this.current;

        // teleport

        SquaresIterator squaresIterator = new SquaresIterator(squares);
        Square square = current;

        while (squaresIterator.hasNext()){
            square = squaresIterator.next();

            temp = square;
                if (temp.isOccupied()) {
                    if (hasEnemy(temp)) {
                        canEat.add(temp);
                    }
                } else {
                    possibleMoveSquares.add(temp);
                }
            }
        }
    }





