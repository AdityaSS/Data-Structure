import java.util.LinkedList;

	import Datastructure.queueLL;

public class BreadthFirstSearch {

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
		public BreadthFirstSearch(int n) {
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

			// AdjacencyLinkedList l = new AdjacencyLinkedList(5);

			// l.add(0, 1, 10);
			// l.add(0, 3, 20);
			// l.add(1, 2, 10);
			// l.add(2, 3, 10);
			// l.add(3, 4, 10);
			// l.add(4, 5, 10);
			// System.out.println(l);
			// System.out.println(l.edgeExists(0, 1));
			BreadthFirstSearch l = new BreadthFirstSearch(4);
			l.add(2, 0, 10);
			l.add(2, 3, 10);
			l.add(0, 1, 10);
	        System.out.println(l);
			System.out.print("Breadth First Search Value is : ");
	        l.BFS(2);

		}

		void BFS(int s) {
			boolean[] visited = new boolean[list.length];
			queueLL q = new queueLL();
			q.enqueue(s);
			while (q != null) {
				visited[s] = true;
				for (BreadthFirstSearch.Edge i : list[s]) {
					q.enqueue(i.getvertex());
				}
				System.out.print(q.dequeue() + " ");
				if(q.Head == null) break;
				s = q.Head.getValue();
				
			}
		}
	}

