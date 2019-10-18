package ChessGame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PiecePot {

    ArrayList<Object> blackPlayerList;
    ArrayList<Object> whitePlayerList;


    PiecePot() {

    }

    public void initPots() {

        initBlackPlayerPot();
        initWhitePlayerPot();
    }

    // Initializing blackPlayerPot
    // TODO: Find a way to initialize a PlayerPot
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

    public ArrayList<Object> getWhitePieces() {
        return this.whitePlayerList;
    }

    public ArrayList<Object> getBlackPieces() {
        return this.blackPlayerList;
    }

    public Object getWhitePiece(int i){
        return this.whitePlayerList.get(i);
    }
    public Object getBlackPiece(int i){
        return this.whitePlayerList.get(i);
    }

}

