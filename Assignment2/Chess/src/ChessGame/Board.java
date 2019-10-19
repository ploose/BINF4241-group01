package ChessGame;

class Board {
    final private Square[][] squares;
    final private Game game;
    private PiecePot piecePot;

    Board(Game game){   //Constructor
        this.game = game;

        squares = new Square[8][8];
        initBoard();

        piecePot = new PiecePot();
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
        squares[0][0].addPiece(piecePot.add(new Rook(Color.BLACK, squares[0][0])));
        squares[7][0].addPiece(piecePot.add(new Rook(Color.BLACK, squares[7][0])));
        squares[0][7].addPiece(piecePot.add(new Rook(Color.WHITE, squares[0][7])));
        squares[7][7].addPiece(piecePot.add(new Rook(Color.WHITE, squares[7][7])));

        squares[1][0].addPiece(piecePot.add(new Knight(Color.BLACK, squares[1][0])));
        squares[6][0].addPiece(piecePot.add(new Knight(Color.BLACK, squares[6][7])));
        squares[1][7].addPiece(piecePot.add(new Knight(Color.WHITE, squares[1][0])));
        squares[6][7].addPiece(piecePot.add(new Knight(Color.WHITE, squares[6][7])));

        squares[2][0].addPiece(piecePot.add(new Bishop(Color.BLACK, squares[2][0])));
        squares[5][0].addPiece(piecePot.add(new Bishop(Color.BLACK, squares[5][7])));
        squares[2][7].addPiece(piecePot.add(new Bishop(Color.WHITE, squares[2][0])));
        squares[5][7].addPiece(piecePot.add(new Bishop(Color.WHITE, squares[5][7])));

        squares[3][0].addPiece(piecePot.add(new Queen(Color.BLACK, squares[3][0])));
        squares[3][7].addPiece(piecePot.add(new Queen(Color.WHITE, squares[3][7])));

        squares[4][0].addPiece(piecePot.add(new King(Color.BLACK, squares[4][0])));
        squares[4][7].addPiece(piecePot.add(new King(Color.WHITE, squares[4][7])));

        for (int i = 0; i < 8; i++) {
            squares[i][1].addPiece(piecePot.add(new Pawn(Color.BLACK, squares[1][i])));
            squares[i][6].addPiece(piecePot.add(new Pawn(Color.WHITE, squares[1][i])));
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
                board.append("[").append(squares[j][i].printPiece()).append("]");
            }
            board.append("\n");
        }

        board.append("    1   2   3   4   5   6   7   8 \n");

        return board.toString();
    }
}
