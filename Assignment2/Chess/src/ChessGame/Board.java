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
        squares[0][0].addPiece(new Rook(Color.BLACK, new Rook()));
        squares[7][0].addPiece(new Rook(Color.WHITE));
        squares[0][7].addPiece(new Rook(Color.BLACK));
        squares[7][7].addPiece(new Rook(Color.WHITE));

        squares[0][1].addPiece(new Knight(Color.BLACK));
        squares[7][1].addPiece(new Knight(Color.WHITE));
        squares[0][6].addPiece(new Knight(Color.BLACK));
        squares[7][6].addPiece(new Knight(Color.WHITE));

        squares[0][2].addPiece(new Bishop(Color.BLACK));
        squares[7][2].addPiece(new Bishop(Color.WHITE));
        squares[0][5].addPiece(new Bishop(Color.BLACK));
        squares[7][5].addPiece(new Bishop(Color.WHITE));

        squares[0][3].addPiece(new Queen(Color.BLACK));
        squares[7][3].addPiece(new Queen(Color.WHITE));

        squares[0][4].addPiece(new King(Color.BLACK));
        squares[7][4].addPiece(new King(Color.WHITE));

        for (int i = 0; i < 8; i++) {
            squares[1][i].addPiece(new Pawn(Color.BLACK));
            squares[6][i].addPiece(new Pawn(Color.WHITE));
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
