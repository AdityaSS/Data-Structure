package Exercise_12;

public class Non_Attacking_Queen_main {

	public static void main(String[] args) {

		Non_Attacking_Queen a = new Non_Attacking_Queen(4);
		boolean b = false;
		int row = 0;
		int column = 0;
		while (b == false) {
			System.out.println("For row " + row + " column " + column);
			b = a.traverse(row, column);
			System.out.println(a);
			if (b == false) {
				System.out.println(b);
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						a.grid[i][j] = 0;
					}
				}
			}
			column = column + 1;
		}
		

	}

}
