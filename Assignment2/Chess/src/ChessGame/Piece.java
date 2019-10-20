

package ChessGame;

import java.util.ArrayList;

abstract class Piece {
        final protected Color color;
        protected Square current;
        private boolean hasMoved;

        Piece(Color color, Square current){
                this.color = color;
                this.current = current;
                hasMoved = false;
        }

        Color getColor() {
                return color;
        }

        boolean hasMoved() {
                return hasMoved;
        }

        void move() {
                hasMoved = true;
        }

        public abstract ArrayList<Square> getMoveSquares(Board board);

        // Returns true if given square holds enemy, false if friendly
        protected boolean hasEnemy(Square s) {
                Piece target = (Piece) s.removePiece();
                s.addPiece(target);
                if (target.color != this.color) {
                        return true;
                }
                return false;
        }
}


