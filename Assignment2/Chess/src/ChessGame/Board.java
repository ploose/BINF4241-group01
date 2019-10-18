package ChessGame;

import java.util.ArrayList;

public class Board {
    final private Square[][] squares;
    final private Game game;
    private PiecePot piecePot;

    Board(Game game, PiecePot piecePot){ //Constructor
        this.game = game;
        this.piecePot = piecePot;

        squares = new Square[8][8];
        initBoard();
    }

    private void initBoard() {  // setting up the board
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                squares[i][j] = new Square(i, j);
            }
        }
        setPieces();
    }

    // Takes the pieces from the PiecePot-PL
    private void setPieces() {

        squares[0][0].addPiece(this.piecePot.getWhiteOnBoard(8));

        squares[7][0].addPiece(this.piecePot.getWhiteOnBoard(8));
        squares[0][7].addPiece(this.piecePot.getWhiteOnBoard(9));
        squares[7][7].addPiece(this.piecePot.getWhiteOnBoard(9));

        squares[0][1].addPiece(this.piecePot.getWhiteOnBoard(10));
        squares[7][1].addPiece(this.piecePot.getWhiteOnBoard(10));
        squares[0][6].addPiece(this.piecePot.getWhiteOnBoard(11));
        squares[7][6].addPiece(this.piecePot.getWhiteOnBoard(11));

        squares[0][2].addPiece(this.piecePot.getWhiteOnBoard(12));
        squares[7][2].addPiece(this.piecePot.getWhiteOnBoard(12));
        squares[0][5].addPiece(this.piecePot.getWhiteOnBoard(13));
        squares[7][5].addPiece(this.piecePot.getWhiteOnBoard(13));

        squares[0][3].addPiece(this.piecePot.getWhiteOnBoard(14));
        squares[7][3].addPiece(this.piecePot.getWhiteOnBoard(14));

        squares[0][4].addPiece(this.piecePot.getWhiteOnBoard(15));
        squares[7][4].addPiece(this.piecePot.getWhiteOnBoard(15));

        for (int i = 0; i < 8; i++) {
            squares[1][i].addPiece(this.piecePot.getWhiteOnBoard(i));
            squares[6][i].addPiece(this.piecePot.getWhiteOnBoard(i));
        }
    }

    Square getSquare(int row, int column){
        return squares[row][column];
    }

    void setWinner(Player winner) {
        game.setWinner(winner);
    }

    boolean move() {    //TODO
       return true;
    }

    public String toString() {
        StringBuilder board = new StringBuilder();

        Column[] values = Column.values();

        for (int i = 0; i < 8; i++) {
            board.append(values[i]);
            board.append("  ");

            for(int j = 0; j < 8; j++) {
                board.append("[").append(squares[i][j].printPiece()).append("]");
            }
            board.append("\n");
        }

        board.append("    1   2   3   4   5   6   7   8");

        return board.toString();
    }
}
