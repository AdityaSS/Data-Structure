package Datastructure;

public class InsertionSort {

	public static void main(String[] args) {
		int[] input = { -19, 6, 15, 17, -3, 12, 10 };
		InsertionSort.insertionsort(input);

		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}

	public static void insertionsort(int list[]) {
		for (int i = 0; i < list.length - 1; i++) {
			int j = i + 1;
			int temp = list[j];
			while ((j - 1) >= 0 && list[j - 1] > temp) {
				list[j] = list[j - 1];
				j--;
			}
			list[j] = temp;
		}

	}

}
