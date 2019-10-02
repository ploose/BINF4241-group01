import java.util.Random;

public class Dice {
    private int value;
    private Random generator;

    public Dice() {
        value = generator.nextInt(7);
    }

    public int get_value() {
        return this.value;
    }

    public void throw_dice() {
        value = generator.nextInt(7);
    }
}
