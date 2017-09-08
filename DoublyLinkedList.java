package Datastructure;

public class DoublyLinkedList {

	DoublyLinkedListNode Head = null;
	DoublyLinkedListNode pos;
	DoublyLinkedListNode start;

	public void Sort(int data) {
		DoublyLinkedListNode newnode = new DoublyLinkedListNode(data);
		DoublyLinkedListNode current = new DoublyLinkedListNode(data);
		if (Head == null) {
			newnode.setNextnode(null);
			newnode.setPreviousnode(null);
			Head = newnode;
			pos = Head;
			start = Head;
		} else {
			pos = start;
			if (current.getValue() < pos.getValue()) {
				while (pos.getPreviousnode() != null && current.getValue() < pos.getValue()) {

					pos = pos.getPreviousnode();
				}
				if (pos.getPreviousnode() == null) {
					current.setPreviousnode(null);
					current.setNextnode(pos);
					pos.setPreviousnode(current);
					Head = current;
				} else {
					current.setNextnode(pos.getNextnode());
					current.setPreviousnode(current.getNextnode().getPreviousnode());
					current.getPreviousnode().setNextnode(current);
					current.getNextnode().setPreviousnode(current);
					start = current.getNextnode();
				}
			} else {
				current.setPreviousnode(pos);
				pos.setNextnode(current);
				current.setNextnode(null);
				start = current;
				pos = current;
			}

		}
	}

	public void insertatHead() {
       
	}

	public int length() {
		int length = 0;
		DoublyLinkedListNode current = Head;
		while (current != null) {
			length++;
			current = current.getNextnode();
		}
		return length;
	}

	public String toString() {
		String result = "{ ";
		DoublyLinkedListNode current = Head;

		while (current != null) {
			result += current.getValue() + " ";
			current = current.getNextnode();
		}
		result += "}";
		return result;
	}

}
