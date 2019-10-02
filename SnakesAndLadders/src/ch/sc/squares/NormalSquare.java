//Author: Pascal Marty
package ch.sc.squares;

public class NormalSquare extends Square{
    public NormalSquare(Game game, int index){
        super(game, index);
    }

    public Square requestLanding(){
        if (!isOccupied){
            return this;
        }
        return null;
    }

    public boolean isLastSquare(){
        return false;
    }
}