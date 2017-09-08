package Datastructure;

import java.util.Scanner;

public class anagram {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 1 word.");
		String s1 = scan.nextLine();
		System.out.println("Enter 2 word.");
		String s2 = scan.nextLine();
		boolean b = Anagram(s1, s2);
		if (b == true) {
			System.out.println("\nAnagram");
		} else {
			System.out.println("\nNot Anagram.");
		}
		scan.close();

	}

	private static boolean Anagram(String s1, String s2) {
		boolean result = false;
		String first = s1.toLowerCase();
		String second = s2.toLowerCase();
		if (first.length() == second.length()) {
			boolean[] charSet = new boolean[128];
			for (int i = 0; i < first.length(); i++) {
				char c = first.charAt(i);
				charSet[c] = true;
			}
			for (int j = 0; j < second.length(); j++) {
				char d = second.charAt(j);
				if (charSet[d] == true) {
					result = true;
				} else {
					result = false;
					break;
				}
			}
		}
		return result;
	}

}
