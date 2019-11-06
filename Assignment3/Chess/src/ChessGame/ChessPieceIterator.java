package ChessGame;

import java.util.ArrayList;

public class ChessPieceIterator implements IIterator{
    private ArrayList<Piece> pieceList;
    private int position;

    ChessPieceIterator(ArrayList<Piece> pieceList){
        this.pieceList = pieceList;
    }

    public Piece next(){
        Piece piece = pieceList.get(position);
        position += 1;
        return piece;
    }

    public boolean hasNext(){
        return position < pieceList.size() && pieceList.get(position) != null;
    }

}
