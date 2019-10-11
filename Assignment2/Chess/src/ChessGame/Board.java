package ChessGame;

public class Board {

    private Square squares[][] = new Square[8][8];

    void initBoard() {


        // setting up the board
        for (int row = 0; row <= 8; row++){
            for (int column = 0; column <= 8; column++){
                this.squares[row][column] = new Square(row, column);
            }
        }

    }

    public Square getSquare(int row, int column){

        return this.squares[row][column];

    }

    void setWinner() {}
}
