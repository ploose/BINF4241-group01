package ChessGame;

import src.ChessGame.Enums.*;

class Ui {

    void celebrateWinner(Color winner) {}

    void printBoard(Square[][] squares) {
        for (int i = 0; i < 8; i++) {
            System.out.print(i);
            for(int j = 0; j < 8; j++) {
                System.out.print("[" + squares[i][j].printPiece() + "]");
            }
            System.out.println();
        }
    }
}
