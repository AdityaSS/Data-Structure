import java.util.*;

class Graph {

	class Edge {
		
		int vertex, weight;
		public Edge(int v, int w) {
			vertex = v;
			weight = w;
		}

		public String toString() {
			return "(" + vertex + "," + weight + ")";
		}
	}

	LinkedList<Edge> l[];

	public Graph(int n) {
		l = new LinkedList[n];
		for (int i = 0; i < l.length; i++) {
			l[i] = new LinkedList<Edge>();
		}
	}

	public boolean isConnected(int u, int v) {
		for (Edge i : l[u]) {
			if (i.vertex == v) {
				return true;
			}
		}
		return false;
	}

	public void addEdge(int u, int v, int w) {
		l[u].add(0, new Edge(v, w));
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < l.length; i++) {
			result += i + "-->" + l[i] + "\n";
		}
		return result;
	}
}

public class GraphExample {

	public static void main(String[] args) {
		Graph g = new Graph(10);
		g.addEdge(0, 2, 10);
		g.addEdge(0, 5, 15);
		g.addEdge(2, 5, 10);
		g.addEdge(9, 3, 6);
		System.out.println(g);
		System.out.println(g.isConnected(9, 3));
	}

}
