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

<<<<<<< Updated upstream
=======
    // Takes the pieces from the PiecePot-PL
>>>>>>> Stashed changes
    private void setPieces() {
        ArrayList<Object> whitePlayerList = this.piecePot.getWhitePieces();
        ArrayList<Object> blackPlayerList = this.piecePot.getBlackPieces();

<<<<<<< Updated upstream
        whitePlayerList = PiecePot.getWhitePieces;
        squares[0][0].addPiece(new Rook(Color.BLACK));
        squares[7][0].addPiece(new Rook(Color.WHITE));
        squares[0][7].addPiece(new Rook(Color.BLACK));
        squares[7][7].addPiece(new Rook(Color.WHITE));
=======
        squares[0][0].addPiece(this.piecePot.getBlackPiece(8));

        squares[7][0].addPiece(this.piecePot.getWhitePiece(8));
        squares[0][7].addPiece(this.piecePot.getWhitePiece(9));
        squares[7][7].addPiece(this.piecePot.getBlackPiece(9));
>>>>>>> Stashed changes

        squares[0][1].addPiece(this.piecePot.getBlackPiece(10));
        squares[7][1].addPiece(this.piecePot.getWhitePiece(10));
        squares[0][6].addPiece(this.piecePot.getBlackPiece(11));
        squares[7][6].addPiece(this.piecePot.getWhitePiece(11));

        squares[0][2].addPiece(this.piecePot.getBlackPiece(12));
        squares[7][2].addPiece(this.piecePot.getWhitePiece(12));
        squares[0][5].addPiece(this.piecePot.getBlackPiece(13));
        squares[7][5].addPiece(this.piecePot.getWhitePiece(13));

        squares[0][3].addPiece(this.piecePot.getBlackPiece(14));
        squares[7][3].addPiece(this.piecePot.getWhitePiece(14));

        squares[0][4].addPiece(this.piecePot.getBlackPiece(15));
        squares[7][4].addPiece(this.piecePot.getWhitePiece(15));

        for (int i = 0; i < 8; i++) {
            squares[1][i].addPiece(this.piecePot.getWhitePiece(i));
            squares[6][i].addPiece(this.piecePot.getWhitePiece(i));
        }
    }

    Square getSquare(int row, int column){
        return squares[row][column];
    }

    void setWinner(Player winner) {
        game.setWinner(winner);
    }

    Square[][] getBoard() {
        return squares;
    }
}
