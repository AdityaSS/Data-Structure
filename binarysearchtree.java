
public class binarysearchtree {

	treenode root;

	public void insert(int data) {
		if (root == null) {
			root = new treenode(data);
		} else {
			root.insert(data);
		}
	}

	public treenode find(int data) {
		if (root == null) {
			return null;
		} else {
			root.find(data);
		}
		return null;
	}
	
	public int numOfLeafNodes() {
		if (root == null) return 0;
		return root.numOfLeafNodes();
	}


	public void inorder() {
		if (root == null) {
			System.out.println("No inorder");
		} else {
			root.inorder();
		}
	}
	
	public int height() {
		if (root == null) return 0;
		return root.height();
	}


	public void delete(int n) {
		treenode current = root;
		treenode parent = root;
		boolean isleftchild = false;

		while (current.getdata() != n && current != null) {
			if (n < current.getdata()) {
				parent = current;
				current = current.getleftchild();
				isleftchild = true;
			} else {
				parent = current;
				current = current.getrightchild();
			}
		}

		if (current.getleftchild() == null && current.getrightchild() == null) {
			if (isleftchild) {
				parent.setleftchild(null);
			} else {
				parent.setrightchild(null);
			}
		}

		else if (current.getleftchild() != null && current.getrightchild() != null) {
			treenode current1 = current.getrightchild();
			treenode root1 = current1;
			while (current1.getleftchild() != null) {
				root1 = current1;
				current1 = current1.getleftchild();
			}
			if (current1.getrightchild() != null) {
				root1.setleftchild(current1.getrightchild());
			}
			if (isleftchild) {
               parent.setleftchild(current1);
               current1.setleftchild(current.getleftchild());
			} else {
				parent.setrightchild(current1);
				current1.setleftchild(current.getleftchild());
			}
		}

		else if (current.getleftchild() != null || current.getrightchild() != null) {
			if (isleftchild) {
				parent.setleftchild(current.getleftchild());
			} else {
				parent.setrightchild(current.getrightchild());
			}
		}

	}
}
