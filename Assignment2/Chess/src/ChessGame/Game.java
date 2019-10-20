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

        boolean isValidMove = false;

        while (isRunning) {
            userInterface.printBoard(board.toString());
            userInterface.printScore(board.lostPieces());

            isRunning = false;

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

        if (move.equals("castle")) {
            return board.castle(currentPlayer.getColor());
        } else if (move.equals("en passent")) {
            return board.enPassent(currentPlayer.getColor());
        } else if (checkInput(move)) {
            return board.move(translate(move.charAt(0)), move.charAt(1), translate(move.charAt(6)), move.charAt(7));
        } else {
            return userInterface.printWrongInput();
        }
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
                num = 0;

            case 'B':
                num = 1;

            case 'C':
                num = 2;

            case 'D':
                num = 3;

            case 'E':
                num = 4;

            case 'F':
                num = 5;

            case 'G':
                num = 6;

            case 'H':
                num = 7;
        }

        return num;
    }
}
