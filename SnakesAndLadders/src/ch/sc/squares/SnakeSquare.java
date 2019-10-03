//Author: Pascal Marty
package ch.sc.squares;

import ch.sc.snakesandladders.Game;

import java.util.Random;

public class SnakeSquare extends Square{
    private int jumpDistance;
    public SnakeSquare(Game game, int index){
        super(game, index);
        initDistance(this.index);
    }


    // Initializes distance, which the snake will move the player, calculated between (index-1) and (start+1)
    // TODO: Multiple snakes could end up at same square, also ladders could spawn on snakes

    // added "void" -PL
    private void initJumpDistance(int index){

        Random random = new Random();
        this.jumpDistance = random.nextInt(index -2) + 2;
    }

    public Square requestLanding(){
        return moveAndLand(jumpDistance);
    }
}