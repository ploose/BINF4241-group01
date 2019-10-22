package ChessGame;

import java.util.ArrayList;

abstract class Piece implements MovementStrategy{
        final protected Color color;
        protected Square current;
        protected boolean hasMoved;
        protected ArrayList<Square> possibleMoveSquares;

        Piece(Color color, Square current){
                this.color = color;
                this.current = current;
                hasMoved = false;

                possibleMoveSquares = new ArrayList<>();
        }

        public Color getColor() {
                return color;
        }

        public boolean hasMoved() {
                return hasMoved;
        }

        public boolean move(Square current, Square next, final Square[][] squares) {
                getMoveSquares(squares);

                if (isValidMove(current, next)) {
                        hasMoved = true;
                        return true;
                } else {
                        return false;
                }
        }

        protected boolean isValidMove(Square current, Square next) {
                return current == this.current && possibleMoveSquares.contains(next);
        }

        protected abstract void getMoveSquares(Square[][] squares);

        // Returns true if given square holds enemy, false if friendly
        protected boolean hasEnemy(Square s) {
                Piece target = s.removePiece();
                s.addPiece(target);

                return target.color != this.color;
        }
}


