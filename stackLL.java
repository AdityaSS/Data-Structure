package Datastructure;

/* Stack implemented using Doublylinkedlist */

public class stackLL {

	DoublyLinkedListNode top = null;

	public boolean isEmpty() {

		return top == null;
	}

	public void push(int n) {
		DoublyLinkedListNode a = new DoublyLinkedListNode(n);
		if (top == null) {
			top = a;
			top.setPreviousnode(null);
		} else {
			top.setNextnode(a);
			a.setPreviousnode(top);
			top = a;
		}
	}

	public void pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		} else {
			System.out.println(top);
			top = top.getPreviousnode();
		}
	}

	public DoublyLinkedListNode peek() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		} else {
			return top;
		}
	}

	public static void main(String[] args) {
		stackLL s = new stackLL();

		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();

		// System.out.println(s.pop());
		// System.out.println(s.pop());
		// System.out.println(s.pop());
		// System.out.println(s.pop());
	}
}
