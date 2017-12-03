public class MinNode {

	GraphDijkstra.Node[] nodelist;
	int current = -1;
	char node = ' ';
	int weight;
	String path;
	boolean[] b;

	public MinNode(int n) {
		nodelist = new GraphDijkstra.Node[n];
		b = new boolean[n];
	}

	public MinNode insert(char a, int w) {
		GraphDijkstra.Node n = new GraphDijkstra().new Node(a, w);
		b[n.getname() % 65] = true;
		nodelist[++current] = n;
		heapify(current);
		return this;
	}

	private void heapify(int current2) {
		int parent = (current2 - 1) / 2;
		while (parent >= 0 && nodelist[parent].getweight() > nodelist[current2].getweight()) {
			GraphDijkstra.Node n = nodelist[current2];
			nodelist[current2] = nodelist[parent];
			nodelist[parent] = n;
			current2 = parent;
			parent = (current2 - 1) / 2;
		}

	}

	public GraphDijkstra.Node extract() {
		GraphDijkstra.Node out = nodelist[0];
		b[out.getname() % 65] = false;
		nodelist[0] = nodelist[current];
		current--;
		nodelist[current + 1] = null;
		int i = 0;
		int leftchild = (2 * i) + 1;
		int rightchild = (2 * i) + 2;
		GraphDijkstra.Node tmp = null;
		while (i < current) {
			if (nodelist[rightchild] != null) {
				if (nodelist[i].getweight() <= nodelist[leftchild].getweight()
						&& nodelist[i].getweight() <= nodelist[rightchild].getweight())
					break;
				else if (nodelist[leftchild].getweight() <= nodelist[rightchild].getweight()
						&& nodelist[i].getweight() > nodelist[leftchild].getweight()) {
					tmp = nodelist[leftchild];
					nodelist[leftchild] = nodelist[i];
					nodelist[i] = tmp;
					i = leftchild;
					if ((2 * i + 1 < nodelist.length && 2 * i + 2 < nodelist.length)
							&& (nodelist[(2 * i) + 1] != null && nodelist[(2 * i) + 2] != null)) {
						leftchild = (2 * i) + 1;
						rightchild = (2 * i) + 2;
					} else {
						if ((2 * i) + 2 > current && (2 * i) + 1 <= current) {
							leftchild = (2 * i) + 1;
							rightchild = (2 * i) + 2;
							nodelist[rightchild] = null;
						} else {
							break;
						}

					}

				} else if (nodelist[leftchild].getweight() > nodelist[rightchild].getweight()
						&& nodelist[i].getweight() > nodelist[rightchild].getweight()) {
					tmp = nodelist[rightchild];
					nodelist[rightchild] = nodelist[i];
					nodelist[i] = tmp;
					i = rightchild;
					leftchild = (2 * i) + 1;
					rightchild = (2 * i) + 2;
				}

			} else {
				if (nodelist[leftchild] != null && nodelist[leftchild].getweight() < nodelist[i].getweight()) {
					tmp = nodelist[leftchild];
					nodelist[leftchild] = nodelist[i];
					nodelist[i] = tmp;
					i = leftchild;
					leftchild = (2 * i) + 1;
					rightchild = (2 * i) + 2;
				} else {
					
					break;
				}
			}
		}
		return out;

	}

	public void checkheap() {

		for (int i = 0; i < nodelist.length - 3; i++) {
			int parent = 0;
			int leftchild = 2 * i + 1;
			int rightchild = 2 * i + 2;
			if (nodelist[parent].getweight() < nodelist[leftchild].getweight()
					|| nodelist[parent].getweight() < nodelist[rightchild].getweight()) {
				if (nodelist[rightchild].getweight() < nodelist[leftchild].getweight()) {
					GraphDijkstra.Node temp = nodelist[parent];
					nodelist[parent] = nodelist[rightchild];
					nodelist[rightchild] = temp;
				} else {
					GraphDijkstra.Node temp = nodelist[parent];
					nodelist[parent] = nodelist[leftchild];
					nodelist[leftchild] = temp;
				}
			}
		}

	}

	public void checknode(DijkstraG.Node node2, int weight2) {
		for (int i = 0; i < nodelist.length; i++) {
			if (nodelist[i] != null) {
				if (nodelist[i].getname() == node2.getname()) {
					if (nodelist[i].getweight() > node2.getweight() + weight2) {
						nodelist[i].setweight(node2.getweight() + weight2);

					}
				}
			}

		}

	}

	public boolean contains(DijkstraG.Node node2) {
		if (b[node2.getname() % 65] == true) {
			return true;
		}
		return false;
	}
}
