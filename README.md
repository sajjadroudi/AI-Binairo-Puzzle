# Binario Puzzle
A board game written in Java. Created as a university project for Artificial Intelligence course. A sample project for constraint satisfaction problems. Study [project_definition.pdf](https://github.com/sajjadroudi/AI-Binairo-Puzzle/blob/master/project_definition.pdf) for more details.

## Used AI Algorithms
- Backtracking
- Forward Checking
- MRV heuristic
- LCV heuristic

## Rules
Binairo is played on a rectangular grid. Some cells start out filled with black or white circles (0 for white and 1 for black in input file). The rest of the cells are empty. The goal is to place circles in all cells in such a way that:
- Each row and each column must contain an equal number of white and black circles. 
- More than two circles of the same color can't be adjacent. 
- Each row and column is unique.
