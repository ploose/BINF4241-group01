package ChessGame;

import java.util.ArrayList;

class PiecePot {
    private ArrayList<Piece> blackPlayerList;
    private ArrayList<Piece> whitePlayerList;
    private ArrayList<Piece> blackPlayerListOffBoard;
    private ArrayList<Piece> whitePlayerListOffBoard;
    private int blackPlayerListOffBoardSize;
    private int whitePlayerListOffBoardSize;

    PiecePot() {
        blackPlayerList = new ArrayList<>();
        whitePlayerList = new ArrayList<>();

        blackPlayerListOffBoard = new ArrayList<>();
        whitePlayerListOffBoard = new ArrayList<>();

        blackPlayerListOffBoardSize = 16;
        whitePlayerListOffBoardSize = 16;
    }

    Piece add(Piece piece) {
        if (piece.getColor() == Color.BLACK) {
            blackPlayerList.add(piece);
            blackPlayerListOffBoardSize -= 1;
        } else {
            whitePlayerList.add(piece);
            whitePlayerListOffBoardSize -= 1;
        }

        return piece;
    }

    void remove(Piece piece) {
        if (piece.getColor() == Color.BLACK) {
            blackPlayerList.remove(piece);
            blackPlayerListOffBoard.add(piece);
            blackPlayerListOffBoardSize += 1;
        } else {
            whitePlayerList.remove(piece);
            whitePlayerListOffBoard.add(piece);
            whitePlayerListOffBoardSize += 1;
        }
    }

    ArrayList<Piece> getPiecesAlive(Color c){
        if(c == Color.BLACK){
            return new ArrayList<>(blackPlayerList);
        }else{
            return new ArrayList<>(whitePlayerList);
        }
    }

    public String getPiecesOnBoard(){
        String StringBuilder;
        String BlackPieces = getBlackPiecesOnBoard();
        String WhitePieces = getWhitePiecesOnBoard();

        StringBuilder = WhitePieces + "\n" + BlackPieces;
        return StringBuilder;
    }

    private String getWhitePiecesOnBoard(){
        ChessPieceIterator iterator = new ChessPieceIterator(this.whitePlayerList);
        String Pieces = "white pieces on board: ";
        while (iterator.hasNext()) {
            Pieces = Pieces.concat(iterator.next().toString() + " ");
        }
        return Pieces;

    }
    private String getBlackPiecesOnBoard(){
        ChessPieceIterator iterator = new ChessPieceIterator(this.blackPlayerList);
        String Pieces = "black pieces on board: ";
        while (iterator.hasNext()) {
            Pieces = Pieces.concat(iterator.next().toString() + " ");
        }
        return Pieces;
    }

    void replace(Piece o, Piece n){
        if(o.getColor() == n.getColor()){
            if(o.getColor() == Color.BLACK){
                blackPlayerList.remove(o);
                blackPlayerList.add(n);
            }else{
                whitePlayerList.remove(o);
                whitePlayerList.add(o);
            }
        }
    }

    String lostPieces() {
        StringBuilder list = new StringBuilder();

        list.append("Pieces lost: \n");

        list.append("Black: ");
        for (Piece element : blackPlayerListOffBoard) {
            list.append(element);
        }
        list.append("\n");

        list.append("White: ");
        for (Piece element : whitePlayerListOffBoard) {
            list.append(element);
        }
        list.append("\n");

        return list.toString();
    }

    public Piece getBlackPlayerListOffBoard(int i){
        return blackPlayerListOffBoard.get(i);
    }

    public Piece getWhitePlayerListOffBoard(int i){
        return whitePlayerListOffBoard.get(i);
    }

    public int blackPlayerListOffBoardSize(){
        int temp = blackPlayerListOffBoardSize;
        return temp;
    }
    public int whitePlayerListOffBoardSize(){
        int temp = whitePlayerListOffBoardSize;
        return temp;
    }
}

