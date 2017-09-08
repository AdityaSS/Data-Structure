package Datastructure;

public class Node {
	private int value;
	private Node nextNode;

	public Node(int data) {
		value = data;
		nextNode = null;
	}

	public int getData() {
		return value;
	}

	public int setData(int data) {
		return value = data;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node e) {
		nextNode = e;
	}

	public String toString() {
		return " " + value;
	}
}
