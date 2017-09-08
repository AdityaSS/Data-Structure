package Datastructure;

import java.util.Scanner;

public class recursion_add {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 1 number");
		int a = scan.nextInt();
		System.out.println("Enter 2 number");
		int b = scan.nextInt();
		if (a > b) {
			System.out.println("Sum of numbers are : " + rec(a, b));
		} else {
			System.out.println("Sum of numbers are : " + rec(b, a));
		}
		scan.close();

	}

	public static int rec(int k, int n) {
		if (n == 0) {
			return k;
		} else {
			return 1 + rec(k, n - 1);
		}
	}

}
