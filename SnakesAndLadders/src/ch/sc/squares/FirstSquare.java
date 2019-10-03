//Author: Pascal Marty
package ch.sc.squares;

import ch.sc.snakesandladders.Game;

public class FirstSquare extends Square{
    public FirstSquare(Game game, int index){

        super(game, index);
    }

    public Square requestLanding(Player p){
        return this;
    }
}