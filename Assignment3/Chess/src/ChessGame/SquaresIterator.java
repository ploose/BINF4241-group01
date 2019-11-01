package ChessGame;

public class SquaresIterator {

    Square[][] squares;
    int row = 0;
    int column = 0;
    int tempColumn;
    int tempRow;

    public SquaresIterator(final Square[][] squares) {
        this.squares = squares;
    }

    public Square next() {

        Square tempSquare = squares[row][column];

        if (column == 7) {
            column = 0;
            row += 1;
        } else {
            column += 1;
        }

        return tempSquare;
    }

    public boolean hasNext() {
        tempColumn = this.column;
        tempRow = this.row;

        if (column > 7 || row == 7) {
            return false;
        } else {
            return true;
        }

    }
}
