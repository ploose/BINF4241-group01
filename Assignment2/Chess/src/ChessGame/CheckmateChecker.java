package ChessGame;

import java.util.ArrayList;

class CheckmateChecker {
    private Square kingSquare;
    private boolean isChecked;
    private Board board;
    private Color color;
    private PiecePot piecePot;
    private Piece piece;

// TODO:      - Can i move out of mate?
//            - Can I block mate?
//            - Can I take the attacker?

    // Returns if the square is checked -> should be games responsibility
    /*
    private boolean isChecked(PiecePot piecePot, Square kingSquare, Color color){
        isChecked = false;

        for(int i = 0; i < piecePot.getOnBoardSize(color); i++) {
            piece = piecePot.getOnBoard(i, color);
            for (Square square : piece.getMoveSquares(board.)) {
                if (square == kingSquare) {
                    isChecked = true;
                    break;
                }
            }
        }

        return isChecked;
    }

     */

    /*
    public boolean isCheckMate(PiecePot piecePot, Square kingSquare, Color color, ArrayList<Square> attackedSquares, King king){
        boolean canMoveOut = false;
        boolean canBlock = false;
        boolean canTake =false;
        ArrayList<Square> safeSquares = king.getMoveSquares(board); //TODO: board shouldn't be a parameter
        Piece attacker = null;
        Piece piece;

        if (!(isChecked(piecePot, kingSquare, color))){
            return false;
        }

        // TODO: Implement getCurrentSquare
        if (piecePot.getOnBoardSize(color) == 1) {
            safeSquares.add(kingSquare);
        }

        for(int i = 0; i < piecePot.getOnBoardSize(color); i++){
            piece = piecePot.getOnBoard(i, color);

            for (Square attackedSquare : piece.getMoveSquares(board)) {
                if (safeSquares.contains(attackedSquare)){
                    safeSquares.remove(attackedSquare);
                    attacker = piece;
                }
            }
        }
        // until here, we have a list of squares that the king can move to without being attacked
        // check if there are any safe squares

        // TODO: Change this
        canMoveOut = !safeSquares.isEmpty();

        // TODO: CanBlock
        //canBlock. Needed for: Queen, Bishop, Rook



        //canEat
        if (king.getMoveSquares(board).contains(attacker.getMoveSquares(board))){
            canTake = true;
        }

        //Final check
        if (canMoveOut || canBlock || canTake) {
                return false;
        } else {
                return true;
        }
    }

     */
}

