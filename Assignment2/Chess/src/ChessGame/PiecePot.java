package ChessGame;

import java.util.ArrayList;

public class PiecePot {

    ArrayList<Object> blackPlayerList;
    ArrayList<Object> whitePlayerList;



    PiecePot() {

    }

    public void initPots(){

        initBlackPlayerPot();
        initWhitePlayerPot();
    }

        // Initializing blackPlayerPot
    // TODO: Find a way to initialize a PlayerPot
        private void initBlackPlayerPot() {
/*
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

 */

    private void initWhitePlayerPot() {
/*
        Color color = Color.WHITE;
        int i;
        for (i = 0; i < 9; i++) {
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

  */



    public Object getPlayer(int i){
        return playerList.get(i);
    }

}
