

package ChessGame;

import java.util.ArrayList;

abstract class Piece {
        protected Color color;
        protected Square current;

        Piece(Color color, Square current){
                this.color = color;
                this.current = current;
        }

        Color getColor() {
                return color;
        }

        public abstract ArrayList<Square> getMoveSquares(Board board);
        // public abstract Square getCurrentSquare();
        // public abstract ArrayList<Square> getAttackedSquares();

/*
        private boolean hasMoved;
        MovementStrategy strategy;
        MovementStrategy


        Piece(Color color, MovementStrategy strategy, MovementStrategy IPawn){
            this.color = color;
            this.strategy = strategy;
            this.specialStrategy = strategy

            Piece(Color colorFromClient, MovementStrategy strategy, MovementStrategy IPawn){
            final Color color = colorFromClient;


        } */
}


