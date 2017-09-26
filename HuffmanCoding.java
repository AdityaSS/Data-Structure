/* Here a demo of HuffMan Coding is shown. It takes an input String and then encodes that String by forming a Heap out of i, it 
   then pop() Minimum frequency Nodes and adds them and again Insert it into MinHeap. This process continues till only 1 Node is
   there in the Heap. Then using tree traversal(inorder) we can assign 0's and 1's and thus compression is achieved.
   WikiPedia Link for HuffMan Coding Explanation: https://en.wikipedia.org/wiki/Huffman_coding#Terminology.
*/ 
import java.util.Arrays;
import java.util.HashMap;

public class HuffmanCoding {

	static Node n;
	static int current = -1;
	static Node[] MinHeap;

	public static void main(String[] args) {

		String msg = "Missisipi River";
		msg = msg.toLowerCase();
		msg = msg.replaceAll("\\s+", ""); // removing space
		char[] msgchar = msg.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		int uniquechar = 0;
		for (int i = 0; i < msgchar.length; i++) {
			if (map.containsKey(msgchar[i]) == false) {
				map.put(msgchar[i], 1);
				uniquechar++;
			} else {
				map.put(msgchar[i], map.get(msgchar[i]) + 1);
			}
		}
		MinHeap = new Node[uniquechar];
		for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
			n = new Node(entry.getKey(), entry.getValue());
			insert(n);
		}
		while (current > 0) {
			System.out.println(Arrays.toString(MinHeap));
			Node a = pop();
			Node b = pop();
			int n1 = a.getvalue();
			int n2 = b.getvalue();
			n = new Node('I', (n1 + n2), a, b);
			insert(n);
		}
		System.out.println(Arrays.toString(MinHeap));
		System.out.println();
		String str = "";
		traverseInOrder(MinHeap[0], str);
	}

	private static void traverseInOrder(Node node, String str) {
         if(node!=null){
        	 Node.traverseInOrder(node,str);
         }
	}

	private static void insert(Node n) {
		MinHeap[++current] = n;
		heapify(current);
	}

	private static void heapify(int k) {
		int current = k;
		int parent = (current - 1) / 2;
		Node temp;
		while (parent >= 0 && MinHeap[parent].getvalue() > MinHeap[current].getvalue()) {
			temp = MinHeap[current];
			MinHeap[current] = MinHeap[parent];
			MinHeap[parent] = temp;
			current = parent;
			parent = (current - 1) / 2;
		}

	}

	public static Node pop() {

		Node a = MinHeap[0];
		MinHeap[0] = MinHeap[current];
		current--;
		MinHeap[current + 1] = null;
		int i = 0;
		int leftchild = (2 * i) + 1;
		int rightchild = (2 * i) + 2;
		Node temp;
		while (i < current) {
			if (MinHeap[rightchild] != null && MinHeap[leftchild] != null) {
				if (MinHeap[i].getvalue() < MinHeap[rightchild].getvalue()
						&& MinHeap[i].getvalue() < MinHeap[leftchild].getvalue())
					break;
			}
			if (MinHeap[rightchild] != null) {
				if (MinHeap[leftchild].getvalue() <= MinHeap[rightchild].getvalue()) {
					temp = MinHeap[leftchild];
					MinHeap[leftchild] = MinHeap[i];
					MinHeap[i] = temp;
					i = leftchild;
					if ((2 * i) + 1 > current && (2 * i) + 2 > current) {
						break;
					} else {
						if ((2 * i) + 2 > current) {
							leftchild = (2 * i) + 1;
							MinHeap[2 * i + 2] = null;
							rightchild = 2 * i + 2;
						} else {
							leftchild = (2 * i) + 1;
							rightchild = (2 * i) + 2;
						}
					}
				} else {
					temp = MinHeap[i];
					MinHeap[i] = MinHeap[rightchild];
					MinHeap[rightchild] = temp;
					i = rightchild;
					if ((2 * i) + 1 > current && (2 * i) + 2 > current) {
						break;
					}
					if ((2 * i) + 1 < current) {
						leftchild = (2 * i) + 1;
					}
					if ((2 * i) + 2 < current) {
						rightchild = (2 * i) + 2;
					} else {
						MinHeap[(2 * i) + 2] = null;
					}
				}
			} else {
				if (MinHeap[i].getvalue() > MinHeap[leftchild].getvalue()) {
					temp = MinHeap[leftchild];
					MinHeap[leftchild] = MinHeap[i];
					MinHeap[i] = temp;
					i = leftchild;
					if ((2 * i) + 1 > current)
						break;
					if ((2 * i) + 1 < current) {
						leftchild = (2 * i) + 1;
					}
				} else {
					break;
				}
			}

		}
		return a;

	}
}

class Node {
	int value;
	char name;

	Node leftNode;
	Node rightNode;
	String s;
	String number;

	public Node(Character name, Integer value) {
		this.name = name;
		this.value = value;
	}

	public static void traverseInOrder(Node a, String str) {
		if (a.getleft() != null) {
			a.getleft();
			Node.traverseInOrder(a.getleft(), str+"0");
		}
		if (a.getname() != 'I') {
			System.out.println(a.getname() + " : " + str);
		}
		if (a.getright() != null) {
			a.getright();
			Node.traverseInOrder(a.getright(), str+"1");
		}

	}

	public Node(Character name, Integer value, Node a, Node b) {
		this.name = name;
		this.value = value;
		leftNode = a;
		rightNode = b;
	}

	public Integer getvalue() {
		return value;
	}

	public Character getname() {
		return name;
	}

	public Node getleft() {
		return leftNode;
	}

	public Node getright() {
		return rightNode;
	}

	public String toString() {
		String result = name + "-" + value;
		return result;
	}

}
