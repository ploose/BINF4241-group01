package ChessGame;

import java.util.*;

class Game {
    private Board board;
    private Ui userInterface;
    private Player currentPlayer, black, white;
    private boolean isRunning;
    private String move;
    private ArrayList<String> log;


    Game() {
        userInterface = new Ui();
        board = new Board(this);

        isRunning = false;

        getPlayers();

        currentPlayer = black;

        log = new ArrayList<>();




        run();
    }

    private void getPlayers() {
        black = new Player(userInterface.getPlayerName(Color.BLACK), Color.BLACK);
        white = new Player(userInterface.getPlayerName(Color.WHITE), Color.WHITE);
    }

    Player getPlayer(Color color) {
        if (color == Color.BLACK){
            return black;
        }
        else{
            return white;
        }
    }

    private void run() {
        isRunning = true;

        userInterface.printBoard(board.toString());
        userInterface.printPieces(board.getPieces());

        while (isRunning) {
            boolean isValidMove = false;

            board.refresh();

            if (checkCheck(white)) {
                if(checkCheckMate(white)) {
                    userInterface.celebrateWinner(black);
                    break;
                } else {

                    userInterface.check();
                }

            }

            if (checkCheck(black)) {
                if (checkCheckMate(black)) {
                    userInterface.celebrateWinner(white);
                    break;
                } else {
                    userInterface.check();
                }
            }

            while (!isValidMove) {
                isValidMove = move();
            }

            log.add(move);

            userInterface.printBoard(board.toString());
            userInterface.printScore(board.lostPieces());
            board.refreshScoreboard();
            userInterface.printScoreBoard(board.scores());


            swapPlayer();
        }
    }

    // returns true if there is at least one remaining attacker for the king
    private boolean isKingFree(Piece king,  Iterator<Piece> enemyPieces){
        Piece enemyPiece;

        while (enemyPieces.hasNext()){
            enemyPiece = enemyPieces.next();
            if(enemyPiece.getPossibleTargets().contains(king.current)){ // returns true if king is possible target
                return false;
            }
        }

        return true;
    }

    boolean checkCheck(Player p) {
        Piece king = board.getKingSquare(p).getCurrentPiece();
        Iterator<Piece> enemyPieces = board.getEnemies(p);

        Iterator<Square> ts;
        Square targetSquare;
        Piece piece;

        while (enemyPieces.hasNext()) {
            piece = enemyPieces.next();
            ts = piece.getPossibleTargets().iterator();
            while (ts.hasNext()) {
                targetSquare = ts.next();
                if (targetSquare == king.current) {

                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkCheckMate(Player p) {
        Piece king = board.getKingSquare(p).getCurrentPiece(), tempPiece, friendlyPiece;

        PiecePotIterator friendlyPieces = board.getFriendlies(p);
        PiecePotIterator enemyPieces = board.getEnemies(p);

        Square tempSquare, moveSquare, targetSquare;

        if (isKingFree(king, enemyPieces)) {
            return false;
        }

        enemyPieces.restart();

        // run through all friendly pieces
        while (friendlyPieces.hasNext()) {
            friendlyPiece = friendlyPieces.next();
            tempSquare = friendlyPiece.current;

            for (Square square : friendlyPiece.getPossibleMoveSquares()) {
                moveSquare = square;

                tempSquare.removePiece(); // temporarily remove piece for checking
                moveSquare.addPiece(friendlyPiece); // temporarily adds piece for checking

                friendlyPiece.current = moveSquare;
                board.refresh(); // refresh the move & eat squares of all pieces alive

                if (isKingFree(king, enemyPieces)) { // If the king can now move again he isn't in a checkMate
                    moveSquare.removePiece(); // remove piece
                    tempSquare.addPiece(friendlyPiece); // add piece back

                    friendlyPiece.current = tempSquare;
                    board.refresh(); // refresh the move & eat squares of all pieces alive

                    return false;
                }

                enemyPieces.restart();

                moveSquare.removePiece(); // remove piece
                tempSquare.addPiece(friendlyPiece); // add piece back

                friendlyPiece.current = tempSquare;
                board.refresh(); // refresh the move & eat squares of all pieces alive
            }

            for (Square square : friendlyPiece.getPossibleTargets()) {
                targetSquare = square;

                tempSquare.removePiece(); // temporarily remove piece for checking
                tempPiece = targetSquare.removePiece(); // temporarily remove target for checking

                enemyPieces.remove(tempPiece);
                targetSquare.addPiece(friendlyPiece); // temporarily adds piece for checking

                friendlyPiece.current = targetSquare;
                board.refresh(); // refresh the move & eat squares of all pieces alive

                if (isKingFree(king, enemyPieces)) { // If the king can now move again he isn't in a checkMate
                    targetSquare.removePiece(); // remove piece
                    targetSquare.addPiece(tempPiece); // add target back

                    tempSquare.addPiece(friendlyPiece); // add piece back

                    friendlyPiece.current = tempSquare;
                    board.refresh(); // refresh the move & eat squares of all pieces alive

                    return false;
                }

                targetSquare.removePiece(); // remove piece
                targetSquare.addPiece(tempPiece); // add target back

                tempSquare.addPiece(friendlyPiece); // add piece back
                friendlyPiece.current = tempSquare;

                board.refresh(); // refresh the move & eat squares of all pieces alive
            }
        }

        return true;
    }

    private boolean move() {
        move = userInterface.getMove(currentPlayer);

        if (move.equals("o-o-o")) {
            if (board.castleLong(currentPlayer.getColor())) {
                return true;
            } else {
                userInterface.printInvalidMove();
                return false;
            }

        } else if (move.equals("o-o")) {
            if (board.castleShort(currentPlayer.getColor())) {
                return true;
            } else {
                userInterface.printInvalidMove();
                return false;
            }

        } else if (checkInput(move, "move")) {
            if (move.length() == 6 && board.move(translate(move.charAt(1)), translate(move.charAt(2)), translate(move.charAt(4)),
                    translate(move.charAt(5)), currentPlayer.getColor())) {
                return true;
            }else if (move.length() == 5 && board.move(translate(move.charAt(0)), translate(move.charAt(1)), translate(move.charAt(3)),
                    translate(move.charAt(4)), currentPlayer.getColor())) {
                return true;
            } else {
                userInterface.printInvalidMove();
                return false;
            }

        } else if (checkInput(move, "eat")) {
            if (move.length() == 6 && board.eat(translate(move.charAt(1)), translate(move.charAt(2)), translate(move.charAt(4)),
                    translate(move.charAt(5)), currentPlayer.getColor())) {
                return true;
            }else if (move.length() == 5 && board.eat(translate(move.charAt(0)), translate(move.charAt(1)), translate(move.charAt(3)),
                    translate(move.charAt(4)), currentPlayer.getColor())) {
                return true;
            } else {
                userInterface.printInvalidMove();
                return false;
            }

        } else if(checkInput(move, "promotion")) {
            if (board.promotion(translate(move.charAt(0)), translate(move.charAt(1)), translate(move.charAt(3)),
                    translate(move.charAt(4)), move.substring(4, 5), currentPlayer.getColor())) {
                return true;
            } else {
                userInterface.printInvalidMove();
                return false;
            }
        }

        else if (checkInput(move, "en passant")) {
            if (enPassant(translate(move.charAt(0)), translate(move.charAt(1)), translate(move.charAt(4)),
                    translate(move.charAt(5)))) {
                return true;
            } else {
                userInterface.printInvalidMove();
                return false;
            }

        } else {
            return userInterface.printWrongInput();
        }
    }

    private boolean enPassant(int x1, int y1, int x2, int y2) {
        String check = log.get(log.size() -1);

        if (!board.getSquare(x1, y1).isOccupied()) {
            return false;
        }

        if (currentPlayer.getColor() == Color.BLACK) {
            if (board.getSquare(x2, y2 + 1).isOccupied()) {
                if (board.getSquare(x2, y2 + 1).getCurrentPiece().getColor() == Color.BLACK) {
                    return false;
                }

                return false;
            }

            if (translate(check.charAt(1)) != (y2 + 1) && translate(check.charAt(0)) != x2) {
                return false;
            }

            if (translate(check.charAt(4)) != (y2 - 1) && translate(check.charAt(3)) != x2) {
                return false;
            }

        } else {
            if (board.getSquare(x2, y2 - 1).isOccupied()) {
                if (board.getSquare(x2, y2 - 1).getCurrentPiece().getColor() == Color.WHITE) {
                    return false;
                }

                return false;
            }

            if (translate(check.charAt(1)) != (y2 - 1) && translate(check.charAt(0)) != x2) {
                return false;
            }

            if (translate(check.charAt(4)) != (y2 + 1) && translate(check.charAt(3)) != x2) {
                return false;
            }

        }

        board.enPassant(x1, y1, x2, y2, currentPlayer.getColor());
        return true;
    }

    private void swapPlayer() {
        if (currentPlayer == black) {
            currentPlayer = white;
        } else {
            currentPlayer = black;
        }
    }

    private boolean checkInput(String move, String mode) {
        switch (mode) {
            case "move":
                if (move.length() == 6) {
                    return move.substring(0, 1).matches("[TNBKQ]") && move.substring(1, 2).matches("[a-h]") &&
                            move.substring(2, 3).matches("[0-9]") && move.substring(3, 4).matches("-") &&
                            move.substring(4, 5).matches("[a-h]") && move.substring(5, 6).matches("[0-9]");
                }else if (move.length() == 5) {
                    return move.substring(0, 1).matches("[a-h]") &&
                            move.substring(1, 2).matches("[0-9]") && move.substring(2, 3).matches("-") &&
                            move.substring(3, 4).matches("[a-h]") && move.substring(4, 5).matches("[0-9]") &&
                            (board.getSquare(translate(move.charAt(0)), translate(move.charAt(1))).getCurrentPiece().getClass() == Pawn.class);

                } else {
                    return false;
                }

            case "eat":
                if (move.length() == 6) {
                    return move.substring(0, 1).matches("[TNBKQ]") && move.substring(1, 2).matches("[a-h]") &&
                            move.substring(2, 3).matches("[0-9]") && move.substring(3, 4).matches("x") &&
                            move.substring(4, 5).matches("[a-h]") && move.substring(5, 6).matches("[0-9]");
                }else if (move.length() == 5) {
                    return move.substring(0, 1).matches("[a-h]") &&
                            move.substring(1, 2).matches("[0-9]") && move.substring(2, 3).matches("x") &&
                            move.substring(3, 4).matches("[a-h]") && move.substring(4, 5).matches("[0-9]") &&
                            (board.getSquare(translate(move.charAt(0)), translate(move.charAt(1))).getCurrentPiece().getClass() == Pawn.class);

                } else {
                    return false;
                }

            case "en passant":
                if (move.length() == 6) {
                    return move.substring(0, 1).matches("[a-h]") && move.substring(1, 2).matches("[0-9]") &&
                            move.substring(2, 4).matches("ep") &&
                            move.substring(4, 5).matches("[a-h]") && move.substring(5, 6).matches("[0-9]");
                } else {
                    return false;
                }

            case "promotion":
                if (move.length() == 7) {
                    return move.substring(0, 1).matches("[a-h]") && move.substring(1, 2).matches("[0-9]") &&
                            move.substring(2, 3).matches("-") &&
                            move.substring(3, 4).matches("[a-h]") && move.substring(4, 5).matches("[0-9]") &&
                            move.substring(5, 6).matches("=") && move.substring(6, 7).matches("[TNBQ]");
                } else {
                    return false;
                }

            default:
                return false;
        }
    }


    private int translate(char current) {
        int num = 0;

        switch (current) {
            case 'a':
            case '8':
                num = 0;
                break;

            case 'b':
            case '7':
                num = 1;
                break;

            case 'c':
            case '6':
                num = 2;
                break;

            case 'd':
            case '5':
                num = 3;
                break;

            case 'e':
            case '4':
                num = 4;
                break;

            case 'f':
            case '3':
                num = 5;
                break;

            case 'g':
            case '2':
                num = 6;
                break;

            case 'h':
            case '1':
                num = 7;
                break;
        }
        return num;
    }
}