package ChessGame;

import java.util.ArrayList;

public class CheckmateChecker {

    Square kingSquare;
    boolean isChecked;
    Board board;
    Color color;
    PiecePot piecePot;
    Object piece;

// TODO:      - Can i move out of mate?
//            - Can I block mate?
//            - Can I take the attacker?

    public boolean isChecked(PiecePot piecePot, Square kingSquare, Color color){

        boolean isChecked = false;

        if (color == Color.WHITE){
            for (Object piece : piecePot.whitePlayerList){
                for (Square square : piece.getAttackedSquares){
                    if (square == kingSquare){
                        isChecked = true;
                    }
                }
            }
        }
        else{
            for (Object piece : piecePot.blackPlayerList){
                for (Square square : piece.getAttackedSquares){
                    if (square == kingSquare){
                        isChecked = true;
                    }
                }
            }
            }
        return isChecked;
        // Returns if the square is checked

        }
     public boolean isCheckMate(PiecePot piecePot, Square kingSquare, Color color, ArrayList<Square> attackedSquares, King king){
        boolean isCheckMate;
        if (!(isChecked(piecePot, kingSquare, color))){isCheckMate = false;}

     else{
         Object piece;
         //requirements of which at least one has to be true for the king to not be checkmated
         boolean canMoveOut;
         boolean canBlock;
         boolean canTake;
         ArrayList<Square> safeSquares = king.getMoveSquares();
         Object attacker = null;


         //move out
            if(color == Color.WHITE) {
                // TODO: Implement getCurrentSquare
                if (piecePot.getWhiteOnBoardCounter() == 1) { safeSquares.add(king.getCurrentSquare)}
                int whiteOnBoard = piecePot.getWhiteOnBoardCounter();
                for(int i = 0; i < whiteOnBoard; i++){
                    piece = piecePot.getWhiteOnBoard(i);


                    for (Square attackedSquare : piece.getMoveSquares()) {
                        if (safeSquares.contains(attackedSquare)){
                            safeSquares.remove(attackedSquare);
                            attacker = piece;
                        }

                    }
                }
                // until here, we have a list of pieces that the king can move to without being attacked
                // check if there are any safe squares

                // TODO: Change this
                if (safeSquares.isEmpty()){
                    canMoveOut = false;
                }
                else{
                    canMoveOut = true;
                }

                // TODO: CanBlock
                //canBlock. Needed for: Queen, Bishop, Rook



                //canEat
                if (king.getMoveSquares().contains(attacker.getCurrentSquare())){
                    canTake = true;
                }
            }

            //The same process for the black pieces
            else{
                

            }

         //take attacker

         //Block attacker
        }


    }


    }

