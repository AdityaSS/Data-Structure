package Exercise_12;

public class Non_Attacking_Queen {
	int[][] grid;

	public Non_Attacking_Queen(int n) {
		grid = new int[n][n];
	}

	public boolean traverse(int row, int column) {
		boolean result = false;
		if (validate(row, column) == true) {
			if (check(row, column) == true) {
				grid[row][column] = 1;

				if (grid[3][0] == 1 || grid[3][1] == 1 || grid[3][2] == 1 || grid[3][3] == 1) {
					result = true;
				} else {
					column = 0;
					result = traverse(row + 1, column);
					if (!result)
						result = traverse(row + 1, column + 1);
					if (!result)
						result = traverse(row + 1, column + 2);
					if (result == false)
						grid[row + 1][column + 2] = 0;
					if (!result)
						result = traverse(row + 1, column + 3);
					
				}
			}
		}

		return result;
	}

	private boolean check(int row, int column) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (grid[i][j] == 1) {
					if (i == row || j == column || Math.abs(row - i) == Math.abs(column - j)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private boolean validate(int row, int column) {
		boolean result = false;
		if (row < 4 && column < 4 && grid[row][column] == 0) {
			result = true;
		}
		return result;
	}

	public String toString() {
		String result = "\n";
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				result += grid[row][column] + " ";
			}
			result += "\n";

		}
		return result;
	}

}
