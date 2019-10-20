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
            return castleLong();
        } else if (move.equals("en passent")) {
            return board.enPassent(currentPlayer.getColor());
        } else if (checkInput(move)) {
            return board.move(translate(move.charAt(0)), translate(move.charAt(1)), translate(move.charAt(6)), translate(move.charAt(7)));
        } else {
            return userInterface.printWrongInput();
        }
    }

    //TODO:
    private boolean castleLong() {
        if (currentPlayer.getColor() == Color.BLACK) {
            Square squareOne = board.getSquare(4, 0), squareTwo = board.getSquare(0, 0);

            if (!(squareOne.hasType("King") && squareTwo.hasType("Rook"))) {
                return false;
            }

            if (squareOne.getCurrentPiece().hasMoved() && squareTwo.getCurrentPiece().hasMoved()) {
                return false;
            }

            if (board.getSquare(1, 0).isOccupied() && board.getSquare(2, 0).isOccupied()
                    && board.getSquare(3, 0).isOccupied()) {
                return false;
            }

            Piece tmp = squareOne.removePiece();

            board.move(0, 0, 4, 0);
            squareTwo.addPiece(tmp);

        } else {

        }
        return true;
    }

    //TODO:
    private boolean castleShort(Color color) {
        return true;
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
            case '0':
                num = 0;
                break;

            case 'B':
            case '1':
                num = 1;
                break;

            case 'C':
            case '2':
                num = 2;
                break;

            case 'D':
            case '3':
                num = 3;
                break;

            case 'E':
            case '4':
                num = 4;
                break;

            case 'F':
            case '5':
                num = 5;
                break;

            case 'G':
            case '6':
                num = 6;
                break;

            case 'H':
            case '7':
                num = 7;
                break;
        }
        System.out.println(num);
        return num;
    }
}
