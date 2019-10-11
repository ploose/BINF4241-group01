package src.ChessGame;

import src.ChessGame.Enums.*;

abstract class Piece {
    final private Color color;

    Piece(Color color) {
        this.color = color;
    }

    Color getColor() {
        return color;
    }

    abstract boolean isValidMove(Square current, Square next);
}
