package Datastructure;

import java.util.Scanner;

public class Duplicate_Check {

	public static void main(String[] args) {
		System.out.println("Enter a String");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();

		boolean result = duplicatecheck(s);
		if (result == true) {
			System.out.println("Duplicate found.");
		} else {
			System.out.println("No Duplicate.");
		}
		scan.close();
	}

	private static boolean duplicatecheck(String s) {
		boolean[] charSet = new boolean[128]; 
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (charSet[c] == true) {
				return true;
			} else {
				charSet[c] = true;
			}
		}
		return false;

	}
}
