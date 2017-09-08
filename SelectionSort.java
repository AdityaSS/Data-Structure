package Datastructure;

public class SelectionSort {

	public static void main(String[] args) {
		int[] input = { 9, 6, 7, 3, 4, 5 };
		SelectionSort.selectionsort(input);

		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
	}

	public static void selectionsort(int list[]) {
		int temp;
		int min;
		for (int i = 0; i < list.length-1; i++) {
			min = i;
			for (int j = i+1; j < list.length; j++) {
				if (list[j] < list[min]) {
					min = j;
				}
			}
			temp = list[min];
			list[min] = list[i];
			list[i] = temp;
		}

	}

}
