package Datastructure;

public class Tower_of_Hanoi {
	
	public void move(int n, char start, char inter, char end) {
		if (n == 1) {
			System.out.println("Move 1 from " + start + " to " + end);
		} else {
			move(n - 1, start, end, inter);
			System.out.println("Move " + n + " from " + start + " to " + end);
			move(n - 1, inter, start, end);
		}
	}

	public static void main(String[] args) {
		Tower_of_Hanoi toh = new Tower_of_Hanoi();
		toh.move(3, 'A', 'B', 'C');
	}
}
