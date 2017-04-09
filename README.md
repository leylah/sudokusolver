# Sudoku Solver

This sudoku solver uses a brute force backtracking algorithm to solve puzzles.
It takes puzzle input paths from the command line and prints the solved puzzle to the console.

Sample input file:
    XXX15XX7X   
    1X6XXX82X   
    3XX86XX4X   
    9XX4XX567   
    XX47X83XX   
    732XX6XX4   
    X4XX81XX9   
    X17XXX2X8   
    X5XX37XXX   

Output:
Solving resources/puzzle1.txt
    4 2 8 1 5 9 6 7 3   
    1 9 6 3 7 4 8 2 5   
    3 7 5 8 6 2 9 4 1   
    9 8 1 4 2 3 5 6 7   
    5 6 4 7 1 8 3 9 2   
    7 3 2 5 9 6 1 8 4   
    2 4 3 6 8 1 7 5 9   
    6 1 7 9 4 5 2 3 8   
    8 5 9 2 3 7 4 1 6   
