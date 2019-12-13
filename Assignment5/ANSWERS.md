#Part 1
- Implemented & documented all tests
## General Findings
In general there were no fundamental bugs in our code. What we found out due to the testing is,
that we relied on checking whether a parameter was valid (e.g. in the correct range) at only one point in the code.
The code has now been adapted to make the classes more independent from each other. They now individually check 
whether the received parameters are indeed to the required specification.

## Further Remarks
- The methods of the parent class square are only tested in the NormalSquareTest class. 
Only square type which would differ in its usage / testing would be the FirstSquare, which is able to receive
more than one player (therefore the tests for addPlayer() and isOccupied() whit an occupied square would be absent).
- The moveAndLand() method in the square parent class hasn't been explicitly testet because it's already been indirectly
tested in the PlayerTest class.


#Part 2
##Failing tests:
- GameBoardTest:
    - markTwice
    - getOpenPosition
    - getOpenPositionAll
    - markOnBoard
        
- TicTacToeGameStateTest:
    - startingPlayerIsX
    - isOverWin
    - getAvailableStatesLastO
    - hasWinCol
    - hasWinRow
    - hasWinDiagonal
    - switchPlayer

##Bugs:
Disclaimer: I had to change the package name for my IDE.

- GameBoardTest:
  - markTwice / markOnBoard:
    In the method mark of the class GameBoard was a bug which was resulting in that you were only able to place
    a mark on an already marked field. The fix to this bug was easy: just switch the return statements.
            
  - getOpenPosition / getOpenPositionAll:
    The method getOpenPosition of the class GameBoard was only iterating over all rows but not all columns. It 
    ignored the column '0'. This bug could be fixed by changing the range of the second for-loop from 
    (int col = 1; col < COLS; col++) to (int col = 0; col < COLS; col++).
    
- TicTacToeGameStateTest:
    - startingPlayerIsX / getAvailableStatesLastO / switchPlayer:
      In the method getCurrentPlayer of the class TicTacToeGameState there was a bug, which forced the method to always
      return the player O. The bug was fixed by simply return the field 'currentPlayer'.
      
    - hasWinCol / hasWinRow / isOverWin:
      The bug failing the tests was found in the method hasWin of the class TicTacToeGameState. The problem was, that if
      a player won by having 3 marks in one row/column, the method would return false and skip the hasWinDiagonal check.
      
    - hasWinDiagonal:
      There was a bug in the completeDiagonal method of the class TicTacToeGameState. The method checked a wrong field
      (field (1, 2)) for which it was never possible to reach a diagonal win. The bug could be fixed by changing the
      field from (1, 2) to (2, 2).

#Part 3

1: Inputs at the start of the game:

- Number of players:	The input should be a number between two and ten. If the user gives such a number, the program will continue.
			If the user enters an invalid input, the program should give a notification, that the input is invalid and ask the user for input again.
			If the input is valid, the program continues and in the next step asks the user to enter the player names.

- Player names:		After the getting the number of players, the system should ask the name of every player participating in the game.
			The names should be entered in 2-10 alphabetical characters.
			If the user enters an invalid input, the program asks the user to type a name with 2-10 letters.
			If the input is valid, the program will start the game:



The programs set up the game:
 - create the deck
 - shuffle the deck
 - give every player 7 cards
 - create a draw pile
 - create a discard pile

Some variables are set up:
 - direction of game (standard: clockwise)
 - dealer (randomly chosen)
 - first player (left to the dealer)



Output:	The program will list all player names in the order they were entered.
	The dealer will be randomly chosen and also printed.
	"[First Player]'s turn!"

During the game, the game will take input about which card the user wants to play (e.g r9 for red nine) and checks if the move is valid.
If the move is valid, perform any changes of the game that might occur (changing direction, change color, etc.)
If the move is invalid, ask the user to input a correct move or draw a card.


Comments to the class diagram:

- Some variables are not explicitly mentioned in the class diagram, as it is visible from the class diagram. Such variables are marked with "...".
- Deck initialization is not being tested, as this is very trivial. For example PlayerPot's successfull initialization gets tested indirectly by testing the other class methods.
- The Game class method initialize() sets up alle the necessary objects for the game to run (create players, create deck, ...).

