package ChessGame;

class Ui {

    void celebrateWinner(Player winner) {
        System.out.println("Hurrah, the player " + winner.getName() + " has won!");
    }

    void printBoard(String board) {
        System.out.print(board);
    }
}
