package Google;

import java.util.Scanner;

public class Longest_word {

	public static void main(String[] args) {
		System.out.println("Please enter a String."); // scanner is used to take
														// input from the user.
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine(); // input is then stored into a String str.
		String a = count(str); // using count method and passing the parameter
								// string in it.
		System.out.println(a);
		scan.close();
	}

	
	private static String count(String str) {
		if (str.equals(" ")) { // if string is empty just return 0, as string
								// size is zero
			return 0 + "";
		}
		int j = 0;             // Here we will use some variables, we will run loop from 0 to str.length.
		int i = 0;             // 2 pointers are used i and j. Also start and end of the longest string is
		int start = 0;         // remembered using variable start and end.
		int end = 0;
		int count = 0;         // count is used to count the length of each word.
		int max = 0;           // max will store the length of maximum word.

		// while both pointers are less than string length, increment j
		while (i < str.length() && j < str.length()) {

			// if j is not empty character, it will calculate the count.
			if (str.charAt(j) != ' ') {
				// if it is like hi.... or "Henry," all kind of punctuation are
				// ignored.
				if (Character.isLetter(str.charAt(j))) {
					// if character at j is letter then only increase the count
					count++;
					if (count > max) {
						max = count;
						start = i;
						end = j;
					}
				}
				j++;
			} else {
				// when encountered an empty character, reset count to 0 and
				// reset i and j.
				if (j < str.length() - 1) {
					i = j + 1;
					j = i;
					count = 0;
				} else {
					// end of string just get out of loop.
					break;
				}

			}
		}
		// returns a string, first it mentions the length, then the string

		return max + " " + str.substring(start, end + 1);

	}

}
