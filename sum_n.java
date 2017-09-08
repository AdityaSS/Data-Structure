package Datastructure;

import java.util.Scanner;

public class sum_n {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 1 number");
		int a = scan.nextInt();

		System.out.println("Sum of numbers are : " + sum(a));

		scan.close();

	}

	private static int sum(int a) {
		if (a == 0) {
			return 0;
		} else {
			return (int) (Math.pow(a, 2) + sum(a - 1));
		}

	}

}
