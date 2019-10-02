//Author: Pascal Marty
public class NormalSquare extends Square{
    public NormalSquare(int index){
        super(index);
    }

    public boolean requestLanding(Player p){
        if (!isOccupied){
            addPlayer(p);
            return true;
        }
        return false;
    }

    public boolean isLastSquare(){
        return false;
    }
}