package Datastructure;

import java.util.Scanner;

public class TwoStack {
	int length;
	static String[] stack;
	static int top1 = -1;
	static int top2;

	public TwoStack(int size) {
		length = size;
		stack = new String[length];
		top2 = length;
	}

	public boolean isEmpty1() {
		return (top1 == -1);
	}

	public boolean isEmpty2() {
		return (top2 == length);
	}

	public boolean isFull() {
		return (top1 == top2 - 1);
	}

	public void push1(String n) {
		if (isFull()) {
			throw new RuntimeException("Stack1 Full");
		} else {
			top1++;
			stack[top1] = n;
			//System.out.println("one " + stack[top1]);
		}
	}

	public void push2(String x) {
		if (isFull()) {
			throw new RuntimeException("Stack2 Full");
		} else {
			top2--;
			stack[top2] = x;
		//	System.out.println("two " + stack[top2]);
		}
	}

	public String pop1() {
		if (isEmpty1())
			throw new RuntimeException("Stack1 Empty.");
		String d = stack[top1--];
		if (d.equals("(")) {
			d = stack[top1--];
		}
		return (d);
	}

	public String pop2() {
		if (isEmpty2())
			throw new RuntimeException("Stack2 Empty.");
		return (stack[top2++]);
	}

	public String peek1() {
		if (isEmpty1())
			throw new RuntimeException("Stack1 Empty.");
		return (stack[top1]);
	}

	public String peek2() {
		if (isEmpty2())
			throw new RuntimeException("Stack2 Empty.");
		return (stack[top2]);
	}

	public static void main(String[] args) {
		TwoStack s = new TwoStack(20);
		System.out.println("Enter the equation.");
		Scanner scan = new Scanner(System.in);
		String equation = scan.nextLine();
		for (int i = 0; i < equation.length(); i++) {
			char ch = equation.charAt(i);
			String str = Character.toString(ch);
			if (str.equals(")")) {
				s.push2((operation(s.pop1(), s.pop2(), s.pop2())));
			} else if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")|| str.equals("(")) {
				s.push1(str);
			} else {
				s.push2(str);
			}
		}
		String answer=" ";
		while(top1!=0 && top2!=stack.length){
			 
			answer += operation(s.pop1(),s.pop2(),s.pop2());
		}
		System.out.println(answer);
		scan.close();

	}

	private static String operation(String pop1, String pop2, String pop22) {
		int result = 0;
		int first = Integer.parseInt(pop2);
		int second = Integer.parseInt(pop22);
		if (pop1.equals("+")) {
			result = first + second;
		}
		if (pop1.equals("-")) {
			result = first - second;
		}
		if (pop1.equals("*")) {
			result = first * second;
		}
		if (pop1.equals("/")) {
			result = first / second;
		}

		return String.valueOf(result);
	}

}
