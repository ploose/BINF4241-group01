package ChessGame;

class Pawn implements MovementStrategy, IPawn{

    Color color = null;
    private boolean hasMoved;
    public void move(){

    }
    public boolean checkPromote(){
        return true;
    }

    Pawn(Color color){
        this.color = color;
    }

    // TODO: Current system allows player to land & eat own pieces, needs fixing!
    public boolean isValidMove(Board board, Square current, Square next) {
        Square temp;
        if(this.color == Color.WHITE){ // only moves up
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

        }else if (this.color == Color.BLACK){ // only moves down
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
        return true;
    }
/*
    @Override
    public String toString() {
        return "Pawn, " + getColor();
    }

 */
}
