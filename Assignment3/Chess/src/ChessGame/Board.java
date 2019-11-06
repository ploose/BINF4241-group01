package ChessGame;

import java.util.Iterator;

class Board {
    final private Square[][] squares;
    final private Game game;
    private PiecePot piecePot;
    private Scoreboard scoreboard;
    private static Board uniqueInstance;

    //Constructor
    private Board(Game game) {
        this.game = game;

        squares = new Square[8][8];
        initBoard();

        piecePot = new PiecePot();
        setPieces();

        scoreboard = Scoreboard.getInstance();
        scoreboard.init(piecePot);

    }

    static Board getUniqueInstance(Game game) {
        if (uniqueInstance == null) {
            uniqueInstance = new Board(game);
        }

        return uniqueInstance;
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


/*
        squares[0][0].addPiece(piecePot.add(new King(Color.BLACK, squares[0][0])));
        squares[6][6].addPiece(piecePot.add(new Pawn(Color.BLACK, squares[6][6])));

        squares[4][7].addPiece(piecePot.add(new King(Color.WHITE, squares[4][7])));
        squares[0][1].addPiece(piecePot.add(new Pawn(Color.WHITE, squares[0][1])));
*/

    }

    Square getSquare(int row, int column) {
        return squares[row][column];
    }

    boolean move(int x1, int y1, int x2, int y2, Color color) {
        if (!squares[x1][y1].isOccupied()) {
            return false;
        }

        if (squares[x2][y2].isOccupied()) {
            return false;
        }

        if (!(color == squares[x1][y1].getCurrentPiece().getColor())) {
            return false;
        }

        if (moveChecked(color,x1,y1, x2, y2)){
            return false;
        }

        if (squares[x1][y1].getCurrentPiece().move(squares[x1][y1], squares[x2][y2], squares)) {
            squares[x2][y2].addPiece(squares[x1][y1].removePiece());

            return true;
        }
        else {
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

    void enPassant(int x1, int y1, int x2, int y2, Color color) {
        squares[x2][y2].addPiece(squares[x1][y1].removePiece());

        if (color == Color.BLACK) {
            piecePot.remove(squares[x2][y2 - 1].removePiece());
        } else {
            piecePot.remove(squares[x2][y2 + 1].removePiece());
        }
    }

    boolean promotion(int x1, int y1, int x2, int y2, String piece, Color color) {
        if (!move(x1, y1, x2, y2, color)) {
            return false;
        }

        Piece promoted;

        switch (piece) {
            case "T":
                promoted = new Rook(color, squares[x2][y2]);
                break;

            case "N":
                promoted = new Knight(color, squares[x2][y2]);
                break;

            case "B":
                promoted = new Bishop(color, squares[x2][y2]);
                break;

            default:
                promoted = new Queen(color, squares[x2][y2]);
                break;
        }

        Piece pawn = squares[x2][y2].removePiece();
        squares[x2][y2].addPiece(promoted);
        piecePot.replace(pawn, promoted);

        return true;
    }

    boolean castleLong(Color color) {
        if (color == Color.BLACK) {
            Square squareOne = squares[4][0], squareTwo = squares[0][0];

            if (!(squareOne.hasType("class ChessGame.King") && squareTwo.hasType("class ChessGame.Rook"))) {
                return false;
            }

            if (squareOne.getCurrentPiece().hasMoved() || squareTwo.getCurrentPiece().hasMoved()) {
                return false;
            }

            for (int i = 1; i < 4; i++) {
                if (squares[i][0].isOccupied()) {
                    return false;
                }

                if (moveChecked(color,4, 0, i, 0)) {
                    return false;
                }
            }

            Piece tmp = squareOne.removePiece();

            move(0, 0, 3, 0, color);
            squares[2][0].addPiece(tmp);
            tmp.hasMoved();

            return true;

        } else {
            Square squareOne = squares[4][7], squareTwo = squares[0][7];

            if (!(squareOne.hasType("class ChessGame.King") && squareTwo.hasType("class ChessGame.Rook"))) {
                return false;
            }

            if (squareOne.getCurrentPiece().hasMoved() || squareTwo.getCurrentPiece().hasMoved()) {
                return false;
            }

            for (int i = 1; i < 4; i++) {
                if (squares[i][7].isOccupied()) {
                    return false;
                }

                if (moveChecked(color, 4, 7, i, 7)) {
                    return false;
                }
            }

            Piece tmp = squareOne.removePiece();

            move(0, 0, 3, 0, color);
            squares[2][0].addPiece(tmp);
            tmp.hasMoved();

            return true;
        }
    }

    boolean castleShort(Color color) {
        if (color == Color.BLACK) {
            Square squareOne = squares[4][0], squareTwo = squares[7][0];

            if (!(squareOne.hasType("class ChessGame.King") && squareTwo.hasType("class ChessGame.Rook"))) {
                return false;
            }

            if (squareOne.getCurrentPiece().hasMoved() || squareTwo.getCurrentPiece().hasMoved()) {
                return false;
            }

            for (int i = 5; i < 6; i++) {
                if (squares[i][0].isOccupied()) {
                    return false;
                }

                if (moveChecked(color,4, 0, i, 0)) {
                    return false;
                }
            }

            Piece tmp = squareOne.removePiece();

            move(7, 0, 5, 0, color);
            squares[6][0].addPiece(tmp);
            tmp.hasMoved();

            return true;

        } else {
            Square squareOne = squares[4][7], squareTwo = squares[7][7];

            if (!(squareOne.hasType("class ChessGame.King") && squareTwo.hasType("class ChessGame.Rook"))) {
                return false;
            }

            if (squareOne.getCurrentPiece().hasMoved() || squareTwo.getCurrentPiece().hasMoved()) {
                return false;
            }

            for (int i = 5; i < 6; i++) {
                if (squares[i][7].isOccupied()) {
                    return false;
                }

                if (moveChecked(color,4, 7, i, 7)) {
                    return false;
                }
            }

            Piece tmp = squareOne.removePiece();

            move(7, 7, 5, 7, color);
            squares[6][7].addPiece(tmp);
            tmp.hasMoved();

            return true;
        }
    }

    // performs a fake move: A move that is not checked if it's valid
    private void doFakeMove(int x1, int y1, int x2, int y2) {
        squares[x1][y1].getCurrentPiece().forcedMove(squares[x2][y2], squares);
        squares[x2][y2].addPiece(squares[x1][y1].removePiece());
    }

    String lostPieces() { return piecePot.lostPieces(); }

    String scores(){ return scoreboard.toString();}

    void refreshScoreboard(){
        scoreboard.refresh();
    }

    PiecePotIterator getFriendlies(Player p){
        return piecePot.getPiecesAlive(p.getColor());
    }

    PiecePotIterator getEnemies(Player p){
        if(p.getColor() == Color.BLACK){
            return piecePot.getPiecesAlive(Color.WHITE);
        }else{
            return piecePot.getPiecesAlive(Color.BLACK);
        }
    }

    Square getKingSquare(Player p){
        Square kingSquare = null;
        Iterator<Piece> piecesAlive = piecePot.getPiecesAlive(p.getColor());

        while (piecesAlive.hasNext()) {
            Piece currentPiece = piecesAlive.next();

            if (currentPiece.getClass() == King.class) {
                kingSquare = currentPiece.current;
            }
        }

        return kingSquare;
    }

    void refresh() {
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(squares[i][j].isOccupied()){
                    squares[i][j].getCurrentPiece().getMoveSquares(squares);
                }
            }
        }
    }

    //checks if a certain move will lead to the player being checked
    private boolean moveChecked(Color color, int x1, int y1, int x2, int y2){
        boolean Checked = false;

        doFakeMove(x1, y1, x2, y2) ;
        this.refresh();
        if (game.checkCheck(game.getPlayer(color))){
            Checked = true;
        }
        doFakeMove(x2, y2, x1, y1);
        this.refresh();

        return Checked;
    }

    public String toString() {
        StringBuilder board = new StringBuilder();

        Column[] values = Column.values();

        for (int i = 0; i < 8; i++) {
            board.append(8 - i);
            board.append("  ");

            for (int j = 0; j < 8; j++) {
                board.append("[").append(squares[j][i]).append("]");
            }
            board.append("\n");
        }
        board.append("    ");
        for (Column col: values){
            board.append(col).append("   ");
        }
        board.append("\n");

        return board.toString();
    }

    String getPieces(){
        return piecePot.getPiecesOnBoard();
    }
}
