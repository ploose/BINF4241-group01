//Author: Pascal Marty
public class NormalSquare extends Square{
    public NormalSquare(int index){
        super(index);
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