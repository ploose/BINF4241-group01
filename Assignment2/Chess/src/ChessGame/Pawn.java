package ChessGame;

class Pawn implements MovementStrategy, IPawn{
    private boolean hasMoved = false;

    Pawn(Color color) {
        super(color);
    }

    public boolean CheckPromote(){
        return true;
    }




    // TODO: Current system allows player to land & eat own pieces, needs fixing!
    public boolean isValidMove(Board board, Square current, Square next) {
        Square temp;
        if(getColor() == Color.WHITE){ // only moves up
            // capture
            temp = board.getSquare(current.x - 1, current.y - 1);
            if (temp == next && temp.isOccupied()){
                return true;
            }
            temp = board.getSquare(current.x + 1, current.y - 1);
            if (temp == next && temp.isOccupied()){
                return true;
            }
            // move
            temp = board.getSquare(current.x, current.y - 1);
            if (temp == next){
                return true;
            }else if (temp.isOccupied()){
                return false;
            }
            if(!hasMoved){
                temp = board.getSquare(current.x, current.y - 2);
                if (temp == next){
                    return true;
                }
            }

        }else if (getColor() == Color.BLACK){ // only moves down
            // capture
            temp = board.getSquare(current.x - 1, current.y + 1);
            if (temp == next && temp.isOccupied()){
                return true;
            }
            temp = board.getSquare(current.x + 1, current.y + 1);
            if (temp == next && temp.isOccupied()){
                return true;
            }
            // move
            temp = board.getSquare(current.x, current.y + 1);
            if (temp == next){
                return true;
            }else if (temp.isOccupied()){
                return false;
            }
            if(!hasMoved){
                temp = board.getSquare(current.x, current.y + 2);
                if (temp == next){
                    return true;
                }
            }

        }

        if(!hasMoved){
            hasMoved = true;
        }
        return false;
    }

    public boolean canBePromoted(){
        return True
    }

    @Override
    public String toString() {
        return "Pawn, " + getColor();
    }
}
