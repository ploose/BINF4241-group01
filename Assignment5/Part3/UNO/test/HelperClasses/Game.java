package HelperClasses;

public class Game {
    public Object direction;
    public Playerpot playerpot;

    public void initialize() {
    }

    public void nextTurn() {
    }

    public Direction getDirection() {
        return Direction.CLOCKWISE;
    }

    public void playCard(NumberCard card) {
    }

    public Card draw() {
        return new Card();
    }

    public boolean isValidMove(Card card) {
        return true;
    }
}
