package Datastructure;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertathead(5);
		list.insertathead(15);
		list.insertathead(25);
		list.insertathead(35);
		list.insertathead(45);
		list.insertathead(55);

		System.out.println(list);

		list.delete(new Node(35));
		System.out.println(list);

	}

}
