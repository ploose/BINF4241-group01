# Assignment 1: Snakes & Ladders by BINF4241-group25 (Brunner Tim, Looser Patrick, Marty Pascal)

## Rules
These are the rules of our Snakes & Ladders implementation: 
- All players start on the first square.
- Each turn, one player throws a dice and moves 1 - 6 squares.
- A player who lands on an square, which is already occupied by another player, must go back
  to the first square. (Exception being the first square, as it has no player limit)
- If the player lands on the bottom of a ladder, he will climb up it (if possible).
- If the player lands on the top of a snake, he will slide down it (if possible).
- If you roll a number higher than the number of squares
  needed to reach the last square, you will move back the remaining distance from the last square.
  - E.g. A board has 4 squares and you are on square 3. You need to throw a 1 but get a 3. 
  You will now move 1 move to the last square and then the remaining 2 moves back. You will thus land on square 2.
  - You don't move further back than the first square, even if there would be more moves. You just stay there.
- The game ends when the first player reaches the last square.


