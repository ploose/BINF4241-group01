//Author: Pascal Marty
public class FirstSquare extends Square{
    public FirstSquare(int index){
        // passes singleSpace = false because there can be multiple players on the first square
        super(index, false);
    }

    public Square requestLanding(Player p){
        // Players can always land on the first square
        return this;
    }

    public boolean isLastSquare(){
        return false;
    }
}