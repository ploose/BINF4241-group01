//Author: Pascal Marty, Tim Brunner
package ch.sc.squares;

public class LastSquare extends Square{
    public LastSquare(Game game, int index){
        super(game, index);
    }

    public Square requestLanding(Player p){
        game.setWinner(p);
        return this;
    }
}