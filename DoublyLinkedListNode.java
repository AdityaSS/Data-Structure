package Datastructure;

public class DoublyLinkedListNode {
	private int value;
	private DoublyLinkedListNode nextnode;
	private DoublyLinkedListNode previousnode;

	public DoublyLinkedListNode(int data) {
		value = data;
		nextnode = null;
		previousnode = null;
	}

	public DoublyLinkedListNode getNextnode() {
		return nextnode;
	}

	public void setNextnode(DoublyLinkedListNode e) {
		nextnode = e;
	}

	public DoublyLinkedListNode getPreviousnode() {
		return previousnode;
	}

	public void setPreviousnode(DoublyLinkedListNode e) {
		previousnode = e;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int data) {
		value = data;
	}
	public String toString() {
		return " " + value;
	}
}
