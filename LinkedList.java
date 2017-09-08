package Datastructure;

import java.util.HashSet;


public class LinkedList {
	Node Head;
	int count = 0;
	HashSet<Integer> hs = new HashSet<Integer>();

	public void insertathead(int data) {
		Node newnode = new Node(data);
		newnode.setNextNode(Head);
		Head = newnode;
	}

	public void insertreverse(int data) {
		Node newnode = new Node(data);
		if (count == 0) {
			newnode.setNextNode(null);
			Head = newnode;
			count++;
		} else {
			newnode.setNextNode(Head);
			Head = newnode;
		}
	}

	public Node kElement(LinkedList a, int data) {
		Node ref1 = Head;
		Node ref2 = Head;
		for (int i = 0; i < data; i++) {
			ref1 = ref1.getNextNode();
		}
		while (ref1.getNextNode() != null) {
			ref1 = ref1.getNextNode();
			ref2 = ref2.getNextNode();
		}
		return ref2;

	}

	public void reverse(LinkedList a) {
		Node ref1 = Head;
		while (ref1 != null) {
			insertreverse(ref1.getData());
			ref1 = ref1.getNextNode();

		}

	}

	public void append(LinkedList a, int n) {
		Node ref1 = Head;
		Node ref2 = Head;
		for (int i = 0; i < n; i++) {
			ref1 = ref1.getNextNode();
		}
		while (ref1.getNextNode() != null) {
			ref1 = ref1.getNextNode();
			ref2 = ref2.getNextNode();
		}

		ref1.setNextNode(Head);
		Head = ref2.getNextNode();
		ref2.setNextNode(null);
	}

	public void removeduplicates(LinkedList a) {
		Node current = Head;
		while (current != null) {
			int value = current.getData();
			if (hs.contains(value) == false) {
				hs.add(value);
			}
			current = current.getNextNode();

		}
		System.out.println(hs);
	}

	public void insert(int data) {
		if (Head == null) {
			Head = new Node(data);
		} else {
			Node newnode = new Node(data);
			Node current = Head;
			if (current.getData() > newnode.getData()) {
				newnode.setNextNode(current);
				Head = newnode;
			} else {
				while (current.getNextNode() != null && (current.getNextNode().getData() < newnode.getData())) {
					current = current.getNextNode();
				}
			}
			if (current.getNextNode() == null) {
				current.setNextNode(newnode);
			} else {
				newnode.setNextNode(current.getNextNode());
				current.setNextNode(newnode);
			}
		}
	}

	public int length() {
		int length = 0;
		Node current = Head;
		while (current != null) {
			length++;
			current = current.getNextNode();
		}
		return length;
	}

	public void deleteHead() {
		Head = Head.getNextNode();
	}

	public void delete(Node n) {
		Node current = Head;
		while(current.getData() != n.getData()){
			current = current.getNextNode();
		}
		current.setData(current.getNextNode().getData());
		current.setNextNode(current.getNextNode().getNextNode());

	}

	public Node find(int data) {
		Node current = Head;
		while (current != null) {
			if (current.getData() == data) {
				return current;
			} else {
				current = current.getNextNode();
			}
		}
		return null;
	}

	public String toString() {
		String result = "{";
		Node current = Head;

		while (current != null) {
			result += current.toString() + " ";
			current = current.getNextNode();
		}
		result += "}";
		return result;
	}
}
