package Datastructure;

public class LinkedListG<T> {

	private NodeG<T> Head;

	public void insertathead(T data) {
		NodeG<T> newNode = new NodeG<T>(data);
		newNode.setNextNode(Head);
		Head = newNode;
	}

	public void deletehead() {
		Head = Head.getNextNode();
	}

	public NodeG<T> find(T data) {
		NodeG<T> current = Head;
		while (current != null) {
			if (current.getValue() == data) {
				return current;
			}
			current = current.getNextNode();
		}
		return null;
	}
	
	public int length(){
		int length = 0;
		NodeG<T> current = Head;
		while (current != null) {
			length++;
			current = current.getNextNode();
		}
		return length;
		
	}
}
