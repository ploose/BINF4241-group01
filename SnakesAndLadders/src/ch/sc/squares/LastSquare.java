//Author: Pascal Marty, Tim Brunner
package ch.sc.squares;


import ch.sc.snakesandladders.Game;

public class LastSquare extends Square{

    public LastSquare(Game game, int index){
        super(game, index);
    }



    public Square requestLanding(Player p){
        game.setWinner(p);
        return this;
    }
}