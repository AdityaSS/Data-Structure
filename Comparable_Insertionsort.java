package Datastructure;

/* Takes input file Employee_main. */

public class Comparable_Insertionsort {

	@SuppressWarnings("unchecked")
	public static void InsertionSort(@SuppressWarnings("rawtypes") Comparable[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			int j = i + 1;
			Comparable<?> temp = list[j];
			while ((j - 1) >= 0 && (list[j - 1].compareTo(temp) > 0)) {
				list[j] = list[j - 1];
				j--;
			}
			list[j] = temp;
		}
	}

}
