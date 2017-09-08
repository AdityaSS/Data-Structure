package Datastructure;

public class LinkedListGDemo {

	public static void main(String[] args) {
		LinkedListG<Integer> list = new LinkedListG<Integer>();

		list.insertathead(5);
		list.insertathead(10);
		list.insertathead(2);
		list.insertathead(12);
		list.insertathead(19);
		list.insertathead(20);
		System.out.println(list.length());
		System.out.println(list.find(120));


	}

}
