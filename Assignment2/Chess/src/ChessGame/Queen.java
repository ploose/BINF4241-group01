package ChessGame;

class Queen extends Piece {

    Queen(Color color, Square current){
        super(color, current);
    }

    public void getMoveSquares(final Square[][] squares){
        possibleMoveSquares.clear();
        canEat.clear();
        Square temp, current = this.current;
        int x, y;

        // Check movement up-left
        x = current.x;
        y = current.y;
        while (true) {
            x--;
            y--;
            if (x < 0 || y < 0) {
                break;
            }
            temp = squares[x][y];
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    canEat.add(temp);
                }else{
                    break;
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }

        // Check movement up-right
        x = current.x;
        y = current.y;
        while (true) {
            x++;
            y--;
            if (x > 7 || y < 0) {
                break;
            }
            temp = squares[x][y];
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    canEat.add(temp);
                }else{
                    break;
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }

        // Check movement down-right
        x = current.x;
        y = current.y;
        while (true) {
            x++;
            y++;
            if (x > 7 || y > 7) {
                break;
            }
            temp = squares[x][y];
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    canEat.add(temp);
                }else{
                    break;
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }

        // Check movement down-left
        x = current.x;
        y = current.y;
        while (true) {
            x--;
            y++;
            if (x < 0 || y > 7) {
                break;
            }
            temp = squares[x][y];
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    canEat.add(temp);
                }else{
                    break;
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }

        // Check movement up
        for (y = current.y - 1; y >= 0; y--) {
            temp = squares[current.x][y];
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    canEat.add(temp);
                }else{
                    break;
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }

        // Check movement down
        for (y = current.y + 1; y < 8; y++) {
            temp = squares[current.x][y];
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    canEat.add(temp);
                }else{
                    break;
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }

        // Check movement left
        for (x = current.x - 1; x >= 0; x--) {
            temp = squares[x][current.y];
            if (temp.isOccupied()) {
                if(hasEnemy(temp)){
                    canEat.add(temp);
                }else{
                    break;
                }
            } else {
                possibleMoveSquares.add(temp);
            }
        }

        // Check movement right
        for (x = current.x + 1; x < 8; x++) {
            temp = squares[x][current.y];
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
        return color.toString().charAt(0) + "Q";
    }
}