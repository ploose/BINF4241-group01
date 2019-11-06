package ChessGame;

public class Scoreboard {

    private static Scoreboard uniqueInstance;
    private int blackPlayerScore;
    private int whitePlayerScore;
    private PiecePot piecePot;
    private int blackPiecesAmount;
    private int whitePiecesAmount;

    private Scoreboard(){
        blackPlayerScore = 0;
        whitePlayerScore = 0;
    }

    static Scoreboard getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new Scoreboard();
            }

        return uniqueInstance;
    }

    void init(PiecePot piecepot){
        this.piecePot = piecepot;

        refresh();
    }

    void refresh(){
        getAmount();
        setBlackPlayerScore();
        setWhitePlayerScore();
    }

    private void setWhitePlayerScore(){
        whitePlayerScore = 0;

        for (int i = 0; i < this.blackPiecesAmount; i++) {
            Piece piece = piecePot.getBlackPlayerListOffBoard(i);

            if (piece instanceof Queen){
                whitePlayerScore += 5;
            } else {
                whitePlayerScore += 1;
            }
        }
    }

    private void setBlackPlayerScore(){
        blackPlayerScore = 0;

        for (int i = 0; i < this.whitePiecesAmount; i++){
            Piece piece = this.piecePot.getWhitePlayerListOffBoard(i);

            if (piece instanceof Queen) {
                blackPlayerScore += 5;
            } else {
                blackPlayerScore += 1;
            }
        }
    }

    private void getAmount(){
        whitePiecesAmount = piecePot.whitePlayerListOffBoardSize();
        blackPiecesAmount = piecePot.blackPlayerListOffBoardSize();
    }

    public String toString() {
        return "Player1 (White), score: " + whitePlayerScore + " - Player 2 (Black), score: " + blackPlayerScore;
    }
}