#Part 1:
- Iterator:
We implemented a seperate Iterator for the piecePot class, changing the getPiecesAlive method. The idea of this
change was to ensure, that we don't have to pass around the pieces ArrayLists we had in this class.
For this change, we implemented the class PiecePotIterator. We had to change several methods in the classes 
PiecePot, Board and Game so that that everything is working.
        
- Singleton:
We chose the class Board to be implemented as a singleton. It would make no sense to have multiple boards
in one game. To achive this, we added a new field, named uniqueInstance of the type board. Additionally, we
added the method getUniqueInstance, which returns the unique instance of the board and creates it first if needed.

The class and the sequence diagrams can be found in the files "class diagram part 1" and "sequence diagram part 1".


#Part 3:
We've decided to implement the second functionality (Scoreboard and ChessPieceIterator).

Input method:
Example input for the pawn movement: a7-a5 (move), a7xb6 (eat)
Example input for the other pieces: Queen: Qa7-a5 (move), Qa7xa5 (eat) 