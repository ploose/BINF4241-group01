package ChessGame;

import java.util.ArrayList;

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
        this.possibleMoveSquares = superqueen.possibleMoveSquares;
        this.canEat = superqueen.canEat;


    }

    @Override
    public String toString() {
        return color.toString().charAt(0) + "Q";
    }
}
