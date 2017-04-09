package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import sudokusolver.Solver;
import sudokusolver.SudokuSolver;

public class SolverTest {

	private static int[][] puzzle;
	private static Solver solver;

	@Test
	public void usedInRowTest() throws Exception{

		puzzle = SudokuSolver.buildPuzzleFromFile("resources/testpuzzle.txt");
		solver = new Solver(puzzle);

		boolean b = solver.usedInRow(0, 4);
		assertTrue(b == false);

		b = solver.usedInRow(3, 3);
		assertTrue(b == false);

		puzzle[1][0] = 6;
		b = solver.usedInRow(1, 0);
		assertTrue(b == true);

		puzzle[7][7] = 8;
		b = solver.usedInRow(7, 7);
		assertTrue(b == true);
	}

	@Test
	public void usedInColTest() throws Exception {

		puzzle = SudokuSolver.buildPuzzleFromFile("resources/testpuzzle.txt");
		solver = new Solver(puzzle);

		boolean b = solver.usedInColumn(1, 0);
		assertTrue(b == false);

		b = solver.usedInColumn(4, 3);
		assertTrue(b == false);

		puzzle[1][0] = 3;
		b = solver.usedInColumn(1, 0);
		assertTrue(b == true);

		puzzle[7][7] = 4;
		b = solver.usedInColumn(7, 7);
		assertTrue(b == true);
	}

	@Test
	public void usedInBoxTest() throws Exception{

		puzzle = SudokuSolver.buildPuzzleFromFile("resources/testpuzzle.txt");
		solver = new Solver(puzzle);

		boolean b = solver.usedInBox(1, 2);
		assertTrue(b == false);

		b = solver.usedInBox(4, 6);
		assertTrue(b == false);

		puzzle[0][6] = 7;
		b = solver.usedInBox(0, 6);
		assertTrue(b == true);

		puzzle[6][3] = 8;
		b = solver.usedInBox(6, 3);
		assertTrue(b == true);

	}

	@Test
	public void findSolvedTest() throws Exception{
		
		puzzle = SudokuSolver.buildPuzzleFromFile("resources/testpuzzle.txt");
		solver = new Solver(puzzle);
		boolean[][] solvedCells = solver.findSolvedCells(puzzle);
		
		assertTrue(solvedCells[0][0] == false);
		assertTrue(solvedCells[1][0] == true);
		assertTrue(solvedCells[4][6] == true);
		assertTrue(solvedCells[7][3] == false);
		
	}
	
	@Test
	public void solveTest() throws Exception{
		
		puzzle = SudokuSolver.buildPuzzleFromFile("resources/testpuzzle.txt");
		solver = new Solver(puzzle);
		int[][] solvedPuzzle = solver.solve();
		
		int[][] correctPuzzle = {{4, 2, 8, 1, 5, 9, 6, 7, 3}, 
				{1, 9, 6, 3, 7, 4, 8, 2, 5 }, 
				{3, 7, 5, 8, 6, 2, 9, 4, 1 }, 
				{9, 8, 1, 4, 2, 3, 5, 6, 7},
				{5, 6, 4, 7, 1, 8, 3, 9, 2}, 
				{7, 3, 2, 5, 9, 6, 1, 8, 4},
				{2, 4, 3, 6, 8, 1, 7, 5, 9},
				{6, 1, 7, 9, 4, 5, 2, 3, 8},
				{8, 5, 9, 2, 3, 7, 4, 1, 6}};
		
		checkEquals(solvedPuzzle, correctPuzzle, "Incorrect value while solving the test puzzle.");
	}
//
//	@Test
//	public void solveAllPuzzlesTest() throws Exception{
//		
//		puzzle = SudokuSolver.buildPuzzleFromFile("resources/puzzle1.txt");
//		solver = new Solver(puzzle);
//		int[][] solvedPuzzle = solver.solve();
//		
//		int[][] correctPuzzle = {{4, 2, 8, 1, 5, 9, 6, 7, 3}, 
//				{1, 9, 6, 3, 7, 4, 8, 2, 5 }, 
//				{3, 7, 5, 8, 6, 2, 9, 4, 1 }, 
//				{9, 8, 1, 4, 2, 3, 5, 6, 7},
//				{5, 6, 4, 7, 1, 8, 3, 9, 2}, 
//				{7, 3, 2, 5, 9, 6, 1, 8, 4},
//				{2, 4, 3, 6, 8, 1, 7, 5, 9},
//				{6, 1, 7, 9, 4, 5, 2, 3, 8},
//				{8, 5, 9, 2, 3, 7, 4, 1, 6}};
//		
//		checkEquals(solvedPuzzle, correctPuzzle, "Puzzle 1 failed validation");
//		
//		puzzle = SudokuSolver.buildPuzzleFromFile("resources/puzzle2.txt");
//		solver = new Solver(puzzle);
//		solvedPuzzle = solver.solve();
//		
//		correctPuzzle = new int[][]{{9, 2, 1, 7, 6, 8, 5, 4, 3}, 
//			{4, 6, 3, 5, 1, 9, 8, 7, 2}, 
//			{8, 7, 5, 4, 3, 2, 9, 6, 1},
//			{5, 9, 4, 2, 8, 3, 6, 1, 7}, 
//			{7, 1, 2, 6, 4, 5, 3, 8, 9}, 
//			{6, 3, 8, 9, 7, 1, 4, 2, 5}, 
//			{3, 4, 9, 8, 2, 7, 1, 5, 6}, 
//			{2, 5, 6, 1, 9, 4, 7, 3, 8}, 
//			{1, 8, 7, 3, 5, 6, 2, 9, 4}};
//			
//		checkEquals(solvedPuzzle, correctPuzzle, "Puzzle 2 failed validation");
//		
//		puzzle = SudokuSolver.buildPuzzleFromFile("resources/puzzle3.txt");
//		solver = new Solver(puzzle);
//		solvedPuzzle = solver.solve();
//		
//		correctPuzzle = new int[][]{{9, 2, 1, 7, 6, 8, 5, 4, 3}, 
//			{4, 6, 3, 5, 1, 9, 8, 7, 2}, 
//			{8, 7, 5, 4, 3, 2, 9, 6, 1},
//			{5, 9, 4, 2, 8, 3, 6, 1, 7}, 
//			{7, 1, 2, 6, 4, 5, 3, 8, 9}, 
//			{6, 3, 8, 9, 7, 1, 4, 2, 5}, 
//			{3, 4, 9, 8, 2, 7, 1, 5, 6}, 
//			{2, 5, 6, 1, 9, 4, 7, 3, 8}, 
//			{1, 8, 7, 3, 5, 6, 2, 9, 4}};
//			
//		checkEquals(solvedPuzzle, correctPuzzle, "Puzzle 3 failed validation");
//		
//		puzzle = SudokuSolver.buildPuzzleFromFile("resources/puzzle4.txt");
//		solver = new Solver(puzzle);
//		solvedPuzzle = solver.solve();
//		
//		correctPuzzle = new int[][]{{5, 3, 4, 6, 7, 8, 9, 1, 2},
//			{6, 7, 2, 1, 9, 5, 3, 4, 8},
//			{1, 9, 8, 3, 4, 2, 5, 6, 7},
//			{8, 5, 9, 7, 6, 1, 4, 2, 3},
//			{4, 2, 6, 8, 5, 3, 7, 9, 1},
//			{7, 1, 3, 9, 2, 4, 8, 5, 6},
//			{9, 6, 1, 5, 3, 7, 2, 8, 4},
//			{2, 8, 7, 4, 1, 9, 6, 3, 5},
//			{3, 4, 5, 2, 8, 6, 1, 7, 9}};
//			
//		checkEquals(solvedPuzzle, correctPuzzle, "Puzzle 4 failed validation");
//		
//		puzzle = SudokuSolver.buildPuzzleFromFile("resources/puzzle5.txt");
//		solver = new Solver(puzzle);
//		solvedPuzzle = solver.solve();
//		
//		correctPuzzle = new int[][]{{9, 1, 5, 3, 4, 8, 6, 2, 7},
//			{3, 4, 8, 6, 7, 2, 1, 5, 9},
//			{7, 6, 2, 1, 5, 9, 4, 8, 3},
//			{6, 9, 7, 8, 1, 4, 2, 3, 5},
//			{5, 3, 4, 7, 2, 6, 9, 1, 8},
//			{8, 2, 1, 9, 3, 5, 7, 6, 4},
//			{4, 7, 6, 5, 8, 1, 3, 9, 2},
//			{1, 8, 3, 2, 9, 7, 5, 4, 6},
//			{2, 5, 9, 4, 6, 3, 8, 7, 1}};
//			
//		checkEquals(solvedPuzzle, correctPuzzle, "Puzzle 5 failed validation");
//	}
//	
	private void checkEquals(int[][] solvedPuzzle, int[][] correctPuzzle, String message){
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				assertTrue(solvedPuzzle[row][col] == correctPuzzle[row][col]);
			}
		}
	}
}
