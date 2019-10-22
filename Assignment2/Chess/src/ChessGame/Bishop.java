package ChessGame;

class Bishop extends Piece {

    Bishop(Color color, Square current){
        super(color, current);
    }

    //needs to be implemented for Checkmate
    public boolean isBlocking(Square blockedSquare, Square targetSquare){
        return false;
    }

    @Override
    public void getMoveSquares(Square[][] squares){
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
                    possibleMoveSquares.add(temp);
                }
                break;
            }
            else{
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
                    possibleMoveSquares.add(temp);
                }
                break;
            }
            else{
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
                    possibleMoveSquares.add(temp);
                }
                break;
            }
            else{
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
                    possibleMoveSquares.add(temp);
                }
                break;
            }
            else{
                possibleMoveSquares.add(temp);
            }
        }
    }

    @Override
    public String toString() {
        return color.toString().charAt(0) + "B";
    }
}
