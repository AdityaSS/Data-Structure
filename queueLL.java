package Datastructure;

public class queueLL {
	DoublyLinkedListNode Head=null;
	DoublyLinkedListNode Tail=null;

	public void enqueue(int n) {

		DoublyLinkedListNode a = new DoublyLinkedListNode(n);

		if (Head == null) {
			Head = a;
			Tail = a;

		} else {
			Tail.setNextnode(a);
		//	System.out.println("t " + Tail);
			a.setPreviousnode(Tail);
		//	System.out.println(a.getPreviousnode());
			Tail = a;
		//	System.out.println(Tail);
		}
	}

	public DoublyLinkedListNode dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue Empty");
		} else {
			DoublyLinkedListNode current = Head;
			Head = Head.getNextnode();
			return current;
		}
	}

	private boolean isEmpty() {
		if (Head == null) {
			return true;
		} else {
			return false;
		}

	}
	
	public static void main(String[] args){
		queueLL q = new queueLL();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		//System.out.println(q.dequeue());
	}

}
