package ChessGame;

import src.ChessGame.Enums.*;

public class Board {
    final private Square[][] squares;
    final private Game game;

    Board(Game game){ //Constructor
        this.game = game;

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

    private void setPieces() {
        squares[0][0].addPiece(new Rook(Color.Black));
        squares[0][7].addPiece(new Rook(Color.White));
        squares[7][0].addPiece(new Rook(Color.Black));
        squares[7][7].addPiece(new Rook(Color.White));

        squares[1][0].addPiece(new Knight(Color.Black));
        squares[1][7].addPiece(new Knight(Color.White));
        squares[6][0].addPiece(new Knight(Color.Black));
        squares[6][7].addPiece(new Knight(Color.White));

        squares[2][0].addPiece(new Bishop(Color.Black));
        squares[2][7].addPiece(new Bishop(Color.White));
        squares[5][0].addPiece(new Bishop(Color.Black));
        squares[5][7].addPiece(new Bishop(Color.White));

        squares[3][0].addPiece(new Queen(Color.Black));
        squares[3][7].addPiece(new Queen(Color.White));

        squares[4][0].addPiece(new King(Color.Black));
        squares[4][7].addPiece(new King(Color.White));

        for (int i = 0; i < 8; i++) {
            squares[i][1].addPiece(new Pawn(Color.Black));
            squares[i][6].addPiece(new Pawn(Color.White));
        }
    }

    public Square getSquare(int row, int column){
        return squares[row][column];
    }

    void setWinner(Color winner) {
        game.setWinner(winner);
    }
}
