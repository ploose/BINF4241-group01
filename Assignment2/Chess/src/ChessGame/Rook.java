package src.ChessGame;

class Rook extends Piece {

    Rook(Color color) {
        super(color);
    }

    // TODO: Current system allows player to land & eat own pieces, needs fixing!
    boolean isValidMove(Board board, Square current, Square next) {
        // Check if alignment is correct
        if (current.x != next.x && current.y != next.y){
            return false;
        }
        // Check movement up
        for(int y = current.y - 1; y >= 0; y--){
            Square temp = board.getSquare(current.x, y);
            if (temp == next){
                return true;
            }else if (temp.isOccupied()){
                break;
            }
        }
        // Check movement down
        for(int y = current.y + 1; y < 8; y++){
            Square temp = board.getSquare(current.x, y);
            if (temp == next){
                return true;
            }else if (temp.isOccupied()){
                break;
            }
        }

        // Check movement left
        for(int x = current.x - 1; x >= 0; x--){
            Square temp = board.getSquare(x, current.y);
            if (temp == next){
                return true;
            }else if (temp.isOccupied()){
                break;
            }
        }

        // Check movement right
        for(int x = current.x + 1; x < 8; x++){
            Square temp = board.getSquare(x, current.y);
            if (temp == next){
                return true;
            }else if (temp.isOccupied()){
                break;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Rook, " + getColor();
    }
}
