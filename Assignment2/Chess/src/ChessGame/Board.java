package ChessGame;

class Board {
    final private Square[][] squares;
    final private Game game;
    private PiecePot piecePot;

    //Constructor
    Board(Game game) {
        this.game = game;

        squares = new Square[8][8];
        initBoard();

        piecePot = new PiecePot();
        setPieces();
    }

    // setting up the board
    private void initBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new Square(i, j);
            }
        }
    }

    // Takes the pieces from the PiecePot
    private void setPieces() {
        squares[0][0].addPiece(piecePot.add(new Rook(Color.BLACK, squares[0][0])));
        squares[7][0].addPiece(piecePot.add(new Rook(Color.BLACK, squares[7][0])));
        squares[0][7].addPiece(piecePot.add(new Rook(Color.WHITE, squares[0][7])));
        squares[7][7].addPiece(piecePot.add(new Rook(Color.WHITE, squares[7][7])));

        squares[1][0].addPiece(piecePot.add(new Knight(Color.BLACK, squares[1][0])));
        squares[6][0].addPiece(piecePot.add(new Knight(Color.BLACK, squares[6][0])));
        squares[1][7].addPiece(piecePot.add(new Knight(Color.WHITE, squares[1][7])));
        squares[6][7].addPiece(piecePot.add(new Knight(Color.WHITE, squares[6][7])));

        squares[2][0].addPiece(piecePot.add(new Bishop(Color.BLACK, squares[2][0])));
        squares[5][0].addPiece(piecePot.add(new Bishop(Color.BLACK, squares[5][0])));
        squares[2][7].addPiece(piecePot.add(new Bishop(Color.WHITE, squares[2][7])));
        squares[5][7].addPiece(piecePot.add(new Bishop(Color.WHITE, squares[5][7])));

        squares[3][0].addPiece(piecePot.add(new Queen(Color.BLACK, squares[3][0])));
        squares[3][7].addPiece(piecePot.add(new Queen(Color.WHITE, squares[3][7])));

        squares[4][0].addPiece(piecePot.add(new King(Color.BLACK, squares[4][0])));
        squares[4][7].addPiece(piecePot.add(new King(Color.WHITE, squares[4][7])));

        for (int i = 0; i < 8; i++) {
            squares[i][1].addPiece(piecePot.add(new Pawn(Color.BLACK, squares[i][1])));
            squares[i][6].addPiece(piecePot.add(new Pawn(Color.WHITE, squares[i][6])));
        }
    }

    Square getSquare(int row, int column) {
        return squares[row][column];
    }

    void setWinner(Player winner) {
        game.setWinner(winner);
    }

    boolean move(int x1, int y1, int x2, int y2, Color color) {
        if (!squares[x1][y1].isOccupied()) {
            return false;
        }

        if (!(color == squares[x1][y1].getCurrentPiece().getColor())) {
            return false;
        }

        if (squares[x1][y1].getCurrentPiece().move(squares[x1][y1], squares[x2][y2], squares)) {
            squares[x2][y2].addPiece(squares[x1][y1].removePiece());
            return true;

        } else {
            return false;
        }
    }

    boolean eat(int x1, int y1, int x2, int y2, Color color) {
        if (!squares[x1][y1].isOccupied()) {
            return false;
        }

        if (!(color == squares[x1][y1].getCurrentPiece().getColor())) {
            return false;
        }

        if (squares[x1][y1].getCurrentPiece().eat(squares[x1][y1], squares[x2][y2], squares)) {
            piecePot.remove(squares[x2][y2].removePiece());
            squares[x2][y2].addPiece(squares[x1][y1].removePiece());

            return true;
        } else {
            return false;
        }
    }

    String lostPieces() {
        return piecePot.lostPieces();
    }

    void enPassant(int x1, int y1, int x2, int y2, Color color) {
        squares[x2][y2].addPiece(squares[x1][y1].removePiece());

        if (color == Color.BLACK) {
            piecePot.remove(squares[x2][y2 - 1].removePiece());
        } else {
            piecePot.remove(squares[x2][y2 + 1].removePiece());
        }
    }

    public String toString() {
        StringBuilder board = new StringBuilder();

        Column[] values = Column.values();

        for (int i = 0; i < 8; i++) {
            board.append(values[i]);
            board.append("  ");

            for (int j = 0; j < 8; j++) {
                board.append("[").append(squares[j][i]).append("]");
            }
            board.append("\n");
        }

        board.append("    1   2   3   4   5   6   7   8 \n");

        return board.toString();
    }
}
