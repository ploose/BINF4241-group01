package ChessGame;

import java.util.ArrayList;
import java.util.Iterator;

class PiecePotIterator implements Iterator<Piece> {
    private ArrayList<Piece> piecesAlive;
    private int position;

    PiecePotIterator(ArrayList<Piece> piecesAlive) {
        this.piecesAlive = piecesAlive;
        position = 0;
    }

    PiecePotIterator(Iterator<Piece> other) {
        readOut(other);

        position = 0;
    }

    public boolean hasNext() {
        return position < piecesAlive.size() && piecesAlive.get(position) != null;
    }

    public Piece next() {
        return piecesAlive.get(position++);
    }

   void restart() {
        position = 0;
    }

    void remove(Piece piece) {
        piecesAlive.remove(piece);
    }

    private void readOut(Iterator<Piece> other) {
        while (other.hasNext()) {
            piecesAlive.add(other.next());
        }
    }
}
