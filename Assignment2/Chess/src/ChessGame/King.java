package ChessGame;

class King extends Piece {

    King(Color color, Square current){
        super(color, current);
    }

    // TODO:
    public boolean CanBeCaptured(){
        return true;
    }

    public boolean isCheckMate() {
        return false;
        }

        //TODO: check movement diagonal
    public void getMoveSquares(final Square[][] squares) {
        Square temp, current = this.current;
        int x, y;

        // Check movement up
        if (current.y - 1 > -1) {
            y = current.y - 1;
            temp = squares[current.x][y];
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
            temp = squares[current.x][y];
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
            temp = squares[x][current.y];
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
            temp = squares[x][current.y];
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    possibleMoveSquares.add(temp);
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }
    }

    @Override
    public String toString() {
        return color.toString().charAt(0) + "K";
    }
}


