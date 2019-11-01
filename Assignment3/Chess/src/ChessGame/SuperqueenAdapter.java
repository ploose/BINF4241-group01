package ChessGame;

public class SuperqueenAdapter extends Queen implements MovementStrategy, GenericMovementStrategy  {

    //private final int speed;
    Superqueen superqueen;

    SuperqueenAdapter(Superqueen superqueen){
        super(superqueen.color, superqueen.current);
        this.superqueen = superqueen;


        //speed = 8;
    }

    public void getMoveSquares(final Square[][] squares){
        superqueen.getSuperqueenMoveSquares(squares);
    }

    @Override
    public String toString() {
        return color.toString().charAt(0) + "Q";
    }
}
