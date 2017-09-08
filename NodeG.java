package Datastructure;

public class NodeG<T> {

	private T value;
	private NodeG<T> nextNode;

	public NodeG(T data) {
		value = data;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T data) {
		value = data;
	}

	public NodeG<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(NodeG<T> e) {
		nextNode = e;
	}
	
	public String toString(){
		return value.toString();
	}

}
