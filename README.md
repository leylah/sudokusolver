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

The puzzles in resources/ produces the following output:

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

    Solving resources/puzzle2.txt
    9 2 1 7 6 8 5 4 3 
    4 6 3 5 1 9 8 7 2 
    8 7 5 4 3 2 9 6 1 
    5 9 4 2 8 3 6 1 7 
    7 1 2 6 4 5 3 8 9 
    6 3 8 9 7 1 4 2 5 
    3 4 9 8 2 7 1 5 6 
    2 5 6 1 9 4 7 3 8 
    1 8 7 3 5 6 2 9 4 

    Solving resources/puzzle3.txt
    9 2 1 7 6 8 5 4 3 
    4 6 3 5 1 9 8 7 2 
    8 7 5 4 3 2 9 6 1 
    5 9 4 2 8 3 6 1 7 
    7 1 2 6 4 5 3 8 9 
    6 3 8 9 7 1 4 2 5 
    3 4 9 8 2 7 1 5 6 
    2 5 6 1 9 4 7 3 8 
    1 8 7 3 5 6 2 9 4 

    Solving resources/puzzle4.txt
    5 3 4 6 7 8 9 1 2 
    6 7 2 1 9 5 3 4 8 
    1 9 8 3 4 2 5 6 7 
    8 5 9 7 6 1 4 2 3 
    4 2 6 8 5 3 7 9 1 
    7 1 3 9 2 4 8 5 6 
    9 6 1 5 3 7 2 8 4 
    2 8 7 4 1 9 6 3 5 
    3 4 5 2 8 6 1 7 9 

    Solving resources/puzzle5.txt
    9 1 5 3 4 8 6 2 7 
    3 4 8 6 7 2 1 5 9 
    7 6 2 1 5 9 4 8 3 
    6 9 7 8 1 4 2 3 5 
    5 3 4 7 2 6 9 1 8 
    8 2 1 9 3 5 7 6 4 
    4 7 6 5 8 1 3 9 2 
    1 8 3 2 9 7 5 4 6 
    2 5 9 4 6 3 8 7 1 
