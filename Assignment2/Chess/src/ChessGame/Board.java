package ChessGame;

import java.util.ArrayList;

class Board {
    final private Square[][] squares;
    final private Game game;
    private PiecePot piecePot;
    Piece oldPiece;

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
        /*
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
        */


        squares[0][0].addPiece(piecePot.add(new King(Color.BLACK, squares[0][0])));

        squares[6][6].addPiece(piecePot.add(new Pawn(Color.BLACK, squares[6][6])));
        squares[5][7].addPiece(piecePot.add(new Queen(Color.WHITE, squares[5][7])));

        squares[4][7].addPiece(piecePot.add(new King(Color.WHITE, squares[4][7])));
        squares[0][1].addPiece(piecePot.add(new Pawn(Color.WHITE, squares[0][1])));


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
        // check if the move leads to a check situation
        if (moveChecked(color,x1,y1, x2, y2)){ return false; }

        if (squares[x1][y1].getCurrentPiece().move(squares[x1][y1], squares[x2][y2], squares)) {
            squares[x2][y2].addPiece(squares[x1][y1].removePiece());

            return true;
        }
        else {
            return false;
        }
    }


    // performs a fakemove: A move that is not checked if it's valid
    public void doFakeMove(int x1, int y1, int x2, int y2, FakemoveMode mode) {

        // check
       squares[x1][y1].getCurrentPiece().forcedMove(squares[x1][y1], squares[x2][y2], squares);

       // If there is a piece standing where he want to move (eat situation), the eaten piece will be stored
       if (squares[x2][y2] != null && mode == FakemoveMode.doMove){
           oldPiece = squares[x2][y2].removePiece();
           squares[x2][y2].addPiece(squares[x1][y1].removePiece());
        }
       // If there is a piece that has to take its place again, this will be executed while undoing
       else if (mode == FakemoveMode.undoMove && oldPiece != null){
           squares[x2][y2].addPiece(squares[x1][y1].removePiece());
           squares[x1][y1].addPiece(oldPiece);
           oldPiece = null;
       }
       else{
           squares[x2][y2].addPiece(squares[x1][y1].removePiece());
       }
        System.out.print(this);



    }



    boolean eat(int x1, int y1, int x2, int y2, Color color) {
        if (!squares[x1][y1].isOccupied()) {
            return false;
        }

        if (!(color == squares[x1][y1].getCurrentPiece().getColor())) {
            return false;
        }
        if (moveChecked(color,x1,y1, x2, y2)){ return false; }

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

    // performs a fakemove: A move that is not checked if it's valid
    private void doFakeMove(int x1, int y1, int x2, int y2) {
       squares[x1][y1].getCurrentPiece().forcedMove(squares[x1][y1], squares[x2][y2], squares);
       squares[x2][y2].addPiece(squares[x1][y1].removePiece());
    }

    String lostPieces() {
        return piecePot.lostPieces();
    }

    ArrayList<Piece> getFriendlies(Player p){
        return piecePot.getPiecesAlive(p.getColor());
    }

    ArrayList<Piece> getEnemies(Player p){
        if(p.getColor() == Color.BLACK){
            return piecePot.getPiecesAlive(Color.WHITE);
        }else{
            return piecePot.getPiecesAlive(Color.BLACK);
        }
    }

    Square getKingSquare(Player p){
        Square kingSquare = null;
        for(Piece piece : piecePot.getPiecesAlive(p.getColor())){
            // System.out.println("Debug: " + piece.getClass() + " | " + King.class);
            if(piece.getClass() == King.class){
                kingSquare = piece.current;
            }
        }
        return kingSquare;
    }

    public Square[][] getSquares(){
        return squares;
    }

    void refresh(){
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



    //checks if a certain move will lead to the player being checked
    private boolean moveChecked(Color color, int x1, int y1, int x2, int y2){
        boolean Checked = false;

        doFakeMove( x1, y1, x2, y2, FakemoveMode.doMove) ;
        this.refresh();
        if (game.checkCheck(game.getPlayer(color))){
            Checked = true;
        }
        doFakeMove(x2,y2,x1,y1,FakemoveMode.undoMove);
        this.refresh();

        return Checked;


    }

    private void promotePawn(Piece p){
        Piece t;
        while (true){
            String input = ui.getPromotion();

            System.out.println(input);
            if(input.equals("q")){
                t = new Queen(p.getColor(), p.current);
                p.current.removePiece();
                t.current.addPiece(t);
                piecePot.replace(p, t);
                break;
            }else if(input.equals("k")){
                t = new Knight(p.getColor(), p.current);
                p.current.removePiece();
                t.current.addPiece(t);
                piecePot.replace(p, t);
                break;
            }else if(input.equals("t")){
                t = new Rook(p.getColor(), p.current);
                p.current.removePiece();
                t.current.addPiece(t);
                piecePot.replace(p, t);
                break;
            }else if(input.equals("b")){
                t = new Bishop(p.getColor(), p.current);
                p.current.removePiece();
                t.current.addPiece(t);
                piecePot.replace(p, t);
                break;
            }
        }
    }

    private void checkPromote(Piece p){
        if(p.getColor()== Color.BLACK){
            if(p.current.y == 7){
                promotePawn(p);
            }
        }else{
            if(p.current.y == 0){
                promotePawn(p);
            }
        }
    }

}
