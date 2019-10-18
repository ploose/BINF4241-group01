package ChessGame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PiecePot {

    private ArrayList<Piece> blackPlayerList;
    private ArrayList<Piece> whitePlayerList;
    private ArrayList<Piece> blackPlayerListOffBoard;
    private ArrayList<Piece> whitePlayerListOffBoard;

    private int whiteOnBoard;
    private int whiteOffBoard;
    private int blackOnBoard;
    private int blackOffBoard;

    Board board;


    PiecePot(Game game) {

    this.board = game.getBoard();
    }

    public void initPots() {

        initBlackPlayerPot();
        initWhitePlayerPot();
        initPieceCounters();
    }

    private void initPieceCounters(){
        this.whiteOnBoard = 8;
        this.blackOnBoard = 8;
        this.whiteOffBoard = 0;
        this.blackOffBoard = 0;

    }

    // Initializing blackPlayerPot
    // TODO: Find a way to initialize a PlayerPot
    // TODO: Add methods that add/subtract from the piecescount
    private void initBlackPlayerPot() {

        Color color = Color.BLACK;
        int i;
        for (i = 0; i < 9; i++) {
            blackPlayerList.add(i, new Pawn(color, 1, i, board));
        }
        blackPlayerList.add(i, new Rook(color, 0, 0, board));
        i++;
        blackPlayerList.add(i, new Rook(color, 0,7, board));
        i++;
        blackPlayerList.add(i, new Knight(color,0,1, board));
        i++;
        blackPlayerList.add(i, new Knight(color,0,6, board));
        i++;
        blackPlayerList.add(i, new Bishop(color,0,2, board));
        i++;
        blackPlayerList.add(i, new Bishop(color,0,5, board));
        i++;
        blackPlayerList.add(i, new Queen(color,0,3, board));
        i++;
        blackPlayerList.add(i, new King(color,0,4, board));
    }


    private void initWhitePlayerPot() {

        Color color = Color.WHITE;
        int i;
        for (i = 0; i < 8; i++) {
            whitePlayerList.add(i, new Pawn(color,6,i, board));
        }
        whitePlayerList.add(i, new Rook(color,7,0, board));
        i++;
        whitePlayerList.add(i, new Rook(color,7,7, board));
        i++;
        whitePlayerList.add(i, new Knight(color,7,1, board));
        i++;
        whitePlayerList.add(i, new Knight(color,7,6, board));
        i++;
        whitePlayerList.add(i, new Bishop(color,7,2, board));
        i++;
        whitePlayerList.add(i, new Bishop(color,7,5, board));
        i++;
        whitePlayerList.add(i, new Queen(color,7,3, board));
        i++;
        whitePlayerList.add(i, new King(color,7,4, board));
    }
/* no good encapsulation
    public ArrayList<Object> getWhitePieces() {
        return this.whitePlayerList;
    }

    public ArrayList<Object> getBlackPieces() {
        return this.blackPlayerList;
    }
    */

    public Piece getWhiteOnBoard(int i){
        return this.whitePlayerList.get(i);
    }
    public Piece getBlackOnBoard(int i){
        return this.whitePlayerList.get(i);
    }
    public Piece getWhiteOffBoard(int i){
        return this.whitePlayerListOffBoard.get(i);
    }
    public Piece getBlackOffBoard(int i){
        return this.whitePlayerListOffBoard.get(i);
    }

    public int getWhiteOnBoardCounter(){
        int tmp = this.whiteOnBoard;
        return tmp;
    }
    public int getBlackOnBoardCounter(){
        int tmp = this.blackOnBoard;
        return tmp;
    }
    public int getWhiteOffBoardCounter(){
        int tmp = this.whiteOffBoard;
        return tmp;
    }
    public int getBlackOffBoardCounter(){
        int tmp = this.blackOffBoard;
        return tmp;
    }

}

