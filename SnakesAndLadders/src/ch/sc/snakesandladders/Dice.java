package ch.sc.snakesandladders; //added missing package statement -PL

import java.util.Random;

class Dice {
    private static int value;
    private static Random generator;

    //Constructor for the Dice class
    Dice() {
        generator = new Random();
        value = generator.nextInt(6) + 1;
    }

    //Return a random generated integer like a real dice :)
    //Added public statement to have the player access it. -PL
    static int throwDice() {
        value = generator.nextInt(6) + 1;
        return value;
    }
}

