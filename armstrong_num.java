import java.util.Scanner;

public class armstrong_num {

	public static void main(String[] args) {
		System.out.println("Enter a num.");
		Scanner scan = new Scanner(System.in);
		String a = scan.nextLine();
		int count = a.length();
		int n = Integer.parseInt(a);
		int temp = n;
		double total = 0;
		while (n > 0) {
			int result = n % 10;
			n = n / 10;
			total = total + Math.pow(result, count);
		}
		int output = (int) total;
		if (output == temp) {
			System.out.println("Armstrong number.");
		} else {
			System.out.println("Not an Armstrong number.");
		}
		scan.close();
	}

}
