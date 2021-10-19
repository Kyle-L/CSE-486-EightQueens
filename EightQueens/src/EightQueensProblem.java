import java.util.Random;

public class EightQueensProblem {
	public final static int N = 8;

	// This array holds the positions of the queens
	// each row has exactly one queen, so we only need to store the column the queen
	// is in
	// for example, queens[1] is the column which the queen in the second row
	// occupies
	// you set values in the array directly, it is up to you to ensure that the
	// values of the array are in the range [0,7]
	public int[] queens;

	/**
	 * Instantiate the problem, randomly assigning a column to each queen
	 */
	public EightQueensProblem() {
		queens = new int[N];
		// randomly assign each queen a column
		for (int i = 0; i < N; i++) {
			int col = (int) (Math.random() * N);
			queens[i] = col;
		}
	}

	/**
	 * Prints out a visualization of the board
	 */
	public void printBoard() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				char c = (queens[row] == col ? 'Q' : ' ');
				if (col == N - 1)
					System.out.println(c);
				else
					System.out.print(c + " | ");
			}

			if (row < N - 1) {
				for (int i = 0; i < (N * 4) - 2; i++) {
					System.out.print("-");
				}
				System.out.println();
			}
		}
	}

	/**
	 * Checks the given position for the number of queens attacking the position
	 * Note, this ignores the queen which is in the given row, because we are
	 * assuming that there is one queen per row
	 * 
	 * @param row the row to check
	 * @param col the column to check
	 * @return the number of queens attacking (row,col) excluding the queen in the
	 *         given row
	 */
	public int conflicts(int row, int col) {
		int conflicts = 0;
		for (int i = 0; i < N; i++) {
			// Ignore the queen in the current row.
			if (i != row) {
				// Check for conflict in column.
				if (queens[i] == col) {
					conflicts++;
				}
				// Checks for conflict on diagonals.
				else if (Math.abs(i - row) == Math.abs(queens[i] - col)) {
					conflicts++;
				}
			}
		}
		return conflicts;
	}

	/**
	 * Checks whether the board is completely solved or not
	 * 
	 * @return true if the board is solved, false otherwise
	 */
	public boolean isSolved() {
		boolean solved = true;
		for (int row = 0; row < N; row++) {
			// A queen is being attacked.
			if (conflicts(row, queens[row]) > 0) {
				solved = false;
				break;
			}
		}
		return solved;
	}

	/**
	 * This is the method you need to implement. Should solve the board using
	 * min-conflicts Remember, at each step, we pick a random row and move the queen
	 * in that row to a new column. The queen should never be left in the column in
	 * which it started, or you could get stuck in a local minimum.
	 */
	public void minConflicts() {
		Random random = new Random();
		while (!isSolved()) {
			// Step 1: Randomly picks a row.
			int row = random.nextInt(queens.length);
			int minConflicts = Integer.MAX_VALUE;
			int minCol = -1;

			// Step 2: Finds the col with the min conflicts.
			for (int col = 0; col < queens.length; col++) {
				if (col == queens[row]) {
					continue;
				}
				int conflicts = conflicts(row, col);
				if (conflicts < minConflicts) {
					minConflicts = conflicts;
					minCol = col;
				}
			}
			
			// Step 3: Updates the queen to the min conflict row.
			queens[row] = minCol;
		}
	}
}
