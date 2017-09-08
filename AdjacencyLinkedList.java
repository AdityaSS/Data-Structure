import java.util.LinkedList;

public class AdjacencyLinkedList {

	class Edge {

		int endvertex, weight;

		public Edge(int v, int w) {
			endvertex = v;
			weight = w;
		}

		public String toString() {
			return "(" + endvertex + "," + weight + ")";
		}
	}

	LinkedList<Edge> list[];

	@SuppressWarnings("unchecked")
	public AdjacencyLinkedList(int n) {
		list = new LinkedList[n];
		for (int i = 0; i < list.length; i++) {
			list[i] = new LinkedList<Edge>();
		}
	}

	public void add(int u, int v, int w) {
		list[u].addFirst(new Edge(v, w));
	}

	public boolean edgeExists(int u, int v) {
		for (Edge i : list[u]) {
			if (i.endvertex == v) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < list.length; i++) {
			result += (i + "-->" + list[i] + "\n");
		}
		return result;
	}

	public static void main(String[] args) {

		AdjacencyLinkedList l = new AdjacencyLinkedList(10);

		l.add(0, 1, 10);
		l.add(0, 3, 20);
		l.add(1, 2, 10);
		l.add(2, 3, 10);
		l.add(3, 4, 10);
		l.add(4, 5, 10);
		System.out.println(l);
		System.out.println(l.edgeExists(0, 1));

	}
}
