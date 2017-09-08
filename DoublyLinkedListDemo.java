package Datastructure;

public class DoublyLinkedListDemo {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();

		list.Sort(5);
		list.Sort(10);
		list.Sort(15);
		list.Sort(12);
		list.Sort(17);
		list.Sort(13);
		
		System.out.println(list);
	}

}
