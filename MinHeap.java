package Datastructure;

import java.util.Arrays;

public class MinHeap {

	Integer[] heap;
	int current = -1;

	public MinHeap(int i) {
		heap = new Integer[i];
	}

	public void insert(int i) {
		heap[++current] = i;
		heapifydown(current);

	}

	public void deleteroot() {
		heap[0] = heap[current];
		 current--;
		 heap[current + 1] = null;
		int i = 0;
		int leftchild = (2 * i) + 1;
		int rightchild = (2 * i) + 2;
		int tmp = 0;
		while (i < current) {
			if (heap[rightchild] != null) {
				if (heap[i] < heap[leftchild] && heap[i] < heap[rightchild])
					break;
				else if (heap[leftchild] < heap[rightchild] && heap[i] > heap[leftchild]) {
					tmp = heap[leftchild];
					heap[leftchild] = heap[i];
					heap[i] = tmp;
					i = leftchild;
					leftchild = (2 * i) + 1;
					rightchild = (2 * i) + 2;
				} else if (heap[leftchild] > heap[rightchild] && heap[i] > heap[rightchild]) {
					tmp = heap[rightchild];
					heap[rightchild] = heap[i];
					heap[i] = tmp;
					i = rightchild;
					leftchild = (2 * i) + 1;
					rightchild = (2 * i) + 2;
				}

			} else {
				if (heap[leftchild] < heap[i]) {
					tmp = heap[leftchild];
					heap[leftchild] = heap[i];
					heap[i] = tmp;
					i = leftchild;
					leftchild = (2 * i) + 1;
					rightchild = (2 * i) + 2;
				}
			}
		}

	}

	private void heapifydown(int current) {
		int parent = (current - 1) / 2;
		while (parent >= 0 && heap[parent] > heap[current]) {
			int temp = heap[current];
			heap[current] = heap[parent];
			heap[parent] = temp;
			current = parent;
			parent = (current - 1) / 2;
		}
	}

	public static void main(String[] args) {
		MinHeap H = new MinHeap(10);
		H.insert(10);
		H.insert(15);
		H.insert(27);
		H.insert(5);
		H.insert(2);
		H.insert(21);
		System.out.println(Arrays.deepToString(H.heap));
		H.deleteroot();
		System.out.println(Arrays.deepToString(H.heap));
	}
}
