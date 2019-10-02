//Author: Pascal Marty
//TODO: Can multiple people land on the last square or is the game finished, as soon as the first player reaches it?
public class LastSquare extends Square{
    public LastSquare(int index){
        super(index);
    }

    public boolean requestLanding(Player p){
        // Assuming the game ends after first player reaches the last square, we don't need to check whether it is
        // occupied, because there will always only be one player that reaches it.
        addPlayer(p);
        finishGame();
        return true;
    }

    public boolean isLastSquare(){
        return true;
    }

}