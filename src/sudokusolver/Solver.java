package sudokusolver;

public class Solver {

	private int[][] puzzle;

	public Solver(int[][] puzzle) {
		this.puzzle = puzzle;
	}

	/**
	 * Uses a brute force back tracking algorithm to solve sudoku puzzles.
	 * 
	 * @return the solved soduko puzzle
	 * @throws Exception if unable to solve the puzzle
	 */
	public int[][] solve() throws Exception {

		int row, col, cell = 0;
		boolean backtrack = false;

		boolean[][] solvedCells = findSolvedCells(puzzle);

		while (cell >= 0 && cell < 81) {

			row = cell / 9;
			col = cell % 9;

			// if this cell is NOT solved
			if (solvedCells[row][col] != true) {

				// get the next plausible value for this cell
				backtrack = false;
				puzzle[row][col] += 1;

				while (!isValueValid(row, col) && puzzle[row][col] <= 10) {
					puzzle[row][col] += 1;
				}
			}

			// if no plausible value was found then reset and backtrack
			if (puzzle[row][col] >= 10) {

				puzzle[row][col] = 0;
				backtrack = true;
			}

			// move forwards or backwards one cell
			cell = (backtrack == true) ? cell - 1 : cell + 1;
		}

		if (cell == -1) {
			throw new Exception("Unable to solve puzzle");
		}

		return puzzle;
	}

	/**
	 * Checks the original puzzle for solved (non-zero) cells and sets a flag
	 * so that this value is not changed later
	 * 
	 * @param puzzle the original unsolved puzzle
	 * @return a multidimensional array which holds the solved cell flags 
	 * @throws Exception if there is an error while searching for solved cells
	 */
	public boolean[][] findSolvedCells(int[][] puzzle) throws Exception {

		boolean[][] solvedCells = new boolean[9][9];

		try {

			for (int row = 0; row < 9; row++) {
				for (int col = 0; col < 9; col++) {
					// non-zero values are considered solved
					if (puzzle[row][col] != 0) {
						solvedCells[row][col] = true;
					}
				}
			}
		} catch (Exception e) {
			throw new Exception("Error while finding solved cells: " + e);
		}

		return solvedCells;
	}
	
	/**
	 * Checks if the value in a cell is valid based on the following rules:
	 * Each row can only contain one instance of each number 1 – 9
	 * Each column can only contain one instance of each number 1 – 9
	 * Each 3x3 quadrant can only contain one instance of each number 1 – 9
	 * @param row row index of puzzle
	 * @param col column index of puzzle
	 * @return boolean value denoting whether the value in the current cell is valid
	 * @throws Exception if there is an issue while checking for cell value validity
	 */
	public boolean isValueValid(int row, int col) throws Exception {
		return !usedInRow(row, col) && !usedInColumn(row, col) && !usedInBox(row, col);
	}

	/**
	 * Checks if the current value for a cell is valid within the row it resides
	 * @param row row index
	 * @param col column index
	 * @return boolean value to signify whether the value is allowed in this row 
	 * @throws Exception if unable to check cell validity for the current row
	 */
	public boolean usedInRow(int row, int col) throws Exception {
		int currentCellValue = puzzle[row][col];
		for (int i = 0; i < 9; i++) {

			if (i == col) {
				// skip current value
				continue;
			} else if (puzzle[row][i] == currentCellValue) {
				return true;
			}

		}
		return false;
	}

	/**
	 * Checks if the current value for a cell is valid within the column it resides
	 * @param row row index
	 * @param col column index
	 * @return boolean value to signify whether the value is allowed in this column 
	 * @throws Exception if unable to check cell validity for the current column
	 */
	public boolean usedInColumn(int row, int col) throws Exception {
		int currentCellValue = puzzle[row][col];
		for (int i = 0; i < 9; i++) {

			if (i == row) {
				// skip current value
				continue;
			} else if (puzzle[i][col] == currentCellValue) {
				return true;
			}

		}
		return false;
	}

	/**
	 * Checks if the current value for a cell is valid within the 3x3 box it resides
	 * @param row row index
	 * @param col column index
	 * @return boolean value to signify whether the value is allowed in this 3x3 box 
	 * @throws Exception if unable to check cell validity for the current 3x3 box
	 */
	public boolean usedInBox(int row, int col) throws Exception {

		int currentCellValue = puzzle[row][col];
		int lowerRowBound = 0;
		int upperRowBound = 0;
		int lowerColBound = 0;
		int upperColBound = 0;

		//find 3x3 box upper and lower row bounds
		if (row < 3) {
			lowerRowBound = 0;
			upperRowBound = 3;
		} else if (row < 6) {
			lowerRowBound = 3;
			upperRowBound = 6;
		} else if (row < 9) {
			lowerRowBound = 6;
			upperRowBound = 9;
		}

		//find 3x3 box upper and lower column bounds
		if (col < 3) {
			lowerColBound = 0;
			upperColBound = 3;
		} else if (col < 6) {
			lowerColBound = 3;
			upperColBound = 6;
		} else if (col < 9) {
			lowerColBound = 6;
			upperColBound = 9;
		}

		for (int r = lowerRowBound; r < upperRowBound; r++) {
			for (int c = lowerColBound; c < upperColBound; c++) {
				if (r == row && c == col) {
					// skip current val
					continue;
				} else if (currentCellValue == puzzle[r][c]) {
					return true;
				}
			}
		}
		return false;
	}
}
