//Author: Pascal Marty
package ch.sc.squares;

import ch.sc.snakesandladders.Game;

import java.util.Random;

public class LadderSquare extends Square{
    private int jumpDistance;

    public LadderSquare(Game game, int index){
        super(game, index);
        initDistance(this.index);
    }

    // Initializes distance, which the ladder will move the player, calculated between (index+1) and (end-1)
    // TODO: Multiple ladders could end up at same square, also snakes could spawn on ladders
    private initJumpDistance(int index){
        Random random = new Random();
        this.jumpDistance = random.nextInt(this.game.getSize() - index -1) + 1 + index;
    }

    public Square requestLanding(){
        return moveAndLand(jumpDistance);
    }
}