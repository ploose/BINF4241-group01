package ChessGame;

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
        squares[0][0].addPiece(new Rook(Color.BLACK));
        squares[0][7].addPiece(new Rook(Color.WHITE));
        squares[7][0].addPiece(new Rook(Color.BLACK));
        squares[7][7].addPiece(new Rook(Color.WHITE));

        squares[1][0].addPiece(new Knight(Color.BLACK));
        squares[1][7].addPiece(new Knight(Color.WHITE));
        squares[6][0].addPiece(new Knight(Color.BLACK));
        squares[6][7].addPiece(new Knight(Color.WHITE));

        squares[2][0].addPiece(new Bishop(Color.BLACK));
        squares[2][7].addPiece(new Bishop(Color.WHITE));
        squares[5][0].addPiece(new Bishop(Color.BLACK));
        squares[5][7].addPiece(new Bishop(Color.WHITE));

        squares[3][0].addPiece(new Queen(Color.BLACK));
        squares[3][7].addPiece(new Queen(Color.WHITE));

        squares[4][0].addPiece(new King(Color.BLACK));
        squares[4][7].addPiece(new King(Color.WHITE));

        for (int i = 0; i < 8; i++) {
            squares[i][1].addPiece(new Pawn(Color.BLACK));
            squares[i][6].addPiece(new Pawn(Color.WHITE));
        }
    }

    public Square getSquare(int row, int column){
        return squares[row][column];
    }

    void setWinner(Color winner) {
        game.setWinner(winner);
    }
}
