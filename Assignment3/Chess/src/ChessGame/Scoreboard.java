package ChessGame;

public class Scoreboard {

    private static Scoreboard uniqueInstance;
    private int blackPlayerScore = 0;
    private int whitePlayerScore = 0;
    private PiecePot piecePot;
    private int blackPiecesAmount;
    private int whitePiecesAmount;

    Scoreboard(){
    }

    public static Scoreboard getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new Scoreboard();
            }
        return uniqueInstance;
    }

    public void init(PiecePot piecepot){

        this.piecePot = piecepot;
        refresh();

    }

    public void refresh(){
        getAmount();
        setBlackPlayerScore();
        setWhitePlayerScore();
    }

    private void setWhitePlayerScore(){
        whitePlayerScore = 0;
        Piece piece;
        for (int i = 0; i < this.blackPiecesAmount; i++){
            piece = piecePot.getBlackPlayerListOffBoard(i);
            if (piece instanceof Queen){
                whitePlayerScore += 5;
            }
            else{
                whitePlayerScore += 1;
            }
        }
    }

    private void setBlackPlayerScore(){
        Piece piece;
        blackPlayerScore = 0;
        for (int i = 0; i < this.whitePiecesAmount; i++){
            piece = this.piecePot.getWhitePlayerListOffBoard(i);
            if (piece instanceof Queen){
                blackPlayerScore += 5;
            }
            else{
                blackPlayerScore += 1;
            }
        }
    }

    private void getAmount(){
        this.whitePiecesAmount = this.piecePot.whitePlayerListOffBoardSize();
        this.blackPiecesAmount = this.piecePot.blackPlayerListOffBoardSize();
    }
    public String toString() {

        String string = "Player1 (White), score: " + whitePlayerScore + " - Player 2 (Black), score: " + blackPlayerScore;

        return string;
    }






}
