package sudokusolver;

import java.io.BufferedReader;
import java.io.FileReader;

public class SudokuSolver {

	/**
	 * Takes puzzle files as input and prints the solved puzzle to console
	 * @param args contains the paths to puzzle files
	 */
	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("No puzzle files specified. Exiting");
			System.exit(1);
		}

		try {
			for (String path : args) {
				
				System.out.println("Solving " + path);
				int[][] puzzle = buildPuzzleFromFile(path);
				
				Solver solver = new Solver(puzzle);
				int[][] solvedPuzzle = solver.solve();

				for (int row = 0; row < 9; row++) {
					for (int col = 0; col < 9; col++) {
						System.out.print(solvedPuzzle[row][col] + " ");
					}
					System.out.println();
				}
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Failed to solve puzzle: " + e);
		}
	}

	/**
	 * Builds a sudoku puzzle from an input file where x's indicate empty spaces
	 * @param path location of the input file
	 * @return sudoku puzzle
	 */
	public static int[][] buildPuzzleFromFile(String path) {

		String input;
		int[][] puzzle = new int[9][9];
		int row = 0;
		int col = 0;

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

			while ((input = bufferedReader.readLine()) != null) {

				input = input.trim().replaceAll("[xX]", "0");

				for (int i = 0; i < input.length(); i++) {
					puzzle[row][col] = Character.getNumericValue(input.charAt(i));
					col = (col == 8) ? 0 : col + 1;

				}
				row = (col == 0) ? row + 1 : row;
			}

		} catch (Exception e) {
			System.out.println("Error converting file to puzzle [" + path + "] " + e);
		}

		return puzzle;
	}
}
