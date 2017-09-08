
public class treenode {

	int data;
	treenode rightchild;
	treenode leftchild;

	public treenode(int value) {
		data = value;
	}

	public void insert(int value) {
		if (value >= data) {
			if (rightchild == null) {
				rightchild = new treenode(value);
			} else {
				rightchild.insert(value);
			}
		} else {
			if (leftchild == null) {
				leftchild = new treenode(value);
			} else {
				leftchild.insert(value);
			}
		}
	}

	public treenode find(int value) {
		if (value == data) {
			return this;
		} else if (value > data && rightchild != null) {
			return rightchild.find(value);
		} else if (value < data && leftchild != null) {
			return leftchild.find(value);
		}
		return null;
	}
  
	public void inorder() {
		if (leftchild != null) {
			leftchild.inorder();
		}
		System.out.print(this + " ");
		if (rightchild != null) {
			rightchild.inorder();
		}
	}
	
	public int height() {
		if (isLeaf()) return 1;
		int left = 0;
		int right = 0;
		if (leftchild != null)
			left = leftchild.height();
		if (rightchild != null)
			right = rightchild.height();
		return (left > right) ? (left + 1) : (right + 1);
	}

	
	public int numOfLeafNodes() {
		if (isLeaf()) return 1;
		int leftLeaves = 0;
		int rightLeaves = 0;
		if (leftchild != null)
			leftLeaves = leftchild.numOfLeafNodes();
		if (rightchild != null)
			rightLeaves = rightchild.numOfLeafNodes();
		return leftLeaves + rightLeaves;
	}
	
	public boolean isLeaf() {
		return leftchild == null && rightchild == null;
	}


	public String toString() {
		String result = "";
		result += data;
		return result;
	}

	public int getdata() {
		return data;
	}

	public treenode getleftchild() {
		return leftchild;
	}

	public treenode getrightchild() {
		return rightchild;
	}
	
	public void setrightchild(treenode a){
		 rightchild = a;
	}
	
	public void setleftchild(treenode a){
		 leftchild = a;
	}
	
	public treenode smallest() {
		if (leftchild == null) {
			return this;
		}
		return leftchild.smallest();
	}
}
