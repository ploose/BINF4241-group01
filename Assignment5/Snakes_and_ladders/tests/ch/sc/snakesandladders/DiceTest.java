package ch.sc.snakesandladders;

import static org.junit.Assert.*;

import org.junit.*;

import java.util.ArrayList;


public class DiceTest {
    private ArrayList<Integer> diceFaces;
    private ArrayList<Integer> thrownFaces;

    /**
     * Setting up variables for the tests
     */
    @Before
    public void setUp() {
        diceFaces = new ArrayList<>(); // creating ArrayList containing all valid faces
        diceFaces.add(1);
        diceFaces.add(2);
        diceFaces.add(3);
        diceFaces.add(4);
        diceFaces.add(5);
        diceFaces.add(6);
        thrownFaces = new ArrayList<>(); // creating empty ArrayList to save all thrown faces
    }

    /**
     * This test checks, whether the dice always returns valid faces
     * (only faces 1-6 in the case of our 'classic' dice)
     * <p>
     * Small disclaimer: Due to being probabilistic, there is a very small chance
     * that the test fails, even when the tested code works as expected
     */
    @Test
    public void testRange() {
        int face;
        boolean failed = false;

        for (int i = 0; i < 1000000; i++) {
            face = Dice.throwDice();
            if (!diceFaces.contains(face)) {
                System.out.println(face + " is not valid face!");
                failed = true;
            }
        }

        assertFalse("Dice threw illegal number (not in 1-6)", failed);
    }

    /**
     * This test checks, whether the dice returns all valid faces
     * (i.e. the dice throws all faces in the valid range at least once)
     * <p>
     * Small disclaimer: Due to being probabilistic, there is a very small chance
     * that the test fails, even when the tested code works as expected
     */
    @Test
    public void testReceivingAllFaces() {
        int face;
        boolean failed = false;
        // throw dice a lot and see whether all valid results have been thrown (probabilistic test!)
        for (int i = 0; i < 1000000; i++) {
            face = Dice.throwDice();
            if (!thrownFaces.contains(face)) {
                thrownFaces.add(face);
            }
        }

        for (int f : diceFaces) {
            if (!thrownFaces.contains(f)) {
                failed = true;
                break;
            }
        }

        assertFalse("Dice didn't throw all valid faces", failed);
    }
}