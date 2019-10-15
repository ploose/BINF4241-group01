package ChessGame;

class Ui {

    void celebrateWinner(Player winner) {
        System.out.println("Hurrah, the player " + winner.getName() + " has won!");
    }

    void printBoard(Square[][] squares) {
        Enums.Column[] values = Enums.Column.values();

        for (int i = 0; i < 8; i++) {
            System.out.print(values[i]);
            System.out.print(" ");

            for(int j = 0; j < 8; j++) {
                System.out.print("[" + squares[i][j].printPiece() + "]");
            }
            System.out.println();
        }

        System.out.println("   1   2   3   4   5   6   7   8");
    }
}
