
/*When we go grocery shopping, we often have a standard list of things to buy. 
 *Each shopper has a distinctive list, depending on one’s needs and preferences. 
 *A housewife might buy healthy ingredients for a family dinner, while a bachelor might buy beer and chips. 
 *Understanding these buying patterns can help to increase sales in several ways. 
 *If there is a pair of items, X and Y, that are frequently bought together:
 *Product placement in Walmart.
 *Both X and Y can be placed on the same shelf, so that buyers of one item would be prompted to buy the other.
 *Promotional discounts could be applied to just one out of the two items.
 *Advertisements on X could be targeted at buyers who purchase Y.
 *X and Y could be combined into a new product, such as having Y in flavors of X.
 *While we may know that certain items are frequently bought together, the question is, how do we uncover these associations?
 *For more info on Apriori Algorithm visit: https://en.wikipedia.org/wiki/Apriori_algorithm. 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Apriory_Algorithm {
	static HashMap<String, Integer> map = new HashMap<String, Integer>();

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws FileNotFoundException {
		int count = 0;
		final float support = (float) 0.5;
		final float confidence = (float) 0.5;
		ArrayList<String> list = new ArrayList<>();
		File text = new File("C:/Users/Aditya/workspace/Data Structure/DataSet");
		Scanner scan = new Scanner(text);
		while (scan.hasNext()) {
			count++;
			String line = scan.nextLine();
			for (int i = 0; i < line.length(); i++) {
				Character c = line.charAt(i);
				if (c.isLetter(c)) {
					String r = c.toString();
					if (map.containsKey(r)) {
						map.put(r, map.get(r) + 1);
					} else {
						map.put(r, 1);
					}
				}
			}
		}
		System.out.println(" 1st Iteration.\n---------------");
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() >= 2)
				list.add(entry.getKey().toString());
		}
		System.out.print(list + "\n");
		System.out.println();
		System.out.println(" 2nd Iteration.\n---------------");
		String s = "";
		for (int i = 0; i < count - 1; i++) {
			for (int j = i + 1; j < count; j++) {
				s = list.get(i) + list.get(j);
				boolean b = Exists(list.get(i), list.get(j));
				if (b)
					list.add(s);
			}

		}

		System.out.println(list + "\n");
		System.out.print("Transactions \t" + "Confidence \t" + "Support\n");
		System.out.print("------------ \t" + "----------\t" + "----------\n");
		for (int i = 0; i < list.size(); i++) {
			scan = new Scanner(text);
			int sum = 0;
			String first = list.get(i);
			char[] ch1 = first.toCharArray();
			for (int j = 0; j < list.size(); j++) {
				String second = list.get(j);
				char[] ch2 = second.toCharArray();
				if (ch1.length == 1 && ch2.length == 1) {
					if (ch1[0] != ch2[0]) {
						while (scan.hasNext()) {
							String line = scan.nextLine();
							if (line.indexOf(ch1[0]) >= 0 && line.indexOf(ch2[0]) >= 0) {
								sum++;
							}
						}
					}
				} else if (ch1.length == 2 && ch2.length == 2) {
					if (ch1[0] != ch2[0] && ch1[0] != ch2[1] && ch1[1] != ch2[0] && ch1[1] != ch2[1]) {
						while (scan.hasNext()) {
							String line = scan.nextLine();
							if (line.indexOf(ch1[0]) >= 0 && line.indexOf(ch1[1]) >= 0 && line.indexOf(ch2[0]) >= 0
									&& line.indexOf(ch2[1]) >= 0) {
								sum++;
							}
						}
					}
				} else if (ch1.length == 1 && ch2.length == 2) {
					if (ch1[0] != ch2[0] && ch1[0] != ch2[1]) {
						while (scan.hasNext()) {
							String line = scan.nextLine();
							if (line.indexOf(ch1[0]) >= 0 && line.indexOf(ch2[0]) >= 0 && line.indexOf(ch2[1]) >= 0
									&& line.indexOf(ch2[1]) >= 0) {
								sum++;
							}
						}
					}
				} else if (ch1.length == 2 && ch2.length == 1) {
					if (ch2[0] != ch1[0] && ch2[0] != ch1[1]) {
						String line = scan.nextLine();
						if (line.indexOf(ch1[0]) >=0  && line.indexOf(ch1[1]) >= 0 && line.indexOf(ch2[0]) >= 0
								&& line.indexOf(ch2[1]) >= 0) {
							sum++;
						}
					}
				}

				float b = ((float) sum / map.get(list.get(i)));
				float a = ((float) sum / count);
				if (b >= confidence) {
					System.out.println(list.get(i) + "-----> " + list.get(j) + "\t " + b + "\t\t" + a);
				}
				scan = new Scanner(text);
				sum = 0;
			}
		}

	}

	@SuppressWarnings("resource")
	public static boolean Exists(String s, String s1) throws FileNotFoundException {
		File file = new File("C:/Users/Aditya/workspace/Data Structure/DataSet");
		Scanner scan1 = new Scanner(file);
		int count = 0;
		String r = "";
		while (scan1.hasNext()) {
			String line = scan1.nextLine();
			if (line.contains(s) && line.contains(s1)) {
				r = s + s1;
				count++;
			}
		}
		if (count >= 2) {
			map.put(r, count);
			return true;
		}
		scan1.close();
		return false;

	}

	@SuppressWarnings("resource")
	public static boolean Exists1(String s, String s1, String s2) throws FileNotFoundException {
		File file = new File("C:/Users/Aditya/workspace/Data Structure/DataSet");
		Scanner scan1 = new Scanner(file);
		int count = 0;
		String r = "";
		while (scan1.hasNext()) {
			String line = scan1.nextLine();
			if (line.contains(s) && line.contains(s1) && line.contains(s2)) {
				r = s + s1 + s2;
				count++;

			}
		}
		if (count >= 2) {
			map.put(r, count);
			return true;
		}
		scan1.close();
		return false;

	}

}
