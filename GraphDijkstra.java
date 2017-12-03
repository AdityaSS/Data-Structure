import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

class DijkstraG {

	class Node {
		char name;
		int weight;

		public Node(char a, int w) {
			name = a;
			weight = w;
		}

		public int getweight() {
			return weight;
		}

		public char getname() {
			return name;
		}

		public String toString() {
			return ("(" + name + "," + weight + ")");
		}
	}

	LinkedList<Node>[] list;

	@SuppressWarnings("unchecked")
	public DijkstraG(int n) {
		list = new LinkedList[n];

		for (int i = 0; i < list.length; i++) {
			list[i] = new LinkedList<Node>();
		}
	}

	public void addNode(char a, char b, int w) {
		list[a % 65].add(new Node(b, w));
	}

	public String toString() {
		String result = "";
		for (int i = 65; i < 72; i++) {
			result += Character.toString((char) i) + " ---> " + list[i % 65] + "\n";
		}
		return result;
	}
}

public class GraphDijkstra {

	public static void main(String[] args) {
		DijkstraG d = new DijkstraG(7);
		d.addNode('A', 'B', 2);
		d.addNode('A', 'D', 1);
		d.addNode('B', 'E', 10);
		d.addNode('B', 'D', 3);
		d.addNode('C', 'A', 2);
		d.addNode('C', 'F', 5);
		d.addNode('D', 'E', 2);
		d.addNode('D', 'C', 2);
		d.addNode('D', 'G', 4);
		d.addNode('D', 'F', 8);
		d.addNode('E', 'G', 6);
		d.addNode('G', 'F', 1);
		System.out.println(d);

		ShortestPath('A', 'F', d.list.length, d);

	}

	private static void ShortestPath(Character start, char end, int glength, DijkstraG graph) {
		HashMap<Character, String> map = new HashMap<Character, String>();
		MinNode m = new MinNode(glength);
		m.insert(start, 0);
		int weight = 0;
		Node ex = m.nodelist[0];
		while (ex.getname() != end) {
			weight = m.nodelist[0].getweight();
			int j = m.nodelist[0].getname() % 65;
			if (graph.list[j] != null) {
				for (int i = 0; i < graph.list[j].size(); i++) {
					if (!map.containsKey(graph.list[j].get(i).getname())) {
						if (m.nodelist != null && m.contains(graph.list[j].get(i))) {
							m.checknode(graph.list[j].get(i), weight);
						} else {
							m.insert(graph.list[j].get(i).getname(), graph.list[j].get(i).getweight() + weight);
						}

					}
				}
			}

			System.out.println("Insert" + "\n-------" + "\n" + Arrays.toString(m.nodelist));
			System.out.println();
			ex = m.extract();
			System.out.println("After Extract " + "\n-------------- " + "\n" + Arrays.toString(m.nodelist));
			System.out.println();
			map.put(ex.getname(), "T");

		}

		System.out.println("Dijkstra distance from " + start + " to " + end + " is " + ex.getweight());

	}

	class Node {
		char name = ' ';
		int weight = 0;

		public Node(char a, int w) {
			name = a;
			weight = w;

		}

		public char getname() {
			return name;
		}

		public int getweight() {
			return weight;
		}

		public void setweight(int b) {
			weight = b;
		}

		public String toString() {
			return name + " " + weight;
		}
	}

}
