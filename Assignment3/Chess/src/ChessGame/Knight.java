package ChessGame;

class Knight extends Piece {

    Knight(Color color, Square current) {
        super(color, current);
    }

    public void getMoveSquares(final Square[][] squares){
        possibleMoveSquares.clear();
        canEat.clear();
        Square temp, current = this.current;

        // up-left
        if (current.x - 1 >= 0 && current.y - 2 >= 0) {
            temp = squares[current.x - 1][current.y - 2];
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    canEat.add(temp);
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }

        // up-right
        if (current.x + 1 < 8 && current.y - 2 >= 0) {
            temp = squares[current.x + 1][current.y - 2];
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    canEat.add(temp);
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }

        // right-up
        if (current.x + 2 < 8 && current.y - 1 >= 0) {
            temp = squares[current.x + 2][current.y - 1];
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    canEat.add(temp);
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }

        // right-down
        if (current.x + 2 < 8 && current.y + 1 < 8) {
            temp = squares[current.x + 2][current.y + 1];
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    canEat.add(temp);
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }

        // down-right
        if (current.x + 1 < 8 && current.y + 2 < 8) {
            temp = squares[current.x + 1][current.y + 2];
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    canEat.add(temp);
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }

        // down-left
        if (current.x - 1 >= 0 && current.y + 2 < 8) {
            temp = squares[current.x - 1][current.y + 2];
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    canEat.add(temp);
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }

        // left-down
        if (current.x - 2 >= 0 && current.y + 1 < 8) {
            temp = squares[current.x - 2][current.y + 1];
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    canEat.add(temp);
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }

        // left-up
        if (current.x - 2 >= 0 && current.y - 1 >= 0) {
            temp = squares[current.x - 2][current.y - 1];
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    canEat.add(temp);
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }
    }

    @Override
    public String toString() {
        return color.toString().charAt(0) + "N";
    }
}
