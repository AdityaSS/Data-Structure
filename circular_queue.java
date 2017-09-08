package Datastructure;

public class circular_queue {
	int[] queue;
	int length;
	int Head = -1;
	int Tail = -1;
	private int numOfItems = 0;

	public circular_queue(int size) {
		queue = new int[size];
		length = size;
	}

	public boolean isEmpty() {
		return numOfItems == 0;
	}

	public boolean isFull() {
		return numOfItems == queue.length;
	}

	public void enqueue(int n) {
		if (isFull()) {
			throw new RuntimeException("Queue is Full");
		} else {
			if (Tail == queue.length - 1) {
				Tail = -1;
			}
			queue[++Tail] = n;
			if (Head == -1) {
				Head = Head++;
			}
			numOfItems++;
		}
	}

	public int dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is Empty");
		} else {
			if (Head == queue.length - 1)
				Head = -1;
			numOfItems--;
			return queue[++Head];

		}
	}

	public int peek() {
		return queue[Head + 1];
	}

	public static void main(String[] args) {
		circular_queue q = new circular_queue(5);
		System.out.println(q.isEmpty());
		q.enqueue(5);
		q.enqueue(4);
		q.enqueue(6);
		q.enqueue(10);
		q.enqueue(46);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(2);
		q.enqueue(4);
		q.enqueue(6);
		q.enqueue(8);
		q.enqueue(10);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(11);
		q.enqueue(12);
		q.enqueue(13);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}

}
