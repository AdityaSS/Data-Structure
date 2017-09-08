package Datastructure;

public class BubbleSort_main {
	
	public static void main(String[] args) {
		int[] input = { 9, 6, 7, 3, 4, 5 };
		BubbleSort_main.bubblesort(input);
		
		for(int i = 0;i<input.length;i++){
			System.out.println(input[i]);
		}
	}
	
	public static void bubblesort(int list[]){
		int temp;
		for (int i = 0; i < list.length - 1; i++) {
			for (int j = 0; j < list.length - 1 - i; j++) {
				if (list[j] > list[j + 1]) {
					temp = list[j + 1];
					list[j+1] = list[j];
					list[j] = temp;
				}
			}
		}
		
	}
	

}


