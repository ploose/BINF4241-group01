package ChessGame;

import java.util.ArrayList;

public class Board {
    final private Square[][] squares;
    final private Game game;
    private PiecePot piecePot;

    Board(Game game){   //Constructor
        this.game = game;

        squares = new Square[8][8];
        initBoard();

        piecePot = new PiecePot(this);
        setPieces();
    }

    private void initBoard() {  // setting up the board
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                squares[i][j] = new Square(i, j);
            }
        }
    }

    private void setPieces() {  // Takes the pieces from the PiecePot
        squares[0][0].addPiece(piecePot.getBlackOnBoard(8));
        squares[7][0].addPiece(piecePot.getWhiteOnBoard(8));
        squares[0][7].addPiece(piecePot.getBlackOnBoard(9));
        squares[7][7].addPiece(piecePot.getWhiteOnBoard(9));

        squares[0][1].addPiece(piecePot.getBlackOnBoard(10));
        squares[7][1].addPiece(piecePot.getWhiteOnBoard(10));
        squares[0][6].addPiece(piecePot.getBlackOnBoard(11));
        squares[7][6].addPiece(piecePot.getWhiteOnBoard(11));

        squares[0][2].addPiece(piecePot.getBlackOnBoard(12));
        squares[7][2].addPiece(piecePot.getWhiteOnBoard(12));
        squares[0][5].addPiece(piecePot.getBlackOnBoard(13));
        squares[7][5].addPiece(piecePot.getWhiteOnBoard(13));

        squares[0][3].addPiece(piecePot.getBlackOnBoard(14));
        squares[7][3].addPiece(piecePot.getWhiteOnBoard(14));

        squares[0][4].addPiece(piecePot.getBlackOnBoard(15));
        squares[7][4].addPiece(piecePot.getWhiteOnBoard(15));

        for (int i = 0; i < 8; i++) {
            squares[1][i].addPiece(piecePot.getBlackOnBoard(i));
            squares[6][i].addPiece(piecePot.getWhiteOnBoard(i));
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

    String lostPieces() {
        return piecePot.lostPieces();
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

        board.append("    1   2   3   4   5   6   7   8 \n");

        return board.toString();
    }
}
