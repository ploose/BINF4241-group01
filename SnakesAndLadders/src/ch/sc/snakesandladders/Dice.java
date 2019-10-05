package ch.sc.snakesandladders; //added missing package statement -PL

import java.util.Random;

class Dice {

    //Return a random generated integer like a real dice :)
    //Added public statement to have the player access it. -PL
    static int throwDice() {
        Random generator = new Random();
        int value = generator.nextInt(6) + 1;
        return value;
    }
}

