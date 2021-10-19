## Eight of Queens <!-- omit in toc -->

- [Overview](#overview)
- [Pseudocode](#pseudocode)
- [References](#references)

## Overview
The eight queens puzzle is the problem of placing eight chess queens on an 8×8 chessboard so that no two queens threaten each other; thus, a solution requires that no two queens share the same row, column, or diagonal [[1]](#refences).

## Pseudocode
```
function MIN-CONFLICTS(max_steps) returns a solution or failure
 for i = 1 to max_steps do
   if current is a solution, then return current as solution
   conflict-queen ← a randomly chosen conflicted queen.
   min-column ← the column that minimizes the conflicts and is different from the column the queen is currently.
   move conflict-queen to the min-column.
 return failure
```

## References
[1] “Eight queens puzzle,” Wikipedia. Oct. 18, 2021. [Online]. Available: https://en.wikipedia.org/w/index.php?title=Eight_queens_puzzle&oldid=1050602922
