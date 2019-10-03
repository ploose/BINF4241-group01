//Author: Pascal Marty
package ch.sc.squares;

public class FirstSquare extends Square{
    public FirstSquare(Game game, int index){
        // passes singleSpace = false because there can be multiple players on the first square
        super(game, index, false);
    }

    public Square requestLanding(Player p){
        return this;
    }
}