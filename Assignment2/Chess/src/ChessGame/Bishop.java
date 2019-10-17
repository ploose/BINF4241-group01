package ChessGame;

class Bishop implements MovementStrategy {

    Color color = null;
    private boolean hasMoved;

    Bishop(Color color){
        this.color = color;
    }

    // TODO: Current system allows player to land & eat own pieces, needs fixing!
    public boolean isValidMove(Board board, Square current, Square next) {
        int x, y;
        // Check movement up-left
        x = current.x;
        y = current.y;
        while (true) {
            x --;
            y --;
            if (x < 0 || y < 0) {
                break;
            }
            Square temp = board.getSquare(x, y);
            if (temp == next) {
                return true;
            } else if (temp.isOccupied()) {
                break;
            }
        }

        // Check movement up-right
        x = current.x;
        y = current.y;
        while (true) {
            x ++;
            y --;
            if (x > 7 || y < 0) {
                break;
            }
            Square temp = board.getSquare(x, y);
            if (temp == next) {
                return true;
            } else if (temp.isOccupied()) {
                break;
            }
        }

        // Check movement down-right
        x = current.x;
        y = current.y;
        while (true) {
            x ++;
            y ++;
            if (x > 7 || y > 8) {
                break;
            }
            Square temp = board.getSquare(x, y);
            if (temp == next) {
                return true;
            } else if (temp.isOccupied()) {
                break;
            }
        }

        // Check movement down-left
        x = current.x;
        y = current.y;
        while (true) {
            x --;
            y ++;
            if (x < 0 || y > 8) {
                break;
            }
            Square temp = board.getSquare(x, y);
            if (temp == next) {
                return true;
            } else if (temp.isOccupied()) {
                break;
            }
        }

        return false;
    }
/*
    @Override
    public String toString() {
        return "Bishop, " + getColor();
    }

 */
}
