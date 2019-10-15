package ChessGame;

class Ui {

    void celebrateWinner(Player winner) {
        System.out.println("Hurrah, the player " + winner.getName() + " has won!");
    }

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
