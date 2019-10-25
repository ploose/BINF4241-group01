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
        board = new Board(this, userInterface);

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

            swapPlayer();
        }
    }

    // returns true if there is at least one remaining attacker for the king
    private boolean isKingTarget(Piece king,  ArrayList<Piece> enemyPieces){

        Iterator<Piece> ep = enemyPieces.iterator();
        Piece enemyPiece;

        while (ep.hasNext()){
            enemyPiece = ep.next();
            if(enemyPiece.getPossibleTargets().contains(king.current)){ // returns true if king is possible target
                return true;
            }
        }
        return false;
    }

    boolean checkCheck(Player p) {
        Piece king = board.getKingSquare(p).getCurrentPiece();
        ArrayList<Piece> enemyPieces = board.getEnemies(p);

        Iterator<Piece> ep = enemyPieces.iterator();
        Iterator<Square> ts;
        Square targetSquare;
        Piece piece;

        while (ep.hasNext()) {
            piece = ep.next();
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
/*  replaced by iterator - ToDelete
        for (Piece enemyPiece : enemyPieces) { // go through all enemy pieces
            for(Square targetSquare : enemyPiece.getPossibleTargets()) { // go through all their possible targets
                // squares

                if(targetSquare == king.current){

                    return true;
                }
            }
        }
        return false;
    }
*/

    private boolean checkCheckMate(Player p) {
        Piece king = board.getKingSquare(p).getCurrentPiece();
        ArrayList<Piece> friendlyPieces = board.getFriendlies(p);
        ArrayList<Piece> enemyPieces = board.getEnemies(p);
        Square tempSquare;
        Piece tempPiece;

        if (!isKingTarget(king, enemyPieces)) {
            return false;
        }
        Piece friendlyPiece;
        Square moveSquare;
        Square targetSquare;

        if (!isKingTarget(king, enemyPieces)) {
            return false;
        }

        Iterator<Piece> fp = friendlyPieces.iterator();

        // run through all friendly pieces
        while (fp.hasNext()) {
            friendlyPiece = fp.next();
            tempSquare = friendlyPiece.current;
            Iterator<Square> ms = friendlyPiece.getPossibleMoveSquares().iterator();
            while (ms.hasNext()) {
                moveSquare = ms.next();
                tempSquare.removePiece(); // temporarily remove piece for checking
                moveSquare.addPiece(friendlyPiece); // temporarily adds piece for checking
                friendlyPiece.current = moveSquare;
                board.refresh(); // refresh the move & eat squares of all pieces alive

                if (!isKingTarget(king, enemyPieces)) { // If the king can now move again he isn't in a checkMate
                    moveSquare.removePiece(); // remove piece
                    tempSquare.addPiece(friendlyPiece); // add piece back
                    friendlyPiece.current = tempSquare;
                    board.refresh(); // refresh the move & eat squares of all pieces alive
                    return false;
                }

                moveSquare.removePiece(); // remove piece
                tempSquare.addPiece(friendlyPiece); // add piece back
                friendlyPiece.current = tempSquare;
                board.refresh(); // refresh the move & eat squares of all pieces alive
            }

            Iterator<Square> ts = friendlyPiece.getPossibleTargets().iterator();
            while (ts.hasNext()) {
                targetSquare = ts.next();
                tempSquare.removePiece(); // temporarily remove piece for checking
                tempPiece = targetSquare.removePiece(); // temporarily remove target for checking
                enemyPieces.remove(tempPiece);
                targetSquare.addPiece(friendlyPiece); // temporarily adds piece for checking
                friendlyPiece.current = targetSquare;
                board.refresh(); // refresh the move & eat squares of all pieces alive

                if (!isKingTarget(king, enemyPieces)) { // If the king can now move again he isn't in a checkMate
                    targetSquare.removePiece(); // remove piece
                    targetSquare.addPiece(tempPiece); // add target back
                    enemyPieces.add(tempPiece);
                    tempSquare.addPiece(friendlyPiece); // add piece back
                    friendlyPiece.current = tempSquare;
                    board.refresh(); // refresh the move & eat squares of all pieces alive
                    return false;
                }

                targetSquare.removePiece(); // remove piece
                targetSquare.addPiece(tempPiece); // add target back
                enemyPieces.add(tempPiece);
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
            if (castleLong()) {
                return true;
            } else {
                userInterface.printInvalidMove();
                return false;
            }

        } else if (move.equals("o-o")) {
            if (castleShort()) {
                return true;
            } else {
                userInterface.printInvalidMove();
                return false;
            }

        } else if (checkInput(move, "move")) {
            if (board.move(translate(move.charAt(0)), translate(move.charAt(1)), translate(move.charAt(3)), translate(move.charAt(4)), currentPlayer.getColor())) {
                return true;
            } else {
                userInterface.printInvalidMove();
                return false;
            }

        } else if (checkInput(move, "eat")) {
            if (board.eat(translate(move.charAt(0)), translate(move.charAt(1)), translate(move.charAt(3)), translate(move.charAt(4)), currentPlayer.getColor())) {
                return true;
            } else {
                userInterface.printInvalidMove();
                return false;
            }

        } else if(checkInput(move, "promotion")) {
            return false;
        }

        else if (checkInput(move, "en passant")) {
            if (enPassant(translate(move.charAt(0)), translate(move.charAt(1)), translate(move.charAt(4)), translate(move.charAt(5)))) {
                return true;
            } else {
                userInterface.printInvalidMove();
                return false;
            }

        } else {
            return userInterface.printWrongInput();
        }
    }

    //TODO: add danger check
    private boolean castleLong() {
        if (currentPlayer.getColor() == Color.BLACK) {
            Square squareOne = board.getSquare(4, 0), squareTwo = board.getSquare(0, 0);

            if (!(squareOne.hasType("class ChessGame.King") && squareTwo.hasType("class ChessGame.Rook"))) {
                return false;
            }

            if (squareOne.getCurrentPiece().hasMoved() || squareTwo.getCurrentPiece().hasMoved()) {
                return false;
            }

            for (int i = 1; i < 4; i++) {
                if (board.getSquare(i, 0).isOccupied()) {
                    return false;
                }
            }

            Piece tmp = squareOne.removePiece();

            board.move(0, 0, 3, 0, currentPlayer.getColor());
            board.getSquare(2, 0).addPiece(tmp);
            tmp.hasMoved();

            return true;

        } else {
            Square squareOne = board.getSquare(4, 7), squareTwo = board.getSquare(0, 7);

            if (!(squareOne.hasType("class ChessGame.King") && squareTwo.hasType("class ChessGame.Rook"))) {
                return false;
            }

            if (squareOne.getCurrentPiece().hasMoved() || squareTwo.getCurrentPiece().hasMoved()) {
                return false;
            }

            for (int i = 1; i < 4; i++) {
                if (board.getSquare(i, 7).isOccupied()) {
                    return false;
                }
            }

            Piece tmp = squareOne.removePiece();

            board.move(0, 7, 3, 7, currentPlayer.getColor());
            board.getSquare(2, 7).addPiece(tmp);
            tmp.hasMoved();

            return true;
        }
    }

    //TODO: add danger check
    private boolean castleShort() {
        if (currentPlayer.getColor() == Color.BLACK) {
            Square squareOne = board.getSquare(4, 0), squareTwo = board.getSquare(7, 0);

            if (!(squareOne.hasType("class ChessGame.King") && squareTwo.hasType("class ChessGame.Rook"))) {
                return false;
            }

            if (squareOne.getCurrentPiece().hasMoved() || squareTwo.getCurrentPiece().hasMoved()) {
                return false;
            }

            for (int i = 5; i < 7; i++) {
                if (board.getSquare(i, 0).isOccupied()) {
                    return false;
                }
            }


            Piece tmp = squareOne.removePiece();

            board.move(7, 0, 5, 0, currentPlayer.getColor());
            board.getSquare(6, 0).addPiece(tmp);
            tmp.hasMoved();

            return true;

        } else {
            Square squareOne = board.getSquare(4, 7), squareTwo = board.getSquare(7, 7);

            if (!(squareOne.hasType("class ChessGame.King") && squareTwo.hasType("class ChessGame.Rook"))) {
                return false;
            }

            if (squareOne.getCurrentPiece().hasMoved() || squareTwo.getCurrentPiece().hasMoved()) {
                return false;
            }

            for (int i = 5; i < 7; i++) {
                if (board.getSquare(i, 7).isOccupied()) {
                    return false;
                }
            }

            Piece tmp = squareOne.removePiece();

            board.move(7, 7, 5, 7, currentPlayer.getColor());
            board.getSquare(6, 7).addPiece(tmp);
            tmp.hasMoved();

            return true;
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
                if (move.length() == 5) {
                    return move.substring(0, 1).matches("[a-h]") && move.substring(1, 2).matches("[0-9]") &&
                            move.substring(2, 3).matches("-") &&
                            move.substring(3, 4).matches("[a-h]") && move.substring(4, 5).matches("[0-9]");
                } else {
                    return false;
                }

            case "eat":
                if (move.length() == 5) {
                    return move.substring(0, 1).matches("[a-h]") && move.substring(1, 2).matches("[0-9]") &&
                            move.substring(2, 3).matches("x") &&
                            move.substring(3, 4).matches("[a-h]") && move.substring(4, 5).matches("[0-9]");
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
