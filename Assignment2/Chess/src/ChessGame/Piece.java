package ChessGame;

import java.util.ArrayList;

abstract class Piece implements MovementStrategy{
        final protected Color color;
        protected Square current;
        protected boolean hasMoved;
        protected ArrayList<Square> possibleMoveSquares;
        protected ArrayList<Square> canEat;


        Piece(Color color, Square current){
                this.color = color;
                this.current = current;
                hasMoved = false;

                possibleMoveSquares = new ArrayList<>();
                canEat = new ArrayList<>();
        }

        protected void clearLists(){
            possibleMoveSquares.clear();
            canEat.clear();
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
                        this.current = next;
                        return true;
                } else {
                        return false;
                }
        }


        // Move that is always valid. Necessary to put the pawn back to his original spot.
        public boolean forcedMove(Square current, Square next, final Square[][] squares) {
        getMoveSquares(squares);
            this.current = next;
            return true;
    }

        public boolean eat(Square current, Square next, final Square[][] squares) {
            getMoveSquares(squares);

            if (isValidAttack(current, next)) {
                hasMoved = true;
                this.current = next;
                return true;
            } else {
                return false;
            }
        }

        protected boolean isValidMove(Square current, Square next) {
            return current == this.current && possibleMoveSquares.contains(next);
        }

        protected boolean isValidAttack(Square current, Square next) {
            return current == this.current && canEat.contains(next);
        }

        protected abstract void getMoveSquares(final Square[][] squares);

        protected ArrayList<Square> getPossibleMoveSquares(){
            return new ArrayList<Square>(possibleMoveSquares);
        }

        protected ArrayList<Square> getPossibleTargets(){
            return new ArrayList<Square>(canEat);
        }

        protected void straightUp(final Square[][] squares, int speed) {
                int y = current.y - 1;
                Square temp;

                for (int i = 0; i < speed; i++) {
                        if (y >= 0) {
                                temp = squares[current.x][y];
                                // Add square if empty or enemy on it
                                if (temp.isOccupied()) {
                                        if(hasEnemy(temp)){
                                            if(!canEat.contains(temp)){
                                                canEat.add(temp);
                                                possibleMoveSquares.remove(temp);
                                            }
                                        }
                                        break;
                                } else {
                                    if(!possibleMoveSquares.contains(temp)){
                                        possibleMoveSquares.add(temp);
                                        canEat.remove(temp);
                                    }
                                }
                                y--;
                        }
                }
        }

        protected void straightDown(final Square[][] squares, int speed) {
                int y = current.y + 1;
                Square temp;

                for (int i = 0; i < speed; i++) {
                        if (y <= 7) {
                                temp = squares[current.x][y];
                                // Add square if empty or enemy on it
                                if (temp.isOccupied()) {
                                        if(hasEnemy(temp)){
                                            if(!canEat.contains(temp)){
                                                canEat.add(temp);
                                                possibleMoveSquares.remove(temp);
                                            }
                                        }
                                        break;
                                } else {
                                    if(!possibleMoveSquares.contains(temp)){
                                        possibleMoveSquares.add(temp);
                                        canEat.remove(temp);
                                    }
                                }
                                y++;
                        }
                }
        }

        protected void straightRight(final Square[][] squares, int speed) {
                int x = current.x + 1;
                Square temp;

                for (int i = 0; i < speed; i++) {
                        if (x <= 7) {
                                temp = squares[x][current.y];
                                // Add square if empty or enemy on it
                                if (temp.isOccupied()) {
                                        if(hasEnemy(temp)){
                                            if(!canEat.contains(temp)){
                                                canEat.add(temp);
                                                possibleMoveSquares.remove(temp);
                                            }
                                        }
                                        break;
                                } else {
                                    if(!possibleMoveSquares.contains(temp)){
                                        possibleMoveSquares.add(temp);
                                        canEat.remove(temp);
                                    }
                                }
                                x++;
                        }
                }
        }

        protected void straightLeft(final Square[][] squares, int speed) {
                int x = current.x - 1;
                Square temp;

                for (int i = 0; i < speed; i++) {
                        if (x >= 0) {
                                temp = squares[x][current.y];
                                // Add square if empty or enemy on it
                                if (temp.isOccupied()) {
                                        if(hasEnemy(temp)){
                                            if(!canEat.contains(temp)){
                                                canEat.add(temp);
                                                possibleMoveSquares.remove(temp);
                                            }
                                        }
                                        break;
                                } else {
                                    if(!possibleMoveSquares.contains(temp)){
                                        possibleMoveSquares.add(temp);
                                        canEat.remove(temp);
                                    }
                                }
                                x--;
                        }
                }
        }

        protected void diagonalUpLeft(final Square[][] squares, int speed) {
            int x = current.x - 1, y = current.y - 1;
            Square temp;

            for (int i = 0; i < speed; i++) {
                if (x >= 0 && y >= 0) {
                    temp = squares[x][y];

                    // Add square if empty or enemy on it
                    if (temp.isOccupied()) {
                        if(hasEnemy(temp)){
                            if(!canEat.contains(temp)){
                                canEat.add(temp);
                                possibleMoveSquares.remove(temp);
                            }
                        }
                        break;
                    } else {
                        if(!possibleMoveSquares.contains(temp)){
                            possibleMoveSquares.add(temp);
                            canEat.remove(temp);
                        }
                    }
                    x--;
                    y--;
                }
            }
        }

        protected void diagonalUpRight(final Square[][] squares, int speed) {
            int x = current.x + 1, y = current.y - 1;
            Square temp;

            for (int i = 0; i < speed; i++) {
                if (x <= 7 && y >= 0) {
                    temp = squares[x][y];

                    // Add square if empty or enemy on it
                    if (temp.isOccupied()) {
                        if(hasEnemy(temp)){
                            if(!canEat.contains(temp)){
                                canEat.add(temp);
                                possibleMoveSquares.remove(temp);
                            }
                        }
                        break;
                    } else {
                        if(!possibleMoveSquares.contains(temp)){
                            possibleMoveSquares.add(temp);
                            canEat.remove(temp);
                        }
                    }
                    x++;
                    y--;
                }
            }
        }

        protected void diagonalDownLeft(final Square[][] squares, int speed) {
            int x = current.x - 1, y = current.y + 1;
            Square temp;

            for (int i = 0; i < speed; i++) {
                if (x >= 0 && y <= 7) {
                    temp = squares[x][y];

                    // Add square if empty or enemy on it
                    if (temp.isOccupied()) {
                        if(hasEnemy(temp)){
                            if(!canEat.contains(temp)){
                                canEat.add(temp);
                                possibleMoveSquares.remove(temp);
                            }
                        }
                        break;
                    } else {
                        if(!possibleMoveSquares.contains(temp)){
                            possibleMoveSquares.add(temp);
                            canEat.remove(temp);
                        }
                    }
                    x--;
                    y++;
                }
            }
        }

        protected void diagonalDownRight(final Square[][] squares, int speed) {
            int x = current.x + 1, y = current.y + 1;
            Square temp;

            for (int i = 0; i < speed; i++) {
                if (x <= 7 && y <= 7) {
                    temp = squares[x][y];

                    // Add square if empty or enemy on it
                    if (temp.isOccupied()) {
                        if(hasEnemy(temp)){
                            if(!canEat.contains(temp)){
                                canEat.add(temp);
                                possibleMoveSquares.remove(temp);
                            }
                        }
                        break;
                    } else {
                        if(!possibleMoveSquares.contains(temp)){
                            possibleMoveSquares.add(temp);
                            canEat.remove(temp);
                        }
                    }
                    x++;
                    y++;
                }
            }
        }

        // Returns true if given square holds enemy, false if friendly
        protected boolean hasEnemy(Square s) {
                Piece target = s.removePiece();
                s.addPiece(target);

                return target.color != this.color;
        }
}


