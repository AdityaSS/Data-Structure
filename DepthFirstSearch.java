import java.util.LinkedList;

import Datastructure.stackLL;

public class DepthFirstSearch {

	class Edge {

		int endvertex, weight;

		public Edge(int v, int w) {
			endvertex = v;
			weight = w;
		}

		public String toString() {
			return "(" + endvertex + "," + weight + ")";
		}

		public int getvertex() {
			return endvertex;
		}
	}

	LinkedList<Edge>[] list;

	@SuppressWarnings("unchecked")
	public DepthFirstSearch(int n) {
		list = new LinkedList[n];
		for (int i = 0; i < list.length; i++) {
			list[i] = new LinkedList<Edge>();
		}
	}

	public void add(int u, int v, int w) {
		list[u].add(new Edge(v, w));
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

		DepthFirstSearch l = new DepthFirstSearch(4);
		l.add(2, 0, 10);
		l.add(2, 3, 10);
		l.add(0, 1, 10);
		System.out.println(l);
		System.out.print("Depth First Search Value is : ");
		l.DFS(2);
        stack.pop();
	}

    static stackLL stack = new stackLL();
	boolean[] visited;

	void DFS(int s) {
		visited = new boolean[list.length];
		stack.push(s);
		visited[s] = true;
		for (Edge i : list[s]) {
			if (i != null) {
				int n = i.getvertex();
				DFS(n);
			}
			stack.pop();
		}
	}
}
