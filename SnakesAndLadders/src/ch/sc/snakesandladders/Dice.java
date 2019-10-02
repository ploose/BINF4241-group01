import java.util.Random;

public class Dice {
    private int value;
    private Random generator;

    public Dice() {
        generator = new Random()
        value = generator.nextInt(6) + 1;
    }

    public int throw_dice() {
        value = generator.nextInt(6) + 1;
        return value;
    }
}

