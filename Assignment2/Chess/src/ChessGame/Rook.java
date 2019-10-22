package ChessGame;

class Rook extends Piece {

    Rook(Color color, Square current) {
        super(color, current);
    }

    //needs to be implemented for Checkmate
    public boolean isBlocking(Square blockedSquare, Square targetSquare) {
        return false;
    }

    public void getMoveSquares(final Square[][] squares) {
        Square temp, current = this.current;
        int x, y;

        // Check movement up
        for (y = current.y - 1; y >= 0; y--) {
            temp = squares[current.x][y];
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
            temp = squares[current.x][y];
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
            temp = squares[x][current.y];
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
            temp = squares[x][current.y];
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
    }

    public String toString() {
        return color.toString().charAt(0) + "T";
    }
}
