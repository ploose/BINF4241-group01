package ChessGame;

public class Square {

    public Square(int row, int column) {
        return;
    }

    enum Row { ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT }
    enum Column { A, B, C, D, E , F, G, H}
    private boolean canBeEatenW;
    private boolean canBeEatenB;
    private boolean canBePromotedW;
    private boolean canBePromotedB;

    private Piece currentPiece;

    Square(Row row, Column column) {


    }



}
