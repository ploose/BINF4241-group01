# Snakes & Ladders by BINF4241-group25 (Brunner Tim, Looser Patrick, Marty Pascal)

## Rules
These are the rules of our Snakes & Ladders implementation: 
- All players start on the first square.
- Each turn, one player throws a dice and moves 1 - 6 squares.
- A player who lands on an already occupied square must go back
  to the first square.
- If the player lands on the bottom of a ladder, he will climb up it (if possible).
- If the player lands on the top of a snake, he will slide down it (if possible).
- If you roll a number higher than the number of squares
  needed to reach the last square, you will move back the remaining distance from the last square.
  - E.g. A board has 4 squares and you are on square 3. You need to throw a 1 but get a 3. 
  You will now move 1 move to the last square and then the remaining 2 moves back. You will thus land on square 2.
  - You don't move further back than the first square, even if there would be more moves.
- The game ends when the first player reaches the last square.

## Classes
Main class: TB, PM
    
    fields:

Game class: PL, PM, TB

    fields:
    - boolean isRunning
    - Players players
    - Player current
    - Player winner
    - Board board
    - Ui userInterface

    methods:
    - main
    - runTheGame
    - setWinner

Dice class: TB

    fields:
    - int value
    - Random generator

    methods:
    - Dice:
        input: none
        output: none
        //Constructor

    - throwDice:
        input: none
        output: a random generated int between 0 and 7 (exclusive)

Board class: PL

    fields:
    - DONE: ArrayList<Square> squareList
    - TODO: Players players
    - DONE: int size
    - DONE: firstSquare
    - DONE: lastSquare


    methods:
    - DONE: getSize()
        returns size

    - DONE: initBoard(int size, Queue playerQueue)
        fills board with squares and sets players on the first square

    - DONE: findSquare
    - DONE: setWinner

UI class: TB

    fields:
    - none

    methods:
    - getPlayers
    - printGame
    - celebrateWinner

Player class: PL

    fields:
    - Square currentSquare
    - String name

    methods:
    - DONE: getCurrentSquare
    - DONE: setCurrentSquare
    - DONE: moveFwd
    - DONE: getName

Players class: PL

    fields:
    - Queue<Player> playerQueue
    - ArrayList<Player> playerList

    methods:
    - DONE: initQueue
    - DONE: getQueue
    - DONE: remove
    - DONE: add
    - DONE: getCurrentPlayer


Squares abstract class: PM

    fields:
    - Board board
    - int index
    - boolean singleSpace
    - ArrayList<Player> currentPlayers
    - String type

    methods:
    - isOccupied()
        returns true if occupied, false if free

    - getIndex()
        returns index of square as int

    - addPlayer(Player p)
        takes Player p and adds it to ArrayList<Player> currentPlayers

    - removePlayer(Player p)
        removes Player p from ArrayList<Player> currentPlayers

    - getType()
        returns string which indicates the type of the square

    - setType(String type)
        sets type of square to given string (Needs to be a valid type!)

    - moveAndLand(int distance, Player p)
        given an integer distance and Player p, this method calculates & returns the square the player will move to

    - requestLanding(Player p)
        abstract method which gets implemented by children. The reason for this is, that it differs quite a bit across
        the types of squares.


NormalSquare class PM
    fields:
    - inherits all fields from abstract class Squares

    methods:
    - inherits all methods from abstract class Squares

    - requestLanding(Player p)
        if it isn't occupied, it returns itself, else null (which the calling square understands as
        "couldn't land here")


FirstSquare class PM

    fields:
    - inherits all fields from abstract class Squares

    methods:
    - inherits all methods from abstract class Squares

    - requestLanding(Player p)
        always returns itself as there can be limitless players on the FirstSquare


LastSquare class PM

    fields:
        - inherits all fields from abstract class Squares

        methods:
        - inherits all methods from abstract class Squares

        - requestLanding(Player p)
            always returns itself (because it can only be occupied once, then the game ends, so no need to check whether
            there is already a player on it).
            tells the board that Player p won the game with setWinner(p)


LadderSquare class PM

    fields:
        - inherits all fields from abstract class Squares
        - int jumpDistance

        methods:
        - inherits all methods from abstract class Squares

        - constructor (... , int indexNext)
            initializes distance to targetSquare with own index and indexNext of next square

        - requestLanding(Player p)
            just passes on call to next square via call with jumpDistance and Player p


SnakeSquare class PM

    fields:
        - inherits all fields from abstract class Squares
        - int jumpDistance
        - Square squareTarget

        methods:
        - inherits all methods from abstract class Squares

        - constructor (... , int indexNext)
            initializes distance to targetSquare with own index and indexNext of next square

        - requestLanding(Player p)
            just passes on call to next square via call with jumpDistance and Player p




