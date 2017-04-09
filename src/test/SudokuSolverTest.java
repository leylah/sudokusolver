package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import sudokusolver.SudokuSolver;

public class SudokuSolverTest {

	@Test
	public void buildPuzzleFromFileTest() {

		int[][] puzzle = SudokuSolver.buildPuzzleFromFile("resources/testpuzzle.txt");
		assertTrue("cell value was " + puzzle[0][3] + " instead of 1", puzzle[0][3] == 1);
		assertTrue("cell value was " + puzzle[3][0] + " instead of 9", puzzle[3][0] == 9);
		assertTrue("cell value was " + puzzle[4][2] + " instead of 4", puzzle[4][2] == 4);
		assertTrue("cell value was " + puzzle[8][7] + " instead of 0", puzzle[8][7] == 0);
	}

}
