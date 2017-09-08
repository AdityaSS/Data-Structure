package Datastructure;

public class stack {

	int[] stack;
	int length;
	int top = -1;

	public stack(int size) {
		stack = new int[size];
		length = size;
	}

	public boolean isEmpty() {
		return top < 0;
	}

	public void push(int a) {
		if (top == stack.length - 1) {
			throw new RuntimeException("Stack is Full");
		} else {
			++top;
			stack[top] = a;
		}
	}

	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		} else {
			return stack[top];
		}
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		} else {
			return (stack[top--]);
		}

	}
	

	public static void main(String[] args) {
             stack s = new stack(5);
             s.push(1);
             s.push(2);
             s.push(3);
             s.push(4);
             s.push(5);
           System.out.println(s.pop());
           System.out.println(s.pop());
           System.out.println(s.peek());
	}

}
