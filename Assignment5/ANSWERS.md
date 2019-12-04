#Part 1


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
- GameBoardTest:
  - markTwice / markOnBoard:
    In the method mark of the class GameBoard was a bug which was resulting in that you were only able to place
    a mark on an already marked field. The fix to this bug was easy: just switch the return statements.
            
  - getOpenPosition / getOpenPositionAll:
    The method getOpenPosition of the class GameBoard was only iterating over all rows but not all columns. It 
    ignored the column '0'. This bug could be fixed by changing the range of the second for-loop from 
    (int col = 1; col < COLS; col++) to (int col = 0; col < COLS; col++).
    
- TicTacToeGameStateTest:
    -
    -

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




