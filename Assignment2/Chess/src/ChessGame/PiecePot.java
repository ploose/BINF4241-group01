package ChessGame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PiecePot {

    ArrayList<Object> blackPlayerList;
    ArrayList<Object> whitePlayerList;
    ArrayList<Object> blackPlayerListOffBoard;
    ArrayList<Object> whitePlayerListOffBoard;

    private int whiteOnBoard;
    private int whiteOffBoard;
    private int blackOnBoard;
    private int blackOffBoard;


    PiecePot() {

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
            blackPlayerList.add(i, new Pawn(color));
        }
        blackPlayerList.add(i, new Rook(color));
        i++;
        blackPlayerList.add(i, new Rook(color));
        i++;
        blackPlayerList.add(i, new Knight(color));
        i++;
        blackPlayerList.add(i, new Knight(color));
        i++;
        blackPlayerList.add(i, new Bishop(color));
        i++;
        blackPlayerList.add(i, new Bishop(color));
        i++;
        blackPlayerList.add(i, new Queen(color));
        i++;
        blackPlayerList.add(i, new King(color));
    }


    private void initWhitePlayerPot() {

        Color color = Color.WHITE;
        int i;
        for (i = 0; i < 8; i++) {
            whitePlayerList.add(i, new Pawn(color));
        }
        whitePlayerList.add(i, new Rook(color));
        i++;
        whitePlayerList.add(i, new Rook(color));
        i++;
        whitePlayerList.add(i, new Knight(color));
        i++;
        whitePlayerList.add(i, new Knight(color));
        i++;
        whitePlayerList.add(i, new Bishop(color));
        i++;
        whitePlayerList.add(i, new Bishop(color));
        i++;
        whitePlayerList.add(i, new Queen(color));
        i++;
        whitePlayerList.add(i, new King(color));
    }
/* no good encapsulation
    public ArrayList<Object> getWhitePieces() {
        return this.whitePlayerList;
    }

    public ArrayList<Object> getBlackPieces() {
        return this.blackPlayerList;
    }
    */

    public Object getWhiteOnBoard(int i){
        return this.whitePlayerList.get(i);
    }
    public Object getBlackOnBoard(int i){
        return this.whitePlayerList.get(i);
    }
    public Object getWhiteOffBoard(int i){
        return this.whitePlayerListOffBoard.get(i);
    }
    public Object getBlackOffBoard(int i){
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

