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

The class and the sequence diagrams can be found in the files "class diagram part 1.pdf" and "sequence diagram part 1.pdf".

#Part 2:
The Board class in our chess implementation is responsible for storing and manipulating it's content.
Due to the abundance of contained functions changing the boards state, the sequence-diagrams are split up.

Some notes for the diagrams:
- General: To visualize multiple attached functions, e.g. squares[x1][y1].getCurrentPiece().getColor(), we first call
getCurrentPiece() to get a piece on which we then call getColor(). Also, if a non-answer-receiving function call goes
from the Board instance to the Game instance, e.g. in various alt scenarios, the scenario / sequence is to be regarded 
as completed. When a new instance is created we assume that the calling instance receives the newly created instance.

- Board.getUniqueInstance(Game game): "piece: Piece" is to be interpreted as a placeholder name for all the possible 
types of pieces. We never call "new Piece(Color, squares(column, row)" in the implementation. Instead it is called
with a specific implementation of a Piece, e.g. new Pawn(Color, squares(column, row). Similarly  "square: Square" is
also a placeholder for all the 64 unique instances, not only one instance.

- Board.refresh(): Similar to "piece: Piece", "square: Square" does not refer to one specific instance of Square,
but to a placeholder instance for each square contained in squares.

The sequence diagrams can be found in the file "class diagram part 2.pdf". The LaTeX source-files can be found in the
folder "Task2_Sequence_Diagram".

#Part 3:
We've decided to implement the second functionality (Scoreboard and ChessPieceIterator).

Input method:
Example input for the pawn movement: a7-a5 (move), a7xb6 (eat)
Example input for the other pieces: Queen: Qa7-a5 (move), Qa7xa5 (eat) 