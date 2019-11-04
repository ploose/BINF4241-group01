package ChessGame;

import java.util.ArrayList;

public class ChessPieceIterator implements IIterator{

    ArrayList<Piece> pieceList;
    int position;


    public ChessPieceIterator(ArrayList<Piece> pieceList){
        this.pieceList = pieceList;
    }

    public Piece next(){
        Piece piece = pieceList.get(position);
        position += 1;
        return piece;
    }

    public boolean hasNext(){
        if (position >= pieceList.size() || pieceList.get(position) == null){
            return false;
        }
        else{
            return true;
        }
    }

}
