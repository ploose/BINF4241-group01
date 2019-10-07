package ch.sc.snakesandladders;

import java.util.Random;

class Dice {

    //Return a random generated integer like a real dice :)
    static int throwDice() {
        Random generator = new Random();
        int value = generator.nextInt(6) + 1;
        return value;
    }
}

