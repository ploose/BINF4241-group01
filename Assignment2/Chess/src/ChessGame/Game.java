package ChessGame;

class Game {
    private Board board;
    private Ui userInterface;
    private Player currentPlayer, black, white;
    private boolean isRunning;

    Game() {
        board = new Board(this);

        userInterface = new Ui();
        isRunning = false;

        getPlayers();

        currentPlayer = black;

        run();
    }

    private void getPlayers() {
        black = new Player(userInterface.getPlayerName(Color.BLACK), Color.BLACK);
        white = new Player(userInterface.getPlayerName(Color.WHITE), Color.WHITE);
    }

    private void run() {
        isRunning = true;


        while (isRunning) {
            boolean isValidMove = false;

            userInterface.printBoard(board.toString());
            userInterface.printScore(board.lostPieces());

            while (!isValidMove) {
                isValidMove = move();
            }

            swapPlayer();
        }
    }

    private boolean checkCheck() {
        return black.isChecked() || white.isChecked();
    }

    //TODO:
    private boolean checkCheckMate() {
        return false;
    }

    private boolean move() {
        String move = userInterface.getMove(currentPlayer);

        if (move.equals("castle long")) {
            if (castleLong()) {
                return true;
            } else {
                userInterface.printInvalidMove();
                return false;
            }

        } else if (move.equals("castle short")) {
            if (castleShort()) {
                return true;
            } else {
                userInterface.printInvalidMove();
                return false;
            }

        } else if (move.equals("en passent")) {
            if (enPassent()) {
                return true;
            } else {
                userInterface.printInvalidMove();
                return false;
            }

        } else if (checkInput(move)) {
            if (board.move(translate(move.charAt(1)), translate(move.charAt(0)), translate(move.charAt(7)), translate(move.charAt(6)), currentPlayer.getColor())) {
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

    private boolean enPassent() {

    }

    private void swapPlayer() {
        if (currentPlayer == black) {
            currentPlayer = white;
        } else {
            currentPlayer = black;
        }
    }

    void setWinner(Player winner) {
        isRunning = false;
        userInterface.celebrateWinner(winner);
    }

    private boolean checkInput(String move) {
        if (move.length() != 8) {
            return false;
        }

        boolean partOne = move.substring(0, 1).matches("[A-H]") && move.substring(1, 2).matches("[0-9]");
        boolean partTwo = move.substring(2, 6).matches(" to ");
        boolean partThree = move.substring(6, 7).matches("[A-H]") && move.substring(7, 8).matches("[0-9]");

        return partOne && partTwo && partThree;
    }

    private int translate(char current) {
        int num = 0;

        switch (current) {
            case 'A':
            case '1':
                num = 0;
                break;

            case 'B':
            case '2':
                num = 1;
                break;

            case 'C':
            case '3':
                num = 2;
                break;

            case 'D':
            case '4':
                num = 3;
                break;

            case 'E':
            case '5':
                num = 4;
                break;

            case 'F':
            case '6':
                num = 5;
                break;

            case 'G':
            case '7':
                num = 6;
                break;

            case 'H':
            case '8':
                num = 7;
                break;
        }
        return num;
    }
}
